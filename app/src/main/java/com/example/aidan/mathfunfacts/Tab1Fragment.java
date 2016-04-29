package com.example.aidan.mathfunfacts;


//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import static com.example.aidan.mathfunfacts.MainActivity.collection;


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

        WebView wv = (WebView) v.findViewById(R.id.webView);
        wv.loadData(collection.findRandomMFF().getHtmlContent(), "text/html", "UTF-8");
        return v;
    }

}
