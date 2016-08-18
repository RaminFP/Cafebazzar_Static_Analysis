package com.c.a;

import d.ab;
import d.m;

final class f extends m {
    final /* synthetic */ c a;
    final /* synthetic */ com.c.a.a.f b;
    final /* synthetic */ e c;

    f(e eVar, ab abVar, c cVar, com.c.a.a.f fVar) {
        this.c = eVar;
        this.a = cVar;
        this.b = fVar;
        super(abVar);
    }

    public final void close() {
        synchronized (this.c.b) {
            if (this.c.a) {
                return;
            }
            this.c.a = true;
            c cVar = this.c.b;
            cVar.b++;
            super.close();
            this.b.a();
        }
    }
}
