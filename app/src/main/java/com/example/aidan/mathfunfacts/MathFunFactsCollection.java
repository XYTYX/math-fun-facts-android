package com.example.aidan.mathfunfacts;

import android.content.Context;

import com.example.aidan.mathfunfacts.Subject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MathFunFactsCollection {
 
    List<ParserMathFunFact> MathFunFacts;
    Context context;

    public MathFunFactsCollection(Context context) {
        this.MathFunFacts = new LinkedList<ParserMathFunFact>();
        this.context = context;
        ParseAllMathFunFactFile(context);
    }



public ArrayList<ParserMathFunFact> findMFFWithLevel(int level) {
    ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
    ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
    while (iter.hasNext()) {
        ParserMathFunFact mathfunfact = iter.next();
        if (mathfunfact.getLevel() == level) {
            results.add(mathfunfact);
        }
    }
    return results;
}

public ArrayList<ParserMathFunFact> findMFFWithSubject(Subject subject_to_find) {
    ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();
    ListIterator<ParserMathFunFact> iter = MathFunFacts.listIterator();
        while (iter.hasNext()) {
            ParserMathFunFact mathfunfact = iter.next();
			for(Subject subject_of_MFF_iterated : mathfunfact.getSubjects()){
				if (subject_to_find.equals(subject_to_find)) {
                results.add(mathfunfact);
            	}
			}
        }
        return results;
}

public ListIterator<ParserMathFunFact> getAllMathFunFacts() {
    return MathFunFacts.listIterator();
}


    public void ParseAllMathFunFactFile(Context context){
    	File[] files = new File(context.getAssets().toString()).listFiles();

    	for(File file: files){
    		if(file.isFile()){
    			MathFunFacts.add(new ParserMathFunFact(file.getName(),context));
    		}
    	}
    }

}