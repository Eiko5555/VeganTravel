package com.vegan.eiko.vegantravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

/**
 * Created by eiko on 11/23/2015.
 */
public class Full_Image_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);
        Toolbar toolbar = findViewById(R.id.toolbar_full_image);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Get intent data
        Intent i = getIntent();
        //select image id
        int image_position = i.getExtras().getInt("id");
        ImageAdapter full_imageAdapter =
                new ImageAdapter(this);
        ImageView full_imageView = findViewById(R.id.vt_full_image_view);
        Picasso.get().load(full_imageAdapter.ThumbImages[image_position])
             //while loading   .placeholder(R.drawable.vegan_certified)
              //if error happens  .error(R.drawable.vegan_certified)
                .into(full_imageView);

        AdView adView = findViewById(R.id.adView_full_image);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
