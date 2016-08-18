package com.projects.phyopwint.weatherapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.projects.phyopwint.weatherapplication.UI.ForecastFragment;

/**
 * Created by phyopwintthu on 8/18/16.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ForecastFragment tab1 = new ForecastFragment();
                return tab1;
            case 1:
                ForecastFragment tab2 = new ForecastFragment();
                return tab2;
            case 2:
                ForecastFragment tab3 = new ForecastFragment();
                return tab3;
            case 3:
                ForecastFragment tab4 = new ForecastFragment();
                return tab4;
            case 4:
                ForecastFragment tab5 = new ForecastFragment();
                return tab5;
            case 5:
                ForecastFragment tab6 = new ForecastFragment();
                return tab6;
            case 6:
                ForecastFragment tab7 = new ForecastFragment();
                return tab7;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
