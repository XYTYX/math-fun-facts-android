package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class FilteredFunFact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_fun_fact);
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

        Bundle bundle = getIntent().getExtras();
        WebView webView = (WebView) findViewById(R.id.display_fun_fact_webview);
        int level = 0, subject = 0;


        MathFunFactsCollection collection = new MathFunFactsCollection(this.getApplicationContext());
        ArrayList<ParserMathFunFact> files = new ArrayList<>();

        // Get the random file based on difficulty
        if(getIntent().hasExtra("difficulty")) {
            level = (int) bundle.get("difficulty");

            files = collection.findMFFWithLevel("" + level);
            Log.d("Level - FilteredFunFact", "_" + level + "_");

        }

        if(getIntent().hasExtra("subject")) {
            subject = (int) bundle.get("subject");
            files = collection.findMFFWithSubject("" + subject);

            Log.d("FilteredFundFact: ", "subject");
        }

        Random random = new Random();
        int index = random.nextInt(files.size() + 1);
        ParserMathFunFact file = files.get(index);
        webView.loadData(file.getHTML_content(),"text/html", "UTF-8");

    }

}
