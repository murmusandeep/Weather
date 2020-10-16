package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("country")
    String country;

    @SerializedName("tz_id")
    String timeZone;

    @SerializedName("localtime")
    String localTime;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }
}
