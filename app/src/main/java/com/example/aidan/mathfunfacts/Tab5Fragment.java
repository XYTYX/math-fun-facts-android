package com.example.aidan.mathfunfacts;
import android.app.ActionBar;
import android.app.ListFragment;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab5Fragment extends Fragment {

//    ActionBar actionBar = getActivity().getActionBar();
    public Tab5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_tab5, container, false);

        setHasOptionsMenu(true);



        // Inflate the layout for this fragment

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Implementing ActionBar Search inside a fragment
        MenuItem item = menu.add("Search");
        item.setIcon(R.drawable.favorite_fragment_tab_icon_un_selected); // sets icon
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        SearchView sv = new SearchView(getActivity());



        // modifying the text inside edittext component
        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) sv.findViewById(id);
        textView.setHint("Search location...");
        //textView.setHintTextColor(getResources().getColor(R.color.DarkGray));
        //textView.setTextColor(getResources().getColor(R.color.clouds));

        // implementing the listener
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.length() < 3) {
                    Toast.makeText(getActivity(),
                            "Your search query must be at least 3 characters long",
                            Toast.LENGTH_LONG).show();
                    return true;
                } else {
                    //doSearch(s); THIS IS OUR SEARCH FUNCTION, TO BE WRITTEN
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        item.setActionView(sv);

//        actionBar.setCustomView(sv);
    }
}
