package com.example.aidan.mathfunfacts;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //test2
        String htmlContent = "";
        WebView wv = (WebView) findViewById(R.id.infoWebView);
        htmlContent = htmlContent + "<h2><b>Developed for: </b></h2>";
        htmlContent = htmlContent + "<center><h3>Prof. Francis E. Su</h3>";
        htmlContent = htmlContent + "<h4>Benediktsson-Karwa Professor of Mathematics</h4>";
        htmlContent = htmlContent + "<h5>Department of Mathematics</h5>";
        htmlContent = htmlContent + "<h5>Harvey Mudd College</h5></center><br>";
        htmlContent = htmlContent + "<h2><b>By:</b></h2>";
        htmlContent = htmlContent + "<center><h3>Anders Chaplin</h3>";
        htmlContent = htmlContent + "<h4>Claremont McKenna College</h4>";
        htmlContent = htmlContent + "<a href = \"https://github.com/achaplin17\">https://github.com/achaplin17</a>";
        htmlContent = htmlContent + "<h3>Aidan Cheng</h3>";
        htmlContent = htmlContent + "<h4>Claremont McKenna College</h4>";
        htmlContent = htmlContent + "<a href = \"https://github.com/xytyx\">https://github.com/xytyx</a>";
        htmlContent = htmlContent + "<h3>Ali Elabridi</h3>";
        htmlContent = htmlContent + "<h4>Al Akhawayn University</h4>";
        htmlContent = htmlContent + "<a href = \"https://github.com/alielabridi\">https://github.com/alielabridi</a>";
        htmlContent = htmlContent + "<h3>Anant Jaitha</h3>";
        htmlContent = htmlContent + "<h4>Claremont McKenna College</h4>";
        htmlContent = htmlContent + "<a href = \"https://github.com/ajaitha17\">https://github.com/ajaitha17</a></center>";

        wv.loadData(htmlContent, "text/html", "UTF-8");

//        String uri = this.getResources().toString();
//        String url = this.getPackageResourcePath();
//        String dir = getFilesDir().toString();
//
//
//        Log.d("Resources Folder", uri);
//        Log.d("Resouce Path", url);
//        Log.d("FilesDir", dir);
    }

}
