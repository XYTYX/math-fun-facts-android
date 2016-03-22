package com.example.aidan.mathfunfacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Anders on 3/20/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabCount;


    public ViewPagerAdapter(FragmentManager fm, int numberOfTabs) {

        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Tab1Fragment tab1 = new Tab1Fragment();

                return tab1;
            case 1:
                Tab1Fragment tab2 = new Tab1Fragment();
                return tab2;
            case 2:
                Tab1Fragment tab3 = new Tab1Fragment();
                return tab3;
            case 3:
                Tab1Fragment tab4 = new Tab1Fragment();
                return tab4;
            case 4:
                Tab1Fragment tab5 = new Tab1Fragment();
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
