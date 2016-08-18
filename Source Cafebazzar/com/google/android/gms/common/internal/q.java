package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class q implements ServiceConnection {
    final /* synthetic */ l a;
    private final int b;

    public q(l lVar, int i) {
        this.a = lVar;
        this.b = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        av.a((Object) iBinder, (Object) "Expecting a valid IBinder");
        this.a.j = an.a(iBinder);
        l lVar = this.a;
        lVar.c.sendMessage(lVar.c.obtainMessage(6, this.b, -1, new t(lVar)));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c.sendMessage(this.a.c.obtainMessage(4, this.b, 1));
    }
}
