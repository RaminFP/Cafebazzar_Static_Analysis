package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.internal.av;

public final class bc extends ba {
    bf a;

    protected bc(ap apVar) {
        super(apVar);
    }

    static /* synthetic */ void a(bc bcVar, String str, String str2, Object obj, long j) {
        av.a(str);
        av.a(str2);
        super.e();
        super.c();
        bcVar.u();
        if (!super.m().r()) {
            super.l().e.a("User attribute not set since app measurement is disabled");
        } else if (bcVar.h.b()) {
            super.l().f.a("Setting user attribute (FE)", str2, obj);
            super.g().a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    protected final void a() {
    }

    public final void a(String str, String str2, Object obj) {
        av.a(str);
        long a = super.h().a();
        super.j().a(str2);
        if (obj != null) {
            super.j().a(str2, obj);
            Object b = super.j().b(str2, obj);
            if (b != null) {
                super.k().a(new bd(this, str, str2, b, a));
                return;
            }
            return;
        }
        super.k().a(new be(this, str, str2, a));
    }

    public final void b() {
        super.e();
        super.c();
        u();
        if (this.h.b()) {
            super.g().o();
        }
    }

    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    public final /* bridge */ /* synthetic */ x f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ bg g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ bz h() {
        return super.h();
    }

    public final /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ g j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ al k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ z l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ ai m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ i n() {
        return super.n();
    }
}
