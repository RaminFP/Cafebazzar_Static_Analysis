package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.j;
import com.farsitel.bazaar.BazaarApplication;

public abstract class d extends BroadcastReceiver {
    public static void b() {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.ON_LOGIN");
        j.a(BazaarApplication.c()).a(intent);
    }

    public abstract void a();

    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.ON_LOGIN".equals(intent.getAction())) {
            com.farsitel.bazaar.g.j.a().n();
            a();
        }
    }
}
