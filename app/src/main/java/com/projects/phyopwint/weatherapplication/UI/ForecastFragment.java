package com.projects.phyopwint.weatherapplication.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
=======
import android.support.v4.app.FragmentPagerAdapter;
>>>>>>> parent of c7b11c1... Successfully JSON parsing.
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.phyopwint.weatherapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
<<<<<<< HEAD
    Bundle bundle;
    TextView txtDay;
    TextView txtCity;
    Weather w;
    private String PARCEL_KEY = "data";
=======
>>>>>>> parent of c7b11c1... Successfully JSON parsing.

    public ForecastFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = getArguments();
        w = bundle.getParcelable(PARCEL_KEY);
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
<<<<<<< HEAD
        txtDay = (TextView) v.findViewById(R.id.textDay);
        txtCity = (TextView) v.findViewById(R.id.textCity);
        txtCity.setText(w.getName().toString());


        return v;
    }
}
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
