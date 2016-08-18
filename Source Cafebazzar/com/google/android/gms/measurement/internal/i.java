package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.android.gms.a.bz;
import com.google.android.gms.a.cf;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.g;

public final class i extends az {
    static final String a = String.valueOf(b.a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean b;

    i(ap apVar) {
        super(apVar);
    }

    public static long A() {
        return (long) (b.a / 1000);
    }

    public static boolean B() {
        return g.a;
    }

    public static long D() {
        return ((Long) s.p.a()).longValue();
    }

    public static long E() {
        return ((Long) s.l.a()).longValue();
    }

    public static long F() {
        return 20;
    }

    public static long G() {
        return Math.max(0, ((Long) s.e.a()).longValue());
    }

    public static int H() {
        return ((Integer) s.f.a()).intValue();
    }

    public static int I() {
        return Math.max(0, ((Integer) s.g.a()).intValue());
    }

    public static String J() {
        return (String) s.h.a();
    }

    public static long K() {
        return Math.max(0, ((Long) s.i.a()).longValue());
    }

    public static long L() {
        return Math.max(0, ((Long) s.k.a()).longValue());
    }

    public static long M() {
        return ((Long) s.j.a()).longValue();
    }

    public static long N() {
        return Math.max(0, ((Long) s.m.a()).longValue());
    }

    public static long O() {
        return Math.max(0, ((Long) s.n.a()).longValue());
    }

    public static int P() {
        return Math.min(20, Math.max(0, ((Integer) s.o.a()).intValue()));
    }

    static String a() {
        return (String) s.c.a();
    }

    public static int b() {
        return 24;
    }

    static int o() {
        return 36;
    }

    static int p() {
        return NotificationCompat.FLAG_LOCAL_ONLY;
    }

    static int q() {
        return 36;
    }

    static int r() {
        return ItemAnimator.FLAG_MOVED;
    }

    static int s() {
        return 20;
    }

    static long t() {
        return 3600000;
    }

    static long u() {
        return 60000;
    }

    static long v() {
        return 61000;
    }

    static long w() {
        return ((Long) s.d.a()).longValue();
    }

    static long x() {
        return ((Long) s.q.a()).longValue();
    }

    public static String y() {
        return "google_app_measurement.db";
    }

    public static String z() {
        return "google_app_measurement2.db";
    }

    public final boolean C() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = super.i().getApplicationInfo();
                    String a = cf.a(super.i(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.b = Boolean.valueOf(z);
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        super.l().a.a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
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
