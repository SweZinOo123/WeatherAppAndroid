package com.projects.phyopwint.weatherapplication.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.projects.phyopwint.weatherapplication.Model.Weather;
import com.projects.phyopwint.weatherapplication.UI.ForecastFragment;

/**
 * Created by phyopwintthu on 8/18/16.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private Weather weather;
    private String PARCEL_KEY = "data";


    public PagerAdapter(FragmentManager fm, int NumOfTabs, Weather data) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.weather = data;

    }


    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARCEL_KEY, weather);

        switch (position) {
            case 0:
                ForecastFragment tab1 = new ForecastFragment();
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                ForecastFragment tab2 = new ForecastFragment();
                tab2.setArguments(bundle);
                return tab2;
            case 2:
                ForecastFragment tab3 = new ForecastFragment();
                tab3.setArguments(bundle);
                return tab3;
            case 3:
                ForecastFragment tab4 = new ForecastFragment();
                tab4.setArguments(bundle);
                return tab4;
            case 4:
                ForecastFragment tab5 = new ForecastFragment();
                tab5.setArguments(bundle);
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
