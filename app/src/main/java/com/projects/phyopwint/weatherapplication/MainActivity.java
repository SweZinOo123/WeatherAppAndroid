package com.projects.phyopwint.weatherapplication;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Lat, Lon;
    LocationManager locationMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        CurrentTrackLocation track = new CurrentTrackLocation(getApplicationContext(), locationMgr);
        // track.getCurrentLocation();
        setContentView(R.layout.activity_main);
        Lat = (TextView) findViewById(R.id.Lat);
        Lon = (TextView) findViewById(R.id.Lon);
        Lat.setText(String.valueOf(track.latitude));
        Lon.setText(String.valueOf(track.longitute));
    }

}

