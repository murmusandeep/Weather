package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    public NextDayWeather nextDayWeather;

    public NextDayWeather getNextDayWeather() {
        return nextDayWeather;
    }

    public void setNextDayWeather(NextDayWeather nextDayWeather) {
        this.nextDayWeather = nextDayWeather;
    }
}
