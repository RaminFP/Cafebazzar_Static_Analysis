package com.a.a.a;

import b.a.a.a.a.g.b;

final class f implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    f(e eVar, b bVar, String str) {
        this.c = eVar;
        this.a = bVar;
        this.b = str;
    }

    public final void run() {
        try {
            this.c.g.a(this.a, this.b);
        } catch (Throwable e) {
            b.a.a.a.f.a().c("Answers", "Failed to set analytics settings data", e);
        }
    }
}
