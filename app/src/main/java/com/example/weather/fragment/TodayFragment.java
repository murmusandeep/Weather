package com.example.weather.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.weather.App;
import com.example.weather.R;
import com.example.weather.Retrofit.models.WeatherData;
import com.example.weather.Retrofit.service.ApiClient;
import com.example.weather.Retrofit.service.ApiInterface;
import com.example.weather.SingletonPattern.Singleton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayFragment extends Fragment implements LocationListener {

    EditText mCityName;
    ImageView mSearch;

    TextView mCountry, mTimeZone, mLocalTime;

    TextView mTemperature, mWindSpeed, mWindDirection, mHumidity, mCloud, mFeelslike;

    TextView mText;
    ImageView mIcon;

    String cityName = "";

    LocationManager locationManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_today,container,false);

        grantPermission();
        checkLocationIsEnableOrNot();


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
        //getLocationRegister();

        //SharedPreferences sharedPreferences = requireActivity().getSharedPreferences();

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityName = mCityName.getText().toString().trim();

                Singleton singleton = Singleton.getInstance();

                singleton.setCityName(cityName);

                getWeatherData(cityName);
            }
        });

        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        getLocationRegister();
//    }


    private void getLocationRegister() {

        try {

            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    private void checkLocationIsEnableOrNot() {

        LocationManager lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnable = false;
        boolean networkEnable = false;

        try {
            gpsEnable = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            networkEnable = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!gpsEnable && !networkEnable) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Enable GPS Service")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                            startActivity(getActivity().getIntent());
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                        }
                    }).setNegativeButton("Cancel", null)
                    .show();
        }
    }

    private void grantPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }


    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient(App.instance).create(ApiInterface.class);
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

                    Singleton singleton = Singleton.getInstance();

                    singleton.setCountry("Country: " + response.body().getLocation().getCountry());
                    singleton.setTimeZone("Time Zone: " + response.body().getLocation().getTimeZone());
                    singleton.setLocalTime("Local Time: " + response.body().getLocation().getLocalTime());

                    singleton.setTemperature("Temperature: " + response.body().getCurrent().getTemp() + "°C");
                    singleton.setWindSpeed("Wind Speed: " + response.body().getCurrent().getWindSpeed() + " Km");
                    singleton.setWindDirection("Wind Direction: " + response.body().getCurrent().getWindDirection());
                    singleton.setHumidity("Humidity: " + response.body().getCurrent().getHumidity() + " %");
                    singleton.setCloud("Cloud: " + response.body().getCurrent().getCloud() + " %");
                    singleton.setFeelslike("Feels Like: " + response.body().getCurrent().getFeelslike() + " °C");

                    singleton.setText(response.body().getCurrent().getCondition().getText());
                    singleton.setIcon(response.body().getCurrent().getCondition().getIconURL());

                    singleton.setNextIcon1(response.body().getForecast().getForecastDayList().get(1).getDay().getCondition().getIconURL());
                    singleton.setMaxTemp1("Max. Temp: " + response.body().getForecast().getForecastDayList().get(1).getDay().getMaxTemp() + "°C");
                    singleton.setMinTemp1("Min. Temp: " + response.body().getForecast().getForecastDayList().get(1).getDay().getMinTemp() + "°C");
                    singleton.setNextText1(response.body().getForecast().getForecastDayList().get(1).getDay().getCondition().getText());
                    singleton.setNextDate1(response.body().getForecast().getForecastDayList().get(1).getDate());

                    singleton.setNextIcon2(response.body().getForecast().getForecastDayList().get(2).getDay().getCondition().getIconURL());
                    singleton.setMaxTemp2("Max. Temp: " + response.body().getForecast().getForecastDayList().get(2).getDay().getMaxTemp() + "°C");
                    singleton.setMinTemp2("Min. Temp: " + response.body().getForecast().getForecastDayList().get(2).getDay().getMinTemp() + "°C");
                    singleton.setNextText2(response.body().getForecast().getForecastDayList().get(2).getDay().getCondition().getText());
                    singleton.setNextDate2(response.body().getForecast().getForecastDayList().get(2).getDate());



//                    singleton.setDate(response.body().getForecast().getForecastDayList().get(2).getDate());
//                    mDate.setText(response.body().getForecast().getForecastDayList().get(2).getDate());



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



                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

        locationManager.removeUpdates(this);

    }

    @Override
    public void onResume() {

        getLocationRegister();

        Singleton singleton = Singleton.getInstance();
        
        mCountry.setText(singleton.getCountry());
        mTimeZone.setText(singleton.getTimeZone());
        mLocalTime.setText(singleton.getLocalTime());

        mTemperature.setText(singleton.getTemperature());

        mWindSpeed.setText(singleton.getWindSpeed());
        mWindDirection.setText(singleton.getWindDirection());
        mHumidity.setText(singleton.getHumidity());
        mCloud.setText(singleton.getCloud());
        mFeelslike.setText(singleton.getFeelslike());

        mText.setText(singleton.getText());
        Picasso.get()
                .load("http:" + singleton.getIcon())
                .into(mIcon);
        super.onResume();
    }


    @Override
    public void onLocationChanged(Location location) {

        try {
            Geocoder geocoder = new Geocoder(App.instance, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

            mCityName.setText(addresses.get(0).getLocality());

           //cityName = addresses.get(0).getLocality();


            getWeatherData(addresses.get(0).getLocality());
            //mCityName.setText(cityName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}

