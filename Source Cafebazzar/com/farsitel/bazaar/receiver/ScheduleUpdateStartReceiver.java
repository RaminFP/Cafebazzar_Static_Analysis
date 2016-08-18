package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.farsitel.bazaar.BazaarApplication;
import java.util.Calendar;

public class ScheduleUpdateStartReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        int i = sharedPreferences.getInt("schedule_update_start_hour", 1);
        int i2 = sharedPreferences.getInt("schedule_update_start_minute", 0);
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        i = sharedPreferences.getInt("schedule_update_stop_hour", 7);
        int i3 = sharedPreferences.getInt("schedule_update_stop_minute", 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, i);
        instance2.set(12, i3);
        instance2.set(13, 0);
        if ((instance.after(instance2) ? instance2.getTimeInMillis() + 86400000 : instance2.getTimeInMillis()) > Calendar.getInstance().getTimeInMillis()) {
            Intent intent2 = new Intent();
            intent2.setAction("com.farsitel.bazaar.UPDATE_ALL");
            context.sendBroadcast(intent2);
        }
    }
}
