package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by eiko on 11/30/2015.
 */
public class Veg_vietnamese extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_vietnamese);
        Toolbar toolbar = findViewById(R.id.toolbar_vietnamese);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}