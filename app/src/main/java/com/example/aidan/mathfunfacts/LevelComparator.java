package com.example.aidan.mathfunfacts;
import java.util.Comparator;


import java.util.Comparator;

/**
 * Created by Ali on 4/21/2016.
 */
public class LevelComparator implements Comparator<ParserMathFunFact> {

    @Override
    public int compare(ParserMathFunFact o1, ParserMathFunFact o2) {
        float change1 = o1.getRating();
        float change2 = o2.getRating();
        if (change1 < change2) return -1;
        if (change1 > change2) return 1;
        return 0;
    }
}
