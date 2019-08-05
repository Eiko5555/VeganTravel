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
public class LanguageListASIA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.language_card_listview,
                container, false);
        //create adapter and set it listview
        ListView listview = rootview.findViewById(R.id.listview_language);
        String[] asia = new String[]{"Chinese", "Arabic", "Filipino", "Japanese",
                "Korean", "Russian", "Thai", "Vietnamese"};
        ArrayAdapter adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,
                asia);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), VegChinese.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), VegArabic.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getActivity(), VegFilipino.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getActivity(), VegJapanese.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(getActivity(), VegKorean.class);
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6 = new Intent(getActivity(), VegRussian.class);
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7 = new Intent(getActivity(), VegThai.class);
                        startActivity(intent7);
                        break;
                    case 7:
                        Intent intent8 = new Intent(getActivity(), VegVietnamese.class);
                        startActivity(intent8);
                        break;
                }
            }
        });
        return rootview;
    }
}
