package com.projects.phyopwint.weatherapplication.UI;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.projects.phyopwint.weatherapplication.Adapter.PagerAdapter;
import com.projects.phyopwint.weatherapplication.R;
import com.projects.phyopwint.weatherapplication.Utils.ConnectionHelper;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    LocationManager locationMgr;
    public static String linkURL;
    ConnectionHelper connection;
    TabLayout tabLayout;

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = new ConnectionHelper(getApplicationContext());
        setContentView(R.layout.activity_main);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(), "Selected page position: " + position, LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpPager);

//        if (connection.isNetworkAvailable()) {
//            locationMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//            CurrentTrackLocation track = new CurrentTrackLocation(getApplicationContext(), locationMgr);
//            String longitude = track.longitude;
//            String latitude = track.latitude;
//            linkURL = String.format("http://api.openweathermap.org/data/2.5/forecast/daily?APPID=049be2fdbe7653c97078dc752d6bc0fa&lat=%s&lon=%s", latitude, longitude);
//
//            Fragment fragment = new ForecastFragment();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.add(R.id.FrameContainer, fragment, null);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        } else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
//            Fragment fragment = new ForecastFragment();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.add(R.id.FrameContainer, fragment, null);
//            transaction.addToBackStack(null);
//            transaction.commit();
        //}
    }
}

