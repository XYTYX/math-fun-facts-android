package com.example.aidan.mathfunfacts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {

    String difficulty;

    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View v = inflater.inflate(R.layout.fragment_tab3, container, false);

        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.difficultySelector);
        radioGroup.clearCheck();

        //this is to update what difficulty is, depending on which radio button was clicked
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId != -1) {
                    difficulty = rb.getText().toString();
                }
            }
        });


        //on click, the go button at the bottom calls getFunFactByDifficulty
        Button go = (Button) v.findViewById(R.id.difficultyButton);
        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(difficulty != null){
                    //just changing the radio button text to string numbers
                    String level;
                    if (difficulty.equals("Easy"))
                        level = "1";
                    else if (difficulty.equals("Medium"))
                        level = "2";
                    else level = "3";

                    //call a fragment transaction, put the name of the file we want to
                    //display in the bundle, pass that bundle along, then call
                    //DisplayOneMFF to display the single selected fact, replace
                    //the root fragment

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("difficulty", level);

                    ListMFFs list = new ListMFFs();
                    list.setArguments(args);

                    ft.replace(R.id.difficulty_root, list);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });
        return  v;
    }
    public void onDestroyView() {
        super.onDestroyView();
        // not cleaning up.
    }
}
