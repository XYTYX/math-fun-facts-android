package com.example.aidan.mathfunfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        MathFunFactsCollection collection = new MathFunFactsCollection(this.getContext());
        WebView wv = (WebView) v.findViewById(R.id.webView);
//        WebSettings settings = wv.getSettings();

//        settings.setDefaultFontSize(24);
        wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
        // Inflate the layout for this fragment
        return v;
    }

}
