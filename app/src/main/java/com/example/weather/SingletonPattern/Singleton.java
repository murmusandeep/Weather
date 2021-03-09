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

    String MaxTemp1;
    String MinTemp1;

    String NextText1;
    String NextIcon1;
    String NextDate1;

    String MaxTemp2;
    String MinTemp2;

    String NextText2;
    String NextIcon2;
    String NextDate2;



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

    public String getMaxTemp1() {
        return MaxTemp1;
    }

    public void setMaxTemp1(String maxTemp1) {
        MaxTemp1 = maxTemp1;
    }

    public String getMinTemp1() {
        return MinTemp1;
    }

    public void setMinTemp1(String minTemp1) {
        MinTemp1 = minTemp1;
    }

    public String getNextText1() {
        return NextText1;
    }

    public void setNextText1(String nextText1) {
        NextText1 = nextText1;
    }

    public String getNextIcon1() {
        return NextIcon1;
    }

    public void setNextIcon1(String nextIcon1) {
        NextIcon1 = nextIcon1;
    }

    public String getMaxTemp2() {
        return MaxTemp2;
    }

    public void setMaxTemp2(String maxTemp2) {
        MaxTemp2 = maxTemp2;
    }

    public String getMinTemp2() {
        return MinTemp2;
    }

    public void setMinTemp2(String minTemp2) {
        MinTemp2 = minTemp2;
    }

    public String getNextText2() {
        return NextText2;
    }

    public void setNextText2(String nextText2) {
        NextText2 = nextText2;
    }

    public String getNextIcon2() {
        return NextIcon2;
    }

    public void setNextIcon2(String nextIcon2) {
        NextIcon2 = nextIcon2;
    }

    public String getNextDate1() {
        return NextDate1;
    }

    public void setNextDate1(String nextDate1) {
        NextDate1 = nextDate1;
    }

    public String getNextDate2() {
        return NextDate2;
    }

    public void setNextDate2(String nextDate2) {
        NextDate2 = nextDate2;
    }
}
