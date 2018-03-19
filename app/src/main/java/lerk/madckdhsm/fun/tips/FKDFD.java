package lerk.madckdhsm.fun.tips;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class FKDFD extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 6;
    private String mode;


    FKDFD(FragmentManager fm, String mode) {
        super(fm);
        this.mode = mode;

    }



    @Override
    public Fragment getItem(int position) {
        return SlideFr.create(position, mode);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}

