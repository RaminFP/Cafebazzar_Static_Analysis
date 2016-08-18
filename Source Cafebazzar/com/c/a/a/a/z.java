package com.c.a.a.a;

import com.c.a.a.v;
import d.ab;
import d.ad;
import d.f;
import java.net.ProtocolException;

public final class z implements ab {
    final f a;
    private boolean b;
    private final int c;

    public z() {
        this(-1);
    }

    public z(int i) {
        this.a = new f();
        this.c = i;
    }

    public final void a(ab abVar) {
        f fVar = new f();
        this.a.a(fVar, 0, this.a.b);
        abVar.a_(fVar, fVar.b);
    }

    public final void a_(f fVar, long j) {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        v.a(fVar.b, 0, j);
        if (this.c == -1 || this.a.b <= ((long) this.c) - j) {
            this.a.a_(fVar, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.c + " bytes");
    }

    public final void close() {
        if (!this.b) {
            this.b = true;
            if (this.a.b < ((long) this.c)) {
                throw new ProtocolException("content-length promised " + this.c + " bytes, but received " + this.a.b);
            }
        }
    }

    public final void flush() {
    }

    public final ad j_() {
        return ad.b;
    }
}
