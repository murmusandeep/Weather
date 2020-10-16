package com.example.weather.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    //http://api.weatherapi.com/v1/current.json?key=319d25570b234e6d8b5142438201510&q=London

    //http://api.weatherapi.com/v1/current.json?q=London&key=319d25570b234e6d8b5142438201510

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    //.baseUrl("http://api.openweathermap.org/data/2.5/")
                    .baseUrl("http://api.weatherapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
