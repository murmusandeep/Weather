package com.example.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterface;
import com.example.weather.Retrofit.WeatherData;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    EditText mCityName;
    ImageView mSearch;

    TextView mCountry, mTimeZone, mLocalTime;

    TextView mTemperature, mWindSpeed, mWindDirection, mHumidity, mCloud, mFeelslike;

    TextView mText;
    ImageView mIcon;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_home,container,false);

        mSearch = view.findViewById(R.id.search);
        mCityName = view.findViewById(R.id.cityName);

        mCountry = view.findViewById(R.id.country);
        mTimeZone = view.findViewById(R.id.timeZone);
        mLocalTime = view.findViewById(R.id.localTime);

        mTemperature = view.findViewById(R.id.temperature);
        mWindSpeed = view.findViewById(R.id.windSpeed);
        mWindDirection = view.findViewById(R.id.windDirection);
        mHumidity = view.findViewById(R.id.humidity);
        mCloud = view.findViewById(R.id.cloud);
        mFeelslike = view.findViewById(R.id.feelsLike);

        mText = view.findViewById(R.id.text);
        mIcon = view.findViewById(R.id.icon);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherData(mCityName.getText().toString().trim());
            }
        });

        return view;
    }


    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient(getActivity()).create(ApiInterface.class);
        Call<WeatherData> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<WeatherData>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (response.code() == 400) {
                    Toast.makeText(getActivity(), "You have not entered city name or Location not found.", Toast.LENGTH_SHORT).show();
                }

                else if(response.code() == 401) {
                    Toast.makeText(getActivity(), "API key provided is invalid or API key not provided.", Toast.LENGTH_SHORT).show();
                }

                else if (response.code() == 403) {
                    Toast.makeText(getActivity(), "API key has exceeded calls per month quota.", Toast.LENGTH_SHORT).show();
                }

                else {
                    mCountry.setText("Country: " + response.body().getLocation().getCountry());
                    mTimeZone.setText("Time Zone: " + response.body().getLocation().getTimeZone());
                    mLocalTime.setText("Local Time: " + response.body().getLocation().getLocalTime());

                    mTemperature.setText("Temperature: " + response.body().getCurrent().getTemp() + "°C");
                    mWindSpeed.setText("Wind Speed: " + response.body().getCurrent().getWindSpeed() + " Km");
                    mWindDirection.setText("Wind Direction: " + response.body().getCurrent().getWindDirection());
                    mHumidity.setText("Humidity: " + response.body().getCurrent().getHumidity() + " %");
                    mCloud.setText("Cloud: " + response.body().getCurrent().getCloud() + " %");
                    mFeelslike.setText("Feels Like: " + response.body().getCurrent().getFeelslike() + " °C");

                    mText.setText(response.body().getCurrent().getCondition().getText());

                    Picasso.get()
                            .load("http:" + response.body().getCurrent().getCondition().getIconURL())
                            .into(mIcon);

//                Glide.with(MainActivity.this)
//                        .load("http:" + response.body().getCurrent().getCondition().getIconURL())
//                        .into(mIcon);

                    //mDate.setText(response.body().getForecast().getForecastDayList().get(0).getDate());

                    // int size = response.body().getForecast().getForecastDayList().size();

                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }

}

