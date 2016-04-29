package com.example.aidan.mathfunfacts;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;
import static com.example.aidan.mathfunfacts.MainActivity.collection;

/**
 * Created by Ali on 4/12/2016.
 */

public class CustomAdapter extends ArrayAdapter<ParserMathFunFact> {
    TextView titleListElement;
    String title;
    String level;
    ParserMathFunFact mathFunFact;

    public CustomAdapter(Context context, ArrayList<ParserMathFunFact> MathFunFacts) {
        super(context, R.layout.custom_row, MathFunFacts);
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ListInflater = LayoutInflater.from(getContext());
        View customView = ListInflater.inflate(R.layout.custom_row, parent, false);

        setRowElement(position,customView);

        return customView;
    }

    /**
     * set the details of a row element
     * @param position
     * @param customView
     */
    public void setRowElement(int position, View customView){
        //get the title and the level
        mathFunFact = getItem(position);
        title = mathFunFact.getTitle();
        level = mathFunFact.getLevel().toLowerCase();

        //set the title of each row element to the title of the MFFF
        titleListElement = (TextView) customView.findViewById(R.id.titleMFF);
        titleListElement.setText(title);

        //set the color depending on the difficulty
        if(level.equals("1")) {
            //easy
            titleListElement.setBackgroundColor(Color.rgb(255,255,136));
        }
        else if (level.equals("2")) {
            //medium
            titleListElement.setBackgroundColor(Color.rgb(255,116,0));
        }
        else {
            // hard
            titleListElement.setBackgroundColor(Color.rgb(255,26,0));
        }
    }

    /**
     * set the details of a row element with rating
     * @param position
     * @param customView
     * @param rating
     */
    public void setRowElementwithRating(int position, View customView,float rating){
        setRowElement(position,customView);
        titleListElement.setText(title + "  (" + String.valueOf(rating) + " Stars)");
    }



}
