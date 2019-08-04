package com.vegan.eiko.vegantravel;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class AppWidgetProvider extends android.appwidget.AppWidgetProvider {

private static void updatewidget(Context context,
                                 AppWidgetManager
                                         appWidgetManager,
                                 int appWidgetId){

    RemoteViews views = new RemoteViews(context.getPackageName(),
            R.layout.appwidget);
    setRemoteAdapter(context, views);
    Intent intent = new Intent(context, MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(context,
            0, intent, 0 );
    views.setOnClickPendingIntent(R.id.widget_imageView, pendingIntent);
    appWidgetManager.updateAppWidget(appWidgetId, views);
    appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.widget_listview);
}
@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager
    , int[] appWidgetIds){
        for (int appwideget : appWidgetIds){

            updatewidget(context,appWidgetManager,appwideget);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_listview);
        }
    }
    private static void setRemoteAdapter(Context context, final RemoteViews views){
    views.setRemoteAdapter(R.id.widget_listview,
            new Intent(context, WidgetService.class));
    }
}
