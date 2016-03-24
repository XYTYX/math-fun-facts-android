package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
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
import java.util.ListIterator;
import java.util.Random;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MathFunFactsCollection collection;
    List<ParserMathFunFact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.collection = new MathFunFactsCollection(this.getApplicationContext());
        this.list = collection.getAllMathFunFacts();

        final View view = this.findViewById(android.R.id.content);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToDifficultySelector(v);
//                WebView wv = (WebView) findViewById(R.id.webView);
//                wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
            }
        });

        WebView wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();

        settings.setDefaultFontSize(24);
        wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");

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
