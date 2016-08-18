package com.c.a.a.a;

import com.c.a.a.v;
import d.ac;
import d.ad;
import d.f;
import d.i;
import d.j;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

final class q implements ac {
    boolean a;
    final /* synthetic */ j b;
    final /* synthetic */ b c;
    final /* synthetic */ i d;
    final /* synthetic */ o e;

    q(o oVar, j jVar, b bVar, i iVar) {
        this.e = oVar;
        this.b = jVar;
        this.c = bVar;
        this.d = iVar;
    }

    public final long a(f fVar, long j) {
        try {
            long a = this.b.a(fVar, j);
            if (a == -1) {
                if (!this.a) {
                    this.a = true;
                    this.d.close();
                }
                return -1;
            }
            fVar.a(this.d.b(), fVar.b - a, a);
            this.d.s();
            return a;
        } catch (IOException e) {
            if (!this.a) {
                this.a = true;
                this.c.a();
            }
            throw e;
        }
    }

    public final void close() {
        if (!(this.a || v.a((ac) this, 100, TimeUnit.MILLISECONDS))) {
            this.a = true;
            this.c.a();
        }
        this.b.close();
    }

    public final ad j_() {
        return this.b.j_();
    }
}
