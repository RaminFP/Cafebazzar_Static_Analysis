package com.c.a.a.a;

import d.f;

final class l extends g {
    final /* synthetic */ f d;
    private boolean e;

    private l(f fVar) {
        this.d = fVar;
        super(fVar);
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e) {
            return -1;
        } else {
            long a = this.d.c.a(fVar, j);
            if (a != -1) {
                return a;
            }
            this.e = true;
            a(false);
            return -1;
        }
    }

    public final void close() {
        if (!this.b) {
            if (!this.e) {
                b();
            }
            this.b = true;
        }
    }
}
