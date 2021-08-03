package com.example.weather.Retrofit.service;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    //http://api.weatherapi.com/v1/forecast.json?q=Delhi&key=319d25570b234e6d8b5142438201510&days=2

    public static Retrofit getClient(Context context) {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new ChuckerInterceptor(context))
                .build();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.weatherapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }
}
