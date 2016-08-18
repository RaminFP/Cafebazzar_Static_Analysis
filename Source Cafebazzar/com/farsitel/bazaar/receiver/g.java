package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.b.j;
import com.farsitel.bazaar.BazaarApplication;

public abstract class g extends BroadcastReceiver {
    public abstract void a();

    public abstract void b();

    public final void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.farsitel.bazaar.ON_REGISTER_SUCCESS");
        intentFilter.addAction("com.farsitel.bazaar.ON_REGISTER_FAIL");
        j.a(BazaarApplication.c()).a(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.ON_REGISTER_SUCCESS".equals(intent.getAction())) {
            a();
        } else if ("com.farsitel.bazaar.ON_REGISTER_FAIL".equals(intent.getAction())) {
            b();
        }
        j.a(BazaarApplication.c()).a((BroadcastReceiver) this);
    }
}
