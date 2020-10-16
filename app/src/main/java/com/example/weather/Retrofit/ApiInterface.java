package com.example.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //http://api.weatherapi.com/v1/forecast.json?q=Delhi&key=319d25570b234e6d8b5142438201510&days=2

    @GET("current.json?key=319d25570b234e6d8b5142438201510&days=2")
    Call<Example> getWeatherData(@Query("q") String name);

}
