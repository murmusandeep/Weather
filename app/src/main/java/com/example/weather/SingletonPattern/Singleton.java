package com.example.weather.SingletonPattern;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.Retrofit.models.Condition;
import com.example.weather.Retrofit.models.Current;
import com.example.weather.Retrofit.models.Location;
import com.example.weather.Retrofit.models.WeatherData;

import java.util.List;

public class Singleton {

    String mCountry;
    String mTimeZone;
    String mLocalTime;

    String mTemperature;
    String mWindSpeed;
    String mWindDirection;
    String mHumidity;
    String mCloud;
    String mFeelslike;

    String mText;
    String mIcon;

    Location location = new Location();
    Current current = new Current();
    Condition condition = new Condition();


    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry() {
        mCountry = location.getCountry();;
    }

    public String getmTimeZone() {
        return mTimeZone;
    }

    public void setmTimeZone() {
        mTimeZone = location.getTimeZone();
    }

    public String getmLocalTime() {
        return mLocalTime;
    }

    public void setmLocalTime() {
        mLocalTime = location.getLocalTime();
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature() {
        mTemperature = current.getTemp();
    }

    public String getmWindSpeed() {
        return mWindSpeed;
    }

    public void setmWindSpeed() {

        mWindSpeed = current.getWindSpeed();



    }

    public String getmWindDirection() {
        return mWindDirection;
    }

    public void setmWindDirection() {
        mWindDirection = current.getWindDirection();
    }

    public String getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity() {
        mHumidity = current.getHumidity();
    }

    public String getmCloud() {
        return mCloud;
    }

    public void setmCloud() {
        mCloud = current.getCloud();
    }

    public String getmFeelslike() {
        return mFeelslike;
    }

    public void setmFeelslike() {
        mFeelslike = current.getFeelslike();
    }

    public String getmText() {
        return mText;
    }

    public void setmText() {
        mText = condition.getText();

    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon() {
        mIcon = condition.getIconURL();
    }

    private static Singleton instance = new Singleton();

    private Singleton(){
    }

    public static Singleton getInstance(){
        return instance;
    }

}
