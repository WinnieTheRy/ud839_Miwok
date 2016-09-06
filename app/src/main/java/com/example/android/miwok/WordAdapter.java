package com.example.android.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//extends arrayadapter<Word> stating that we are expecting only to use arrayadapter<word> as an input
public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Activity context, ArrayList<Word> wordsArray) {

        //we are calling the super classes ArrayAdapter constructor here
        //setting 0 since we are using a custom view
        super(context, 0, wordsArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        } //once the listitemview is inflated in the continues on to making the textviews

        //getting the position of the curent word from the constructors array
        //Word curentWord_2 = (Word) this.getItem(position);
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //get the current word from the arraylist and set it to the textview
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
