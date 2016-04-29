package com.example.aidan.mathfunfacts;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static com.example.aidan.mathfunfacts.MainActivity.collection;

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
        reader.beginArray();
        while (reader.hasNext()) {
            readRating(reader);
        }
        reader.endArray();
    }


    public void readRating(JsonReader reader) throws IOException {
        float rating = 0;
        String filename = null;


        reader.beginObject();
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
        insertRatingInParserMathFunFactObject(rating, filename);
    }

    public void insertRatingInParserMathFunFactObject(float rating, String filename){
        collection.getByFileName(filename).setRating(rating);
    }
}