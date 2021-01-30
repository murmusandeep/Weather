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

    String Country;
    String TimeZone;
    String LocalTime;

    String Temperature;
    String WindSpeed;
    String WindDirection;
    String Humidity;
    String Cloud;

    String Feelslike;

    String Text;
    String Icon;


    private static Singleton instance = new Singleton();

    private Singleton(){
    }

    public static Singleton getInstance(){
        return instance;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public String getLocalTime() {
        return LocalTime;
    }

    public void setLocalTime(String localTime) {
        LocalTime = localTime;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        WindSpeed = windSpeed;
    }

    public String getWindDirection() {
        return WindDirection;
    }

    public void setWindDirection(String windDirection) {
        WindDirection = windDirection;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getCloud() {
        return Cloud;
    }

    public void setCloud(String cloud) {
        Cloud = cloud;
    }

    public String getFeelslike() {
        return Feelslike;
    }

    public void setFeelslike(String feelslike) {
        Feelslike = feelslike;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

}
