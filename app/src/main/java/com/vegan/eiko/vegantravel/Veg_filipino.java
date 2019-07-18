package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by eiko on 11/24/2015.
 */
public class Veg_filipino extends AppCompatActivity {
    public static String titleStringFilipino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_filipino);
        Toolbar toolbar = findViewById(R.id.toolbar_filipino);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv_title = findViewById(R.id.tv_filipino_title);
        titleStringFilipino = tv_title.getText().toString();
    }
}