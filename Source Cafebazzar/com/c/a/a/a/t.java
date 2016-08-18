package com.c.a.a.a;

import com.c.a.a.k;
import com.c.a.ak;
import com.c.a.al;
import com.c.a.ap;
import com.c.a.aq;
import com.c.a.ar;
import d.ab;
import d.ac;
import d.r;
import java.net.Proxy.Type;

public final class t implements ag {
    private final o a;
    private final f b;

    public t(o oVar, f fVar) {
        this.a = oVar;
        this.b = fVar;
    }

    public final ar a(ap apVar) {
        ac a;
        if (!o.a(apVar)) {
            a = this.b.a(0);
        } else if ("chunked".equalsIgnoreCase(apVar.a("Transfer-Encoding"))) {
            r1 = this.b;
            o oVar = this.a;
            if (r1.e != 4) {
                throw new IllegalStateException("state: " + r1.e);
            }
            r1.e = 5;
            a = new i(r1, oVar);
        } else {
            long a2 = u.a(apVar);
            if (a2 != -1) {
                a = this.b.a(a2);
            } else {
                r1 = this.b;
                if (r1.e != 4) {
                    throw new IllegalStateException("state: " + r1.e);
                }
                r1.e = 5;
                a = new l(r1);
            }
        }
        return new w(apVar.f, r.a(a));
    }

    public final ab a(al alVar, long j) {
        f fVar;
        if ("chunked".equalsIgnoreCase(alVar.a("Transfer-Encoding"))) {
            fVar = this.b;
            if (fVar.e != 1) {
                throw new IllegalStateException("state: " + fVar.e);
            }
            fVar.e = 2;
            return new h(fVar);
        } else if (j != -1) {
            fVar = this.b;
            if (fVar.e != 1) {
                throw new IllegalStateException("state: " + fVar.e);
            }
            fVar.e = 2;
            return new j(fVar, j);
        } else {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final void a() {
        this.b.a();
    }

    public final void a(o oVar) {
        k.b.a(this.b.b, (Object) oVar);
    }

    public final void a(z zVar) {
        f fVar = this.b;
        if (fVar.e != 1) {
            throw new IllegalStateException("state: " + fVar.e);
        }
        fVar.e = 3;
        zVar.a(fVar.d);
    }

    public final void a(al alVar) {
        this.a.b();
        Type type = this.a.b.b.b.type();
        ak akVar = this.a.b.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(alVar.b);
        stringBuilder.append(' ');
        Object obj = (alVar.e() || type != Type.HTTP) ? null : 1;
        if (obj != null) {
            stringBuilder.append(alVar.a());
        } else {
            stringBuilder.append(y.a(alVar.a()));
        }
        stringBuilder.append(' ');
        stringBuilder.append(y.a(akVar));
        this.b.a(alVar.c, stringBuilder.toString());
    }

    public final aq b() {
        return this.b.c();
    }

    public final void c() {
        f fVar;
        if (d()) {
            fVar = this.b;
            fVar.f = 1;
            if (fVar.e == 0) {
                fVar.f = 0;
                k.b.a(fVar.a, fVar.b);
                return;
            }
            return;
        }
        fVar = this.b;
        fVar.f = 2;
        if (fVar.e == 0) {
            fVar.e = 6;
            fVar.b.c.close();
        }
    }

    public final boolean d() {
        if ("close".equalsIgnoreCase(this.a.g.a("Connection")) || "close".equalsIgnoreCase(this.a.f().a("Connection"))) {
            return false;
        }
        return !(this.b.e == 6);
    }
}
