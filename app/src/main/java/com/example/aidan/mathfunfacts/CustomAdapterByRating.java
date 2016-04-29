package com.example.aidan.mathfunfacts;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ali on 4/12/2016.
 */

public class CustomAdapterByRating extends CustomAdapter {

    public CustomAdapterByRating(Context context, ArrayList<ParserMathFunFact> MathFunFacts) {
        super(context, MathFunFacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ListInflater = LayoutInflater.from(getContext());
        View customView = ListInflater.inflate(R.layout.custom_row_by_rating, parent, false);

        //call a method from the super class.
        super.setRowElementwithRating(position,customView,getItem(position).getRating());

        return customView;
    }
}
