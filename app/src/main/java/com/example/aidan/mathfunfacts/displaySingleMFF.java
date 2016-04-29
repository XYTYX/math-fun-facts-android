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
        WebView webView = (WebView) findViewById(R.id.singleWebview);
        String HTML_content = MFF.getHtmlContent().replaceAll("FFig\\Q(\\E([0-9]+)\\Q)\\E", " <br> <center><img src=\"file:///android_asset/images/" + MFF.getFilename() + ".$1.gif\"> </center><br>");

        webView.loadDataWithBaseURL("file:///android_asset", HTML_content, "text/html", "UTF-8", "file:///android_asset");

    }
}
