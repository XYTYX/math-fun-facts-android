package com.example.aidan.mathfunfacts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


/**
 * Favorites fragment, serves as a root fragment because
 * we don't need to call more than one fragment on top of
 * this one
 */
public class Tab2Fragment extends Fragment {
    View v;

    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tab2, container, false);
        ListAdapter ratingAdapter;
        ratingAdapter = new CustomAdapterByRating(getContext(),collection.getAllMathFunFactsSortedByRating());

        //calling the ListView
        ListView difficultyListView = (ListView) v.findViewById(R.id.listByRating);
        difficultyListView.setAdapter(ratingAdapter);

        difficultyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ParserMathFunFact MFF = (ParserMathFunFact)parent.getItemAtPosition(position);

                        //call a fragment transaction, put the name of the file we want to
                        //display in the bundle, pass that bundle along, then call
                        //DisplayOneMFF to display the single selected fact, replace
                        //the root fragment

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        Bundle args = new Bundle();
                        args.putString("MFFFile", MFF.getFilename());

                        DisplayOneMFF oneMFF = new DisplayOneMFF();
                        oneMFF.setArguments(args);

                        ft.replace(R.id.fav_root, oneMFF);
                        ft.addToBackStack(null);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        return v;
    }
    public void onDestroyView() {
        super.onDestroyView();
        // not cleaning up.
    }

}
