package com.a.a.a;

import android.content.Context;
import b.a.a.a.a.b.j;
import b.a.a.a.a.b.l;
import b.a.a.a.a.c.a.c;
import b.a.a.a.a.c.a.e;
import b.a.a.a.a.d.h;
import b.a.a.a.a.d.k;
import b.a.a.a.a.e.m;
import b.a.a.a.a.g.b;
import b.a.a.a.f;
import b.a.a.a.p;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class v implements aj {
    final an a;
    h b;
    j c = new j();
    w d = new x();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    private final p h;
    private final m i;
    private final Context j;
    private final ag k;
    private final ScheduledExecutorService l;
    private final AtomicReference m = new AtomicReference();

    public v(p pVar, Context context, ScheduledExecutorService scheduledExecutorService, ag agVar, m mVar, an anVar) {
        this.h = pVar;
        this.j = context;
        this.l = scheduledExecutorService;
        this.k = agVar;
        this.i = mVar;
        this.a = anVar;
    }

    private void a(long j, long j2) {
        if ((this.m.get() == null ? 1 : null) != null) {
            Runnable kVar = new k(this.j, this);
            l.a(this.j, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.m.set(this.l.scheduleAtFixedRate(kVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                l.b(this.j, "Failed to schedule time based file roll over");
            }
        }
    }

    public final void a() {
        Exception e;
        int i = 0;
        if (this.b == null) {
            l.a(this.j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        l.a(this.j, "Sending all files");
        List e2 = this.k.e();
        while (e2.size() > 0) {
            try {
                l.a(this.j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e2.size())}));
                boolean a = this.b.a(e2);
                if (a) {
                    i += e2.size();
                    try {
                        this.k.a(e2);
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (!a) {
                    break;
                }
                e2 = this.k.e();
            } catch (Exception e4) {
                e = e4;
            }
        }
        if (i == 0) {
            this.k.g();
        }
        l.b(this.j, "Failed to send batch of analytics files to server: " + e.getMessage());
        if (i == 0) {
            this.k.g();
        }
    }

    public final void a(b bVar, String str) {
        this.b = new o(new ah(this.h, str, bVar.a, this.i, this.c.a(this.j)), new ad(new e(new ab(new c(1000, 8), 0.1d), new b.a.a.a.a.c.a.b(5))));
        this.k.a = bVar;
        this.e = bVar.f;
        f.a().a("Answers", "Custom event tracking " + (this.e ? "enabled" : "disabled"));
        this.f = bVar.g;
        f.a().a("Answers", "Predefined event tracking " + (this.f ? "enabled" : "disabled"));
        if (bVar.i > 1) {
            f.a().a("Answers", "Event sampling enabled");
            this.d = new ae(bVar.i);
        }
        this.g = bVar.b;
        a(0, (long) this.g);
    }

    public final void a(al alVar) {
        byte b = (byte) 0;
        ak akVar = new ak(this.a, alVar.b, alVar.a, alVar.c, alVar.d, alVar.e, alVar.f, alVar.g);
        if (!this.e && am.CUSTOM.equals(akVar.c)) {
            f.a().a("Answers", "Custom events tracking disabled - skipping event: " + akVar);
        } else if (!this.f && am.PREDEFINED.equals(akVar.c)) {
            f.a().a("Answers", "Predefined events tracking disabled - skipping event: " + akVar);
        } else if (this.d.a(akVar)) {
            f.a().a("Answers", "Skipping filtered event: " + akVar);
        } else {
            try {
                this.k.a((Object) akVar);
            } catch (Throwable e) {
                f.a().c("Answers", "Failed to write event: " + akVar, e);
            }
            if (this.g != -1) {
                b = (byte) 1;
            }
            if (b != (byte) 0) {
                a((long) this.g, (long) this.g);
            }
        }
    }

    public final void b() {
        this.k.f();
    }

    public final boolean c() {
        try {
            return this.k.d();
        } catch (IOException e) {
            l.b(this.j, "Failed to roll file over.");
            return false;
        }
    }

    public final void d() {
        if (this.m.get() != null) {
            l.a(this.j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.m.get()).cancel(false);
            this.m.set(null);
        }
    }
}
