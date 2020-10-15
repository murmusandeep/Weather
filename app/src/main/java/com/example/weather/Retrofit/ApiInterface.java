package com.example.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?appid=029ef0fa73f1262ff1a83ec4912186df&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);

    @GET("onecall?exclude=alerts&appid=029ef0fa73f1262ff1a83ec4912186df")
    Call<Example2> getWeatherData2(@Query("lat") String latitude, @Query("lon") String longitude);
}
