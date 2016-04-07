package com.example.aidan.mathfunfacts;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {


    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View v = inflater.inflate(R.layout.fragment_tab3, container, false);
        Button button = (Button) v.findViewById(R.id.difficultyButton);
//        button.setOnContextClickListener(View.OnContextClickListener()) {
//
//        }

//        super.onCreate(savedInstanceState);
//        v.setContentView(R.layout.activity_difficulty);
//        MathFunFactsCollection collection = new MathFunFactsCollection(this.getContext());
//        WebView wv = (WebView) v.findViewById(R.id.webView);
//        WebSettings settings = wv.getSettings();

//        settings.setDefaultFontSize(24);
//        wv.loadData(collection.findRandomMFF().getHTML_content(), "text/html", "UTF-8");
        // Inflate the layout for this fragment
        return  v;
    }



    public void getFunFactByDifficulty(View view) {
        RadioGroup difficultySelector = (RadioGroup) view.findViewById(R.id.difficultySelector);
        view = this.getView();
        String difficulty = ((RadioButton) view.findViewById(difficultySelector.getCheckedRadioButtonId())).getText().toString();
        Log.d("Selected ID", difficulty);

        int level;
        if(difficulty.equals("Easy"))
            level = 1;
        else if (difficulty.equals("Medium"))
            level = 2;
        else level = 3;

        MathFunFactsCollection collection = new MathFunFactsCollection(this.getContext());
        Intent intent = new Intent(this.getContext(),FilteredFunFact.class);
        intent.putExtra("difficulty", level);
        startActivity(intent);
    }
}
