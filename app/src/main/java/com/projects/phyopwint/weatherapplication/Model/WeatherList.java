package com.projects.phyopwint.weatherapplication.Model;

import android.util.Log;

import com.projects.phyopwint.weatherapplication.Utils.JsonParser;

import org.json.JSONObject;

import java.util.HashMap;

import static com.projects.phyopwint.weatherapplication.UI.MainActivity.linkURL;

/**
 * Created by phyo.pwint on 17/8/16.
 */

public class WeatherList extends HashMap<String, String> {
    public static Weather jsonRead() {
        Weather w = new Weather();
        JSONObject allDataForecast = JsonParser.getJSONFromUrl(linkURL);
        try {
            JSONObject cityData = allDataForecast.getJSONObject("city");
            String cityName = (String) cityData.get("name");
            w.setName(cityName);
        } catch (Exception e) {
            Log.e("NewsItem", "JSONArray error");
        }
        return(w);
    }
}
