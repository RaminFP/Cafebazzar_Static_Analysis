package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.List;

public final class bg extends ba {
    final bm a;
    u b;
    private Boolean c;
    private final l d;
    private final c e;
    private final List f = new ArrayList();
    private final l g;

    protected bg(ap apVar) {
        super(apVar);
        this.e = new c(apVar.d);
        this.a = new bm(this);
        this.d = new bh(this, apVar);
        this.g = new bi(this, apVar);
    }

    static /* synthetic */ void a(bg bgVar) {
        super.e();
        if (bgVar.b()) {
            super.l().g.a("Inactivity, disconnecting from AppMeasurementService");
            super.e();
            bgVar.u();
            try {
                b.a().a(super.i(), bgVar.a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            bgVar.b = null;
        }
    }

    static /* synthetic */ void a(bg bgVar, ComponentName componentName) {
        super.e();
        if (bgVar.b != null) {
            bgVar.b = null;
            super.l().g.a("Disconnected from device MeasurementService", componentName);
            super.e();
            bgVar.q();
        }
    }

    private void a(u uVar) {
        super.e();
        av.a((Object) uVar);
        this.b = uVar;
        p();
        super.e();
        super.l().g.a("Processing queued up service tasks", Integer.valueOf(this.f.size()));
        for (Runnable a : this.f) {
            super.k().a(a);
        }
        this.f.clear();
        this.g.b();
    }

    private void a(Runnable runnable) {
        super.e();
        if (b()) {
            runnable.run();
        } else if (((long) this.f.size()) >= i.F()) {
            super.l().a.a("Discarding data. Max runnable queue size reached");
        } else {
            this.f.add(runnable);
            this.g.a(60000);
            q();
        }
    }

    private void p() {
        super.e();
        this.e.a();
        this.d.a(i.x());
    }

    private void q() {
        int i = 0;
        super.e();
        u();
        if (!b()) {
            Intent intent;
            b a;
            if (this.c == null) {
                this.c = super.m().q();
                if (this.c == null) {
                    boolean z;
                    super.l().g.a("State of service unknown");
                    super.e();
                    u();
                    if (i.B()) {
                        z = true;
                    } else {
                        intent = new Intent("com.google.android.gms.measurement.START");
                        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.measurement.service.MeasurementBrokerService"));
                        a = b.a();
                        super.l().g.a("Checking service availability");
                        if (a.a(super.i(), intent, new bl(this), 0)) {
                            super.l().g.a("Service available");
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    this.c = Boolean.valueOf(z);
                    super.m().a(this.c.booleanValue());
                }
            }
            if (this.c.booleanValue()) {
                super.l().g.a("Using measurement service");
                bm bmVar = this.a;
                super.e();
                Context i2 = super.i();
                synchronized (bmVar) {
                    if (bmVar.a) {
                        super.l().g.a("Connection attempt already in progress");
                        return;
                    } else if (bmVar.b != null) {
                        super.l().g.a("Already awaiting connection attempt");
                        return;
                    } else {
                        bmVar.b = new y(i2, Looper.getMainLooper(), new i(i2).a(), bmVar, bmVar);
                        super.l().g.a("Connecting to remote service");
                        bmVar.a = true;
                        bmVar.b.j();
                        return;
                    }
                }
            }
            List queryIntentServices = super.i().getPackageManager().queryIntentServices(new Intent(super.i(), AppMeasurementService.class), 65536);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                i = 1;
            }
            if (i != 0) {
                super.l().g.a("Using local app measurement service");
                intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(super.i(), AppMeasurementService.class));
                bm bmVar2 = this.a;
                super.e();
                Context i3 = super.i();
                a = b.a();
                synchronized (bmVar2) {
                    if (bmVar2.a) {
                        super.l().g.a("Connection attempt already in progress");
                        return;
                    }
                    bmVar2.a = true;
                    a.a(i3, intent, bmVar2.c.a, 129);
                }
            } else if (super.n().C()) {
                super.l().g.a("Using direct local measurement implementation");
                a(new as(this.h, true));
            } else {
                super.l().a.a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    protected final void a() {
    }

    protected final void a(UserAttributeParcel userAttributeParcel) {
        super.e();
        u();
        a(new bj(this, userAttributeParcel));
    }

    public final boolean b() {
        super.e();
        u();
        return this.b != null;
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

    protected final void o() {
        super.e();
        u();
        a(new bk(this));
    }
}
