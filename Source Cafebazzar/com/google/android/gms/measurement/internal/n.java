package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.a.bz;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class n extends ba {
    private long a;
    private String b;

    n(ap apVar) {
        super(apVar);
    }

    protected final void a() {
        Calendar instance = Calendar.getInstance();
        this.a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public final String b() {
        u();
        return Build.MODEL;
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

    public final String o() {
        u();
        return VERSION.RELEASE;
    }

    public final long p() {
        u();
        return this.a;
    }

    public final String q() {
        u();
        return this.b;
    }
}
