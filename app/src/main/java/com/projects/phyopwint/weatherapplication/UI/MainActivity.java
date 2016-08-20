package com.projects.phyopwint.weatherapplication.UI;

import android.content.Context;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.projects.phyopwint.weatherapplication.Adapter.PagerAdapter;
import com.projects.phyopwint.weatherapplication.Model.Weather;
import com.projects.phyopwint.weatherapplication.R;
import com.projects.phyopwint.weatherapplication.Utils.ConnectionHelper;
import com.projects.phyopwint.weatherapplication.Utils.CurrentTrackLocation;
import com.projects.phyopwint.weatherapplication.Utils.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocationManager locationMgr;
    public static String linkURL;
    ConnectionHelper connection;
    Weather weatherDetail;
    List<Weather> weatherDetails;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = new ConnectionHelper(getApplicationContext());
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        if (connection.isNetworkAvailable()) {
            locationMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            CurrentTrackLocation track = new CurrentTrackLocation(getApplicationContext(), locationMgr);
            String longitude = track.longitude;
            String latitude = track.latitude;
            linkURL = String.format("http://api.openweathermap.org/data/2.5/forecast/daily?APPID=049be2fdbe7653c97078dc752d6bc0fa&lat=%s&lon=%s", latitude, longitude);
            Log.e("linkURL", linkURL);

            weatherDetails = new ArrayList<>();

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    JSONObject allDataForecast = JsonParser.getJSONFromUrl(linkURL);
                    try {
                        JSONObject cityData = allDataForecast.getJSONObject("city");
                        String cityName = (String) cityData.get("name");
                        JSONArray arrWeatherList = allDataForecast.getJSONArray("list");
                        for (int i = 0; i < 5; i++) {
                            String combineDate = String.valueOf(arrWeatherList.getJSONObject(i).get("dt").toString());
                            String day = getDay(combineDate)[1];
                            String date = getDay(combineDate)[0];
                            JSONObject objectTemp = arrWeatherList.getJSONObject(i).getJSONObject("temp");
                            String name = cityName;
                            String temp = objectTemp.get("day").toString();
                            String min = objectTemp.get("min").toString();
                            String max = objectTemp.get("max").toString();
                            String humid = arrWeatherList.getJSONObject(i).get("humidity").toString();
                            JSONObject objectWeather = arrWeatherList.getJSONObject(i).getJSONArray("weather").getJSONObject(0);
                            String status = objectWeather.get("description").toString();
                            String icon = objectWeather.get("icon").toString();
                            weatherDetail = new Weather(name, min, max, temp, humid, status, icon, day, date);
                            weatherDetails.add(weatherDetail);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void result) {
                    for (Weather w : weatherDetails) {
                        String arrDay = w.getDay();
//                        String max = w.getMaxTemp();
//                        String min = w.getMinTemp();
//                        String tabText = String.format("%s1 \n %s2/%s3", arrDay,max,min);
                        tabLayout.addTab(tabLayout.newTab().setText(arrDay));
                    }

                    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                    //Pager
                    adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), weatherDetails.get(0));
                    viewPager.setAdapter(adapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                    //TODO
                    viewPager.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View arg0, MotionEvent arg1) {
                            return true;
                        }
                    });

                    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                            adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), weatherDetails.get(tab.getPosition()));

                            viewPager.setAdapter(adapter);
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }

                    });

                }
            }.execute();


        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }

    //Utils Functions
    private String[] getDay(String x) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("E");
        long seconds = Long.parseLong(x);
        long milliSeconds = 1000 * seconds;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        String date = formatter.format(calendar.getTime());
        String day = formatter2.format(calendar.getTime());
        String[] dateNDay = {date, day};
        return dateNDay;
    }
}
