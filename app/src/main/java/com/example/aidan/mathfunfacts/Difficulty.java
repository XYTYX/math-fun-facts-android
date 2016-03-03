package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
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
            String fileName = "10001.1";

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

        }
        catch (Exception e) {
            e.printStackTrace();
        }
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

        MathFunFactCollection collection = new MathFunFactCollection(this.getApplicationContext());
        ArrayList<MathFunFactMetadata> files = collection.findMFFWithDifficulty(level);
    }

}
