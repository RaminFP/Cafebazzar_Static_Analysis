package com.a.a.a;

import android.content.Context;
import b.a.a.a.a.d.f;
import b.a.a.a.a.e.m;
import b.a.a.a.p;
import java.util.concurrent.ScheduledExecutorService;

public final class e implements f {
    final p a;
    final Context b;
    final l c;
    final ap d;
    final m e;
    final ScheduledExecutorService f;
    aj g = new u();

    public e(p pVar, Context context, l lVar, ap apVar, m mVar, ScheduledExecutorService scheduledExecutorService) {
        this.a = pVar;
        this.b = context;
        this.c = lVar;
        this.d = apVar;
        this.e = mVar;
        this.f = scheduledExecutorService;
    }

    public final void a() {
        a(new h(this));
    }

    public final void a(al alVar, boolean z, boolean z2) {
        Runnable kVar = new k(this, alVar, z2);
        if (z) {
            try {
                this.f.submit(kVar).get();
                return;
            } catch (Throwable e) {
                b.a.a.a.f.a().c("Answers", "Failed to run events task", e);
                return;
            }
        }
        a(kVar);
    }

    void a(Runnable runnable) {
        try {
            this.f.submit(runnable);
        } catch (Throwable e) {
            b.a.a.a.f.a().c("Answers", "Failed to submit events task", e);
        }
    }
}
