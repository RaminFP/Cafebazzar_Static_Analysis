package com.c.a.a.a;

import com.c.a.a.v;
import d.ab;
import d.ad;
import d.f;
import d.o;
import java.net.ProtocolException;

final class j implements ab {
    final /* synthetic */ f a;
    private final o b;
    private boolean c;
    private long d;

    private j(f fVar, long j) {
        this.a = fVar;
        this.b = new o(this.a.d.j_());
        this.d = j;
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        v.a(fVar.b, 0, j);
        if (j > this.d) {
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
        this.a.d.a_(fVar, j);
        this.d -= j;
    }

    public final void close() {
        if (!this.c) {
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            f.a(this.a, this.b);
            this.a.e = 3;
        }
    }

    public final void flush() {
        if (!this.c) {
            this.a.d.flush();
        }
    }

    public final ad j_() {
        return this.b;
    }
}
