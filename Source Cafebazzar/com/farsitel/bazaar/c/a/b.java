package com.farsitel.bazaar.c.a;

import com.farsitel.bazaar.util.t;

final class b extends Thread {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        long j = 0;
        while (this.a.i == 13 && this.a.l.a() > 0) {
            if (t.a(this.a.l.a())) {
                this.a.a(13);
                long j2 = this.a.l.b;
                e.a(j2 - j);
                try {
                    Thread.sleep(300);
                    j = j2;
                } catch (InterruptedException e) {
                    return;
                }
            }
            this.a.a(11);
            return;
        }
    }
}
