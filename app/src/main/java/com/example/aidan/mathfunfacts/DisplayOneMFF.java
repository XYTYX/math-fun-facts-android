package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.Toast;

import org.xml.sax.Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


public class DisplayOneMFF extends Fragment {
    ParserMathFunFact MFF;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_display_one_mf, container, false);
        Bundle args = getArguments();

        final WebView webView = (WebView) view.findViewById(R.id.singleWebview);

        if (args.containsKey("random")) {
            MFF = collection.findRandomMFF();

            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Bundle args = new Bundle();
                    args.putString("random","");
                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    DisplayOneMFF disp = new DisplayOneMFF();
                    disp.setArguments(args);
                    ft.replace(R.id.display_one, disp);
                    ft.commit();
                }
            });
        }
        else {
            MFF = collection.getByFileName(args.getString("MFFFile"));
            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.hide();
        }



        //add rating listener
        addListenerOnRatingBar(view);

        String HTML_content = MFF.getHtmlContent().replaceAll("FFig\\Q(\\E([0-9]+)\\Q)\\E", " <br> " +
                "<center><img src=\"file:///android_asset/images/" + MFF.getFilename() + ".$1.gif\"> " +
                "</center><br>");
        webView.loadDataWithBaseURL("file:///android_asset", HTML_content, "text/html", "UTF-8", "file:///android_asset");

        // Inflate the layout for this fragment
        return view;
    }

    public void addListenerOnRatingBar(View view) {

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        ratingBar.setRating(MFF.getRating());
        Log.d("rating =", Float.toString(MFF.getRating()));

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                Toast.makeText(getContext(), "You rated this Math Fun Fact " + String.valueOf(rating) + " stars, thanks.", Toast.LENGTH_LONG).show();

                //modify the value of the MathFunFact Rating
                MFF.setRating(rating);
                //open the Json rating file as an output file
                FileOutputStream fos = null;
                try {
                    fos = getContext().openFileOutput("rating.json", Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                JsonRatingWriter jsonRatingWriter = new JsonRatingWriter();
                try {
                    jsonRatingWriter.writeJsonStream(fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //for testing purposes try to display in a raw way what was written in the json file

                try {
                    FileInputStream fis = getContext().openFileInput("rating.json");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public static String getFileContent(
            FileInputStream fis,
            String          encoding ) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(fis, encoding));
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    //end testing


}
