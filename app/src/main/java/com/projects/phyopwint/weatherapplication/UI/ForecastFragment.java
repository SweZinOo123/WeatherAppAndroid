package com.projects.phyopwint.weatherapplication.UI;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.phyopwint.weatherapplication.Model.Weather;
import com.projects.phyopwint.weatherapplication.R;
import com.projects.phyopwint.weatherapplication.Utils.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.projects.phyopwint.weatherapplication.UI.MainActivity.linkURL;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
    TextView cityName;
    Weather weatherCityName;
    Weather weatherDetail;
    List<Weather> weatherDetails;
    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        cityName = (TextView) v.findViewById(R.id.cityName);
        weatherDetails = new ArrayList<>();

        new AsyncTask<Void, Void, Weather>() {
            @Override
            protected Weather doInBackground(Void... params) {

                JSONObject allDataForecast = JsonParser.getJSONFromUrl(linkURL);
                try {
                    JSONObject cityData = allDataForecast.getJSONObject("city");
                    String cityName = (String) cityData.get("name");
                    weatherCityName = new Weather(cityName);
                    JSONArray arrWeatherList = allDataForecast.getJSONArray("list");
                    for(int i=0;i<arrWeatherList.length();i++) {
                        String date = arrWeatherList.getJSONObject(i).get("dt").toString();
                        JSONObject objectTemp = arrWeatherList.getJSONObject(i).getJSONObject("temp");
                        String temp = objectTemp.get("day").toString();
                        String min = objectTemp.get("min").toString();
                        String max = objectTemp.get("max").toString();
                        String humid = arrWeatherList.getJSONObject(i).get("humidity").toString();
                        JSONObject objectWeather = arrWeatherList.getJSONObject(i).getJSONArray("weather").getJSONObject(0);
                        String status = objectWeather.get("description").toString();
                        String icon = objectWeather.get("icon").toString();
                        weatherDetail = new Weather(min,max,temp,humid,status,icon,date);
                        weatherDetails.add(weatherDetail);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return weatherCityName;
            }

            @Override
            protected void onPostExecute(Weather result) {
                cityName.setText(result.getName());
                for (Weather w: weatherDetails) {
                    Log.e("CloudStatus", w.getCloudStatus());
                }
            }
        }.execute();

        return v;
    }
}



