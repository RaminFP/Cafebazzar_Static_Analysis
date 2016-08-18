package com.google.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

final class c implements ServiceConnection {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        as.c("service connected, binder: " + iBinder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                as.c("bound to service");
                this.a.e = com.google.android.gms.analytics.internal.c.a(iBinder);
                this.a.b.a();
                return;
            }
        } catch (RemoteException e) {
        }
        this.a.d.unbindService(this);
        this.a.a = null;
        this.a.c.a(2);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        as.c("service disconnected: " + componentName);
        this.a.a = null;
        this.a.b.b();
    }
}
