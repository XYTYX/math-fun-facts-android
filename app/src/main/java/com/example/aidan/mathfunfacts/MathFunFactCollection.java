package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.content.res.AssetManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MathFunFactCollection {

    ArrayList<MathFunFactMetadata> MathFunFacts;
    Context context;

    public MathFunFactCollection(Context context) {
        this.MathFunFacts = new ArrayList<MathFunFactMetadata>();
        this.context = context;
        ParseAllMathFunFactFile(context);
    }

    public ArrayList<MathFunFactMetadata> findMFFWithDifficulty(int level) {
        ArrayList<MathFunFactMetadata> results = new ArrayList<MathFunFactMetadata>();
        ListIterator<MathFunFactMetadata> iter = MathFunFacts.listIterator();
        while (iter.hasNext()) {
            MathFunFactMetadata mathfunfact = iter.next();
            if (mathfunfact.getLevel() == level) {
                results.add(mathfunfact);
            }
        }
        return results;
    }

    public ArrayList<MathFunFactMetadata> findMFFWithSubject(Subject subject_to_find) {
        ArrayList<MathFunFactMetadata> results = new ArrayList<MathFunFactMetadata>();
        ListIterator<MathFunFactMetadata> iter = MathFunFacts.listIterator();
        while (iter.hasNext()) {
            MathFunFactMetadata mathfunfact = iter.next();
            for(Subject subject_of_MFF_iterated : mathfunfact.getSubjects()){
                if (subject_to_find.equals(subject_to_find)) {
                    results.add(mathfunfact);
                }
            }
        }
        return results;
    }

//    public ListIterator<Student> getAllMathFunFacts() {
//        return MathFunFacts.listIterator();
//    }


    public void ParseAllMathFunFactFile(Context context){

        try {
            // Get Android Assets
            AssetManager am = context.getApplicationContext().getAssets();

            // Get list of files
            String[] files = am.list("");

            // Get number of files
            int length = files.length;

            for(int i=0;i<length;i++) {
                MathFunFacts.add(new MathFunFactMetadata(files[i],context));
            }


//            File[] files = new File[context.getAssets().list("/").length];
//
//            for (File file : files) {
//                if (file.isFile()) {
//                    MathFunFacts.add(ParserMathFunFact(context, file.getName()));
//                }
//            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
