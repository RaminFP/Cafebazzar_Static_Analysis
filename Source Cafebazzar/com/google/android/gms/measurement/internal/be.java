package com.google.android.gms.measurement.internal;

final class be implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ bc d;

    be(bc bcVar, String str, String str2, long j) {
        this.d = bcVar;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public final void run() {
        bc.a(this.d, this.a, this.b, null, this.c);
    }
}
