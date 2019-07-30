package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by eiko on 10/8/2015.
 */
public class Veg_german extends AppCompatActivity {
    public static String titleStringGerman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_german);
        Toolbar toolbar = findViewById(R.id.toolbar_german);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.tvGerman2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        TextView tv_title = findViewById(R.id.tv_german_title);
        titleStringGerman = tv_title.getText().toString();
    }

}
