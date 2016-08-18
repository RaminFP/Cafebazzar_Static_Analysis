package com.c.a.a.a;

import com.c.a.a.k;
import com.c.a.a.v;
import d.ac;
import d.ad;
import d.o;

abstract class g implements ac {
    protected final o a;
    protected boolean b;
    final /* synthetic */ f c;

    private g(f fVar) {
        this.c = fVar;
        this.a = new o(this.c.c.j_());
    }

    protected final void a(boolean z) {
        if (this.c.e != 5) {
            throw new IllegalStateException("state: " + this.c.e);
        }
        f.a(this.c, this.a);
        this.c.e = 0;
        if (z && this.c.f == 1) {
            this.c.f = 0;
            k.b.a(this.c.a, this.c.b);
        } else if (this.c.f == 2) {
            this.c.e = 6;
            this.c.b.c.close();
        }
    }

    protected final void b() {
        v.a(this.c.b.c);
        this.c.e = 6;
    }

    public final ad j_() {
        return this.a;
    }
}
