package com.b.b;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;

public class ao implements ak {
    static final String a = ao.class.getSimpleName();
    private static ao l;
    Location b;
    boolean c = false;
    boolean d;
    int e = 0;
    private final long f = 1800000;
    private final long g = 0;
    private LocationManager h;
    private Criteria i;
    private ap j = new ap(this);
    private String k;

    private ao() {
        aj a = ai.a();
        this.i = (Criteria) a.a("LocationCriteria");
        a.a("LocationCriteria", (ak) this);
        ba.a(4, a, "initSettings, LocationCriteria = " + this.i);
        this.d = ((Boolean) a.a("ReportLocation")).booleanValue();
        a.a("ReportLocation", (ak) this);
        ba.a(4, a, "initSettings, ReportLocation = " + this.d);
    }

    public static ao a() {
        synchronized (ao.class) {
            try {
                if (l == null) {
                    l = new ao();
                }
                ao aoVar = l;
                return aoVar;
            } finally {
                Object obj = ao.class;
            }
        }
    }

    private void g() {
        if (this.d) {
            Context context = ah.a.b;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                e();
                String f = f();
                if (!TextUtils.isEmpty(f)) {
                    this.h.requestLocationUpdates(f, 1800000, 0.0f, this.j, Looper.getMainLooper());
                }
                this.b = a(f);
                this.c = true;
                ba.a(4, a, "LocationProvider started");
            }
        }
    }

    Location a(String str) {
        return !TextUtils.isEmpty(str) ? this.h.getLastKnownLocation(str) : null;
    }

    public final void a(String str, Object obj) {
        if (str.equals("LocationCriteria")) {
            this.i = (Criteria) obj;
            ba.a(4, a, "onSettingUpdate, LocationCriteria = " + this.i);
            if (this.c) {
                g();
            }
        } else if (str.equals("ReportLocation")) {
            this.d = ((Boolean) obj).booleanValue();
            ba.a(4, a, "onSettingUpdate, ReportLocation = " + this.d);
            if (!this.d) {
                e();
            } else if (!this.c && this.e > 0) {
                g();
            }
        } else {
            ba.a(6, a, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.h == null) {
                this.h = (LocationManager) ah.a.b.getSystemService("location");
            }
        }
    }

    public final void c() {
        synchronized (this) {
            ba.a(4, a, "Location provider subscribed");
            this.e++;
            if (!this.c) {
                g();
            }
        }
    }

    public final void d() {
        synchronized (this) {
            ba.a(4, a, "Location provider unsubscribed");
            if (this.e <= 0) {
                ba.a(6, a, "Error! Unsubscribed too many times!");
            } else {
                this.e--;
                if (this.e == 0) {
                    e();
                }
            }
        }
    }

    void e() {
        this.h.removeUpdates(this.j);
        this.c = false;
        ba.a(4, a, "LocationProvider stoped");
    }

    String f() {
        Criteria criteria = this.i;
        if (criteria == null) {
            criteria = new Criteria();
        }
        String bestProvider = TextUtils.isEmpty(this.k) ? this.h.getBestProvider(criteria, true) : this.k;
        ba.a(4, a, "provider = " + bestProvider);
        return bestProvider;
    }
}
