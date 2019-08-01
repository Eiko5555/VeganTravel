package com.vegan.eiko.vegantravel;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class AppWidgetProvider extends android.appwidget.AppWidgetProvider {
@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager
    , int[] appWidgetIds){


        for (int appwideget : appWidgetIds){
            //For Intent to launch app(Mainactivity).
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,
                    0, intent, 0 );
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.appwidget);
//            views.setImageViewResource();
            views.setOnClickPendingIntent(R.id.widget_imageView, pendingIntent);
            appWidgetManager.updateAppWidget(appwideget, views);
        }
    }
}
