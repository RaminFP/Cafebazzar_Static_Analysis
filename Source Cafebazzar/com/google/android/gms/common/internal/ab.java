package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class ab implements ServiceConnection {
    final /* synthetic */ aa a;

    public ab(aa aaVar) {
        this.a = aaVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.h.a) {
            this.a.e = iBinder;
            this.a.g = componentName;
            for (ServiceConnection onServiceConnected : this.a.b) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.a.c = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.h.a) {
            this.a.e = null;
            this.a.g = componentName;
            for (ServiceConnection onServiceDisconnected : this.a.b) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.a.c = 2;
        }
    }
}
