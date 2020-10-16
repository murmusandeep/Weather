package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterface;
import com.example.weather.Retrofit.Example;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mCityName;
    ImageView mSearch;

    TextView mCountry, mTimeZone, mLocalTime;

    TextView mTemperature, mWindSpeed, mWindDirection, mHumidity, mCloud, mFeelslike;

    TextView mText;
    ImageView mIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearch = findViewById(R.id.search);
        mCityName = findViewById(R.id.cityName);

        mCountry = findViewById(R.id.country);
        mTimeZone = findViewById(R.id.timeZone);
        mLocalTime = findViewById(R.id.localTime);

        mTemperature = findViewById(R.id.temperature);
        mWindSpeed = findViewById(R.id.windSpeed);
        mWindDirection = findViewById(R.id.windDirection);
        mHumidity = findViewById(R.id.humidity);
        mCloud = findViewById(R.id.cloud);
        mFeelslike = findViewById(R.id.feelsLike);

        mText = findViewById(R.id.text);
        mIcon = findViewById(R.id.icon);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherData(mCityName.getText().toString().trim());
            }
        });

    }

    private void getWeatherData(String name) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                mCountry.setText("Country: " + response.body().getLocation().getCountry());
                mTimeZone.setText("Time Zone: " + response.body().getLocation().getTimeZone());
                mLocalTime.setText("Local Time: " + response.body().getLocation().getLocalTime());

                mTemperature.setText("Temperature: " + response.body().getCurrent().getTemp() + " °C");
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
//                        .load(response.body().getCurrent().getCondition().getIconURL())
//                        .into(mIcon);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

}