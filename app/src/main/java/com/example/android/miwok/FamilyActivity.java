package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private String JustATest;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //pause
                mMediaPlayer.pause();
                //restart trasnlation so that the user can hear it again
                mMediaPlayer.seekTo(0);

            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //stop audio and realease mediaPlayer
                releaseMediaPlayer();
                Log.v("NumbersActivity", "audio focus, Realease Media Player");
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //resume
                mMediaPlayer.start();
                Log.v("NumbersActivity", "Audio Focus, mediaplayer started");
            }

        }
    };

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
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        Log.v("FamilyActivity", "father default: " + words.get(0).getDefaultTranslation() + " and father miwok: " + words.get(0).getMiwokTranslation());

        //creating word adapter to link between the arraylist and the listview
        WordAdapter adapter = new WordAdapter(
                this,                       //context for the activitity
                words,                      //Items to be displayed
                R.color.category_family);   //Color of the background listitem for each of the four activityies (colors, family...)

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //getting the position of the item being clicked in the listview
                Word wordPosition = words.get(position);

                releaseMediaPlayer();

                int resultOfAudioGain = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (resultOfAudioGain == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    //assinging that position to the audio file
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, wordPosition.getSongResourceId()); //resourceid is an int

                    mMediaPlayer.start();

                    //shuts down mediaplayer once audio has finished playing
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }


            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
