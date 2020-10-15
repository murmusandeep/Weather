package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Coordination {

    @SerializedName("lon")
    String lon;

    @SerializedName("lat")
    String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
