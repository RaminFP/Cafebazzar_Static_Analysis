package com.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import b.a.a.a.a.b.j;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.q;
import b.a.a.a.a.b.x;
import b.a.a.a.a.b.y;
import b.a.a.a.a.e.m;
import b.a.a.a.a.f.c;
import b.a.a.a.a.g.f;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class a implements l {
    final AtomicBoolean a;
    final AtomicBoolean b;
    private Context c;
    private e d;
    private x e;
    private f f;
    private f g;
    private c h;
    private q i;
    private m j;
    private long k;

    public a() {
        this(false);
    }

    public a(boolean z) {
        this.a = new AtomicBoolean();
        this.k = 0;
        this.b = new AtomicBoolean(z);
    }

    @SuppressLint({"CommitPrefEdits"})
    protected final void a() {
        synchronized (this.h) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long a = this.i.a();
        long j = ((long) this.f.b) * 1000;
        b.a.a.a.f.a().a("Beta", "Check for updates delay: " + j);
        b.a.a.a.f.a().a("Beta", "Check for updates last check time: " + this.k);
        j += this.k;
        b.a.a.a.f.a().a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                b.a.a.a.f.a().a("Beta", "Performing update check");
                new g(this.d, l.c(this.d.p, "com.crashlytics.ApiEndpoint"), this.f.a, this.j, new i()).a(new j().a(this.c), (String) this.e.c().get(y.FONT_TOKEN), this.g);
            } finally {
                this.k = a;
            }
        } else {
            b.a.a.a.f.a().a("Beta", "Check for updates next check time was not passed");
        }
    }

    public final void a(Context context, e eVar, x xVar, f fVar, f fVar2, c cVar, q qVar, m mVar) {
        this.c = context;
        this.d = eVar;
        this.e = xVar;
        this.f = fVar;
        this.g = fVar2;
        this.h = cVar;
        this.i = qVar;
        this.j = mVar;
        this.a.set(true);
        if (this.b.get()) {
            a();
        }
    }
}
