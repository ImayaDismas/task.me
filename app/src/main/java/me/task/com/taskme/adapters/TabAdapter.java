package me.task.com.taskme.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.task.com.taskme.fragments.LatestFragment;
import me.task.com.taskme.fragments.SavedFragment;
import me.task.com.taskme.fragments.SearchesFragment;

/**
 * Created by root on 11/30/17.
 */

public class TabAdapter extends FragmentPagerAdapter {

//    declare the variables
    public static int int_items = 3;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return fragment with respect to Position .
     */

    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0 : return new LatestFragment();
            case 1 : return new SearchesFragment();
            case 2 : return new SavedFragment();
        }
        return null;
    }

    @Override
    public int getCount() {

        return int_items;

    }

    /**
     * This method returns the title of the tab according to the position.
     */

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "LATEST";
            case 1 :
                return "SEARCHES";
            case 2 :
                return "SAVED";
        }
        return null;
    }
}
