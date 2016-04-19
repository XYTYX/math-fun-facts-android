package com.example.aidan.mathfunfacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListMFFs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListMFFs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMFFs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "ListMFFs";

    public ListMFFs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        if(args.containsKey("difficulty")){
            CustomAdapter difficultyAdapter = new CustomAdapter(this.getContext(),collection.findMFFWithLevel((String)args.get("difficulty")));
        }
        else{
            CustomAdapter subjectAdapter = new CustomAdapter(this.getContext(),collection.findMFFWithSubject((String)args.get("subject")));
        }



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_mffs, container, false);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
