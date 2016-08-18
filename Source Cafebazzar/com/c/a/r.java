package com.c.a;

import com.c.a.a.a.f;
import com.c.a.a.d.ac;
import java.net.Socket;

public final class r {
    final s a;
    public final as b;
    public Socket c;
    boolean d = false;
    f e;
    ac f;
    public ak g = ak.HTTP_1_1;
    long h;
    public y i;
    int j;
    Object k;

    public r(s sVar, as asVar) {
        this.a = sVar;
        this.b = asVar;
    }

    final void a(Object obj) {
        if (!e()) {
            synchronized (this.a) {
                if (this.k != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.k = obj;
            }
        }
    }

    final boolean a() {
        synchronized (this.a) {
            if (this.k == null) {
                return false;
            }
            this.k = null;
            return true;
        }
    }

    final boolean b() {
        return (this.c.isClosed() || this.c.isInputShutdown() || this.c.isOutputShutdown()) ? false : true;
    }

    final boolean c() {
        return this.f == null || this.f.a();
    }

    final long d() {
        return this.f == null ? this.h : this.f.b();
    }

    final boolean e() {
        return this.f != null;
    }

    public final String toString() {
        return "Connection{" + this.b.a.b + ":" + this.b.a.c + ", proxy=" + this.b.b + " hostAddress=" + this.b.c.getAddress().getHostAddress() + " cipherSuite=" + (this.i != null ? this.i.a : "none") + " protocol=" + this.g + '}';
    }
}
