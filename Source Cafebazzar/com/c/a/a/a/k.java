package com.c.a.a.a;

import com.c.a.a.v;
import d.ac;
import d.f;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class k extends g {
    final /* synthetic */ f d;
    private long e;

    public k(f fVar, long j) {
        this.d = fVar;
        super(fVar);
        this.e = j;
        if (this.e == 0) {
            a(true);
        }
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e == 0) {
            return -1;
        } else {
            long a = this.d.c.a(fVar, Math.min(this.e, j));
            if (a == -1) {
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= a;
            if (this.e == 0) {
                a(true);
            }
            return a;
        }
    }

    public final void close() {
        if (!this.b) {
            if (!(this.e == 0 || v.a((ac) this, 100, TimeUnit.MILLISECONDS))) {
                b();
            }
            this.b = true;
        }
    }
}
