package com.example.weather.Retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecast {

    @SerializedName("forecastday")
    public List<ForecastDay> forecastDayList = new ArrayList<>();

    public List<ForecastDay> getForecastDayList() {
        return forecastDayList;
    }

    public void setForecastDayList(List<ForecastDay> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }
}
