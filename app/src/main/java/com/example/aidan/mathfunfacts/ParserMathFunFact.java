package com.example.aidan.mathfunfacts;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Parser math fun fact.
 */
public class ParserMathFunFact {
    private String title;
    private String keywords;
    private String subjects;
    private String level;
    private String htmlContent;
    private String filename;
    private float rating = 0;
    private Context context;


    /**
     *
     * @param Filename
     * @param context
     */
    public ParserMathFunFact(String Filename, Context context){
        this.context = context;
        ParseFile(Filename);
        this.filename = Filename;
    }


    /**
     *
     * @param Filename
     */
    public void ParseFile(String Filename){

        try {
            //opening the file
            InputStreamReader inputFile = new InputStreamReader(context.getAssets().open(Filename));
            BufferedReader reader = new BufferedReader(inputFile);

            //parsing the metadata
            this.title = reader.readLine().substring(7);
            this.keywords = reader.readLine().substring(10);
            this.subjects = reader.readLine().substring(9);
            this.level = reader.readLine().substring(7);

            StringBuilder total = new StringBuilder();

            //wrapping the title with h2 tags
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
            this.htmlContent = total.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Gettings and setters
    public String getFilename() {
        return filename;
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

    public String getHtmlContent() {
        return htmlContent;
    }

    public Context getContext() {
        return context;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    public float getRating() {
        return rating;
    }

}
