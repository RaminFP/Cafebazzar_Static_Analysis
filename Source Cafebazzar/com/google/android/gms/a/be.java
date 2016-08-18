package com.google.android.gms.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.b;

abstract class be extends BroadcastReceiver {
    protected Context a;

    be() {
    }

    public static be a(Context context, be beVar) {
        return a(context, beVar, b.a());
    }

    public static be a(Context context, be beVar, b bVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(beVar, intentFilter);
        beVar.a = context;
        if (b.a(context, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            return beVar;
        }
        beVar.a();
        beVar.b();
        return null;
    }

    protected abstract void a();

    public final void b() {
        synchronized (this) {
            if (this.a != null) {
                this.a.unregisterReceiver(this);
            }
            this.a = null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if (GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(obj)) {
            a();
            b();
        }
    }
}
