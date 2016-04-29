package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//This is a typical root fragment with nothing in it
//it simply calls the child fragment immediately
public class FavoritesRootFragment extends Fragment {

    public FavoritesRootFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_difficulty_root, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(R.id.favorites_root, new Tab2Fragment());

        ft.commit();

        return view;
    }
}
