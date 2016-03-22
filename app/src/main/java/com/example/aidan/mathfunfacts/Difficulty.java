package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.random_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.favorite_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.difficulty_fragment_tab_icon_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.subject_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.search_fragment_tab_icon_un_selected)));
//
//        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//
//
//        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(viewPagerAdapter);


//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.random_fragment_tab_icon_selected);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.favorite_fragment_tab_icon_selected);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.difficulty_fragment_tab_icon_selected);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.subject_fragment_tab_icon_selected);
                        break;
                    case 4:
                        tab.setIcon(R.drawable.search_fragment_tab_icon_selected);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.random_fragment_tab_icon_un_selected);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.favorite_fragment_tab_icon_un_selected);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.difficulty_fragment_tab_icon_un_selected);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.subject_fragment_tab_icon_un_selected);
                        break;
                    case 4:
                        tab.setIcon(R.drawable.search_fragment_tab_icon_un_selected);
                        break;
                }


            }

            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void getFunFactByDifficulty(View view) {
        RadioGroup difficultySelector = (RadioGroup) findViewById(R.id.difficultySelector);
        String difficulty = ((RadioButton) findViewById(difficultySelector.getCheckedRadioButtonId())).getText().toString();
        Log.d("Selected ID", difficulty);

        int level;
        if(difficulty.equals("Easy"))
            level = 1;
        else if (difficulty.equals("Medium"))
            level = 2;
        else level = 3;

//        MathFunFactCollection collection = new MathFunFactCollection(this.getApplicationContext());
//        ArrayList<MathFunFactMetadata> files = collection.findMFFWithDifficulty(level);
        Intent intent = new Intent(getApplicationContext(),FilteredFunFact.class);
        intent.putExtra("difficulty", level);
        startActivity(intent);
    }

}
