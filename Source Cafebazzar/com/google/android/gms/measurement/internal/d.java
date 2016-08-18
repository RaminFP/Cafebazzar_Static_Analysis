package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public final class d extends ba {
    private boolean a;
    private final AlarmManager b = ((AlarmManager) super.i().getSystemService("alarm"));

    protected d(ap apVar) {
        super(apVar);
    }

    private PendingIntent o() {
        Intent intent = new Intent(super.i(), AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(super.i(), 0, intent, 0);
    }

    protected final void a() {
        this.b.cancel(o());
    }

    public final void a(long j) {
        u();
        av.b(j > 0);
        av.a(AppMeasurementReceiver.a(super.i()), (Object) "Receiver not registered/enabled");
        av.a(AppMeasurementService.a(super.i()), (Object) "Service not registered/enabled");
        b();
        long b = super.h().b();
        this.a = true;
        this.b.setInexactRepeating(2, b + j, Math.max(i.M(), j), o());
    }

    public final void b() {
        u();
        this.a = false;
        this.b.cancel(o());
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
