package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
