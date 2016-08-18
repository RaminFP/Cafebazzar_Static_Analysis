package com.c.a;

import com.c.a.a.a.a;
import com.c.a.a.e.b;
import com.c.a.a.k;
import com.c.a.a.l;
import com.c.a.a.n;
import com.c.a.a.u;
import com.c.a.a.v;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class ag implements Cloneable {
    private static final List w = v.a(ak.HTTP_2, ak.SPDY_3, ak.HTTP_1_1);
    private static final List x = v.a(u.a, u.b, u.c);
    private static SSLSocketFactory y;
    private n A;
    final u a;
    x b;
    public Proxy c;
    public List d;
    public List e;
    final List f;
    public final List g;
    public ProxySelector h;
    public CookieHandler i;
    l j;
    public SocketFactory k;
    public SSLSocketFactory l;
    public HostnameVerifier m;
    public n n;
    public b o;
    public s p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    int v;
    private c z;

    static {
        k.b = new ah();
    }

    public ag() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.q = true;
        this.r = true;
        this.s = true;
        this.a = new u();
        this.b = new x();
    }

    private ag(ag agVar) {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.q = true;
        this.r = true;
        this.s = true;
        this.a = agVar.a;
        this.b = agVar.b;
        this.c = agVar.c;
        this.d = agVar.d;
        this.e = agVar.e;
        this.f.addAll(agVar.f);
        this.g.addAll(agVar.g);
        this.h = agVar.h;
        this.i = agVar.i;
        this.z = agVar.z;
        this.j = this.z != null ? this.z.a : agVar.j;
        this.k = agVar.k;
        this.l = agVar.l;
        this.m = agVar.m;
        this.n = agVar.n;
        this.o = agVar.o;
        this.p = agVar.p;
        this.A = agVar.A;
        this.q = agVar.q;
        this.r = agVar.r;
        this.s = agVar.s;
        this.t = agVar.t;
        this.u = agVar.u;
        this.v = agVar.v;
    }

    private SSLSocketFactory c() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (this) {
            if (y == null) {
                try {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init(null, null, null);
                    y = instance.getSocketFactory();
                } catch (GeneralSecurityException e) {
                    throw new AssertionError();
                }
            }
            sSLSocketFactory = y;
        }
        return sSLSocketFactory;
    }

    final ag a() {
        ag agVar = new ag(this);
        if (agVar.h == null) {
            agVar.h = ProxySelector.getDefault();
        }
        if (agVar.i == null) {
            agVar.i = CookieHandler.getDefault();
        }
        if (agVar.k == null) {
            agVar.k = SocketFactory.getDefault();
        }
        if (agVar.l == null) {
            agVar.l = c();
        }
        if (agVar.m == null) {
            agVar.m = b.a;
        }
        if (agVar.n == null) {
            agVar.n = n.a;
        }
        if (agVar.o == null) {
            agVar.o = a.a;
        }
        if (agVar.p == null) {
            agVar.p = s.a();
        }
        if (agVar.d == null) {
            agVar.d = w;
        }
        if (agVar.e == null) {
            agVar.e = x;
        }
        if (agVar.A == null) {
            agVar.A = n.a;
        }
        return agVar;
    }

    public final ag a(c cVar) {
        this.z = cVar;
        this.j = null;
        return this;
    }

    public final l a(al alVar) {
        return new l(this, alVar);
    }

    public final void a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.t = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public final ag b() {
        return new ag(this);
    }

    public final void b(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.u = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public final void c(long j, TimeUnit timeUnit) {
        if (20000 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(20000);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || 20000 <= 0) {
                this.v = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public /* synthetic */ Object clone() {
        return b();
    }
}
