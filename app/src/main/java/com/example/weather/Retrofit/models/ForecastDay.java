package com.example.weather.Retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastDay {

    @SerializedName("date")
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
