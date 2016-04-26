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
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {


    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        ListAdapter ratingAdapter;
        ratingAdapter = new CustomAdapterByRating(getContext(),collection.getAllMathFunFactsSortedByRating());

        ListView difficultyListView = (ListView) v.findViewById(R.id.listByRating);
        difficultyListView.setAdapter(ratingAdapter);

        difficultyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String text = String.valueOf(parent.getItemAtPosition(position));
                        ParserMathFunFact MFF = (ParserMathFunFact)parent.getItemAtPosition(position);
//                        Intent intent = new Intent(parent.getContext(),displaySingleMFF.class);
//                        intent.putExtra("MFFFile", MFF.getFilename());
//                        startActivity(intent);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        Bundle args = new Bundle();
                        args.putString("MFFFile", MFF.getFilename());

                        DisplayOneMFF oneMFF = new DisplayOneMFF();
                        oneMFF.setArguments(args);

                        ft.replace(R.id.fav_root, oneMFF);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        return v;
    }

}
