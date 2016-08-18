package com.projects.phyopwint.weatherapplication.UI;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.projects.phyopwint.weatherapplication.Adapter.PagerAdapter;
import com.projects.phyopwint.weatherapplication.R;
import com.projects.phyopwint.weatherapplication.Utils.ConnectionHelper;
import com.projects.phyopwint.weatherapplication.Utils.CurrentTrackLocation;

public class MainActivity extends AppCompatActivity {
    LocationManager locationMgr;
    public static String linkURL;
    ConnectionHelper connection;

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
        tabLayout.addTab(tabLayout.newTab().setText("Frag6"));
        tabLayout.addTab(tabLayout.newTab().setText("Frag7"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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

        if (connection.isNetworkAvailable()) {
            locationMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            CurrentTrackLocation track = new CurrentTrackLocation(getApplicationContext(), locationMgr);
            String longitude = track.longitude;
            String latitude = track.latitude;
            linkURL = String.format("http://api.openweathermap.org/data/2.5/forecast/daily?APPID=049be2fdbe7653c97078dc752d6bc0fa&lat=%s&lon=%s", latitude, longitude);
            Log.e("linkURL", linkURL);
            Fragment fragment = new ForecastFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.FrameContainer, fragment, null);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}