package com.example.aidan.mathfunfacts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Fragment extends Fragment {

    String subject;

    public Tab4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        final View v = inflater.inflate(R.layout.fragment_tab4, container, false);

        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.subjectSelector);
        radioGroup.clearCheck();

        //this is to update what difficulty is, depending on which radio button was clicked
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null != rb && checkedId != -1) {
                    subject = rb.getText().toString();
                }
            }
        });

        //on click, the go button at the bottom calls getFunFactByDifficulty
        Button go = (Button) v.findViewById(R.id.subjectButton);
        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getFunFactBySubject(view, subject);
            }
        });
        return  v;
    }

    public void getFunFactBySubject(View view, String subject) {
        String subjectNum = "0";
        switch(subject) {
            case "algebra": subjectNum = "1";
                Log.d("subject", "algebra");
                break;

            case "calculus_analysis": subjectNum = "2";
                break;

            case "combinatorics": subjectNum = "3";
                break;

            case "geometry": subjectNum = "4";
                break;

            case "number_theory": subjectNum = "5";
                break;

            case "probability": subjectNum = "6";
                break;

            case "topology": subjectNum = "7";
                break;

            case "other": subjectNum = "8";
        }

        Intent intent = new Intent(this.getContext(), FilteredFunFact.class);
        intent.putExtra("subject", subjectNum);
        startActivity(intent);
    }
}
