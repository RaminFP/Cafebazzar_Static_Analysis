package com.a.a.c;

import b.a.a.a.a.f.d;
import b.a.a.a.a.g.s;
import b.a.a.a.a.g.v;

final class m implements s {
    final /* synthetic */ h a;

    m(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ Object a(v vVar) {
        boolean z = false;
        if (!vVar.d.a) {
            return Boolean.valueOf(false);
        }
        if (!new d(this.a).a().getBoolean("always_send_reports_opt_in", false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
