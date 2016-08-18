package com.projects.phyopwint.weatherapplication.Model;

/**
 * Created by phyopwintthu on 8/16/16.
 */

public class Weather {

    private String maxTemp;
    private String minTemp;
    private String temp;
    private String humidity;
    private String cloudStatus;
    private String imageName;
    private String name;
    private String day;

    public Weather(String name) {
        this.cloudStatus = name;
    }

    public Weather(String maxTemp, String minTemp, String temp, String humidity, String cloudStatus, String imageName,String day) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.temp = temp;
        this.humidity = humidity;
        this.cloudStatus = cloudStatus;
        this.imageName = imageName;
        this.day = day;
    }

    public Weather() {
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }


    public String getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(String cloudStatus) {
        this.cloudStatus = cloudStatus;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
