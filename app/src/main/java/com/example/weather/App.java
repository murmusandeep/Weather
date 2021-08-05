package com.example.weather;

import android.app.Application;

public class App extends Application {
    public static Application instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
