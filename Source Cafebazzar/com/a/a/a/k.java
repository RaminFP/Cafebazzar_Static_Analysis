package com.a.a.a;

import b.a.a.a.f;

final class k implements Runnable {
    final /* synthetic */ al a;
    final /* synthetic */ boolean b;
    final /* synthetic */ e c;

    k(e eVar, al alVar, boolean z) {
        this.c = eVar;
        this.a = alVar;
        this.b = z;
    }

    public final void run() {
        try {
            this.c.g.a(this.a);
            if (this.b) {
                this.c.g.c();
            }
        } catch (Throwable e) {
            f.a().c("Answers", "Failed to process event", e);
        }
    }
}
