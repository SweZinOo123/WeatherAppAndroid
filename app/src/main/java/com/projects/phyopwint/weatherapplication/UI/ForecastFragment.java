package com.projects.phyopwint.weatherapplication.UI;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    TextView txtDate;
    TextView txtTemp;
    TextView txtHumid;
    TextView txtStatus;
    ImageView imgIcon;
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
        txtDate = (TextView) v.findViewById(R.id.textDate);
        txtTemp = (TextView) v.findViewById(R.id.textTemp);
        txtHumid = (TextView) v.findViewById(R.id.textHumid);
        txtStatus = (TextView) v.findViewById(R.id.textDesc);
        imgIcon = (ImageView) v.findViewById(R.id.imageViewIcon);
        txtCity.setText(w.getName());
        txtDay.setText(w.getDay());
        txtDate.setText(w.getDate());
        txtTemp.setText(w.getTemp()+"°C");
        txtStatus.setText(w.getCloudStatus());
        txtHumid.setText("Humidity - "+w.getHumidity());
        //Setting Dynamic Images
        String imgName = String.format("art_%s", w.getImageName().substring(0, 2));
        String PACKAGE_NAME = getContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME + ":drawable/" + imgName, null, null);
        imgIcon.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
        return v;
    }
}