package com.c.a.a.a;

import com.c.a.a;
import com.c.a.a.v;
import com.c.a.ad;
import com.c.a.ae;
import com.c.a.al;
import com.c.a.ap;
import d.i;
import java.net.ProtocolException;

final class r implements ae {
    final /* synthetic */ o a;
    private final int b;
    private final al c;
    private int d;

    r(o oVar, int i, al alVar) {
        this.a = oVar;
        this.b = i;
        this.c = alVar;
    }

    public final ap a(al alVar) {
        ad adVar;
        this.d++;
        if (this.b > 0) {
            adVar = (ad) this.a.a.g.get(this.b - 1);
            a aVar = this.a.b.b.a;
            if (!alVar.a().getHost().equals(aVar.b) || v.a(alVar.a()) != aVar.c) {
                throw new IllegalStateException("network interceptor " + adVar + " must retain the same host and port");
            } else if (this.d > 1) {
                throw new IllegalStateException("network interceptor " + adVar + " must call proceed() exactly once");
            }
        }
        if (this.b < this.a.a.g.size()) {
            r rVar = new r(this.a, this.b + 1, alVar);
            adVar = (ad) this.a.a.g.get(this.b);
            ap a = adVar.a();
            if (rVar.d == 1) {
                return a;
            }
            throw new IllegalStateException("network interceptor " + adVar + " must call proceed() exactly once");
        }
        this.a.d.a(alVar);
        this.a.o = alVar;
        if (this.a.c() && alVar.d != null) {
            i a2 = d.r.a(this.a.d.a(alVar, alVar.d.b()));
            alVar.d.a(a2);
            a2.close();
        }
        ap c = this.a.m();
        int i = c.c;
        if ((i != 204 && i != 205) || c.g.a() <= 0) {
            return c;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + c.g.a());
    }
}
