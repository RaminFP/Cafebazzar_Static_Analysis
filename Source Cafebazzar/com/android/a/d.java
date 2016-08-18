package com.android.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class d extends Thread {
    private static final boolean b = z.b;
    volatile boolean a = false;
    private final BlockingQueue c;
    private final BlockingQueue d;
    private final b e;
    private final u f;

    public d(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, b bVar, u uVar) {
        this.c = blockingQueue;
        this.d = blockingQueue2;
        this.e = bVar;
        this.f = uVar;
    }

    public final void run() {
        if (b) {
            z.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.e.a();
        while (true) {
            try {
                o oVar = (o) this.c.take();
                oVar.a("cache-queue-take");
                if (oVar.h) {
                    oVar.b("cache-discard-canceled");
                } else {
                    c a = this.e.a(oVar.b);
                    if (a == null) {
                        oVar.a("cache-miss");
                        this.d.put(oVar);
                    } else {
                        if ((a.d < System.currentTimeMillis() ? 1 : 0) != 0) {
                            oVar.a("cache-hit-expired");
                            oVar.k = a;
                            this.d.put(oVar);
                        } else {
                            oVar.a("cache-hit");
                            s a2 = oVar.a(new m(a.a, a.f));
                            oVar.a("cache-hit-parsed");
                            if ((a.e < System.currentTimeMillis() ? 1 : 0) == 0) {
                                this.f.a(oVar, a2);
                            } else {
                                oVar.a("cache-hit-refresh-needed");
                                oVar.k = a;
                                a2.d = true;
                                this.f.a(oVar, a2, new e(this, oVar));
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.a) {
                    return;
                }
            }
        }
    }
}
