package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class bk implements Runnable {
    final /* synthetic */ bg a;

    bk(bg bgVar) {
        this.a = bgVar;
    }

    public final void run() {
        u uVar = this.a.b;
        if (uVar == null) {
            this.a.l().a.a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            uVar.a(this.a.f().a(this.a.l().b()));
            this.a.p();
        } catch (RemoteException e) {
            this.a.l().a.a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
