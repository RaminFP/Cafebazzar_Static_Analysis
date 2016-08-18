package com.google.android.gms.measurement.internal;

final class aa implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ z b;

    aa(z zVar, String str) {
        this.b = zVar;
        this.a = str;
    }

    public final void run() {
        ba d = this.b.h.d();
        if (!d.t() || d.i) {
            this.b.a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            d.b.a(this.a, 1);
        }
    }
}
