package com.c.a.a.a;

import d.ab;
import d.ad;
import d.f;
import d.o;

final class h implements ab {
    final /* synthetic */ f a;
    private final o b;
    private boolean c;

    private h(f fVar) {
        this.a = fVar;
        this.b = new o(this.a.d.j_());
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j != 0) {
            this.a.d.i(j);
            this.a.d.b("\r\n");
            this.a.d.a_(fVar, j);
            this.a.d.b("\r\n");
        }
    }

    public final void close() {
        synchronized (this) {
            if (!this.c) {
                this.c = true;
                this.a.d.b("0\r\n\r\n");
                f.a(this.a, this.b);
                this.a.e = 3;
            }
        }
    }

    public final void flush() {
        synchronized (this) {
            if (!this.c) {
                this.a.d.flush();
            }
        }
    }

    public final ad j_() {
        return this.b;
    }
}
