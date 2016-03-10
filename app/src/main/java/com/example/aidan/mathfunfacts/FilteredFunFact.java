package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.ArrayList;

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
        int level=0,subject=0;

        if(getIntent().hasExtra("difficulty")) {
            level = (int) bundle.get("difficulty");
            // Get the random file based on difficulty
        }

        if(getIntent().hasExtra("subject")) {
            subject = (int) bundle.get("subject");
        }

        MathFunFactCollection collection = new MathFunFactCollection(this.getApplicationContext());
        ArrayList<MathFunFactMetadata> files = collection.findMFFWithDifficulty(level);


    }

}
