package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by eiko on 10/8/2015.
 */
public class Veg_spanish extends AppCompatActivity {
    public static String titleStringSpanish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_spanish);
        Toolbar toolbar = findViewById(R.id.toolbar_spanish);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv_title = findViewById(R.id.tv_spanish_title);
        titleStringSpanish = tv_title.getText().toString();
    }
}
