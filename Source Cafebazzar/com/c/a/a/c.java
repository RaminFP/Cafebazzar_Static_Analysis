package com.c.a.a;

final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        int i = 0;
        synchronized (this.a) {
            if (!this.a.p) {
                i = 1;
            }
            if ((i | this.a.q) != 0) {
                return;
            }
            try {
                this.a.j();
                if (this.a.g()) {
                    this.a.f();
                    this.a.n = 0;
                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
