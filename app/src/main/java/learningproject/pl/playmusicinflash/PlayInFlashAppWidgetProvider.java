package learningproject.pl.playmusicinflash;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class PlayInFlashAppWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.play_in_flash_widget);
            views.setOnClickPendingIntent(R.id.play_in_flash_button, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }
}
