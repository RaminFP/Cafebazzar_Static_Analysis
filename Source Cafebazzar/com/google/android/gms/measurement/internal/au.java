package com.google.android.gms.measurement.internal;

final class au implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ as c;

    au(as asVar, AppMetadata appMetadata, EventParcel eventParcel) {
        this.c = asVar;
        this.a = appMetadata;
        this.b = eventParcel;
    }

    public final void run() {
        this.c.a(this.a.h);
        this.c.a.a(this.b, this.a);
    }
}
