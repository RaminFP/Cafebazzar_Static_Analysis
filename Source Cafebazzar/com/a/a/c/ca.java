package com.a.a.c;

import b.a.a.a.a.b.k;
import b.a.a.a.a.g.r;
import b.a.a.a.f;
import java.util.List;

final class ca extends k {
    final /* synthetic */ by a;
    private final float b;

    ca(by byVar, float f) {
        this.a = byVar;
        this.b = f;
    }

    public final void a() {
        try {
            f.a().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
            if (this.b > 0.0f) {
                try {
                    Thread.sleep((long) (this.b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            h f = h.f();
            ac acVar = f.c;
            List<bx> a = this.a.a();
            if (!acVar.e.get()) {
                if (a.isEmpty() || ((Boolean) r.a.a(new n(f), Boolean.valueOf(true))).booleanValue()) {
                    List list = a;
                    int i = 0;
                    List list2 = list;
                    while (!r0.isEmpty() && !h.f().c.e.get()) {
                        f.a().a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                        for (bx a2 : r0) {
                            this.a.a(a2);
                        }
                        list2 = this.a.a();
                        if (!list2.isEmpty()) {
                            long j = (long) by.c[Math.min(i, by.c.length - 1)];
                            f.a().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i++;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                } else {
                    f.a().a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
                    for (bx a22 : a) {
                        a22.a();
                    }
                }
            }
        } catch (Throwable e3) {
            f.a().c("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e3);
        }
        this.a.f = null;
    }
}
