package com.c.a.a.d;

import d.ac;
import d.ad;
import d.f;
import d.j;
import java.util.logging.Level;

final class k implements ac {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final j f;

    public k(j jVar) {
        this.f = jVar;
    }

    public final long a(f fVar, long j) {
        while (this.d == 0) {
            this.f.f((long) this.e);
            this.e = (short) 0;
            if ((this.b & 4) != 0) {
                return -1;
            }
            int i = this.c;
            int a = ((((this.f.g() & 255) << 16) | ((this.f.g() & 255) << 8)) | (this.f.g() & 255));
            this.d = a;
            this.a = a;
            byte g = this.f.g();
            this.b = this.f.g();
            if (j.a.isLoggable(Level.FINE)) {
                j.a.fine(l.a(true, this.c, this.a, g, this.b));
            }
            this.c = this.f.i() & Integer.MAX_VALUE;
            if (g != (byte) 9) {
                throw j.c("%s != TYPE_CONTINUATION", Byte.valueOf(g));
            } else if (this.c != i) {
                throw j.c("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
        long a2 = this.f.a(fVar, Math.min(j, (long) this.d));
        if (a2 == -1) {
            return -1;
        }
        this.d = (int) (((long) this.d) - a2);
        return a2;
    }

    public final void close() {
    }

    public final ad j_() {
        return this.f.j_();
    }
}
