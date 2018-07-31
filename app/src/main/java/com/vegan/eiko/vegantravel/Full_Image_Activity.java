package com.vegan.eiko.vegantravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by eiko on 11/23/2015.
 */
public class Full_Image_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);
        //Get intent data
        Intent i = getIntent();
        //select image id
        int image_position = i.getExtras().getInt("id");
        ImageAdapter full_imageAdapter =
                new ImageAdapter(this);
        ImageView full_imageView =
                (ImageView)findViewById(R.id.vt_full_image_view);
        full_imageView.setImageResource(full_imageAdapter
                .ThumbImages[image_position]);
    }
}
