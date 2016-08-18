package com.c.a.a.d;

import d.ab;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

public final class ao {
    static final /* synthetic */ boolean i = (!ao.class.desiredAssertionStatus());
    long a = 0;
    long b;
    final int c;
    final ac d;
    List e;
    public final aq f;
    final ap g;
    public final ar h = new ar(this);
    private final List j;
    private final ar k = new ar(this);
    private a l = null;

    ao(int i, ac acVar, boolean z, boolean z2, List list) {
        if (acVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.c = i;
            this.d = acVar;
            this.b = (long) acVar.f.c(65536);
            this.f = new aq(this, (long) acVar.e.c(65536));
            this.g = new ap(this);
            this.f.g = z2;
            this.g.e = z;
            this.j = list;
        }
    }

    private boolean d(a aVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.l != null) {
                    return false;
                } else if (this.f.g && this.g.e) {
                    return false;
                } else {
                    this.l = aVar;
                    notifyAll();
                    this.d.b(this.c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    private void f() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    static /* synthetic */ void f(ao aoVar) {
        if (i || !Thread.holdsLock(aoVar)) {
            Object obj;
            boolean a;
            synchronized (aoVar) {
                obj = (!aoVar.f.g && aoVar.f.f && (aoVar.g.e || aoVar.g.d)) ? 1 : null;
                a = aoVar.a();
            }
            if (obj != null) {
                aoVar.a(a.CANCEL);
                return;
            } else if (!a) {
                aoVar.d.b(aoVar.c);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    static /* synthetic */ void h(ao aoVar) {
        if (aoVar.g.d) {
            throw new IOException("stream closed");
        } else if (aoVar.g.e) {
            throw new IOException("stream finished");
        } else if (aoVar.l != null) {
            throw new IOException("stream was reset: " + aoVar.l);
        }
    }

    final void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void a(a aVar) {
        if (d(aVar)) {
            this.d.b(this.c, aVar);
        }
    }

    public final boolean a() {
        boolean z = false;
        synchronized (this) {
            if (this.l == null) {
                if (!(this.f.g || this.f.f) || (!(this.g.e || this.g.d) || this.e == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void b(a aVar) {
        if (d(aVar)) {
            this.d.a(this.c, aVar);
        }
    }

    public final boolean b() {
        return this.d.b == ((this.c & 1) == 1);
    }

    public final List c() {
        List list;
        synchronized (this) {
            this.h.k_();
            while (this.e == null && this.l == null) {
                try {
                    f();
                } catch (Throwable th) {
                    this.h.b();
                }
            }
            this.h.b();
            if (this.e != null) {
                list = this.e;
            } else {
                throw new IOException("stream was reset: " + this.l);
            }
        }
        return list;
    }

    final void c(a aVar) {
        synchronized (this) {
            if (this.l == null) {
                this.l = aVar;
                notifyAll();
            }
        }
    }

    public final ab d() {
        synchronized (this) {
            if (this.e != null || b()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.g;
    }

    final void e() {
        if (i || !Thread.holdsLock(this)) {
            boolean a;
            synchronized (this) {
                this.f.g = true;
                a = a();
                notifyAll();
            }
            if (!a) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
