package com.b.b;

final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ m c;

    q(m mVar, String str, String str2) {
        this.c = mVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        m.b();
        if (!this.c.h.a(this.a, this.b)) {
            ba.a(6, m.d, "Internal error. Block wasn't deleted with id = " + this.a);
        }
        if (!this.c.e.remove(this.a)) {
            ba.a(6, m.d, "Internal error. Block with id = " + this.a + " was not in progress state");
        }
    }
}
