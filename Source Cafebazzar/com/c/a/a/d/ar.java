package com.c.a.a.d;

import d.a;
import java.io.InterruptedIOException;

final class ar extends a {
    final /* synthetic */ ao a;

    ar(ao aoVar) {
        this.a = aoVar;
    }

    protected final void a() {
        this.a.b(a.CANCEL);
    }

    public final void b() {
        if (l_()) {
            throw new InterruptedIOException("timeout");
        }
    }
}
