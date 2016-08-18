package com.google.android.gms.measurement.internal;

final class ae implements Runnable {
    private final ad a;
    private final int b;
    private final Throwable c;
    private final byte[] d;

    private ae(ad adVar, int i, Throwable th, byte[] bArr) {
        this.a = adVar;
        this.b = i;
        this.c = th;
        this.d = bArr;
    }

    public final void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
