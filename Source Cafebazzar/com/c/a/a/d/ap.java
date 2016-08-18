package com.c.a.a.d;

import d.ab;
import d.ad;
import d.f;

final class ap implements ab {
    static final /* synthetic */ boolean a = (!ao.class.desiredAssertionStatus());
    final /* synthetic */ ao b;
    private final f c = new f();
    private boolean d;
    private boolean e;

    ap(ao aoVar) {
        this.b = aoVar;
    }

    private void a(boolean z) {
        synchronized (this.b) {
            this.b.k.k_();
            while (this.b.b <= 0 && !this.e && !this.d && this.b.l == null) {
                try {
                    this.b.f();
                } catch (Throwable th) {
                    this.b.k.b();
                }
            }
            this.b.k.b();
            ao.h(this.b);
            long min = Math.min(this.b.b, this.c.b);
            ao aoVar = this.b;
            aoVar.b -= min;
        }
        this.b.k.k_();
        try {
            ac a = this.b.d;
            int b = this.b.c;
            boolean z2 = z && min == this.c.b;
            a.a(b, z2, this.c, min);
        } finally {
            this.b.k.b();
        }
    }

    public final void a_(f fVar, long j) {
        if (a || !Thread.holdsLock(this.b)) {
            this.c.a_(fVar, j);
            while (this.c.b >= 16384) {
                a(false);
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
        r6 = this;
        r4 = 0;
        r2 = 1;
        r0 = a;
        if (r0 != 0) goto L_0x0015;
    L_0x0007:
        r0 = r6.b;
        r0 = java.lang.Thread.holdsLock(r0);
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0015:
        r1 = r6.b;
        monitor-enter(r1);
        r0 = r6.d;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
    L_0x001d:
        return;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        r0 = r6.b;
        r0 = r0.g;
        r0 = r0.e;
        if (r0 != 0) goto L_0x004e;
    L_0x0027:
        r0 = r6.c;
        r0 = r0.b;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x003e;
    L_0x002f:
        r0 = r6.c;
        r0 = r0.b;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x004e;
    L_0x0037:
        r6.a(r2);
        goto L_0x002f;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = r6.b;
        r0 = r0.d;
        r1 = r6.b;
        r1 = r1.c;
        r3 = 0;
        r0.a(r1, r2, r3, r4);
    L_0x004e:
        r1 = r6.b;
        monitor-enter(r1);
        r0 = 1;
        r6.d = r0;	 Catch:{ all -> 0x0064 }
        monitor-exit(r1);	 Catch:{ all -> 0x0064 }
        r0 = r6.b;
        r0 = r0.d;
        r0.c();
        r0 = r6.b;
        com.c.a.a.d.ao.f(r0);
        goto L_0x001d;
    L_0x0064:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0064 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.d.ap.close():void");
    }

    public final void flush() {
        if (a || !Thread.holdsLock(this.b)) {
            synchronized (this.b) {
                ao.h(this.b);
            }
            while (this.c.b > 0) {
                a(false);
                this.b.d.c();
            }
            return;
        }
        throw new AssertionError();
    }

    public final ad j_() {
        return this.b.k;
    }
}
