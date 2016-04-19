package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DisplayOneMFF extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_display_one_mf, container, false);
        Bundle args = getArguments();

        ParserMathFunFact MFF = new ParserMathFunFact(args.getString("MFFFile"), getContext());

        WebView webView = (WebView) view.findViewById(R.id.singleWebview);
        webView.loadData(MFF.getHTML_content(),"text/html", "UTF-8");

        // Inflate the layout for this fragment
        return view;
    }

}
