package com.google.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

final class b implements a {
    ServiceConnection a;
    d b;
    e c;
    Context d;
    com.google.android.gms.analytics.internal.b e;

    public b(Context context, d dVar, e eVar) {
        this.d = context;
        if (dVar == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.b = dVar;
        if (eVar == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.c = eVar;
    }

    private com.google.android.gms.analytics.internal.b d() {
        if ((this.e != null ? 1 : null) != null) {
            return this.e;
        }
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public final void a() {
        try {
            d().a();
        } catch (RemoteException e) {
            as.a("clear hits failed: " + e);
        }
    }

    public final void a(Map map, long j, String str, List list) {
        try {
            d().a(map, j, str, list);
        } catch (RemoteException e) {
            as.a("sendHit failed: " + e);
        }
    }

    public final void b() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.putExtra("app_package_name", this.d.getPackageName());
        if (this.a != null) {
            as.a("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.a = new c(this);
        boolean bindService = this.d.bindService(intent, this.a, 129);
        as.c("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.a = null;
            this.c.a(1);
        }
    }

    public final void c() {
        this.e = null;
        if (this.a != null) {
            try {
                this.d.unbindService(this.a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.a = null;
            this.b.b();
        }
    }
}
