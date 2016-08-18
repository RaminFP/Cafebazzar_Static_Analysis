package com.d.a.b;

import com.d.a.a;

final class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        while (true) {
            try {
                synchronized (this.a.f) {
                    while (!this.a.g && this.a.o >= this.a.f.size()) {
                        d.a = false;
                        this.a.f.wait();
                    }
                }
                if (this.a.o >= this.a.m) {
                    while (this.a.n != this.a.o) {
                        a.a("Waiting for read and write to catch up before cleanup.");
                    }
                    d.f(this.a);
                }
                if (this.a.o < this.a.f.size()) {
                    d.a = true;
                    a aVar = (a) this.a.f.get(this.a.o);
                    aVar.d = new c(aVar);
                    aVar.d.setPriority(1);
                    aVar.d.start();
                    aVar.f = true;
                    a.a("Executing: " + aVar.c());
                    this.a.e.write(aVar.c());
                    this.a.e.write("\necho F*D^W@#FGF " + this.a.p + " $?\n");
                    this.a.e.flush();
                    this.a.o = this.a.o + 1;
                    this.a.p = this.a.p + 1;
                } else if (this.a.g) {
                    d.a = false;
                    this.a.e.write("\nexit 0\n");
                    this.a.e.flush();
                    a.a("Closing shell");
                    this.a.o = 0;
                    d.a(this.a.e);
                    return;
                }
            } catch (Exception e) {
                try {
                    a.a(e.getMessage(), 2, e);
                    return;
                } finally {
                    this.a.o = 0;
                    d.a(this.a.e);
                }
            } catch (Exception e2) {
                a.a(e2.getMessage(), 2, e2);
                this.a.o = 0;
                d.a(this.a.e);
                return;
            }
        }
    }
}
