package com.gereonelvers.android.shguide;
/**
 * Created by Gereon on 2018-04-14.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PageViewAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Nature", "Entertainment", "Churches", "Other", "About" };

    public PageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NatureFragment();
        } else if (position == 1){
            return new EntertainmentFragment();
        } else if (position == 2) {
            return new ChurchesFragment();
        } else if (position == 3){
            return new OtherFragment();
        } else {
            return new AboutFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
