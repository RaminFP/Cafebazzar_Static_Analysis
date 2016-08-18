package com.c.a.a.d;

import com.c.a.a.m;
import com.c.a.a.v;
import com.c.a.ak;
import d.j;
import d.k;
import d.r;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

final class al extends m implements c {
    b b;
    final /* synthetic */ ac c;

    private al(ac acVar) {
        this.c = acVar;
        super("OkHttp %s", acVar.o);
    }

    protected final void a() {
        a aVar;
        Throwable th;
        a aVar2 = a.INTERNAL_ERROR;
        a aVar3 = a.INTERNAL_ERROR;
        try {
            this.b = this.c.g.a(r.a(r.b(this.c.h)), this.c.b);
            if (!this.c.b) {
                this.b.a();
            }
            do {
            } while (this.b.a(this));
            try {
                this.c.a(a.NO_ERROR, a.CANCEL);
            } catch (IOException e) {
            }
            v.a(this.b);
        } catch (IOException e2) {
            aVar = a.PROTOCOL_ERROR;
            try {
                this.c.a(aVar, a.PROTOCOL_ERROR);
            } catch (IOException e3) {
            }
            v.a(this.b);
        } catch (Throwable th2) {
            th = th2;
            this.c.a(aVar, aVar3);
            v.a(this.b);
            throw th;
        }
    }

    public final void a(int i, long j) {
        if (i == 0) {
            synchronized (this.c) {
                ac acVar = this.c;
                acVar.d += j;
                this.c.notifyAll();
            }
            return;
        }
        ao a = this.c.a(i);
        if (a != null) {
            synchronized (a) {
                a.a(j);
            }
        }
    }

    public final void a(int i, a aVar) {
        if (ac.a(this.c, i)) {
            ac.a(this.c, i, aVar);
            return;
        }
        ao b = this.c.b(i);
        if (b != null) {
            b.c(aVar);
        }
    }

    public final void a(int i, k kVar) {
        int length = kVar.c.length;
        synchronized (this.c) {
            ao[] aoVarArr = (ao[]) this.c.n.values().toArray(new ao[this.c.n.size()]);
            this.c.r = true;
        }
        for (ao aoVar : aoVarArr) {
            if (aoVar.c > i && aoVar.b()) {
                aoVar.c(a.REFUSED_STREAM);
                this.c.b(aoVar.c);
            }
        }
    }

    public final void a(int i, List list) {
        ac.a(this.c, i, list);
    }

    public final void a(boolean z, int i, int i2) {
        if (z) {
            v c = this.c.c(i);
            if (c == null) {
                return;
            }
            if (c.c != -1 || c.b == -1) {
                throw new IllegalStateException();
            }
            c.c = System.nanoTime();
            c.a.countDown();
            return;
        }
        ac.b(this.c, true, i, i2, null);
    }

    public final void a(boolean z, int i, j jVar, int i2) {
        if (ac.a(this.c, i)) {
            ac.a(this.c, i, jVar, i2, z);
            return;
        }
        ao a = this.c.a(i);
        if (a == null) {
            this.c.a(i, a.INVALID_STREAM);
            jVar.f((long) i2);
        } else if (ao.i || !Thread.holdsLock(a)) {
            a.f.a(jVar, (long) i2);
            if (z) {
                a.e();
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void a(boolean z, y yVar) {
        long j;
        ao[] aoVarArr;
        synchronized (this.c) {
            int i;
            int c = this.c.f.c(65536);
            if (z) {
                y yVar2 = this.c.f;
                yVar2.c = 0;
                yVar2.b = 0;
                yVar2.a = 0;
                Arrays.fill(yVar2.d, 0);
            }
            y yVar3 = this.c.f;
            for (i = 0; i < 10; i++) {
                if (yVar.a(i)) {
                    yVar3.a(i, yVar.b(i), yVar.d[i]);
                }
            }
            if (this.c.a == ak.HTTP_2) {
                ac.l.execute(new an(this, "OkHttp %s ACK Settings", new Object[]{this.c.o}, yVar));
            }
            i = this.c.f.c(65536);
            if (i == -1 || i == c) {
                j = 0;
                aoVarArr = null;
            } else {
                j = (long) (i - c);
                if (!this.c.x) {
                    ac acVar = this.c;
                    acVar.d += j;
                    if (j > 0) {
                        acVar.notifyAll();
                    }
                    this.c.x = true;
                }
                aoVarArr = !this.c.n.isEmpty() ? (ao[]) this.c.n.values().toArray(new ao[this.c.n.size()]) : null;
            }
        }
        if (aoVarArr != null && j != 0) {
            for (ao aoVar : aoVarArr) {
                synchronized (aoVar) {
                    aoVar.a(j);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r9, boolean r10, int r11, java.util.List r12, com.c.a.a.d.f r13) {
        /*
        r8 = this;
        r2 = 0;
        r1 = 1;
        r0 = r8.c;
        r0 = com.c.a.a.d.ac.a(r0, r11);
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r8.c;
        com.c.a.a.d.ac.a(r0, r11, r12, r10);
    L_0x000f:
        return;
    L_0x0010:
        r6 = r8.c;
        monitor-enter(r6);
        r0 = r8.c;	 Catch:{ all -> 0x001d }
        r0 = r0.r;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0020;
    L_0x001b:
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        goto L_0x000f;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        throw r0;
    L_0x0020:
        r0 = r8.c;	 Catch:{ all -> 0x001d }
        r3 = r0.a(r11);	 Catch:{ all -> 0x001d }
        if (r3 != 0) goto L_0x0095;
    L_0x0028:
        r0 = com.c.a.a.d.f.SPDY_REPLY;	 Catch:{ all -> 0x001d }
        if (r13 == r0) goto L_0x0030;
    L_0x002c:
        r0 = com.c.a.a.d.f.SPDY_HEADERS;	 Catch:{ all -> 0x001d }
        if (r13 != r0) goto L_0x0031;
    L_0x0030:
        r2 = r1;
    L_0x0031:
        if (r2 == 0) goto L_0x003c;
    L_0x0033:
        r0 = r8.c;	 Catch:{ all -> 0x001d }
        r1 = com.c.a.a.d.a.INVALID_STREAM;	 Catch:{ all -> 0x001d }
        r0.a(r11, r1);	 Catch:{ all -> 0x001d }
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        goto L_0x000f;
    L_0x003c:
        r0 = r8.c;	 Catch:{ all -> 0x001d }
        r0 = r0.p;	 Catch:{ all -> 0x001d }
        if (r11 > r0) goto L_0x0046;
    L_0x0044:
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        goto L_0x000f;
    L_0x0046:
        r0 = r11 % 2;
        r1 = r8.c;	 Catch:{ all -> 0x001d }
        r1 = r1.q;	 Catch:{ all -> 0x001d }
        r1 = r1 % 2;
        if (r0 != r1) goto L_0x0054;
    L_0x0052:
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        goto L_0x000f;
    L_0x0054:
        r0 = new com.c.a.a.d.ao;	 Catch:{ all -> 0x001d }
        r2 = r8.c;	 Catch:{ all -> 0x001d }
        r1 = r11;
        r3 = r9;
        r4 = r10;
        r5 = r12;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x001d }
        r1 = r8.c;	 Catch:{ all -> 0x001d }
        r1.p = r11;	 Catch:{ all -> 0x001d }
        r1 = r8.c;	 Catch:{ all -> 0x001d }
        r1 = r1.n;	 Catch:{ all -> 0x001d }
        r2 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001d }
        r1.put(r2, r0);	 Catch:{ all -> 0x001d }
        r1 = com.c.a.a.d.ac.l;	 Catch:{ all -> 0x001d }
        r2 = new com.c.a.a.d.am;	 Catch:{ all -> 0x001d }
        r3 = "OkHttp %s stream %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001d }
        r5 = 0;
        r7 = r8.c;	 Catch:{ all -> 0x001d }
        r7 = r7.o;	 Catch:{ all -> 0x001d }
        r4[r5] = r7;	 Catch:{ all -> 0x001d }
        r5 = 1;
        r7 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001d }
        r4[r5] = r7;	 Catch:{ all -> 0x001d }
        r2.<init>(r8, r3, r4, r0);	 Catch:{ all -> 0x001d }
        r1.execute(r2);	 Catch:{ all -> 0x001d }
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        goto L_0x000f;
    L_0x0095:
        monitor-exit(r6);	 Catch:{ all -> 0x001d }
        r0 = com.c.a.a.d.f.SPDY_SYN_STREAM;
        if (r13 != r0) goto L_0x00a9;
    L_0x009a:
        r0 = r1;
    L_0x009b:
        if (r0 == 0) goto L_0x00ab;
    L_0x009d:
        r0 = com.c.a.a.d.a.PROTOCOL_ERROR;
        r3.b(r0);
        r0 = r8.c;
        r0.b(r11);
        goto L_0x000f;
    L_0x00a9:
        r0 = r2;
        goto L_0x009b;
    L_0x00ab:
        r0 = com.c.a.a.d.ao.i;
        if (r0 != 0) goto L_0x00bb;
    L_0x00af:
        r0 = java.lang.Thread.holdsLock(r3);
        if (r0 == 0) goto L_0x00bb;
    L_0x00b5:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x00bb:
        r0 = 0;
        monitor-enter(r3);
        r4 = r3.e;	 Catch:{ all -> 0x00e1 }
        if (r4 != 0) goto L_0x00e4;
    L_0x00c1:
        r4 = com.c.a.a.d.f.SPDY_HEADERS;	 Catch:{ all -> 0x00e1 }
        if (r13 != r4) goto L_0x00c6;
    L_0x00c5:
        r2 = r1;
    L_0x00c6:
        if (r2 == 0) goto L_0x00d7;
    L_0x00c8:
        r0 = com.c.a.a.d.a.PROTOCOL_ERROR;	 Catch:{ all -> 0x00e1 }
    L_0x00ca:
        monitor-exit(r3);	 Catch:{ all -> 0x00e1 }
        if (r0 == 0) goto L_0x00fe;
    L_0x00cd:
        r3.b(r0);
    L_0x00d0:
        if (r10 == 0) goto L_0x000f;
    L_0x00d2:
        r3.e();
        goto L_0x000f;
    L_0x00d7:
        r3.e = r12;	 Catch:{ all -> 0x00e1 }
        r1 = r3.a();	 Catch:{ all -> 0x00e1 }
        r3.notifyAll();	 Catch:{ all -> 0x00e1 }
        goto L_0x00ca;
    L_0x00e1:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00e1 }
        throw r0;
    L_0x00e4:
        r4 = com.c.a.a.d.f.SPDY_REPLY;	 Catch:{ all -> 0x00e1 }
        if (r13 != r4) goto L_0x00e9;
    L_0x00e8:
        r2 = r1;
    L_0x00e9:
        if (r2 == 0) goto L_0x00ee;
    L_0x00eb:
        r0 = com.c.a.a.d.a.STREAM_IN_USE;	 Catch:{ all -> 0x00e1 }
        goto L_0x00ca;
    L_0x00ee:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x00e1 }
        r2.<init>();	 Catch:{ all -> 0x00e1 }
        r4 = r3.e;	 Catch:{ all -> 0x00e1 }
        r2.addAll(r4);	 Catch:{ all -> 0x00e1 }
        r2.addAll(r12);	 Catch:{ all -> 0x00e1 }
        r3.e = r2;	 Catch:{ all -> 0x00e1 }
        goto L_0x00ca;
    L_0x00fe:
        if (r1 != 0) goto L_0x00d0;
    L_0x0100:
        r0 = r3.d;
        r1 = r3.c;
        r0.b(r1);
        goto L_0x00d0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.d.al.a(boolean, boolean, int, java.util.List, com.c.a.a.d.f):void");
    }
}
