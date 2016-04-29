package com.example.aidan.mathfunfacts;

import java.util.Comparator;

public class RatingComparator implements Comparator<ParserMathFunFact> {

    @Override
    public int compare(ParserMathFunFact o1, ParserMathFunFact o2) {
        float change1 = o1.getRating();
        float change2 = o2.getRating();
        if (change1 < change2) return 1;
        if (change1 > change2) return -1;
        return 0;
    }
}
