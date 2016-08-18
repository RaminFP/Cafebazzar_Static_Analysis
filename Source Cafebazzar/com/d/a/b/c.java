package com.d.a.b;

import com.d.a.a;

final class c extends Thread {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        while (!this.a.j) {
            synchronized (this.a) {
                try {
                    this.a.wait((long) this.a.o);
                } catch (InterruptedException e) {
                }
            }
            if (!this.a.j) {
                a.a("Timeout Exception has occurred.");
                this.a.a("Timeout Exception");
            }
        }
    }
}
