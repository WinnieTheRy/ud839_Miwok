package com.example.android.miwok;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


//extends arrayadapter<Word> stating that we are expecting only to use arrayadapter<word> as an input
public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroudColor;

    public WordAdapter(Activity context, ArrayList<Word> wordsArray, int backgroundColor) {

        //we are calling the super classes ArrayAdapter constructor here
        //setting 0 since we are using a custom view
        super(context, 0, wordsArray);

        mBackgroudColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        } //once the listitemview is inflated in the continues on to making the textviews

        //getting the position of the curent word from the arraylist
        //Word curentWord_2 = (Word) this.getItem(position);
        Word currentWord = getItem(position);

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.linear_layout_background_color);
        //View textContainer2 = (View) listItemView.findViewById(R.id.linear_layout_background_color);
        /*
        The (View typecast is redundant so it is removed in the textContainer
         */

        //Find the color that the resouce ID Maps to
        int color = ContextCompat.getColor(getContext(), mBackgroudColor);
        //Set the background color of the text container
        textContainer.setBackgroundColor(color);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //get the current word from the arraylist and set it to the textview
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        //checks if the the imageview has and image or not
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            //if the previous view was hidden through recycling we want to
            // make sure the view is now visible
            imageView.setVisibility(View.VISIBLE);

        } else {
            //sets the imageView to gone, it doesnt take up any extra space
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
