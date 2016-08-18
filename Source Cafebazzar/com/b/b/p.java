package com.b.b;

final class p implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ m b;

    p(m mVar, s sVar) {
        this.b = mVar;
        this.a = sVar;
    }

    public final void run() {
        m.b();
        try {
            this.b.c();
        } catch (Throwable e) {
            ba.a(6, m.d, "retransmitNotSentBlocks error", e);
        }
    }
}
