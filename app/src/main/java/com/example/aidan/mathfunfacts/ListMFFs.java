package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


public class ListMFFs extends Fragment {

    private static final String TAG = "ListMFFs";

    public ListMFFs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_list_mffs, container, false);

        Bundle args = getArguments();

        ListAdapter difficultyAdapter;
        difficultyAdapter = new CustomAdapter(this.getContext(),collection.findMFFWithLevel(args.getString("difficulty")));
        ListView difficultyListView = (ListView) view.findViewById(R.id.mff_list);
        difficultyListView.setAdapter(difficultyAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}
