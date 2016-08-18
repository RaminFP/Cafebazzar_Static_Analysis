package com.c.a.a.a;

import com.c.a.a.v;
import com.c.a.aa;
import d.ac;
import d.f;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class i extends g {
    final /* synthetic */ f d;
    private long e = -1;
    private boolean f = true;
    private final o g;

    i(f fVar, o oVar) {
        this.d = fVar;
        super(fVar);
        this.g = oVar;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (!this.f) {
            return -1;
        } else {
            if (this.e == 0 || this.e == -1) {
                if (this.e != -1) {
                    this.d.c.p();
                }
                try {
                    this.e = this.d.c.m();
                    String trim = this.d.c.p().trim();
                    if (this.e < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + trim + "\"");
                    }
                    if (this.e == 0) {
                        this.f = false;
                        aa aaVar = new aa();
                        this.d.a(aaVar);
                        this.g.a(aaVar.a());
                        a(true);
                    }
                    if (!this.f) {
                        return -1;
                    }
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long a = this.d.c.a(fVar, Math.min(j, this.e));
            if (a == -1) {
                b();
                throw new IOException("unexpected end of stream");
            }
            this.e -= a;
            return a;
        }
    }

    public final void close() {
        if (!this.b) {
            if (this.f && !v.a((ac) this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.b = true;
        }
    }
}
