package com.farsitel.bazaar.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import com.farsitel.bazaar.BazaarApplication;
import java.util.Calendar;

public final class an {
    public static void a() {
        int[] b = b();
        Calendar instance = Calendar.getInstance();
        instance.set(11, b[0]);
        instance.set(12, b[1]);
        instance.set(13, 0);
        b = c();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, b[0]);
        instance2.set(12, b[1]);
        instance2.set(13, 0);
        long timeInMillis = Calendar.getInstance().after(instance) ? instance.getTimeInMillis() + 86400000 : instance.getTimeInMillis();
        long timeInMillis2 = instance2.getTimeInMillis();
        AlarmManager alarmManager = (AlarmManager) BazaarApplication.c().getApplicationContext().getSystemService("alarm");
        alarmManager.setRepeating(0, timeInMillis, 86400000, PendingIntent.getBroadcast(BazaarApplication.c().getApplicationContext(), 0, new Intent("com.farsitel.bazaar.START_SCHEDULE_UPDATE"), 0));
        alarmManager.setRepeating(0, timeInMillis2, 86400000, PendingIntent.getBroadcast(BazaarApplication.c().getApplicationContext(), 0, new Intent("com.farsitel.bazaar.STOP_SCHEDULE_UPDATE"), 0));
    }

    public static int[] b() {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        return new int[]{sharedPreferences.getInt("schedule_update_start_hour", 1), sharedPreferences.getInt("schedule_update_start_minute", 0)};
    }

    public static int[] c() {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        return new int[]{sharedPreferences.getInt("schedule_update_stop_hour", 7), sharedPreferences.getInt("schedule_update_stop_minute", 0)};
    }
}
