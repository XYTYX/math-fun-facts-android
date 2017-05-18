package com.example.aidan.mathfunfacts;
import android.app.ActionBar;
import android.app.ListFragment;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab5Fragment extends Fragment {

    public ArrayList<String> filenames;

//    ActionBar actionBar = getActivity().getActionBar();
    public Tab5Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_tab5, container, false);


        ListAdapter searchResultAdapter;
        searchResultAdapter = new CustomAdapterByRating(getContext(),collection.getAllMathFunFactsSortedByRating());

        //calling the ListView
        ListView searchListView = (ListView) v.findViewById(R.id.listView);
        searchListView.setAdapter(searchResultAdapter);


        searchListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //call a fragment transaction, put the name of the file we want to
                        //display in the bundle, pass that bundle along, then call
                        //DisplayOneMFF to display the single selected fact, replace
                        //the root fragment depending on which fragment called this fragment
                        //originally

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                        DisplayOneMFF display = new DisplayOneMFF();
                        Bundle newArgs = new Bundle();
                        ParserMathFunFact MFF = (ParserMathFunFact) parent.getItemAtPosition(position);
                        newArgs.putString("MFFFile", MFF.getFilename());
                        display.setArguments(newArgs);

                            ft.replace(R.id.search_root, display);


                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.addToBackStack(null);
                        ft.commit();

                    }
                }
        );
        final TextView errorMessage = (TextView) v.findViewById(R.id.errorMessage);


        SearchView searchBar = (SearchView) v.findViewById(R.id.searchView);
        searchBar.setEnabled(true);
        searchBar.setIconifiedByDefault(false);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                             @Override
                                             public boolean onQueryTextSubmit(String query) {
                                                 return false;
                                             }

                                             @Override
                                             public boolean onQueryTextChange(String newText) {
                                                 char[] c = "".toCharArray();
                                                 ArrayList<ParserMathFunFact> searchResults = doSearch(newText.toString());
                                                 if (searchResults.size() == 0 && newText.length() != 0) {
                                                     c = "No result found, please try again".toCharArray();
                                                 }
                                                 //set the error message
                                                 errorMessage.setText(c, 0, c.length);
                                                 ListAdapter searchResultAdapter;
                                                 if (newText.length() != 0) {
                                                     searchResultAdapter = new CustomAdapterByRating(getContext(), searchResults);
                                                 } else {
                                                     searchResultAdapter = new CustomAdapterByRating(getContext(), collection.getAllMathFunFactsSortedByRating());
                                                 }

                                                 ListView difficultyListView = (ListView) v.findViewById(R.id.listView);
                                                 difficultyListView.setAdapter(searchResultAdapter);
                                                 return false;
                                             }
                                         }
        );



        // Inflate the layout for this fragment

        return v;
    }

    public ArrayList<ParserMathFunFact> doSearch(String s) {

        ArrayList<ParserMathFunFact> results = new ArrayList<ParserMathFunFact>();


        List<ParserMathFunFact> allFacts = collection.getAllMathFunFacts();
        ListIterator<ParserMathFunFact> iter = allFacts.listIterator();
        if(s.isEmpty()) return results;
        if(s.charAt(0)==' ') {
            String copy = "";
            int l = s.length();
            int i;
            for(i=0;i<l;i++) {
                if(s.charAt(i)!=' ') {
                    copy = s.substring(i);
                    s = copy;
                    break;
                }
            }
        }
        if(s.charAt(s.length()-1)==' ') {
            String copy = "";
            int l = s.length();
            int i;
            for(i=l-1;i>0;i--) {
                if(s.charAt(i)!=' ') {
                    copy = s.substring(0,i+1);
                    s = copy;
                    break;
                }
            }
        }

        while (iter.hasNext()) {
            
            ParserMathFunFact mathfunfact = iter.next();

            if(mathfunfact.getTitle().toLowerCase().contains(s.toLowerCase())) {

                results.add(mathfunfact);
                //Log.d("Title ++ title", mathfunfact.getTitle() +  "++" + mathfunfact.getTitle());
            }
            else if(mathfunfact.getKeywords().toLowerCase().contains(s.toLowerCase())) {
                results.add(mathfunfact);
                //Log.d("Title ++ keywords", mathfunfact.getTitle() + "++" + mathfunfact.getKeywords());
            }
        }

        return results;
    }

    public void onDestroyView() {
        super.onDestroyView();
        // not cleaning up.
    }
}
