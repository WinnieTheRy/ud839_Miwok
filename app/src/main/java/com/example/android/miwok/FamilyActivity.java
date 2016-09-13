package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> words = new ArrayList<>();

        /**
         * using the second constructor because these words have images associated with them
         * this is called overloading when you have multiple constructor with different input parameters
         */
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father)); //array list 0 storing instance of word class with those words in it
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));


        Log.v("FamilyActivity", "father default: " + words.get(0).getDefaultTranslation() + " and father miwok: " + words.get(0).getMiwokTranslation());

        //creating word adapter to liknk between the arraylist and the listview
        WordAdapter adapter = new WordAdapter(
                this,                       //context for the activitity
                words,                      //Items to be displayed
                R.color.category_family);   //Color of the background listitem for each of the four activityies (colors, family...)

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //getting the position of the item being clicked in the listview
                Word wordPosition = words.get(position);

                //assinging that position to the audio file
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, wordPosition.getSongResourceId()); //resourceid is an int

                mMediaPlayer.start();
            }
        });

    }
}
