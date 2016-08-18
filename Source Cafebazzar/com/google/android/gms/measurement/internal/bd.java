package com.google.android.gms.measurement.internal;

final class bd implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ long d;
    final /* synthetic */ bc e;

    bd(bc bcVar, String str, String str2, Object obj, long j) {
        this.e = bcVar;
        this.a = str;
        this.b = str2;
        this.c = obj;
        this.d = j;
    }

    public final void run() {
        bc.a(this.e, this.a, this.b, this.c, this.d);
    }
}
