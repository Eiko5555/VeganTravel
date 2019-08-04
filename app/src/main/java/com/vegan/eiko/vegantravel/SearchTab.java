package com.vegan.eiko.vegantravel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SearchTab extends Fragment {
    private Button button;
    private ImageView image;
    private String LINK = "https://www.peta.org/wp-content/uploads/2010/11/infographic-vegan-cooking-substitutions-v02.jpg";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_tab, container, false);
        button = view.findViewById(R.id.button_load_image);
        image = view.findViewById(R.id.img_search_tab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartAyncTask startSync = new StartAyncTask();
                startSync.execute(LINK);
            }
        });
        return view;
    }

    public class StartAyncTask extends AsyncTask<String, Void, Bitmap> {
        public StartAyncTask() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Log.i("asynctask", "start");
            String url = params[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            image.setImageBitmap(bitmap);
        }
    }
}
