package com.vegan.eiko.vegantravel;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by eiko on 12/25/2015.
 */
public class Picture_tab extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.picture, container, false);
        GridView vtGridView = rootView.findViewById(R.id.VegTravel_gridView);
        vtGridView.setAdapter(new ImageAdapter(vtGridView.getContext()));
        vtGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sending image id to FullScreenActivity
                Intent i = new Intent(getActivity().getApplicationContext(),
                        Full_Image_Activity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        AdView adView = rootView.findViewById(R.id.adView_image_tab);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        Log.i("pic tab", "showing");
        adView.loadAd(adRequest);
        return rootView;
    }
}
