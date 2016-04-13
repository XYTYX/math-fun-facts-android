package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MathFunFactsCollection {

    List<ParserMathFunFact> MathFunFacts;
    Context context;

    // Parse all fun facts on create
    public MathFunFactsCollection(Context context) {
        this.MathFunFacts = new ArrayList<ParserMathFunFact>();
        this.context = context;
        ParseAllMathFunFactFile(context);
    }


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

    public ArrayList<ParserMathFunFact> findMFFWithSubject(String subject) {
        Log.d("finding subject: ",subject);
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

    public List<ParserMathFunFact> getAllMathFunFacts() {
    return MathFunFacts;
    }

    public ParserMathFunFact findRandomMFF() {
        Random rand = new Random();
        int n = rand.nextInt(199) + 1;
        return MathFunFacts.get(n);
    }

    // Method called on creatio
    public void ParseAllMathFunFactFile(Context context){
        AssetManager am = context.getAssets();
        try {

            // I start at 1 and end at 200 because index 0's file is
            // differently formatted from the rest, and because our files
            // are in assets, we dip into binary files we don't want to
            // be messing with.
            // TODO we should move the files to res instead of assets

            String[] files = am.list("");
            for (int x = 1; x < 200; x++) {
                MathFunFacts.add(new ParserMathFunFact(files[x],context));
               // System.out.println("Level is *"+MathFunFacts.get(x).getLevel()+"*");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
