package com.projects.phyopwint.weatherapplication.UI;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.support.v4.app.FragmentPagerAdapter;
>>>>>>> parent of c7b11c1... Successfully JSON parsing.
=======
import android.util.Log;
>>>>>>> parent of f51f374... TabLayout Problems
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
<<<<<<< HEAD
<<<<<<< HEAD
    Bundle bundle;
    TextView txtDay;
    TextView txtCity;
    Weather w;
    private String PARCEL_KEY = "data";
=======
>>>>>>> parent of c7b11c1... Successfully JSON parsing.

=======
    TextView cityName;
    Weather weatherCityName;
    Weather weatherDetail;
    List<Weather> weatherDetails;
>>>>>>> parent of f51f374... TabLayout Problems
    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
<<<<<<< HEAD
<<<<<<< HEAD
        txtDay = (TextView) v.findViewById(R.id.textDay);
        txtCity = (TextView) v.findViewById(R.id.textCity);
        txtCity.setText(w.getName().toString());
=======
        cityName = (TextView) v.findViewById(R.id.cityName);
        weatherDetails = new ArrayList<>();
>>>>>>> parent of f51f374... TabLayout Problems

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
<<<<<<< HEAD
=======
        TextView messageTextView = (TextView) v.findViewById(R.id.cityName);
        messageTextView.setText("Tab");
        return v;
    }
}

//        new AsyncTask<Void, Void, Weather>() {
//            @Override
//            protected Weather doInBackground(Void... params) {
//                return WeatherList.jsonRead();
//            }
//            @Override
//            protected void onPostExecute(Weather result) {
//                cityName.setText(result.getName());
//            }
//        }.execute();


>>>>>>> parent of c7b11c1... Successfully JSON parsing.
=======



>>>>>>> parent of f51f374... TabLayout Problems
