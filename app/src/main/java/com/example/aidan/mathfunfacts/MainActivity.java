package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.ListIterator;
import java.util.Random;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MathFunFactsCollection collection;
    List<ParserMathFunFact> list;

    // Creates a MathFunFactsCollection, which then parses all of the MFFs
    // Creates a floating action button that retrieves a random MFF on click
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.collection = new MathFunFactsCollection(this.getApplicationContext());
        this.list = collection.getAllMathFunFacts();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //default set random to selected since this is first view to show after app load
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.random_fragment_tab_icon_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.favorite_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.difficulty_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.subject_fragment_tab_icon_un_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon((R.drawable.search_fragment_tab_icon_un_selected)));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2 Item"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3 Item"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 4 Item"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 5 Item"));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.random_fragment_tab_icon_selected);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.favorite_fragment_tab_icon_selected);


//                        Intent j = new Intent(getApplicationContext(), favorites.class);
//                        startActivity(j);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.difficulty_fragment_tab_icon_selected);
//
//                        Intent i = new Intent(getApplicationContext(), Difficulty.class);
//                        startActivity(i);
                        overridePendingTransition(0,0);



//                        this.startActivity(new Intent(v.getContext(), newactivity.class));
//                        this.overridePendingTransition(0, 0);
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
                viewPager.setCurrentItem(tab.getPosition());
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
                viewPager.setCurrentItem(tab.getPosition());
            }
        });


        final View view = this.findViewById(android.R.id.content);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WebView wv = (WebView) findViewById(R.id.webView);
                wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
//                GoToDifficultySelector(v);
            }
        });

//        WebView wv = (WebView) findViewById(R.id.webView);
//        WebSettings settings = wv.getSettings();
//
//        settings.setDefaultFontSize(24);
//        wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");

        System.out.println("printed stack");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void GoToDifficultySelector(View view) {
        Intent i = new Intent(getApplicationContext(), Difficulty.class);
//        MathFunFactsCollection mffc = new MathFunFactsCollection(this.getApplicationContext());
//        Bundle b = new Bundle();
//        b.putParcelable("mffc", (Parcelable) mffc);
        startActivity(i);
    }
}
