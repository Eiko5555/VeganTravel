package com.vegan.eiko.vegantravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by eiko on 11/30/2015.
 */
public class Veg_thai extends AppCompatActivity {
    public static String titleStringThai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_thai);
        Toolbar toolbar = findViewById(R.id.toolbar_thai);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.tv_thai2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        TextView tv_title = findViewById(R.id.tv_thai_title);
        titleStringThai = tv_title.getText().toString();
    }
}
