package com.d.a.b;

final class f extends Thread {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        synchronized (this.a.f) {
            this.a.f.notifyAll();
        }
    }
}
