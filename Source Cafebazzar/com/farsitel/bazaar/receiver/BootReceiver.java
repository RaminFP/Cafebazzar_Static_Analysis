package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.a;
import com.farsitel.bazaar.util.an;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && "android.intent.action.BOOT_COMPLETED".equals(action)) {
            a.a();
            if (Boolean.valueOf(BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("schedule_update", false)).booleanValue()) {
                an.a();
            }
        }
    }
}
