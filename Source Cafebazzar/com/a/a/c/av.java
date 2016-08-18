package com.a.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

final class av {
    private static final IntentFilter f = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter g = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter h = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    final AtomicBoolean a;
    final Context b;
    final BroadcastReceiver c;
    final BroadcastReceiver d;
    boolean e;

    public av(Context context) {
        int i = -1;
        this.b = context;
        Intent registerReceiver = context.registerReceiver(null, f);
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        boolean z = i == 2 || i == 5;
        this.e = z;
        this.d = new aw(this);
        this.c = new ax(this);
        context.registerReceiver(this.d, g);
        context.registerReceiver(this.c, h);
        this.a = new AtomicBoolean(true);
    }
}
