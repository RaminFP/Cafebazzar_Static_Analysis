package com.a.a.c;

import b.a.a.a.f;

final class w implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ v b;

    w(v vVar, Runnable runnable) {
        this.b = vVar;
        this.a = runnable;
    }

    public final void run() {
        try {
            this.a.run();
        } catch (Throwable e) {
            f.a().c("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
