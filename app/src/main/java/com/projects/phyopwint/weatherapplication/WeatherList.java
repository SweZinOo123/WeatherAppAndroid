package com.projects.phyopwint.weatherapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.projects.phyopwint.weatherapplication.MainActivity.linkURL;

/**
 * Created by phyo.pwint on 17/8/16.
 */

public class WeatherList extends HashMap<String, String> {
    public static List<Weather> jread() {
        List<Weather> list = new ArrayList<Weather>();
        JSONArray forecasts = JsonParser.getJSONArrayFromUrl(linkURL);
        try {
            for (int i = 0; i < forecasts.length(); i++) {
                JSONObject forecast = forecasts.getJSONObject(i);
                list.add(new Weather(forecast.getString("cloudStatus"), forecast.getString("temp")));
            }
        } catch (Exception e) {
            Log.e("NewsItem", "JSONArray error");
        }
        return(list);
    }
}
