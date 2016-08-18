package com.c.a.a;

import d.ab;

final class d extends j {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    final /* synthetic */ b b;

    d(b bVar, ab abVar) {
        this.b = bVar;
        super(abVar);
    }

    protected final void a() {
        if (a || Thread.holdsLock(this.b)) {
            this.b.o = true;
            return;
        }
        throw new AssertionError();
    }
}
