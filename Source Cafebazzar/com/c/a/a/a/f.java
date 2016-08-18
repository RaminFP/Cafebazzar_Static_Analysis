package com.c.a.a.a;

import com.c.a.a.k;
import com.c.a.aa;
import com.c.a.aq;
import com.c.a.r;
import com.c.a.s;
import com.c.a.z;
import d.ac;
import d.ad;
import d.i;
import d.j;
import d.o;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class f {
    final s a;
    final r b;
    final j c;
    final i d;
    int e = 0;
    int f = 0;
    private final Socket g;

    public f(s sVar, r rVar, Socket socket) {
        this.a = sVar;
        this.b = rVar;
        this.g = socket;
        this.c = d.r.a(d.r.b(socket));
        this.d = d.r.a(d.r.a(socket));
    }

    static /* synthetic */ void a(f fVar, o oVar) {
        ad adVar = oVar.a;
        ad adVar2 = ad.b;
        if (adVar2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        oVar.a = adVar2;
        adVar.o_();
        adVar.d();
    }

    public final ac a(long j) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new k(this, j);
    }

    public final void a() {
        this.d.flush();
    }

    public final void a(int i, int i2) {
        if (i != 0) {
            this.c.j_().a((long) i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.d.j_().a((long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void a(aa aaVar) {
        while (true) {
            String p = this.c.p();
            if (p.length() != 0) {
                k.b.a(aaVar, p);
            } else {
                return;
            }
        }
    }

    public final void a(z zVar, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.b(str).b("\r\n");
        int length = zVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            this.d.b(zVar.a(i)).b(": ").b(zVar.b(i)).b("\r\n");
        }
        this.d.b("\r\n");
        this.e = 1;
    }

    public final boolean b() {
        int soTimeout;
        try {
            soTimeout = this.g.getSoTimeout();
            this.g.setSoTimeout(1);
            if (this.c.e()) {
                this.g.setSoTimeout(soTimeout);
                return false;
            }
            this.g.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.g.setSoTimeout(soTimeout);
        }
    }

    public final aq c() {
        if (this.e == 1 || this.e == 3) {
            aq aqVar;
            af a;
            do {
                try {
                    a = af.a(this.c.p());
                    aqVar = new aq();
                    aqVar.b = a.a;
                    aqVar.c = a.b;
                    aqVar.d = a.c;
                    aa aaVar = new aa();
                    a(aaVar);
                    aaVar.a(u.d, a.a.toString());
                    aqVar.a(aaVar.a());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.b + " (recycle count=" + k.b.b(this.b) + ")");
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a.b == 100);
            this.e = 4;
            return aqVar;
        }
        throw new IllegalStateException("state: " + this.e);
    }
}
