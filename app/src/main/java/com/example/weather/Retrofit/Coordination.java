package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Coordination {

    @SerializedName("lon")
    Double lon;

    @SerializedName("lat")
    Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
