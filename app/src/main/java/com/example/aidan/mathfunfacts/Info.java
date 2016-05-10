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
        htmlContent = htmlContent + "<P><h3>Project Director:</h3>";
        htmlContent = htmlContent + "<P>Professor <a href=\"http://www.math.hmc.edu/~su/\">Francis Edward Su</a>";
        htmlContent = htmlContent + "<br>Benediktsson-Karwa Professor of Mathematics";
        htmlContent = htmlContent + "<br>Department of Mathematics";
        htmlContent = htmlContent + "<br>Harvey Mudd College";
        htmlContent = htmlContent + "<h3>Developers:</h3>";
        htmlContent = htmlContent + "<P>Anders Chaplin";
        htmlContent = htmlContent + "<br>Claremont McKenna College";
        htmlContent = htmlContent + "<br><a href = \"https://github.com/achaplin17\">https://github.com/achaplin17</a>";
        htmlContent = htmlContent + "<P>Aidan Cheng";
        htmlContent = htmlContent + "<br>Claremont McKenna College";
        htmlContent = htmlContent + "<br><a href = \"https://github.com/xytyx\">https://github.com/xytyx</a>";
        htmlContent = htmlContent + "<P>Ali Elabridi";
        htmlContent = htmlContent + "<br>Al Akhawayn University";
        htmlContent = htmlContent + "<br><a href = \"https://github.com/alielabridi\">https://github.com/alielabridi</a>";
        htmlContent = htmlContent + "<P>Anant Jaitha";
        htmlContent = htmlContent + "<br>Claremont McKenna College";
        htmlContent = htmlContent + "<br><a href = \"https://github.com/ajaitha17\">https://github.com/ajaitha17</a>";
        htmlContent = htmlContent + "<P><h3>About Math Fun Facts:</h3> I developed Math Fun Facts in 1994 as a warm-up activity for the calculus courses I taught at Harvard. ";
        htmlContent = htmlContent + "I wanted my students to see that Math is more than just calculus--- it is full of beautiful and accessible ideas, aha! moments, and ";
        htmlContent = htmlContent + "new ways of thinking.  Fun Facts are meant to be presented in less than 5 minutes, to whet one's appetite for learning more math! ";
        htmlContent = htmlContent + "<P>";
        htmlContent = htmlContent + "This app contains hundreds of Fun Facts I have collected over the years.  They are also available on my <i>Math Fun Facts</i> website, ";
        htmlContent = htmlContent + "but the nice thing about this app is that it is mobile and does not require an internet connection.";
        htmlContent = htmlContent + "<P>";
        htmlContent = htmlContent + "Writing these Fun Facts has been a labor of love for me, but I have had lots of help.  ";
        htmlContent = htmlContent + "I'd like to thank <a href=\"http://www.math.hmc.edu/funfacts/contrib.shtml\">fans</a> ";
        htmlContent = htmlContent + "who contributed several ideas, my colleagues at Harvey Mudd College (for generous support of this project), ";
        htmlContent = htmlContent + "Christian Jones (who coded the website), and Ian Schempp (who made many figures). ";
        htmlContent = htmlContent + "And the thanks for this app goes to Professor Jessica Wu and students Anders Chaplin, Aidan Cheng, Ali Elabridi, and Anant Jaitha! ";
        htmlContent = htmlContent + "<P>";
        htmlContent = htmlContent + "Enjoy the app!  Thank you for your support of high-quality high-level mathematics content for Android.";
        htmlContent = htmlContent + "<P><a href=\"http://www.math.hmc.edu/~su/\">Francis Su</a>";


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
