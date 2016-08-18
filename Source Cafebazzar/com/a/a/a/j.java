package com.a.a.a;

import b.a.a.a.f;

final class j implements Runnable {
    final /* synthetic */ e a;

    j(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        try {
            this.a.g.c();
        } catch (Throwable e) {
            f.a().c("Answers", "Failed to flush events", e);
        }
    }
}
