package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("text")
    String text;

    @SerializedName("icon")
    String iconURL;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
