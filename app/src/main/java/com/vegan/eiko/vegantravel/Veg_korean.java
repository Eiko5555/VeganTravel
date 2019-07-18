package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by eiko on 11/30/2015.
 */
public class Veg_korean extends AppCompatActivity {
    public static String titleStringKorean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_korean);
        Toolbar toolbar = findViewById(R.id.toolbar_korean);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv_title = findViewById(R.id.tv_korean_title);
        titleStringKorean = tv_title.getText().toString();
    }
}
