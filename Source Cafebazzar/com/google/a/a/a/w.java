package com.google.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class w extends BroadcastReceiver {
    static final String a = w.class.getName();
    private final bc b;

    w(bc bcVar) {
        this.b = bcVar;
    }

    public static void a(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(a, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.b.a(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(a)) {
            this.b.d();
        }
    }
}
