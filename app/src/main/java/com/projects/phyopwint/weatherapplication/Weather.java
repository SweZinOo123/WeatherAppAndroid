package com.projects.phyopwint.weatherapplication;

/**
 * Created by phyopwintthu on 8/16/16.
 */

public class Weather {

    private String maxTemp;
    private String minTemp;
    private String temp;
    private String humidity;
    private String pressure;
    private String cloudStatus;
    private String imageName;
    private String winds;


    public Weather(String maxTemp, String minTemp, String temp, String humidity, String pressure, String cloudStatus, String imageName, String winds) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.cloudStatus = cloudStatus;
        this.imageName = imageName;
        this.winds = winds;
    }

    public Weather() {
    }
}
