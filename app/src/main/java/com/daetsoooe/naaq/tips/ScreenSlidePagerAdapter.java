package com.daetsoooe.naaq.tips;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 6;
    private String mode;


    ScreenSlidePagerAdapter(FragmentManager fm, String mode) {
        super(fm);
        this.mode = mode;

    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.create(position, mode);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}

