package com.c.a.a.d;

import d.ac;
import d.ad;
import d.f;
import d.j;
import java.io.EOFException;

final class aq implements ac {
    static final /* synthetic */ boolean a = (!ao.class.desiredAssertionStatus());
    final /* synthetic */ ao b;
    private final f c;
    private final f d;
    private final long e;
    private boolean f;
    private boolean g;

    private aq(ao aoVar, long j) {
        this.b = aoVar;
        this.c = new f();
        this.d = new f();
        this.e = j;
    }

    private void b() {
        this.b.h.k_();
        while (this.d.b == 0 && !this.g && !this.f && this.b.l == null) {
            try {
                this.b.f();
            } catch (Throwable th) {
                this.b.h.b();
            }
        }
        this.b.h.b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(d.f r9, long r10) {
        /*
        r8 = this;
        r4 = 0;
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x001b;
    L_0x0006:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "byteCount < 0: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x001b:
        r2 = r8.b;
        monitor-enter(r2);
        r8.b();	 Catch:{ all -> 0x002d }
        r0 = r8.f;	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x0030;
    L_0x0025:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x002d }
        r1 = "stream closed";
        r0.<init>(r1);	 Catch:{ all -> 0x002d }
        throw r0;	 Catch:{ all -> 0x002d }
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002d }
        throw r0;
    L_0x0030:
        r0 = r8.b;	 Catch:{ all -> 0x002d }
        r0 = r0.l;	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x0053;
    L_0x0038:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x002d }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002d }
        r3 = "stream was reset: ";
        r1.<init>(r3);	 Catch:{ all -> 0x002d }
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r3 = r3.l;	 Catch:{ all -> 0x002d }
        r1 = r1.append(r3);	 Catch:{ all -> 0x002d }
        r1 = r1.toString();	 Catch:{ all -> 0x002d }
        r0.<init>(r1);	 Catch:{ all -> 0x002d }
        throw r0;	 Catch:{ all -> 0x002d }
    L_0x0053:
        r0 = r8.d;	 Catch:{ all -> 0x002d }
        r0 = r0.b;	 Catch:{ all -> 0x002d }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x005f;
    L_0x005b:
        monitor-exit(r2);	 Catch:{ all -> 0x002d }
        r0 = -1;
    L_0x005e:
        return r0;
    L_0x005f:
        r0 = r8.d;	 Catch:{ all -> 0x002d }
        r1 = r8.d;	 Catch:{ all -> 0x002d }
        r4 = r1.b;	 Catch:{ all -> 0x002d }
        r4 = java.lang.Math.min(r10, r4);	 Catch:{ all -> 0x002d }
        r0 = r0.a(r9, r4);	 Catch:{ all -> 0x002d }
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r4 = r3.a;	 Catch:{ all -> 0x002d }
        r4 = r4 + r0;
        r3.a = r4;	 Catch:{ all -> 0x002d }
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r4 = r3.a;	 Catch:{ all -> 0x002d }
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r3 = r3.d;	 Catch:{ all -> 0x002d }
        r3 = r3.e;	 Catch:{ all -> 0x002d }
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = r3.c(r6);	 Catch:{ all -> 0x002d }
        r3 = r3 / 2;
        r6 = (long) r3;	 Catch:{ all -> 0x002d }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 < 0) goto L_0x00a6;
    L_0x008d:
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r3 = r3.d;	 Catch:{ all -> 0x002d }
        r4 = r8.b;	 Catch:{ all -> 0x002d }
        r4 = r4.c;	 Catch:{ all -> 0x002d }
        r5 = r8.b;	 Catch:{ all -> 0x002d }
        r6 = r5.a;	 Catch:{ all -> 0x002d }
        r3.a(r4, r6);	 Catch:{ all -> 0x002d }
        r3 = r8.b;	 Catch:{ all -> 0x002d }
        r4 = 0;
        r3.a = r4;	 Catch:{ all -> 0x002d }
    L_0x00a6:
        monitor-exit(r2);	 Catch:{ all -> 0x002d }
        r2 = r8.b;
        r2 = r2.d;
        monitor-enter(r2);
        r3 = r8.b;	 Catch:{ all -> 0x00f5 }
        r3 = r3.d;	 Catch:{ all -> 0x00f5 }
        r4 = r3.c;	 Catch:{ all -> 0x00f5 }
        r4 = r4 + r0;
        r3.c = r4;	 Catch:{ all -> 0x00f5 }
        r3 = r8.b;	 Catch:{ all -> 0x00f5 }
        r3 = r3.d;	 Catch:{ all -> 0x00f5 }
        r4 = r3.c;	 Catch:{ all -> 0x00f5 }
        r3 = r8.b;	 Catch:{ all -> 0x00f5 }
        r3 = r3.d;	 Catch:{ all -> 0x00f5 }
        r3 = r3.e;	 Catch:{ all -> 0x00f5 }
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = r3.c(r6);	 Catch:{ all -> 0x00f5 }
        r3 = r3 / 2;
        r6 = (long) r3;	 Catch:{ all -> 0x00f5 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 < 0) goto L_0x00f2;
    L_0x00d6:
        r3 = r8.b;	 Catch:{ all -> 0x00f5 }
        r3 = r3.d;	 Catch:{ all -> 0x00f5 }
        r4 = 0;
        r5 = r8.b;	 Catch:{ all -> 0x00f5 }
        r5 = r5.d;	 Catch:{ all -> 0x00f5 }
        r6 = r5.c;	 Catch:{ all -> 0x00f5 }
        r3.a(r4, r6);	 Catch:{ all -> 0x00f5 }
        r3 = r8.b;	 Catch:{ all -> 0x00f5 }
        r3 = r3.d;	 Catch:{ all -> 0x00f5 }
        r4 = 0;
        r3.c = r4;	 Catch:{ all -> 0x00f5 }
    L_0x00f2:
        monitor-exit(r2);	 Catch:{ all -> 0x00f5 }
        goto L_0x005e;
    L_0x00f5:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00f5 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.d.aq.a(d.f, long):long");
    }

    final void a(j jVar, long j) {
        if (a || !Thread.holdsLock(this.b)) {
            while (j > 0) {
                boolean z;
                Object obj;
                synchronized (this.b) {
                    z = this.g;
                    obj = this.d.b + j > this.e ? 1 : null;
                }
                if (obj != null) {
                    jVar.f(j);
                    this.b.b(a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    jVar.f(j);
                    return;
                } else {
                    long a = jVar.a(this.c, j);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    j -= a;
                    synchronized (this.b) {
                        obj = this.d.b == 0 ? 1 : null;
                        this.d.a(this.c);
                        if (obj != null) {
                            this.b.notifyAll();
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public final void close() {
        synchronized (this.b) {
            this.f = true;
            this.d.r();
            this.b.notifyAll();
        }
        ao.f(this.b);
    }

    public final ad j_() {
        return this.b.h;
    }
}
