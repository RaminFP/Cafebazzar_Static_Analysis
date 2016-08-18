package com.b.b;

final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    r(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }

    public final void run() {
        m.b();
        if (!this.b.e.remove(this.a)) {
            ba.a(6, m.d, "Internal error. Block with id = " + this.a + " was not in progress state");
        }
    }
}
