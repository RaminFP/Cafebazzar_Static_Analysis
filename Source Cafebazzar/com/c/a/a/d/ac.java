package com.c.a.a.d;

import com.c.a.a.v;
import com.c.a.ak;
import d.f;
import d.j;
import d.r;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ac implements Closeable {
    static final /* synthetic */ boolean k = (!ac.class.desiredAssertionStatus());
    private static final ExecutorService l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), v.a("OkHttp SpdyConnection", true));
    public final ak a;
    final boolean b;
    long c;
    long d;
    public final y e;
    final y f;
    final as g;
    final Socket h;
    public final d i;
    final al j;
    private final q m;
    private final Map n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map u;
    private final w v;
    private int w;
    private boolean x;
    private final Set y;

    private ac(ak akVar) {
        int i = 2;
        this.n = new HashMap();
        this.s = System.nanoTime();
        this.c = 0;
        this.e = new y();
        this.f = new y();
        this.x = false;
        this.y = new LinkedHashSet();
        this.a = akVar.d;
        this.v = akVar.e;
        this.b = akVar.f;
        this.m = akVar.c;
        this.q = akVar.f ? 1 : 2;
        if (akVar.f && this.a == ak.HTTP_2) {
            this.q += 2;
        }
        if (akVar.f) {
            i = 1;
        }
        this.w = i;
        if (akVar.f) {
            this.e.a(7, 0, 16777216);
        }
        this.o = akVar.a;
        if (this.a == ak.HTTP_2) {
            this.g = new j();
            this.t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), v.a(String.format("OkHttp %s Push Observer", new Object[]{this.o}), true));
            this.f.a(7, 0, 65535);
            this.f.a(5, 0, 16384);
        } else if (this.a == ak.SPDY_3) {
            this.g = new z();
            this.t = null;
        } else {
            throw new AssertionError(this.a);
        }
        this.d = (long) this.f.c(65536);
        this.h = akVar.b;
        this.i = this.g.a(r.a(r.a(akVar.b)), this.b);
        this.j = new al();
        new Thread(this.j).start();
    }

    private void a(a aVar, a aVar2) {
        IOException iOException;
        IOException iOException2;
        if (k || !Thread.holdsLock(this)) {
            ao[] aoVarArr;
            v[] vVarArr;
            try {
                synchronized (this.i) {
                    synchronized (this) {
                        if (this.r) {
                            iOException = null;
                        } else {
                            this.r = true;
                            this.i.a(this.p, aVar, v.a);
                            iOException = null;
                        }
                    }
                    if (aoVarArr != null) {
                        iOException2 = iOException;
                        for (ao a : aoVarArr) {
                            try {
                                a.a(aVar2);
                            } catch (IOException iOException3) {
                                if (iOException2 != null) {
                                    iOException2 = iOException3;
                                }
                            }
                        }
                        iOException3 = iOException2;
                    }
                    if (vVarArr != null) {
                        for (v vVar : vVarArr) {
                            if (vVar.c == -1 || vVar.b == -1) {
                                throw new IllegalStateException();
                            }
                            vVar.c = vVar.b - 1;
                            vVar.a.countDown();
                        }
                    }
                    this.i.close();
                    iOException2 = iOException3;
                    this.h.close();
                    if (iOException2 != null) {
                        throw iOException2;
                    }
                    return;
                }
            } catch (IOException iOException22) {
                iOException3 = iOException22;
            }
            synchronized (this) {
                if (this.n.isEmpty()) {
                    aoVarArr = null;
                } else {
                    ao[] aoVarArr2 = (ao[]) this.n.values().toArray(new ao[this.n.size()]);
                    this.n.clear();
                    a(false);
                    aoVarArr = aoVarArr2;
                }
                if (this.u != null) {
                    v[] vVarArr2 = (v[]) this.u.values().toArray(new v[this.u.size()]);
                    this.u = null;
                    vVarArr = vVarArr2;
                } else {
                    vVarArr = null;
                }
            }
            if (aoVarArr != null) {
                iOException22 = iOException3;
                while (r2 < r6) {
                    a.a(aVar2);
                }
                iOException3 = iOException22;
            }
            if (vVarArr != null) {
                while (r0 < r2) {
                    if (vVar.c == -1) {
                    }
                    throw new IllegalStateException();
                }
            }
            try {
                this.i.close();
                iOException22 = iOException3;
            } catch (IOException e) {
                iOException22 = e;
                if (iOException3 != null) {
                    iOException22 = iOException3;
                }
            }
            try {
                this.h.close();
            } catch (IOException e2) {
                iOException22 = e2;
            }
            if (iOException22 != null) {
                throw iOException22;
            }
            return;
        }
        throw new AssertionError();
    }

    static /* synthetic */ void a(ac acVar, int i, a aVar) {
        ac acVar2 = acVar;
        acVar.t.execute(new aj(acVar2, "OkHttp %s Push Reset[%s]", new Object[]{acVar.o, Integer.valueOf(i)}, i, aVar));
    }

    static /* synthetic */ void a(ac acVar, int i, j jVar, int i2, boolean z) {
        f fVar = new f();
        jVar.a((long) i2);
        jVar.a(fVar, (long) i2);
        if (fVar.b != ((long) i2)) {
            throw new IOException(fVar.b + " != " + i2);
        }
        ac acVar2 = acVar;
        acVar.t.execute(new ai(acVar2, "OkHttp %s Push Data[%s]", new Object[]{acVar.o, Integer.valueOf(i)}, i, fVar, i2, z));
    }

    static /* synthetic */ void a(ac acVar, int i, List list) {
        synchronized (acVar) {
            if (acVar.y.contains(Integer.valueOf(i))) {
                acVar.a(i, a.PROTOCOL_ERROR);
                return;
            }
            acVar.y.add(Integer.valueOf(i));
            ac acVar2 = acVar;
            acVar.t.execute(new ag(acVar2, "OkHttp %s Push Request[%s]", new Object[]{acVar.o, Integer.valueOf(i)}, i, list));
        }
    }

    static /* synthetic */ void a(ac acVar, int i, List list, boolean z) {
        ac acVar2 = acVar;
        acVar.t.execute(new ah(acVar2, "OkHttp %s Push Headers[%s]", new Object[]{acVar.o, Integer.valueOf(i)}, i, list, z));
    }

    static /* synthetic */ void a(ac acVar, boolean z, int i, int i2, v vVar) {
        synchronized (acVar.i) {
            if (vVar != null) {
                if (vVar.b != -1) {
                    throw new IllegalStateException();
                }
                vVar.b = System.nanoTime();
            }
            acVar.i.a(z, i, i2);
        }
    }

    private void a(boolean z) {
        synchronized (this) {
            this.s = z ? System.nanoTime() : Long.MAX_VALUE;
        }
    }

    static /* synthetic */ boolean a(ac acVar, int i) {
        return acVar.a == ak.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    static /* synthetic */ void b(ac acVar, boolean z, int i, int i2, v vVar) {
        ac acVar2 = acVar;
        l.execute(new af(acVar2, "OkHttp %s ping %08x%08x", new Object[]{acVar.o, Integer.valueOf(i), Integer.valueOf(i2)}, true, i, i2, null));
    }

    private v c(int i) {
        v vVar;
        synchronized (this) {
            vVar = this.u != null ? (v) this.u.remove(Integer.valueOf(i)) : null;
        }
        return vVar;
    }

    final ao a(int i) {
        ao aoVar;
        synchronized (this) {
            aoVar = (ao) this.n.get(Integer.valueOf(i));
        }
        return aoVar;
    }

    public ao a(int i, List list, boolean z, boolean z2) {
        ao aoVar;
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        synchronized (this.i) {
            int i2;
            synchronized (this) {
                if (this.r) {
                    throw new IOException("shutdown");
                }
                i2 = this.q;
                this.q += 2;
                aoVar = new ao(i2, this, z4, z3, list);
                if (aoVar.a()) {
                    this.n.put(Integer.valueOf(i2), aoVar);
                    a(false);
                }
            }
            this.i.a(z4, z3, i2, 0, list);
        }
        if (!z) {
            this.i.b();
        }
        return aoVar;
    }

    final void a(int i, long j) {
        l.execute(new ae(this, "OkHttp Window Update %s stream %d", new Object[]{this.o, Integer.valueOf(i)}, i, j));
    }

    final void a(int i, a aVar) {
        l.submit(new ad(this, "OkHttp %s stream %d", new Object[]{this.o, Integer.valueOf(i)}, i, aVar));
    }

    public final void a(int i, boolean z, f fVar, long j) {
        if (j == 0) {
            this.i.a(z, i, fVar, 0);
            return;
        }
        while (j > 0) {
            int min;
            synchronized (this) {
                while (this.d <= 0) {
                    try {
                        if (this.n.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.d), this.i.c());
                this.d -= (long) min;
            }
            j -= (long) min;
            d dVar = this.i;
            boolean z2 = z && j == 0;
            dVar.a(z2, i, fVar, min);
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this) {
            z = this.s != Long.MAX_VALUE;
        }
        return z;
    }

    public final long b() {
        long j;
        synchronized (this) {
            j = this.s;
        }
        return j;
    }

    final ao b(int i) {
        ao aoVar;
        synchronized (this) {
            aoVar = (ao) this.n.remove(Integer.valueOf(i));
            if (aoVar != null && this.n.isEmpty()) {
                a(true);
            }
            notifyAll();
        }
        return aoVar;
    }

    final void b(int i, a aVar) {
        this.i.a(i, aVar);
    }

    public final void c() {
        this.i.b();
    }

    public final void close() {
        a(a.NO_ERROR, a.CANCEL);
    }
}
