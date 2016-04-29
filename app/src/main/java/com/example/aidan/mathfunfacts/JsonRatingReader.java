package com.example.aidan.mathfunfacts;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static com.example.aidan.mathfunfacts.MainActivity.collection;

/**
 * Created by Ali on 4/25/2016.
 */
public class JsonRatingReader {


    public JsonRatingReader(InputStream inputStream) throws IOException {
        try {
            readJsonStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            readRatingsArray(reader);
        }
        finally{
            reader.close();
        }
    }


    public void readRatingsArray(JsonReader reader) throws IOException {
        //read the array and go through all the objects inside
        reader.beginArray();
        while (reader.hasNext()) {
            readRating(reader);
        }
        reader.endArray();
    }


    public void readRating(JsonReader reader) throws IOException {
        //assume that if not specificed these proprieties are null
        float rating = 0;
        String filename = null;

        //start reading an object from the array
        reader.beginObject();
        //look for name/value pairs i.e. filename & rating
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("filename")) {
                filename = reader.nextString();
            } else if (name.equals("rating")) {
                rating = (float) reader.nextDouble();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        //insert that object in the specific ParserMathFunFact in the collection
        insertRatingInParserMathFunFactObject(rating, filename);
    }

    public void insertRatingInParserMathFunFactObject(float rating, String filename){
        collection.getByFileName(filename).setRating(rating);
    }
}