package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("coord")
    private Coordination coordination;

    @SerializedName("main")
    private Main main;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Coordination getCoordination() {
        return coordination;
    }

    public void setCoordination(Coordination coordination) {
        this.coordination = coordination;
    }
}
