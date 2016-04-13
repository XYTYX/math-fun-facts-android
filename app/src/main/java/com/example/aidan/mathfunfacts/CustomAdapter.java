package com.example.aidan.mathfunfacts;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;
import static com.example.aidan.mathfunfacts.MainActivity.collection;

/**
 * Created by Ali on 4/12/2016.
 */

public class CustomAdapter extends ArrayAdapter<ParserMathFunFact> {
    public CustomAdapter(Context context, ArrayList<ParserMathFunFact> MathFunFacts) {
        super(context, R.layout.custom_row, MathFunFacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ListInflater = LayoutInflater.from(getContext());
            View customView = ListInflater.inflate(R.layout.custom_row, parent, false);

        String title = getItem(position).getTitle();
        String level = getItem(position).getLevel().toLowerCase();
        TextView titleListElement = (TextView) customView.findViewById(R.id.titleMFF);
        titleListElement.setText(title);

        //set the color depending on the difficulty
        if(level.equals("1")) {
            //easy
            titleListElement.setBackgroundColor(Color.YELLOW);
        }
        else if (level.equals("2")) {
            //medium
            titleListElement.setBackgroundColor(Color.BLUE);
        }
        else {
            // hard
            titleListElement.setBackgroundColor(Color.GREEN);

        }

        return customView;
    }
}
