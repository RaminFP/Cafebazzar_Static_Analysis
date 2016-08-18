package com.c.a;

import com.c.a.a.a.aa;
import com.c.a.a.a.o;
import com.c.a.a.a.x;
import java.io.IOException;
import java.net.ProtocolException;

public final class l {
    final ag a;
    volatile boolean b;
    al c;
    o d;
    private boolean e;

    l(ag agVar, al alVar) {
        this.a = agVar.a();
        this.c = alVar;
    }

    public final ap a() {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        try {
            this.a.b.a(this);
            ap a = new m(this, 0, this.c, false).a(this.c);
            if (a != null) {
                return a;
            }
            throw new IOException("Canceled");
        } finally {
            this.a.b.b(this);
        }
    }

    final ap a(al alVar, boolean z) {
        al a;
        o a2;
        an anVar = alVar.d;
        if (anVar != null) {
            am c = alVar.c();
            af a3 = anVar.a();
            if (a3 != null) {
                c.a("Content-Type", a3.toString());
            }
            long b = anVar.b();
            if (b != -1) {
                c.a("Content-Length", Long.toString(b));
                c.b("Transfer-Encoding");
            } else {
                c.a("Transfer-Encoding", "chunked");
                c.b("Content-Length");
            }
            a = c.a();
        } else {
            a = alVar;
        }
        this.d = new o(this.a, a, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.b) {
            try {
                this.d.a();
                this.d.i();
                ap f = this.d.f();
                a = this.d.j();
                if (a == null) {
                    if (!z) {
                        this.d.g();
                    }
                    return f;
                }
                int i2 = i + 1;
                if (i2 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (!this.d.b(a.a())) {
                    this.d.g();
                }
                this.d = new o(this.a, a, false, false, z, this.d.h(), null, null, f);
                i = i2;
            } catch (x e) {
                throw e.a();
            } catch (aa e2) {
                a2 = this.d.a(e2);
                if (a2 != null) {
                    this.d = a2;
                } else {
                    throw e2.b;
                }
            } catch (IOException e3) {
                a2 = this.d.a(e3, null);
                if (a2 != null) {
                    this.d = a2;
                } else {
                    throw e3;
                }
            }
        }
        this.d.g();
        throw new IOException("Canceled");
    }
}
