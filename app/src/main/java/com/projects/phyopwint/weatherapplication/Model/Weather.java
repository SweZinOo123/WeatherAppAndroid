package com.projects.phyopwint.weatherapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phyopwintthu on 8/16/16.
 */

public class Weather implements Parcelable {

    private String maxTemp;
    private String minTemp;
    private String temp;
    private String humidity;
    private String cloudStatus;
    private String imageName;
    private String name;
    private String day;
    private String date;

    public Weather(String name, String maxTemp, String minTemp, String temp, String humidity, String cloudStatus, String imageName, String day, String date) {
        this.name = name;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.temp = temp;
        this.humidity = humidity;
        this.cloudStatus = cloudStatus;
        this.imageName = imageName;
        this.day = day;
        this.date = date;
    }

    protected Weather(Parcel in) {
        maxTemp = in.readString();
        minTemp = in.readString();
        temp = in.readString();
        humidity = in.readString();
        cloudStatus = in.readString();
        imageName = in.readString();
        name = in.readString();
        day = in.readString();
        date = in.readString();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getTemp() {
        return temp;
    }

    public String getHumidity() {
        return humidity;
    }


    public String getCloudStatus() {
        return cloudStatus;
    }

    public String getImageName() {
        return imageName;
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

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maxTemp);
        dest.writeString(minTemp);
        dest.writeString(temp);
        dest.writeString(humidity);
        dest.writeString(cloudStatus);
        dest.writeString(imageName);
        dest.writeString(name);
        dest.writeString(day);
        dest.writeString(date);
    }

}
