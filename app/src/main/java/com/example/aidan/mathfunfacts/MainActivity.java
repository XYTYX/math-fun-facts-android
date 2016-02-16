package com.example.aidan.mathfunfacts;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Context;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView funFactTextView;
    String funFactTitle;
    String funFactSubject;
    int funFactLevel;
    String[] funFactKeywords;
    String funFactDescription;
    String funFactContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        funFactTextView = (TextView)findViewById(R.id.funFactTextView);

        // Getting random file and displaying it
        String contents = this.getRandomFile();
        funFactTextView.setText(contents);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * On Click, set the displayed text to a new file's text
     * @param v
     */
    public void NextButton(View v) {
        TextView text = (TextView) findViewById(R.id.funFactTextView);
        String contents = this.getRandomFile();
        text.setText(contents);
    }

    /**
     * Return string with all contents of a given file name
     * @param fileName File name
     * @return file contents in a string
     */

    public String getFileContent(String fileName) {
        try {

            // Read from file
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // REad file contents and build the string
            StringBuilder total = new StringBuilder();
            String line;

            // Read line-by-line and store it in the StringBuilder
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }

            // Create the string and return it
            String message=total.toString();
            return message;
        } catch (IOException e) {
            e.printStackTrace();
            return "File Not Found";
        }
    }

    /**
     * Get a random file and then return the contents of it in a file
     * @return File contents in a string
     */
    public String getRandomFile() {

        // Get all assets from the Asset Folder
        AssetManager assetManager = getApplicationContext().getAssets();

        // Array to store all the file names
        String files[] = null;
        try {

            // Returns array of file names from given "" (blank) path in assets
            files = assetManager.list("");

            // Get random number between 0 and the length of the array to get a random fun fact in that array location
            Random random = new Random();
            String fileName = files[random.nextInt(files.length)];

            // Get contents of that file
            String contents = this.getFileContent(fileName);

            // Return file to calling function
            return contents;
        } catch (IOException e) {
            e.printStackTrace();
            return "Random File Not Found";
        }

    }
}
