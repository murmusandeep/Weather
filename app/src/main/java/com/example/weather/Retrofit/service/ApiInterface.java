package com.example.weather.Retrofit.service;

import com.example.weather.Retrofit.models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //http://api.weatherapi.com/v1/forecast.json?q=Delhi&key=319d25570b234e6d8b5142438201510&days=2

    @GET("current.json?key=b8f48217200e44b3a8e84021211508&days=2")
    Call<WeatherData> getWeatherData(@Query("q") String name);

}
