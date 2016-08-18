package com.a.a.a;

import b.a.a.a.f;

final class h implements Runnable {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        try {
            this.a.g.a();
        } catch (Throwable e) {
            f.a().c("Answers", "Failed to send events files", e);
        }
    }
}
