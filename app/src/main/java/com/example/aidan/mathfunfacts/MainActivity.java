package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                        break;
                    case 2:
                        tab.setIcon(R.drawable.difficulty_fragment_tab_icon_selected);

                        Intent i = new Intent(getApplicationContext(), Difficulty.class);
                        startActivity(i);

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


        final View view = this.findViewById(android.R.id.content);
        FloatingActionButton fab = (FloatingActionButton)  view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getRandom(v);
            }
        });


        try {
            // Get Assets
            AssetManager am = getApplicationContext().getAssets();

            // Get List of files in assets
            String[] files = am.list("");

            // Get number of files
            int length = files.length;
            String l = " " + length;

            // Get random number to get a random file
            Random rand = new Random();
            int index = rand.nextInt(length-9);
            String fileName = files[index];

            // Create the string for the WebView
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            String message=total.toString();

            // Set the WebView content to the file contents
            WebView wv = (WebView) findViewById(R.id.webView);
            WebSettings settings = wv.getSettings();


            settings.setDefaultFontSize(24);
            //message  = "Title: Multiplication by 11\n" +
            wv.loadData(total.toString(), "text/html", "UTF-8");
            System.out.print("Alis string" + total.toString());



            //funFactTextView.setText(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("printed stack");

            e.printStackTrace();
        }
        System.out.println("printed stack");



        //"10001.1");

        //wv.loadUrl("file:///android_asset/test.html");
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

    public void getRandom(View view) {
        try {

            // Get Android Assets
            AssetManager am = getApplicationContext().getAssets();

            // Get list of files
            String[] files = am.list("");

            // Get number of files
            int length = files.length;

            // Get Random file
            Random rand = new Random();
            int index = rand.nextInt(length-9);
            String fileName = files[index];

            // Read from file and set it to a string to send to the WebView
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            String message=total.toString();
            WebView wv = (WebView) findViewById(R.id.webView);
            //message  = "Title: Multiplication by 11\n" +
            wv.loadData(total.toString(), "text/html", "UTF-8");
            System.out.print("Alis string" + total.toString());



            //funFactTextView.setText(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("printed stack");

            e.printStackTrace();
        }
    }

    public void GoToDifficultySelector(View view) {
        Intent i = new Intent(getApplicationContext(), Difficulty.class);
        startActivity(i);
    }
}