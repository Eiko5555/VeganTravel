package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by eiko on 10/8/2015.
 */
public class Veg_Italian extends AppCompatActivity {
    public static String titleStringItalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_italian);
        Toolbar toolbar = findViewById(R.id.toolbar_italian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv_title = findViewById(R.id.tv_italian_title);
        titleStringItalian = tv_title.getText().toString();
    }
}
