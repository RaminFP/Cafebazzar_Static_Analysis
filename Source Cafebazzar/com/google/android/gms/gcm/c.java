package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar, Looper looper) {
        this.a = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.a.j.add(intent);
        } else if (!b.a(this.a, intent)) {
            intent.setPackage(this.a.f.getPackageName());
            this.a.f.sendBroadcast(intent);
        }
    }
}
