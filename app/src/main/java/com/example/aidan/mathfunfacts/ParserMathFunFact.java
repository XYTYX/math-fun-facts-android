package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
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
    Context context;

    public ParserMathFunFact(String Filename, Context context){
        this.context = context;
        ParseFile(Filename);
    }

    // Parse the file passed in
    public void ParseFile(String Filename){

        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(Filename)));

//          parsing the metadata

            this.title = reader.readLine().substring(7);
            Log.d("title", title);

            this.keywords = reader.readLine().substring(10);
            Log.d("keywords", keywords);

            this.subjects = reader.readLine().substring(9);
            Log.d("subjects", subjects);

            this.level = reader.readLine().substring(7);
            Log.d("level", level);

//            this.description = reader.readLine().substring(16);
//            Log.d("description", description);


            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            this.HTML_content = total.toString();
            Log.d("Full String", HTML_content);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Gettings and setters

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
