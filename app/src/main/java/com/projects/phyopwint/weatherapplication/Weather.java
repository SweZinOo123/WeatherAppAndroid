package com.projects.phyopwint.weatherapplication;

import java.util.HashMap;

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

    public Weather(String temp,String cloudStatus) {
        this.temp = temp;
        this.cloudStatus = cloudStatus;
    }

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

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
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

    public String getWinds() {
        return winds;
    }

    public void setWinds(String winds) {
        this.winds = winds;
    }
}
