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

        switch (position) {
            case 0:
                Bundle args = new Bundle();
                args.putString("random","10001.1-4");
                //Tab1Fragment tab1 = new Tab1Fragment();
                DisplayOneMFF tab1 = new DisplayOneMFF();
                tab1.setArguments(args);
                return tab1;
            case 1:
                Tab2Fragment tab2 = new Tab2Fragment();
                return tab2;
            case 2:
                DifficultyRootFragment tab3 = new DifficultyRootFragment();
                return tab3;
            case 3:
                SubjectRootFragment tab4 = new SubjectRootFragment();
                return tab4;
            case 4:
                SearchRootFragment tab5 = new SearchRootFragment();
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
