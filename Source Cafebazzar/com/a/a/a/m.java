package com.a.a.a;

import android.app.Activity;
import b.a.a.a.d;
import b.a.a.a.f;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class m extends d {
    private final ai a;
    private final p b;

    public m(ai aiVar, p pVar) {
        this.a = aiVar;
        this.b = pVar;
    }

    public final void a(Activity activity) {
    }

    public final void b(Activity activity) {
        this.a.a(activity, am.START);
    }

    public final void c(Activity activity) {
        this.a.a(activity, am.RESUME);
        p pVar = this.b;
        pVar.e = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) pVar.d.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void d(Activity activity) {
        this.a.a(activity, am.PAUSE);
        p pVar = this.b;
        if (pVar.c && !pVar.e) {
            pVar.e = true;
            try {
                pVar.d.compareAndSet(null, pVar.a.schedule(new q(pVar), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                f.a().a("Answers", "Failed to schedule background detector", e);
            }
        }
    }

    public final void e(Activity activity) {
        this.a.a(activity, am.STOP);
    }
}
