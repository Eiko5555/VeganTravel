package com.vegan.eiko.vegantravel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by eiko on 11/23/2015.
 */
public class ImageAdapter extends BaseAdapter {
    //keep all images in array
    public Integer[] ThumbImages = {
            R.drawable.noanimal, R.drawable.vegan_logo,
            R.drawable.vegan_certified, R.drawable.nondairy,
            R.drawable.nocowy, R.drawable.nopiggy,
            R.drawable.nochiken, R.drawable.nonfish
    };
    private Context imageAdapterContex;

    //constructor
    public ImageAdapter(Context c) {
        imageAdapterContex = c;
    }

    @Override
    public int getCount() {
        return ThumbImages.length;
    }

    @Override
    public Object getItem(int position) {
        return ThumbImages[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ImageView vt_imageview = new ImageView(imageAdapterContex);
        vt_imageview.setImageResource(ThumbImages[position]);
        vt_imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vt_imageview.setLayoutParams(new GridView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, 300));
        return vt_imageview;
    }
}
