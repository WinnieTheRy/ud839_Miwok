package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by RyanHaniff on 2016-09-22.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {

            case 0: return new NumbersFragment();

            case 1: return new ColorsFragment();

            case 2: return new FamilyFragments();

            case 3: return new PhrasesFragment();

            default: return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}
