package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.util.ad;

final class ab implements ad {
    final /* synthetic */ u a;

    ab(u uVar) {
        this.a = uVar;
    }

    public final void a() {
        this.a.m = null;
        if (this.a.l.size() > 0) {
            this.a.m = (al) this.a.l.poll();
            this.a.a(this.a.m.a, this.a.m.b);
        }
    }

    public final void b() {
        this.a.m = null;
        if (this.a.l.size() > 0) {
            this.a.m = (al) this.a.l.poll();
            this.a.a(this.a.m.a, this.a.m.b);
        }
    }
}
