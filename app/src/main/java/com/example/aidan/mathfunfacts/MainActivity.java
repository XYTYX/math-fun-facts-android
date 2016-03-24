package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
<<<<<<< HEAD
import android.provider.MediaStore;
=======
>>>>>>> clean-parser
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
<<<<<<< HEAD
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
=======
import java.util.List;
>>>>>>> clean-parser

public class MainActivity extends AppCompatActivity {

    MathFunFactsCollection collection;
<<<<<<< HEAD

=======
    List<ParserMathFunFact> list;
>>>>>>> clean-parser

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        collection = new MathFunFactsCollection(this.getApplicationContext());
        final ListIterator<ParserMathFunFact> iter = collection.getAllMathFunFacts();
=======
        this.collection = new MathFunFactsCollection(this.getApplicationContext());
        this.list = collection.getAllMathFunFacts();
>>>>>>> clean-parser

        final View view = this.findViewById(android.R.id.content);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
<<<<<<< HEAD
                GoToDifficultySelector(v);

//                WebView wv = (WebView) findViewById(R.id.webView);
//                WebSettings settings = wv.getSettings();
//                wv.loadData(iter.next().getHTML_content(), "text/html", "UTF-8");
=======
                WebView wv = (WebView) findViewById(R.id.webView);
                wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
>>>>>>> clean-parser
            }
        });


<<<<<<< HEAD

        String total = iter.next().getHTML_content();

        WebView wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();


        settings.setDefaultFontSize(24);
        wv.loadData(total, "text/html", "UTF-8");
=======
        WebView wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();

        settings.setDefaultFontSize(24);
        wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
>>>>>>> clean-parser

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

<<<<<<< HEAD
//    public void getRandom(View view) {
//        try {
//
//            // Get Android Assets
//            AssetManager am = getApplicationContext().getAssets();
//
//            // Get list of files
//            String[] files = am.list("");
//
//            // Get number of files
//            int length = files.length;
//
//            // Get Random file
//            Random rand = new Random();
//            int index = rand.nextInt(length-9);
//            String fileName = files[index];
//
//            // Read from file and set it to a string to send to the WebView
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(getAssets().open(fileName)));
//            StringBuilder total = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                total.append(line);
//            }
//            String message=total.toString();
//            WebView wv = (WebView) findViewById(R.id.webView);
//            //message  = "Title: Multiplication by 11\n" +
//            wv.loadData(total.toString(), "text/html", "UTF-8");
//            System.out.print("Alis string" + total.toString());
//
//            //funFactTextView.setText(message);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("printed stack");
//
//            e.printStackTrace();
//        }
//    }

    public void GoToDifficultySelector(View view) {
        Intent i = new Intent(getApplicationContext(), Difficulty.class);
//        MathFunFactsCollection mffc = new MathFunFactsCollection(this.getApplicationContext());
//        Bundle b = new Bundle();
//        b.putParcelable("mffc", (Parcelable) mffc);
=======

    public void GoToDifficultySelector(View view) {
        Intent i = new Intent(getApplicationContext(), Difficulty.class);
        MathFunFactsCollection mffc = new MathFunFactsCollection(this.getApplicationContext());
        Bundle b = new Bundle();
        b.putParcelable("mffc", (Parcelable) mffc);
>>>>>>> clean-parser
        startActivity(i);
    }
}
