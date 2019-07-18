package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by eiko on 11/30/2015.
 */
public class Veg_russian extends AppCompatActivity {
    public static String titleStringRussian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_russian);
        Toolbar toolbar = findViewById(R.id.toolbar_russian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv_title = findViewById(R.id.tv_russian_title);
        titleStringRussian = tv_title.getText().toString();
    }
}
