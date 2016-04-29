package com.example.aidan.mathfunfacts;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.Random;

/**
 * Created by Ali on 4/13/2016.
 */
public class displaySingleMFF extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_single_mff);
        Bundle bundle = getIntent().getExtras();
        ParserMathFunFact MFF = new ParserMathFunFact((String) bundle.get("MFFFile"),getBaseContext());
        WebView webView = (WebView) findViewById(R.id.singleMFFwebview);
        webView.loadData(MFF.getHtmlContent(),"text/html", "UTF-8");
    }
}
