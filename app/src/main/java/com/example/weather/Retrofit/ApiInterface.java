package com.example.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

//    @GET("weather?appid=029ef0fa73f1262ff1a83ec4912186df&units=metric")
//    Call<Example> getWeatherData(@Query("q") String name);

    @GET("current.json?key=319d25570b234e6d8b5142438201510&days=2")
    Call<Example> getWeatherData(@Query("q") String name);

}
