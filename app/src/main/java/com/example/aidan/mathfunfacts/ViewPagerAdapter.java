package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

///**
// * Created by Anders on 3/20/16.
// */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public ViewPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        switch (position) {
            case 0:
                RootFragment tab1 = new RootFragment();
                args.putInt("tab",1);
                tab1.setArguments(args);
                return tab1;
            case 1:
                Tab2Fragment tab2 = new Tab2Fragment();
                return tab2;
            case 2:
                RootFragment tab3 = new RootFragment();
                args.putInt("tab",3);
                tab3.setArguments(args);
                return tab3;
            case 3:
                RootFragment tab4 = new RootFragment();
                args.putInt("tab",4);
                tab4.setArguments(args);
                return tab4;
            case 4:
                Tab5Fragment tab5 = new Tab5Fragment();
                return tab5;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabCount;
    }

}
