package com.b.b;

final class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    n(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }

    public final void run() {
        m.b();
        try {
            this.b.h = new v(this.a);
        } catch (Throwable e) {
            ba.a(6, m.d, "initialization of FlurryDataSenderIndex error", e);
        }
    }
}
