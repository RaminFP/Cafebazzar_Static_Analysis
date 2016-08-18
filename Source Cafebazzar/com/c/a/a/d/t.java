package com.c.a.a.d;

import d.ac;
import d.f;
import d.n;

final class t extends n {
    final /* synthetic */ s a;

    t(s sVar, ac acVar) {
        this.a = sVar;
        super(acVar);
    }

    public final long a(f fVar, long j) {
        if (this.a.a == 0) {
            return -1;
        }
        long a = super.a(fVar, Math.min(j, (long) this.a.a));
        if (a == -1) {
            return -1;
        }
        this.a.a = (int) (((long) this.a.a) - a);
        return a;
    }
}
