package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.internal.av;

class az {
    protected final ap h;

    az(ap apVar) {
        av.a((Object) apVar);
        this.h = apVar;
    }

    public void c() {
        ap apVar = this.h;
        if (i.B()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public void d() {
        this.h.f().d();
    }

    public void e() {
        this.h.f().e();
    }

    public x f() {
        return this.h.j();
    }

    public bg g() {
        ap apVar = this.h;
        ap.a(apVar.e);
        return apVar.e;
    }

    public bz h() {
        return this.h.d;
    }

    public Context i() {
        return this.h.a;
    }

    public g j() {
        return this.h.g();
    }

    public al k() {
        return this.h.f();
    }

    public z l() {
        return this.h.e();
    }

    public ai m() {
        return this.h.d();
    }

    public i n() {
        return this.h.b;
    }
}
