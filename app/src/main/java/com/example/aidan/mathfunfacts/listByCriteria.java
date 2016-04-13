package com.example.aidan.mathfunfacts;

import android.os.Bundle;
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
public class listByCriteria  extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_by_criteria);
        ListAdapter difficultyAdapter = new CustomAdapter(this,(ArrayList) collection.getAllMathFunFacts());
        ListView difficultyListView = (ListView) findViewById(R.id.listByCriteria);
        difficultyListView.setAdapter(difficultyAdapter);

        //difficultyAdapter.getView(1,difficultyListView,difficultyListView).setBackgroundColor(Color.BLUE);
        //difficultyListView.findViewById(1).setBackgroundColor(Color.BLUE);
        difficultyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String text = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, "id is"+String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
                    }
                }
        );



    }
}
