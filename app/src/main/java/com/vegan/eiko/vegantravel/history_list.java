package com.vegan.eiko.vegantravel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class history_list extends AppCompatActivity {
    private ListView listView;
    private Context context;
    private DatabaseReference mRef;
    private String url = "https://vegantravel.firebaseio.com/";
    private Map<String, String> map;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> list;
    private TextView empty_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list);
        Toolbar toolbar = findViewById(R.id.tooldbar_history);
        setSupportActionBar(toolbar);

        context = this;
        empty_text = findViewById(R.id.empty_comment);
        listView = findViewById(R.id.history_listview);
        mRef = FirebaseDatabase.getInstance().getReferenceFromUrl(url);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(
                    @NonNull final DataSnapshot dataSnapshot) {
                map = (HashMap<String, String>) dataSnapshot.getValue();
                if (map != null) {
                    empty_text.setVisibility(View.GONE);
                    list = new ArrayList<>();
                    for (HashMap.Entry<String, String> M : map.entrySet()) {
                        list.add(M.getKey());
                        Log.i("history list", list.toString());
                    }
                    arrayAdapter =
                            new ArrayAdapter<>(context,
                                    android.R.layout.simple_list_item_1, list);
                    listView.setAdapter(arrayAdapter);
                }else {
                    empty_text.setVisibility(View.VISIBLE);
                    empty_text.setText(R.string.empty_text_comment);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("History", "Failed to get data");
            }
        });
    }
}
