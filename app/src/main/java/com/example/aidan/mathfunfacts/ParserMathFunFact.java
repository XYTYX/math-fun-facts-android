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

import static com.example.aidan.mathfunfacts.Subject.*;

/**
 * Created by Ali ELABRIDI.
 */
public class ParserMathFunFact {
    private String Title;
    ArrayList<String> Keywords;
    ArrayList<Subject> Subjects;
    private int Level;
    Context context;
    private String Description;
    String HTML_content;

    public ParserMathFunFact(String Filename, Context context){
        this.context = context;
        ParseFile(Filename);
    }

    public void ParseFile(String Filename){


        try {
            Keywords = new ArrayList<>();
            Subjects = new ArrayList<>();
            AssetManager am = context.getApplicationContext().getAssets();
            String[] files = am.list("");
            int length = files.length;
            String l = " " + length;
            Random rand = new Random();
            int index = rand.nextInt(length);

            //String fileName = files[index];

            /*setting the title*/
            //TextView tv = (TextView) findViewById(R.id.textView);
            //tv.setText(fileName + index);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(Filename)));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            String message=total.toString();
            Log.d("Filename", Filename);
            
            /*setting the webview*/
            //WebView wv = (WebView) findViewById(R.id.webView);
            
            //message  = "Title: Multiplication by 11\n" +
            //wv.loadData(total.toString(), "text/html", "UTF-8");
            Log.d("tag", "Alis string" + total.toString());
            String RawParsedData = total.toString();

            Scanner parser = new Scanner(RawParsedData).useDelimiter("\\s*Keywords:\\s*");
            Title = parser.next();
            Log.d("Title",Title);

            /*parsing the keywords*/
            RawParsedData = RawParsedData.replace(Title, "");
            Log.d("RawParsedData" , RawParsedData);
            parser = new Scanner(RawParsedData).useDelimiter("Subject:\\s*");
            String KeywordsString = parser.next();
            Log.d("KeywordString", KeywordsString);
            KeywordsString = KeywordsString.replace("Keywords:","");
            Scanner SingleKeywordParser = new Scanner(KeywordsString).useDelimiter(",|\n");
            while(SingleKeywordParser.hasNext()){
                Keywords.add(SingleKeywordParser.next().trim());
            }
            Log.d("Size_array", Integer.toString(Keywords.size()));


            for(String keyword : Keywords){
                Log.d("Keyword",keyword);
            }

            RawParsedData = RawParsedData.replace(KeywordsString,"");
            RawParsedData = RawParsedData.replace("Keywords:", "");
            Log.d("Subject & Rest", RawParsedData);
            parser = new Scanner(RawParsedData).useDelimiter("Level:");
            String SubjectsString = parser.next();
            Log.d("SubjectsString", SubjectsString);
            SubjectsString = SubjectsString.replace("Subject:","");
            Scanner SingleSubjectParser = new Scanner(SubjectsString).useDelimiter(",|\n");
            int SubjectParsed;
            while(SingleSubjectParser.hasNext()){
                SubjectParsed = Integer.parseInt(SingleSubjectParser.next().trim());
                Subjects.add(IntegerToEnumSubject(SubjectParsed));
            }
            Log.d("Size_array of Subjects", Integer.toString(Subjects.size()));


            for(Subject subject : Subjects){
                Log.d("Subject",subject.name().toLowerCase());
            }


            Level = Integer.parseInt(Filename.substring(0,1));
            Log.d("Level",Integer.toString(Level));

            Scanner HTML = new Scanner(RawParsedData).useDelimiter("FF Description:");
            HTML_content = RawParsedData.replace(HTML.next(),"");
            Log.d("HTML",HTML_content);




            //funFactTextView.setText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getTitle() {
        return Title;
    }

    public ArrayList<String> getKeywords() {
        return Keywords;
    }

    public ArrayList<Subject> getSubjects() {
        return Subjects;
    }

    public int getLevel() {
        return Level;
    }

    public Context getContext() {
        return context;
    }

    public String getDescription() {
        return Description;
    }

    public String getHTML_content() {
        return HTML_content;
    }
    public Subject IntegerToEnumSubject(int IntegerSubject){
        if (IntegerSubject == 1)
            return SUBJECT1;
        else if(IntegerSubject == 2)
            return SUBJECT2;
        return NONE;
    }
}
