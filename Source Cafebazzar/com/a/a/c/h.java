package com.a.a.c;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.o;
import b.a.a.a.a.b.t;
import b.a.a.a.a.c.n;
import b.a.a.a.a.c.y;
import b.a.a.a.a.e.m;
import b.a.a.a.a.f.b;
import b.a.a.a.a.g.r;
import b.a.a.a.a.g.v;
import b.a.a.a.f;
import b.a.a.a.p;
import com.a.a.a.ai;
import com.a.a.a.al;
import com.a.a.a.am;
import com.a.a.a.e;
import com.a.a.c.a.a;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@n(a = {a.class})
public class h extends p {
    private m A;
    private v B;
    final ConcurrentHashMap a;
    y b;
    public ac c;
    public String d;
    public String e;
    public String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    public boolean l;
    a m;
    private final long s;
    private File t;
    private b.a.a.a.a.f.a u;
    private y v;
    private z w;
    private String x;
    private float y;
    private final bu z;

    public h() {
        this(1.0f, null, null, false);
    }

    private h(float f, z zVar, bu buVar, boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(t.a("Crashlytics Exception Handler"));
        t.a("Crashlytics Exception Handler", newSingleThreadExecutor);
        this(1.0f, null, null, false, newSingleThreadExecutor);
    }

    private h(float f, z zVar, bu buVar, boolean z, ExecutorService executorService) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.y = f;
        if (zVar == null) {
            zVar = new t();
        }
        this.w = zVar;
        this.z = buVar;
        this.l = z;
        this.B = new v(executorService);
        this.a = new ConcurrentHashMap();
        this.s = System.currentTimeMillis();
    }

    static void a(String str) {
        com.a.a.a.a aVar = (com.a.a.a.a) f.a(com.a.a.a.a.class);
        if (aVar != null) {
            o pVar = new b.a.a.a.a.b.p(str);
            if (aVar.a != null) {
                ai aiVar = aVar.a;
                String str2 = pVar.a;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new IllegalStateException("onCrash called from main thread!!!");
                }
                f.a().a("Answers", "Logged crash");
                e eVar = aiVar.b;
                Map singletonMap = Collections.singletonMap("sessionId", str2);
                al alVar = new al(am.CRASH);
                alVar.c = singletonMap;
                eVar.a(alVar, true, false);
            }
        }
    }

    private boolean a(Activity activity, b.a.a.a.a.g.o oVar) {
        ay ayVar = new ay(activity, oVar);
        u uVar = new u();
        activity.runOnUiThread(new o(this, activity, uVar, ayVar, oVar));
        f.a().a("CrashlyticsCore", "Waiting for user opt-in.");
        try {
            uVar.b.await();
        } catch (InterruptedException e) {
        }
        return uVar.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r11) {
        /*
        r10 = this;
        r8 = 1;
        r7 = 0;
        r0 = r10.l;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r0 = r7;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = new b.a.a.a.a.b.j;
        r0.<init>();
        r0 = r0.a(r11);
        r10.h = r0;
        r0 = r10.h;
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r7;
        goto L_0x0007;
    L_0x0019:
        r0 = b.a.a.a.f.a();
        r1 = "CrashlyticsCore";
        r2 = new java.lang.StringBuilder;
        r3 = "Initializing Crashlytics ";
        r2.<init>(r3);
        r3 = "2.3.8.97";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.c(r1, r2);
        r0 = new b.a.a.a.a.f.b;
        r0.<init>(r10);
        r10.u = r0;
        r0 = new com.a.a.c.y;
        r1 = "crash_marker";
        r2 = r10.u;
        r0.<init>(r1, r2);
        r10.b = r0;
        r0 = new com.a.a.c.y;
        r1 = "initialization_marker";
        r2 = r10.u;
        r0.<init>(r1, r2);
        r10.v = r0;
        r1 = r10.h;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r10.z;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        if (r0 == 0) goto L_0x0169;
    L_0x0056:
        r0 = new com.a.a.c.ab;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.z;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0.<init>(r2);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
    L_0x005d:
        r2 = new b.a.a.a.a.e.b;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r3 = b.a.a.a.f.a();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2.<init>(r3);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r10.A = r2;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.A;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2.a(r0);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r11.getPackageName();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r10.x = r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r10.r;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r0.d();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r10.i = r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = b.a.a.a.f.a();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = "CrashlyticsCore";
        r3 = new java.lang.StringBuilder;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r4 = "Installer package name is: ";
        r3.<init>(r4);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r4 = r10.i;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r3 = r3.append(r4);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r3 = r3.toString();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0.a(r2, r3);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r11.getPackageManager();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.x;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r3 = 0;
        r0 = r0.getPackageInfo(r2, r3);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r0.versionCode;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = java.lang.Integer.toString(r2);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r10.j = r2;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r0.versionName;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        if (r2 != 0) goto L_0x013f;
    L_0x00ac:
        r0 = "0.0";
    L_0x00ae:
        r10.k = r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = b.a.a.a.a.b.l.k(r11);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r10.g = r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = new com.a.a.c.a;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.g;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r3 = "com.crashlytics.RequireBuildId";
        r4 = 1;
        r3 = b.a.a.a.a.b.l.a(r11, r3, r4);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0.<init>(r2, r3);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.x;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0.a(r1, r2);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r4 = new com.a.a.c.bd;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r10.x;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r4.<init>(r11, r0);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r10.B;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r1 = new com.a.a.c.l;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r1.<init>(r10);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r0.a(r1);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r9 = r0.booleanValue();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r10.B;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r1 = new com.a.a.c.s;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = r10.b;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r1.<init>(r2);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r0.a(r1);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r1 = java.lang.Boolean.TRUE;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r1.equals(r0);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        if (r0 == 0) goto L_0x00f8;
    L_0x00f8:
        r0 = b.a.a.a.f.a();	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r1 = "CrashlyticsCore";
        r2 = "Installing exception handler...";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r0 = new com.a.a.c.ac;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r2 = r10.B;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r3 = r10.r;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r5 = r10.u;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r6 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r10.c = r0;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r0 = r10.c;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r1 = r0.f;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r2 = new com.a.a.c.ae;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r1.b(r2);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r0 = r10.c;	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r0 = b.a.a.a.f.a();	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
        r1 = "CrashlyticsCore";
        r2 = "Successfully installed exception handler.";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x0143, aa -> 0x0150 }
    L_0x0131:
        if (r9 == 0) goto L_0x0157;
    L_0x0133:
        r0 = b.a.a.a.a.b.l.l(r11);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        if (r0 == 0) goto L_0x0157;
    L_0x0139:
        r10.o();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r0 = r7;
        goto L_0x0007;
    L_0x013f:
        r0 = r0.versionName;	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        goto L_0x00ae;
    L_0x0143:
        r0 = move-exception;
        r1 = b.a.a.a.f.a();	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        r2 = "CrashlyticsCore";
        r3 = "There was a problem installing the exception handler.";
        r1.c(r2, r3, r0);	 Catch:{ aa -> 0x0150, Exception -> 0x015a }
        goto L_0x0131;
    L_0x0150:
        r0 = move-exception;
        r1 = new b.a.a.a.a.c.z;
        r1.<init>(r0);
        throw r1;
    L_0x0157:
        r0 = r8;
        goto L_0x0007;
    L_0x015a:
        r0 = move-exception;
        r1 = b.a.a.a.f.a();
        r2 = "CrashlyticsCore";
        r3 = "Crashlytics was not started due to an exception during initialization";
        r1.c(r2, r3, r0);
        r0 = r7;
        goto L_0x0007;
    L_0x0169:
        r0 = 0;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.h.a(android.content.Context):boolean");
    }

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }

    public static h f() {
        return (h) f.a(h.class);
    }

    static b.a.a.a.a.g.p l() {
        v a = r.a.a();
        return a == null ? null : a.b;
    }

    private void o() {
        Callable iVar = new i(this);
        for (y a : this.o.c()) {
            iVar.a(a);
        }
        Future submit = this.n.c.submit(iVar);
        f.a().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            f.a().c("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            f.a().c("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            f.a().c("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    private void p() {
        this.B.b(new k(this));
    }

    final at a(v vVar) {
        return vVar != null ? new au(this, l.c(this.p, "com.crashlytics.ApiEndpoint"), vVar.a.d, this.A) : null;
    }

    public final String a() {
        return "2.3.8.97";
    }

    public final void a(String str, String str2) {
        if (!this.l) {
            if (str == null) {
                Context context = this.p;
                if (context == null || !l.h(context)) {
                    f.a().c("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
                    return;
                }
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
            String b = b(str);
            if (this.a.size() < 64 || this.a.containsKey(b)) {
                this.a.put(b, str2 == null ? "" : b(str2));
                ac acVar = this.c;
                acVar.f.b(new an(acVar, this.a));
                return;
            }
            f.a().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
        }
    }

    protected final boolean a_() {
        return a(this.p);
    }

    public final String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    protected final Void c() {
        this.B.a(new j(this));
        ac acVar = this.c;
        acVar.f.a(new ag(acVar));
        try {
            v a = r.a.a();
            if (a == null) {
                f.a().d("CrashlyticsCore", "Received null settings, skipping initialization!");
            } else if (a.d.c) {
                acVar = this.c;
                ((Boolean) acVar.f.a(new af(acVar))).booleanValue();
                at a2 = a(a);
                if (a2 == null) {
                    f.a().d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    p();
                } else {
                    new by(a2).a(this.y);
                    p();
                }
            } else {
                f.a().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                p();
            }
        } catch (Throwable e) {
            f.a().c("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            p();
        }
        return null;
    }

    protected final /* synthetic */ Object e() {
        return c();
    }

    final String g() {
        return this.r.b ? this.d : null;
    }

    final String h() {
        return this.r.b ? this.e : null;
    }

    final String i() {
        return this.r.b ? this.f : null;
    }

    final File j() {
        if (this.t == null) {
            this.t = new b(this).a();
        }
        return this.t;
    }

    final boolean k() {
        return ((Boolean) r.a.a(new m(this), Boolean.valueOf(false))).booleanValue();
    }
}
