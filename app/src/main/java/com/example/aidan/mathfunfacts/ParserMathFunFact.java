package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ali ELABRIDI.
 */
public class ParserMathFunFact {
    private String title;
    private String keywords;
    private String subjects;
    private String level;
    private String description;
    private String HTML_content;

    private String Filename;
    private float rating = 0;

    Context context;

    public void setRating(float rating) {
        this.rating = rating;
    }
    public float getRating() {
        return rating;
    }

    public ParserMathFunFact(String Filename, Context context){
        this.context = context;
        ParseFile(Filename);
        this.Filename = Filename;
    }

    // Parse the file passed in
    public void ParseFile(String Filename){

        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(Filename)));

//          parsing the metadata

            this.title = reader.readLine().substring(7);
//            Log.d("title", title);

            this.keywords = reader.readLine().substring(10);
//            Log.d("keywords", keywords);

            this.subjects = reader.readLine().substring(9);
//            Log.d("subjects", subjects);

            this.level = reader.readLine().substring(7);
//            Log.d("level", level);

            StringBuilder total = new StringBuilder();

//            wrapping the title with h2 tags
            String headerTitle = "<h2>" + this.title + "</h2>";
            total.append(headerTitle);

//            getting rid of FFdescription
            total.append(reader.readLine().substring(16) + " ");

            String line;
            line = reader.readLine() + " ";

            while (line != null && !line.equals("Submitted by: ")) {
                total.append(line + " ");
                line = reader.readLine();
            }
            this.HTML_content = total.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Gettings and setters
    public String getFilename() {
        return Filename;
    }

    public String getTitle() {
        return title;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public String getHTML_content() {
        return HTML_content;
    }

    public Context getContext() {
        return context;
    }

}
