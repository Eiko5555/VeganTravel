package com.vegan.eiko.vegantravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by eiko on 1/4/2016.
 */
public class LanguageListAfrica extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.language_card_listview,
                container, false);
        //create adapter and set it listview
        ListView listview = rootview.findViewById(R.id.listview_language);
        String[] africa = new String[]{"Arabic", "French", "Swahili"};
        ArrayAdapter adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,
                africa);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), Veg_arabic.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getActivity(), Veg_french.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getActivity(), Veg_swahili.class);
                    startActivity(intent);
                }
            }
        });
        return rootview;
    }
}
