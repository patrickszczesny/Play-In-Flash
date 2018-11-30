package learningproject.pl.playmusicinflash;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.RemoteViews;


public class PlayInFlashAppWidgetProvider extends AppWidgetProvider {
    public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.play_in_flash_widget);

            Intent intentForMainActivity = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentForMainActivity, 0);
            views.setOnClickPendingIntent(R.id.play_in_flash_button, pendingIntent);

            Intent intentToPlayCarelessWhisper = new Intent(context, PlayInFlashAppWidgetProvider.class);
            intentToPlayCarelessWhisper.setAction(ACTION_WIDGET_RECEIVER);
            PendingIntent pendingIntentForCarelessWhisper = PendingIntent.getBroadcast(context, 0, intentToPlayCarelessWhisper, 0);
            views.setOnClickPendingIntent(R.id.instant_play,pendingIntentForCarelessWhisper);

            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) {
            final int appWidgetId = intent.getExtras().getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                this.onDeleted(context, new int[] { appWidgetId });
            }
        } else {
            if (intent.getAction().equals(ACTION_WIDGET_RECEIVER)) {
                MediaPlayer carelessWhisperMediaPlayer = MediaPlayer.create(context,R.raw.wham_careless_whisper);
                carelessWhisperMediaPlayer.start();
            }
            super.onReceive(context, intent);
        }
}}
