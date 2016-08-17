package com.projects.phyopwint.weatherapplication.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.phyopwint.weatherapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
    TextView cityName;

    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        cityName = (TextView) view.findViewById(R.id.cityName);


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
        return view;
    }
}

