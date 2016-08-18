package com.google.a.a.a;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

final class aa implements bd, d, e {
    volatile long a;
    volatile int b;
    final Queue c;
    volatile Timer d;
    l e;
    long f;
    private volatile a g;
    private f h;
    private f i;
    private final ap j;
    private final h k;
    private final Context l;
    private volatile int m;
    private volatile Timer n;
    private volatile Timer o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    aa(Context context, h hVar) {
        this(context, hVar, null, ap.a(context));
    }

    private aa(Context context, h hVar, f fVar, ap apVar) {
        this.c = new ConcurrentLinkedQueue();
        this.f = 300000;
        this.i = null;
        this.l = context;
        this.k = hVar;
        this.j = apVar;
        this.e = new ab(this);
        this.m = 0;
        this.b = ae.g;
    }

    private static Timer a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void j() {
        this.n = a(this.n);
        this.o = a(this.o);
        this.d = a(this.d);
    }

    private void k() {
        this.h.a();
        this.p = false;
    }

    private void l() {
        this.n = a(this.n);
        this.n = new Timer("Service Reconnect");
        this.n.schedule(new ai(), 5000);
    }

    public final void a() {
        synchronized (this) {
            this.o = a(this.o);
            this.m = 0;
            as.c("Connected to service");
            this.b = ae.b;
            if (this.r) {
                i();
                this.r = false;
            } else {
                f();
                this.d = a(this.d);
                this.d = new Timer("disconnect check");
                this.d.schedule(new af(), this.f);
            }
        }
    }

    public final void a(int i) {
        synchronized (this) {
            this.b = ae.e;
            if (this.m < 2) {
                as.d("Service unavailable (code=" + i + "), will retry.");
                l();
            } else {
                as.d("Service unavailable (code=" + i + "), using local store.");
                g();
            }
        }
    }

    public final void a(Map map, long j, String str, List list) {
        as.c("putHit called");
        this.c.add(new ah(map, j, str, list));
        f();
    }

    public final void b() {
        synchronized (this) {
            if (this.b == ae.f) {
                as.c("Disconnected from service");
                j();
                this.b = ae.g;
            } else {
                as.c("Unexpected disconnect.");
                this.b = ae.e;
                if (this.m < 2) {
                    l();
                } else {
                    g();
                }
            }
        }
    }

    public final void c() {
        switch (ad.a[this.b - 1]) {
            case 1:
                k();
                return;
            case 2:
                return;
            default:
                this.p = true;
                return;
        }
    }

    public final void d() {
        synchronized (this) {
            if (!this.s) {
                as.c("setForceLocalDispatch called.");
                this.s = true;
                switch (ad.a[this.b - 1]) {
                    case 1:
                        break;
                    case 2:
                        i();
                        break;
                    case 3:
                        this.r = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void e() {
        if (this.g == null) {
            this.g = new b(this.l, this, this);
            h();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void f() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x007b }
        r3 = r8.k;	 Catch:{ all -> 0x007b }
        r3 = r3.d();	 Catch:{ all -> 0x007b }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x007b }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.k;	 Catch:{ all -> 0x007b }
        r2 = r2.c();	 Catch:{ all -> 0x007b }
        r3 = new com.google.a.a.a.ac;	 Catch:{ all -> 0x007b }
        r3.<init>(r8);	 Catch:{ all -> 0x007b }
        r2.add(r3);	 Catch:{ all -> 0x007b }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.q;	 Catch:{ all -> 0x007b }
        if (r2 == 0) goto L_0x003d;
    L_0x0025:
        r2 = "clearHits called";
        com.google.a.a.a.as.c(r2);	 Catch:{ all -> 0x007b }
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2.clear();	 Catch:{ all -> 0x007b }
        r2 = com.google.a.a.a.ad.a;	 Catch:{ all -> 0x007b }
        r3 = r8.b;	 Catch:{ all -> 0x007b }
        r3 = r3 + -1;
        r2 = r2[r3];	 Catch:{ all -> 0x007b }
        switch(r2) {
            case 1: goto L_0x007e;
            case 2: goto L_0x0089;
            default: goto L_0x003a;
        };	 Catch:{ all -> 0x007b }
    L_0x003a:
        r2 = 1;
        r8.q = r2;	 Catch:{ all -> 0x007b }
    L_0x003d:
        r2 = com.google.a.a.a.ad.a;	 Catch:{ all -> 0x007b }
        r3 = r8.b;	 Catch:{ all -> 0x007b }
        r3 = r3 + -1;
        r2 = r2[r3];	 Catch:{ all -> 0x007b }
        switch(r2) {
            case 1: goto L_0x0049;
            case 2: goto L_0x009a;
            case 3: goto L_0x0048;
            case 4: goto L_0x0048;
            case 5: goto L_0x0048;
            case 6: goto L_0x00e9;
            default: goto L_0x0048;
        };	 Catch:{ all -> 0x007b }
    L_0x0048:
        goto L_0x001f;
    L_0x0049:
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x007b }
        if (r2 != 0) goto L_0x0092;
    L_0x0051:
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2 = r2.poll();	 Catch:{ all -> 0x007b }
        r0 = r2;
        r0 = (com.google.a.a.a.ah) r0;	 Catch:{ all -> 0x007b }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007b }
        r3 = "Sending hit to store  ";
        r2.<init>(r3);	 Catch:{ all -> 0x007b }
        r2 = r2.append(r7);	 Catch:{ all -> 0x007b }
        r2 = r2.toString();	 Catch:{ all -> 0x007b }
        com.google.a.a.a.as.c(r2);	 Catch:{ all -> 0x007b }
        r2 = r8.h;	 Catch:{ all -> 0x007b }
        r3 = r7.a;	 Catch:{ all -> 0x007b }
        r4 = r7.b;	 Catch:{ all -> 0x007b }
        r6 = r7.c;	 Catch:{ all -> 0x007b }
        r7 = r7.d;	 Catch:{ all -> 0x007b }
        r2.a(r3, r4, r6, r7);	 Catch:{ all -> 0x007b }
        goto L_0x0049;
    L_0x007b:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x007e:
        r2 = r8.h;	 Catch:{ all -> 0x007b }
        r4 = 0;
        r2.a(r4);	 Catch:{ all -> 0x007b }
        r2 = 0;
        r8.q = r2;	 Catch:{ all -> 0x007b }
        goto L_0x003d;
    L_0x0089:
        r2 = r8.g;	 Catch:{ all -> 0x007b }
        r2.a();	 Catch:{ all -> 0x007b }
        r2 = 0;
        r8.q = r2;	 Catch:{ all -> 0x007b }
        goto L_0x003d;
    L_0x0092:
        r2 = r8.p;	 Catch:{ all -> 0x007b }
        if (r2 == 0) goto L_0x001f;
    L_0x0096:
        r8.k();	 Catch:{ all -> 0x007b }
        goto L_0x001f;
    L_0x009a:
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x007b }
        if (r2 != 0) goto L_0x00df;
    L_0x00a2:
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2 = r2.peek();	 Catch:{ all -> 0x007b }
        r0 = r2;
        r0 = (com.google.a.a.a.ah) r0;	 Catch:{ all -> 0x007b }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007b }
        r3 = "Sending hit to service   ";
        r2.<init>(r3);	 Catch:{ all -> 0x007b }
        r2 = r2.append(r7);	 Catch:{ all -> 0x007b }
        r2 = r2.toString();	 Catch:{ all -> 0x007b }
        com.google.a.a.a.as.c(r2);	 Catch:{ all -> 0x007b }
        r2 = r8.j;	 Catch:{ all -> 0x007b }
        r2 = r2.b();	 Catch:{ all -> 0x007b }
        if (r2 != 0) goto L_0x00d9;
    L_0x00c6:
        r2 = r8.g;	 Catch:{ all -> 0x007b }
        r3 = r7.a;	 Catch:{ all -> 0x007b }
        r4 = r7.b;	 Catch:{ all -> 0x007b }
        r6 = r7.c;	 Catch:{ all -> 0x007b }
        r7 = r7.d;	 Catch:{ all -> 0x007b }
        r2.a(r3, r4, r6, r7);	 Catch:{ all -> 0x007b }
    L_0x00d3:
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2.poll();	 Catch:{ all -> 0x007b }
        goto L_0x009a;
    L_0x00d9:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.a.a.a.as.c(r2);	 Catch:{ all -> 0x007b }
        goto L_0x00d3;
    L_0x00df:
        r2 = r8.e;	 Catch:{ all -> 0x007b }
        r2 = r2.a();	 Catch:{ all -> 0x007b }
        r8.a = r2;	 Catch:{ all -> 0x007b }
        goto L_0x001f;
    L_0x00e9:
        r2 = "Need to reconnect";
        com.google.a.a.a.as.c(r2);	 Catch:{ all -> 0x007b }
        r2 = r8.c;	 Catch:{ all -> 0x007b }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x007b }
        if (r2 != 0) goto L_0x001f;
    L_0x00f6:
        r8.h();	 Catch:{ all -> 0x007b }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.aa.f():void");
    }

    void g() {
        synchronized (this) {
            if (this.b != ae.c) {
                j();
                as.c("falling back to local store");
                if (this.i != null) {
                    this.h = this.i;
                } else {
                    x a = x.a();
                    a.a(this.l, this.k);
                    this.h = a.b();
                }
                this.b = ae.c;
                f();
            }
        }
    }

    void h() {
        synchronized (this) {
            if (this.s || this.g == null || this.b == ae.c) {
                as.d("client not initialized.");
                g();
            } else {
                try {
                    this.m++;
                    a(this.o);
                    this.b = ae.a;
                    this.o = new Timer("Failed Connect");
                    this.o.schedule(new ag(), 3000);
                    as.c("connecting to Analytics service");
                    this.g.b();
                } catch (SecurityException e) {
                    as.d("security exception on connectToService");
                    g();
                }
            }
        }
    }

    void i() {
        synchronized (this) {
            if (this.g != null && this.b == ae.b) {
                this.b = ae.f;
                this.g.c();
            }
        }
    }
}
