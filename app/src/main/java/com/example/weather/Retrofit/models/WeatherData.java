package com.example.weather.Retrofit.models;

import com.example.weather.Retrofit.models.Current;
import com.example.weather.Retrofit.models.Forecast;
import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("current")
    private Current current;

    @SerializedName("forecast")
    private Forecast forecast;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
