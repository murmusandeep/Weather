package com.example.weather.Retrofit.models;

import com.example.weather.Retrofit.models.Current;
import com.example.weather.Retrofit.models.Forecast;
import com.example.weather.Retrofit.models.Location;
import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("location")
    private Location location;

    @SerializedName("current")
    private Current current;

    @SerializedName("forecast")
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

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
