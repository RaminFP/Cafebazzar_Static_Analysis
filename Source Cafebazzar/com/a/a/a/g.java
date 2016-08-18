package com.a.a.a;

import b.a.a.a.f;

final class g implements Runnable {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        try {
            aj ajVar = this.a.g;
            this.a.g = new u();
            ajVar.b();
        } catch (Throwable e) {
            f.a().c("Answers", "Failed to disable events", e);
        }
    }
}
