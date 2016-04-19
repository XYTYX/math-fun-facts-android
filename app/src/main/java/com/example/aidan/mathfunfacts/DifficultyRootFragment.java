package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DifficultyRootFragment extends Fragment {

    private static final String TAG = "DifficultyRootFragment";

    public DifficultyRootFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_difficulty_root, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Bundle args = getArguments();

        ft.replace(R.id.difficulty_root, new Tab3Fragment());

        ft.commit();

        return view;
    }
}
