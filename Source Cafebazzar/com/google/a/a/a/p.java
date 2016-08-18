package com.google.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class p extends bg {
    private static p b;
    private static String c;
    boolean a;
    private final ap d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;
    private long i;
    private Context j;
    private final Map k;
    private aw l;
    private bc m;
    private l n;
    private Timer o;
    private TimerTask p;
    private boolean q;

    private p(Context context) {
        this(context, new ax(context), ap.a(context), x.a(), null);
    }

    private p(Context context, aw awVar, ap apVar, bc bcVar, bh bhVar) {
        super("easy_tracker", null, apVar);
        this.f = false;
        this.g = 0;
        this.k = new HashMap();
        this.a = false;
        this.q = false;
        if (c != null) {
            awVar.d(c);
        }
        this.d = apVar;
        if (context == null) {
            as.a("Context cannot be null");
        }
        this.j = context.getApplicationContext();
        this.m = bcVar;
        this.l = awVar;
        as.c("Starting EasyTracker.");
        String a = this.l.a("ga_trackingId");
        if (TextUtils.isEmpty(a)) {
            a = this.l.a("ga_api_key");
        }
        a("&tid", a);
        as.c("[EasyTracker] trackingId loaded: " + a);
        a = this.l.a("ga_appName");
        if (!TextUtils.isEmpty(a)) {
            as.c("[EasyTracker] app name loaded: " + a);
            a("&an", a);
        }
        a = this.l.a("ga_appVersion");
        if (a != null) {
            as.c("[EasyTracker] app version loaded: " + a);
            a("&av", a);
        }
        a = this.l.a("ga_logLevel");
        if (a != null) {
            au a2 = a(a);
            if (a2 != null) {
                as.c("[EasyTracker] log level loaded: " + a2);
                this.d.c.a(a2);
            }
        }
        Double b = this.l.b("ga_sampleFrequency");
        if (b == null) {
            b = new Double((double) this.l.a("ga_sampleRate", 100));
        }
        if (b.doubleValue() != 100.0d) {
            a("&sf", Double.toString(b.doubleValue()));
        }
        as.c("[EasyTracker] sample rate loaded: " + b);
        int a3 = this.l.a("ga_dispatchPeriod", 1800);
        as.c("[EasyTracker] dispatch period loaded: " + a3);
        this.m.a(a3);
        this.h = (long) (this.l.a("ga_sessionTimeout", 30) * 1000);
        as.c("[EasyTracker] session timeout loaded: " + this.h);
        boolean z = this.l.c("ga_autoActivityTracking") || this.l.c("ga_auto_activity_tracking");
        this.f = z;
        as.c("[EasyTracker] auto activity tracking loaded: " + this.f);
        z = this.l.c("ga_anonymizeIp");
        if (z) {
            a("&aip", "1");
            as.c("[EasyTracker] anonymize ip loaded: " + z);
        }
        this.e = this.l.c("ga_reportUncaughtExceptions");
        if (this.e) {
            Thread.setDefaultUncaughtExceptionHandler(new t(this, this.m, Thread.getDefaultUncaughtExceptionHandler(), this.j));
            as.c("[EasyTracker] report uncaught exceptions loaded: " + this.e);
        }
        z = this.l.c("ga_dryRun");
        ap apVar2 = this.d;
        an.a().a(ao.SET_DRY_RUN);
        apVar2.a = z;
        this.n = new q(this);
    }

    private static au a(String str) {
        try {
            return au.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static p a(Context context) {
        if (b == null) {
            b = new p(context);
        }
        return b;
    }

    private void b() {
        synchronized (this) {
            if (this.o != null) {
                this.o.cancel();
                this.o = null;
            }
        }
    }

    public final void a() {
        an.a().a(ao.EASY_TRACKER_ACTIVITY_STOP);
        this.g--;
        this.g = Math.max(0, this.g);
        this.i = this.n.a();
        if (this.g == 0) {
            b();
            this.p = new r();
            this.o = new Timer("waitForActivityStart");
            this.o.schedule(this.p, 1000);
        }
    }

    public final void a(Activity activity) {
        an.a().a(ao.EASY_TRACKER_ACTIVITY_START);
        b();
        if (!this.a && this.g == 0) {
            boolean z = this.h == 0 || (this.h > 0 && this.n.a() > this.i + this.h);
            if (z) {
                this.q = true;
            }
        }
        this.a = true;
        this.g++;
        if (this.f) {
            String str;
            Map hashMap = new HashMap();
            hashMap.put("&t", "appview");
            an.a().a(true);
            String canonicalName = activity.getClass().getCanonicalName();
            if (this.k.containsKey(canonicalName)) {
                str = (String) this.k.get(canonicalName);
            } else {
                str = this.l.a(canonicalName);
                if (str == null) {
                    str = canonicalName;
                }
                this.k.put(canonicalName, str);
            }
            a("&cd", str);
            a(hashMap);
            an.a().a(false);
        }
    }

    public final void a(Map map) {
        if (this.q) {
            map.put("&sc", "start");
            this.q = false;
        }
        super.a(map);
    }
}
