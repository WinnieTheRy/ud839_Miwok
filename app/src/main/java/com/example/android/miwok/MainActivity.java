package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the view that shows the number category
        TextView numberTextView = (TextView) findViewById(R.id.numbers);
        //interface: onClickListener
        numberTextView.setOnClickListener(new View.OnClickListener() {
            //abstract methode: onClick
            @Override
            public void onClick(View v) {
                //Create a new intent to open the numbers activity
                Intent numberActivity = new Intent(MainActivity.this, NumbersActivity.class);
                //start the new activity
                startActivity(numberActivity);
            }
        });

        TextView phrasesTextView = (TextView) findViewById(R.id.phrases);
        phrasesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesActivity = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesActivity);
            }
        });


        TextView colorsTextView = (TextView) findViewById(R.id.colors);
        colorsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsActvity = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsActvity);
            }
        });


        TextView familyTextView = (TextView) findViewById(R.id.family);
        familyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyActivity = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyActivity);
            }
        });
    }
}
