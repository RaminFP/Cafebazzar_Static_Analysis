package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class v implements Callback {
    public final w a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public volatile boolean e = false;
    public final AtomicInteger f = new AtomicInteger(0);
    public boolean g = false;
    public final Handler h;
    public final Object i = new Object();

    public v(Looper looper, w wVar) {
        this.a = wVar;
        this.h = new Handler(looper, this);
    }

    public final void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    public final void a(l lVar) {
        av.a((Object) lVar);
        synchronized (this.i) {
            if (this.d.contains(lVar)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + lVar + " is already registered");
            } else {
                this.d.add(lVar);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            k kVar = (k) message.obj;
            synchronized (this.i) {
                if (this.e && this.a.b() && this.b.contains(kVar)) {
                    kVar.a(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
