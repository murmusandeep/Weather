package com.example.weather.Retrofit.models;

import com.example.weather.Retrofit.models.Condition;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("condition")
    Condition condition;

    @SerializedName("temp_c")
    String temp;

    @SerializedName("wind_kph")
    String windSpeed;

    @SerializedName("wind_dir")
    String windDirection;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("cloud")
    String cloud;

    @SerializedName("feelslike_c")
    String feelslike;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(String feelslike) {
        this.feelslike = feelslike;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
