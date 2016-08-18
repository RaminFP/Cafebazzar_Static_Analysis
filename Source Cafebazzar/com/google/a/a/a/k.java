package com.google.a.a.a;

final class k extends Thread {
    final /* synthetic */ j a;

    k(j jVar, String str) {
        this.a = jVar;
        super(str);
    }

    public final void run() {
        synchronized (this.a.f) {
            this.a.d = this.a.b();
            this.a.e = true;
            this.a.f.notifyAll();
        }
    }
}
