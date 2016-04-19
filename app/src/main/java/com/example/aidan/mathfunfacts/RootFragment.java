package com.example.aidan.mathfunfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RootFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RootFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RootFragment extends Fragment {

    private static final String TAG = "RootFragment";

    public RootFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_root, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        Bundle args = getArguments();
        int tabNum = args.getInt("tab", 1);

        switch(tabNum) {
            case 1:
                ft.replace(R.id.root_fragment, new Tab1Fragment());
                break;
            case 2:
                ft.replace(R.id.root_fragment, new Tab2Fragment());
                break;
            case 3:
                ft.replace(R.id.root_fragment, new Tab3Fragment());
                break;
            case 4:
                ft.replace(R.id.root_fragment, new Tab4Fragment());
                break;
            case 5:
                ft.replace(R.id.root_fragment, new Tab5Fragment());
                break;
        }

        ft.commit();

        return view;
        //return inflater.inflate(R.layout.fragment_root, container, false);
    }
}
