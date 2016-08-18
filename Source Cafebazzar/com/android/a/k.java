package com.android.a;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class k extends Thread {
    volatile boolean a = false;
    private final BlockingQueue b;
    private final j c;
    private final b d;
    private final u e;

    public k(BlockingQueue blockingQueue, j jVar, b bVar, u uVar) {
        this.b = blockingQueue;
        this.c = jVar;
        this.d = bVar;
        this.e = uVar;
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                o oVar = (o) this.b.take();
                try {
                    oVar.a("network-queue-take");
                    if (oVar.h) {
                        oVar.b("network-discard-cancelled");
                    } else {
                        if (VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(oVar.c);
                        }
                        m a = this.c.a(oVar);
                        oVar.a("network-http-complete");
                        if (a.d && oVar.i) {
                            oVar.b("not-modified");
                        } else {
                            s a2 = oVar.a(a);
                            oVar.a("network-parse-complete");
                            if (oVar.g && a2.b != null) {
                                this.d.a(oVar.b, a2.b);
                                oVar.a("network-cache-written");
                            }
                            oVar.i = true;
                            this.e.a(oVar, a2);
                        }
                    }
                } catch (y e) {
                    this.e.a(oVar, o.a(e));
                } catch (Throwable e2) {
                    z.a(e2, "Unhandled exception %s", e2.toString());
                    this.e.a(oVar, new y(e2));
                }
            } catch (InterruptedException e3) {
                if (this.a) {
                    return;
                }
            }
        }
    }
}
