package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterface;
import com.example.weather.Retrofit.Example;
import com.example.weather.Retrofit.Example2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mCityName;
    ImageView mSearch;
    TextView mNameOfCity;
    TextView mTempText, mDescText, mHumidityText, mLatitude1, mLongitude1;

    String mLongitude, mLatitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearch = findViewById(R.id.search);
        mTempText = findViewById(R.id.tempText);
        mDescText = findViewById(R.id.descText);
        mHumidityText = findViewById(R.id.humidityText);
        mCityName = findViewById(R.id.cityName);


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

                mTempText.setText("Temperature: " + response.body().getMain().getTemp() + " °C");
                mDescText.setText("Feels Likes: " + response.body().getMain().getFeels_like());
                mHumidityText.setText("Humidity: " + response.body().getMain().getHumidity());
                // mNameOfCity.setText("Name of City: " + response.body().getName());

                mLongitude = response.body().getCoordination().getLon();
                mLatitude = response.body().getCoordination().getLat();

                Toast.makeText(MainActivity.this,mLongitude + " & " + mLatitude,Toast.LENGTH_SHORT).show();

                //getWeatherData2(mLatitude,mLongitude);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

    private void getWeatherData2(String lat, String lon) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example2> call2 = apiInterface.getWeatherData2(lat, lon);

        call2.enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call, Response<Example2> response) {

                mLatitude1.setText(response.body().getLat());
                mLongitude1.setText(response.body().getLon());
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {

            }
        });
    }
}