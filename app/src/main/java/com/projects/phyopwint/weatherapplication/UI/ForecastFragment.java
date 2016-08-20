package com.projects.phyopwint.weatherapplication.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.phyopwint.weatherapplication.Model.Weather;
import com.projects.phyopwint.weatherapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
    Bundle bundle;
    TextView txtDay;
    TextView txtCity;
    Weather w;
    private String PARCEL_KEY = "data";

    public ForecastFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = getArguments();
        w = bundle.getParcelable(PARCEL_KEY);
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        txtDay = (TextView) v.findViewById(R.id.textDay);
        txtCity = (TextView) v.findViewById(R.id.textCity);
        txtCity.setText(w.getName().toString());


        return v;
    }
}
