package com.vegan.eiko.vegantravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by eiko on 12/25/2015.
 */
public class Picture_tab extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.picture, container, false);
        GridView vtGridView = (GridView) rootView.findViewById(R.id.VegTravel_gridView);
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
        return rootView;
    }
    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GridView vtGridView = (GridView) findViewById(R.id.VegTravel_gridView);
        //Instance of ImageAdapter class
        //vtGridView.setAdapter(new ImageAdapter(this));
        // Onclick event for single gridView item
        vtGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(),
                        Full_Image_Activity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });*/
}
