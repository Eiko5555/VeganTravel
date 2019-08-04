package com.vegan.eiko.vegantravel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Widget_data implements RemoteViewsService.RemoteViewsFactory {

    Context context;
    Intent intent;
    List<String> history = new ArrayList<>();
    DatabaseReference reference;
    String URL = "https://vegantravel.firebaseio.com/";
    Map<String, String> map;

    public Widget_data(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }

    private void pullData() {
        reference = FirebaseDatabase.getInstance().getReferenceFromUrl(URL);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                map = (HashMap<String, String>) dataSnapshot.getValue();
                if (map != null) {
                    history = new ArrayList<>();
                    for (HashMap.Entry<String, String> M : map.entrySet()) {
                        history.add(M.getKey());
                        Log.i("pull data1", history.toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onCreate() {
        pullData();
    }

    @Override
    public void onDataSetChanged() {
        pullData();
//        reference = FirebaseDatabase.getInstance().getReferenceFromUrl(URL);
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                map = (HashMap<String, String>) dataSnapshot.getValue();
//                if (map != null) {
//                    history = new ArrayList<>();
//                    for (HashMap.Entry<String, String> M : map.entrySet()) {
//                        history.add(M.getKey());
//                        Log.i("pull data", history.toString());
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        return history.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.widget_list_item);
        remoteViews.setTextViewText(R.id.widget_textview, history.get(position));
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
