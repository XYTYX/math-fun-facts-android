package com.example.aidan.mathfunfacts;

import android.util.JsonWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static com.example.aidan.mathfunfacts.MainActivity.collection;

/**
 * Created by Ali on 4/20/2016.
 */
public final class JsonRatingWriter {

    public void writeJsonStream(OutputStream out) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

        //set the indentation to well format the json file
        writer.setIndent("  ");

        //beging structuring an array with ParserMathFunFact Objects inside of it
        writer.beginArray();
        for (ParserMathFunFact mathFunFact : collection.getAllMathFunFacts()) {
            writeRatingObject(writer, mathFunFact);
        }

        writer.endArray();
        writer.close();
    }


    public void writeRatingObject(JsonWriter writer, ParserMathFunFact mathFunFact) throws IOException {
        //create an object with name/value pairs filename & rating
        writer.beginObject();
        writer.name("filename").value(mathFunFact.getFilename());
        writer.name("rating").value(mathFunFact.getRating());
        writer.endObject();
    }




}
