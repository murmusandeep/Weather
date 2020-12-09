package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterface;
import com.example.weather.Retrofit.WeatherData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

//        mSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getWeatherData(mCityName.getText().toString().trim());
//            }
//        });

    }

    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient(MainActivity.this).create(ApiInterface.class);
        Call<WeatherData> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<WeatherData>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (response.code() == 400) {
                    Toast.makeText(MainActivity.this, "You have not entered city name or Location not found.", Toast.LENGTH_SHORT).show();
                }

                else if(response.code() == 401) {
                    Toast.makeText(MainActivity.this, "API key provided is invalid or API key not provided.", Toast.LENGTH_SHORT).show();
                }

                else if (response.code() == 403) {
                    Toast.makeText(MainActivity.this, "API key has exceeded calls per month quota.", Toast.LENGTH_SHORT).show();
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

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();


                            break;
                        case R.id.search_city:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.setting:
                            selectedFragment = new SettingFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}