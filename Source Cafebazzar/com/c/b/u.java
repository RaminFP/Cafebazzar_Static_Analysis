package com.c.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

final class u extends BroadcastReceiver {
    final q a;

    u(q qVar) {
        this.a = qVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    q qVar = this.a;
                    qVar.i.sendMessage(qVar.i.obtainMessage(10, intent.getBooleanExtra("state", false) ? 1 : 0, 0));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) bj.a(context, "connectivity");
                q qVar2 = this.a;
                qVar2.i.sendMessage(qVar2.i.obtainMessage(9, connectivityManager.getActiveNetworkInfo()));
            }
        }
    }
}
