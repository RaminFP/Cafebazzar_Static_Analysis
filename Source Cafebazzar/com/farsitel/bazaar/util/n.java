package com.farsitel.bazaar.util;

import android.content.Intent;
import android.content.IntentFilter;
import com.farsitel.bazaar.BazaarApplication;

public final class n {
    public static boolean a() {
        try {
            int intExtra = BazaarApplication.c().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Throwable th) {
            return false;
        }
    }

    public static float b() {
        try {
            Intent registerReceiver = BazaarApplication.c().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            return (intExtra == -1 || intExtra2 == -1) ? 50.0f : (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            return -1.0f;
        }
    }
}
