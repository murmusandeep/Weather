package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("location")
    private Location location;

    @SerializedName("current")
    private Current current;

    @SerializedName("forecast")
    Forecast forecast;

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
