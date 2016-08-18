package com.google.android.gms.measurement.internal;

final class bn implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ bm b;

    bn(bm bmVar, u uVar) {
        this.b = bmVar;
        this.a = uVar;
    }

    public final void run() {
        if (!this.b.c.b()) {
            this.b.c.l().f.a("Connected to service");
            this.b.c.a(this.a);
        }
    }
}
