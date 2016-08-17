package com.projects.phyopwint.weatherapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.projects.phyopwint.weatherapplication.UI.ForecastFragment;

/**
 * Created by phyopwintthu on 8/18/16.
 */

public class PagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 7;

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ForecastFragment();
                case 1:
                    return new ForecastFragment();
                case 2:
                    return new ForecastFragment();
                case 3:
                    return new ForecastFragment();
                case 4:
                    return new ForecastFragment();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

}
