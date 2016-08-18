package com.b.b;

final class o implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ m d;

    o(m mVar, byte[] bArr, String str, String str2) {
        this.d = mVar;
        this.a = bArr;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        m.b();
        try {
            this.d.c(this.a, this.b, this.c);
        } catch (Throwable e) {
            ba.a(6, m.d, "storeData error", e);
        }
    }
}
