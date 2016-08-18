package com.google.android.gms.measurement.internal;

final class ax implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ as c;

    ax(as asVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = asVar;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    public final void run() {
        this.c.a(this.a.h);
        this.c.a.a(this.b, this.a);
    }
}
