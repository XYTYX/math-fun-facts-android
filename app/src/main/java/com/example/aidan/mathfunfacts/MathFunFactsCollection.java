package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MathFunFactsCollection {

    ArrayList<ParserMathFunFact> MathFunFacts;
    Context context;

    /**
     * Parse all fun facts on create as soon as the MathFunFactsColllection is created
     * @param context
     */
    public MathFunFactsCollection(Context context) {
        this.MathFunFacts = new ArrayList<ParserMathFunFact>();
        this.context = context;
        ParseAllMathFunFactFile(context);
    }

    /**
     * find all the MathFunFacts with a certain level
     *helper method for the search by level fragment
     * @param level
     * @return  ArrayList<ParserMathFunFact>
     */
    public ArrayList<ParserMathFunFact> findMFFWithLevel(String level) {

        ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
        ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
        while (iter.hasNext()) {
            ParserMathFunFact mathfunfact = iter.next();
            if (mathfunfact.getLevel().equals(level)) {
                results.add(mathfunfact);
            }
        }
        return results;
    }
    /**
     * find all the MathFunFacts with a certain subject
     *helper method for the search by subject fragment
     * @param subject
     * @return ArrayList<ParserMathFunFact>
     */
    public ArrayList<ParserMathFunFact> findMFFWithSubject(String subject) {
        ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
        ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
            while (iter.hasNext()) {
                ParserMathFunFact mathfunfact = iter.next();
    			if(mathfunfact.getSubjects().contains(subject)) {
                    results.add(mathfunfact);
                }
            }
            return results;
    }

    /**
     * return all MFFS
     * @return ArrayList<ParserMathFunFact>
     */
    public ArrayList<ParserMathFunFact> getAllMathFunFacts() {
        return MathFunFacts;
    }

    /**
     * return the MFF that has a specific filename
     * @param fileName
     * @return ParserMathFunFact
     */
    public ParserMathFunFact getByFileName(String fileName){
        for(ParserMathFunFact MFF : MathFunFacts){
            if(MFF.getFilename().equals(fileName)){
                return MFF;
            }
        }
        return null;
    }

    /**
     *sort the MFFs by rating using a comparator since it is what s needed for
     *the favorite fragment
     * @return ArrayList<ParserMathFunFact>
     */
    public ArrayList<ParserMathFunFact> getAllMathFunFactsSortedByRating() {
        Collections.sort(MathFunFacts, new RatingComparator());
        return MathFunFacts;
    }

    /**
     * randomly pick a MFF from the array to display in the random display MFF first fragment
     * @return ParserMathFunFact
     */
    public ParserMathFunFact findRandomMFF() {
        Random rand = new Random();
        int n = rand.nextInt(MathFunFacts.size());
        return MathFunFacts.get(n);
    }

    /**
     * go through all the files present in the assets folder.
     * parse them, and add them to our array of MFFs
     * Method called on create
     * @param context
     */
    public void ParseAllMathFunFactFile(Context context){
        AssetManager am = context.getAssets();
        try {
            String[] files = am.list("");
            ParserMathFunFact temp;
            //started with 1 to avoid a binary file
            for (int x = 1; x < files.length; x++) {
                //add only the files that have filename that start with 1, 2, 3
                // because that how the funfacts are nameed if not binary
                char firstCharOfFileName = files[x].charAt(0);
                if (firstCharOfFileName == '1' || firstCharOfFileName == '2' || firstCharOfFileName == '3'){
                    temp = new ParserMathFunFact(files[x],context);
                    MathFunFacts.add(temp);
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
