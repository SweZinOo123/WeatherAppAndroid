package com.projects.phyopwint.weatherapplication.UI;

import android.content.Context;
import android.location.LocationManager;
<<<<<<< HEAD
import android.os.AsyncTask;
=======
import android.net.Uri;
>>>>>>> parent of c7b11c1... Successfully JSON parsing.
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.projects.phyopwint.weatherapplication.Adapter.PagerAdapter;
import com.projects.phyopwint.weatherapplication.Model.Weather;
import com.projects.phyopwint.weatherapplication.R;
import com.projects.phyopwint.weatherapplication.Utils.ConnectionHelper;
import com.projects.phyopwint.weatherapplication.Utils.CurrentTrackLocation;
import com.projects.phyopwint.weatherapplication.Utils.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocationManager locationMgr;
    public static String linkURL;
    ConnectionHelper connection;
    Weather weatherCityName;
    Weather weatherDetail;
    List<Weather> weatherDetails;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = new ConnectionHelper(getApplicationContext());
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Frag1"));
        tabLayout.addTab(tabLayout.newTab().setText("Frag2"));
        tabLayout.addTab(tabLayout.newTab().setText("Frag3"));
        tabLayout.addTab(tabLayout.newTab().setText("Frag4"));
        tabLayout.addTab(tabLayout.newTab().setText("Frag5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        if (connection.isNetworkAvailable()) {
            locationMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            CurrentTrackLocation track = new CurrentTrackLocation(getApplicationContext(), locationMgr);
            String longitude = track.longitude;
            String latitude = track.latitude;
            linkURL = String.format("http://api.openweathermap.org/data/2.5/forecast/daily?APPID=049be2fdbe7653c97078dc752d6bc0fa&lat=%s&lon=%s", latitude, longitude);
<<<<<<< HEAD
            Log.e("linkURL", linkURL);

            weatherDetails = new ArrayList<>();

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
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
                    return null;
                }

                @Override
                protected void onPostExecute(Void result) {
                    bundle.putParcelable("DATA",weatherCityName);
                    for (Weather w: weatherDetails) {
                        Log.e("CloudStatus", w.getCloudStatus());
                    }
                }
            }.execute();


            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), weatherCityName);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }

            });
=======
>>>>>>> parent of c7b11c1... Successfully JSON parsing.

            Fragment fragment = new ForecastFragment();
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.FrameContainer, fragment, null);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}