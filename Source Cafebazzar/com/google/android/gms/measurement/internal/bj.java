package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class bj implements Runnable {
    final /* synthetic */ UserAttributeParcel a;
    final /* synthetic */ bg b;

    bj(bg bgVar, UserAttributeParcel userAttributeParcel) {
        this.b = bgVar;
        this.a = userAttributeParcel;
    }

    public final void run() {
        u uVar = this.b.b;
        if (uVar == null) {
            this.b.l().a.a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            uVar.a(this.a, this.b.f().a(this.b.l().b()));
            this.b.p();
        } catch (RemoteException e) {
            this.b.l().a.a("Failed to send attribute to AppMeasurementService", e);
        }
    }
}
