package com.example.aidan.mathfunfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.aidan.mathfunfacts.MainActivity.collection;


/**
 * Created by Ali on 4/12/2016.
 */
public class listByCriteria extends AppCompatActivity {


    public void onCreateView(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_by_criteria);

        Bundle bundle = getIntent().getExtras();
        ListAdapter difficultyAdapter;
        if(getIntent().hasExtra("difficulty")){
            difficultyAdapter = new CustomAdapter(this,collection.findMFFWithLevel((String)bundle.get("difficulty")));

        }
        else{
            difficultyAdapter = new CustomAdapter(this,collection.findMFFWithSubject((String)bundle.get("subject")));
        }
        ListView difficultyListView = (ListView) findViewById(R.id.listByCriteria);
        difficultyListView.setAdapter(difficultyAdapter);

        difficultyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ParserMathFunFact MFF = (ParserMathFunFact)parent.getItemAtPosition(position);
                        Intent intent = new Intent(parent.getContext(),displaySingleMFF.class);
                        intent.putExtra("MFFFile", MFF.getFilename());
                        startActivity(intent);

                    }
                }
        );



    }
}
