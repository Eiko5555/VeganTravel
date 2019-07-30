package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by eiko on 10/8/2015.
 */
public class Veg_french extends AppCompatActivity {
    public static String titleStringFrench;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_french);

        Toolbar toolbar = findViewById(R.id.toolbar_french);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting title string for history.
        TextView textViewTitle = findViewById(R.id.tv_french_title);
        titleStringFrench = textViewTitle.getText().toString();
        Log.i("French Title", titleStringFrench);
        TextView textView = findViewById(R.id.tv_french2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        
    }
}
