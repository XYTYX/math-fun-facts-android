package com.example.aidan.mathfunfacts;


//import android.app.Fragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {
    ParserMathFunFact MFF;
    View v;

    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tab1, container, false);

        final WebView wv = (WebView) v.findViewById(R.id.webView);
        MFF = collection.findRandomMFF();

        //add rating listener
        addListenerOnRatingBar(v);
        String HTML_content = MFF.getHtmlContent().replaceAll("FFig\\Q(\\E([0-9]+)\\Q)\\E", "Figure $1");

        //replace FFact(bla+bla2) by see fun fact bla bla2
        HTML_content = HTML_content.replaceAll("([a-zA-Z  _:-]+)\\+([a-zA-Z_  :-]+)", "$1 $2 ");
        HTML_content = HTML_content.replaceAll("\\+([a-zA-Z_  :-]+)", "$1 ");
        HTML_content = HTML_content.replaceAll("FFact\\Q(\\E([a-zA-Z1-9 +_]+)\\Q)\\E", " $1");
        //wrap presentating and behind the fact by h2 tag
        HTML_content = HTML_content.replaceAll("Presentation suggestions:", "<h3>Presentation suggestions:</h3>");
        HTML_content = HTML_content.replaceAll("Behind the fact:", "<h3>Behind the fact:</h3>");
        //go through the images folder find all the images correspending to the MFF
        //print the first at the top and other at the bottom
        if(checkFile(MFF.getFilename() + ".1.gif", getContext()) ){
            HTML_content =
                    "<h2>" + MFF.getTitle() + "</h2>"
                            +"<center><figure><img src=\"file:///android_asset/images/" + MFF.getFilename() + ".1.gif" +"\">" +"  <figcaption>Figure 1</figcaption></figure></center>"
                            + HTML_content;

            Integer i = 2;
            while (checkFile(MFF.getFilename() + "."+ i +".gif", getContext()) ) {
                HTML_content +=  "<center><figure><img src=\"file:///android_asset/images/" + MFF.getFilename() + "."+i+".gif" +"\">" +"  <figcaption>Figure "+i+"</figcaption></figure></center>";
                i++;
            }
        }
        else{
            HTML_content =
                    "<h2>" + MFF.getTitle() + "</h2>"
                            + HTML_content;
        }

        wv.loadDataWithBaseURL("file:///android_asset", HTML_content, "text/html", "UTF-8", "file:///android_asset");

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MFF = collection.findRandomMFF();

                //add rating listener
                addListenerOnRatingBar(v);
                String HTML_content = MFF.getHtmlContent().replaceAll("FFig\\Q(\\E([0-9]+)\\Q)\\E", "Figure $1");

                //replace FFact(bla+bla2) by see fun fact bla bla2
                HTML_content = HTML_content.replaceAll("([a-zA-Z_  :]+)\\+([a-zA-Z_  :]+)", "$1 $2 ");
                HTML_content = HTML_content.replaceAll("\\+([a-zA-Z_  :]+)", "$1 ");
                HTML_content = HTML_content.replaceAll("FFact\\Q(\\E([a-zA-Z1-9 +_]+)\\Q)\\E", " $1");
                //wrap presentating and behind the fact by h2 tag
                HTML_content = HTML_content.replaceAll("Presentation suggestions:", "<h3>Presentation suggestions:</h3>");
                HTML_content = HTML_content.replaceAll("Behind the fact:", "<h3>Behind the fact:</h3>");
                //go through the images folder find all the images correspending to the MFF
                //print the first at the top and other at the bottom
                if(checkFile(MFF.getFilename() + ".1.gif", getContext()) ){
                    HTML_content =
                            "<h2>" + MFF.getTitle() + "</h2>"
                                    +"<center><figure><img src=\"file:///android_asset/images/" + MFF.getFilename() + ".1.gif" +"\">" +"  <figcaption>Figure 1</figcaption></figure></center>"
                                    + HTML_content;

                    Integer i = 2;
                    while (checkFile(MFF.getFilename() + "."+ i +".gif", getContext()) ) {
                        HTML_content +=  "<center><figure><img src=\"file:///android_asset/images/" + MFF.getFilename() + "."+i+".gif" +"\">" +"  <figcaption>Figure "+i+"</figcaption></figure></center>";
                        i++;
                    }
                }
                else{
                    HTML_content =
                            "<h2>" + MFF.getTitle() + "</h2>"
                                    + HTML_content;
                }

                wv.loadDataWithBaseURL("file:///android_asset", HTML_content, "text/html", "UTF-8", "file:///android_asset");
            }
        });
        return v;
    }


    public boolean checkFile(String filename,Context context){
        AssetManager am = context.getAssets();
        String[] files = null;
        try {
            files = am.list("images");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String file : files){
            if(file.equalsIgnoreCase(filename))
                return true;
        }

        return false;
    }



    public void addListenerOnRatingBar(View view) {
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                //Toast.makeText(getContext(), "You rated this Math Fun Fact " + String.valueOf(rating) + " stars, thanks.", Toast.LENGTH_LONG).show();

                //modify the value of the MathFunFact Rating
                MFF.setRating(rating);
                //open the Json rating file as an output file
                FileOutputStream fos = null;
                try {
                    fos = getContext().openFileOutput("rating.json", Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                JsonRatingWriter jsonRatingWriter = new JsonRatingWriter();
                try {
                    jsonRatingWriter.writeJsonStream(fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for testing purposes try to display in a raw way what was written in the json file

                try {
                    FileInputStream fis = getContext().openFileInput("rating.json");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });




        ratingBar.setRating(MFF.getRating());

    }
}