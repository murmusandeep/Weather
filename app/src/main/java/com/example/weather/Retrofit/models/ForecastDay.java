package com.example.weather.Retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastDay {

    @SerializedName("date")
    String date;

    @SerializedName("day")
    Day day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
