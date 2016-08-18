package com.a.a.a;

import android.annotation.SuppressLint;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.t;
import b.a.a.a.a.e.m;
import b.a.a.a.a.f.d;
import b.a.a.a.a.g.b;
import b.a.a.a.a.g.r;
import b.a.a.a.a.g.v;
import b.a.a.a.f;
import b.a.a.a.p;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class a extends p {
    public ai a;

    public static a c() {
        return (a) f.a(a.class);
    }

    private Boolean f() {
        try {
            v a = r.a.a();
            if (a == null) {
                f.a().e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (a.d.d) {
                f.a().a("Answers", "Analytics collection enabled");
                r1 = this.a;
                b bVar = a.e;
                String c = l.c(this.p, "com.crashlytics.ApiEndpoint");
                r1.d.c = bVar.h;
                e eVar = r1.b;
                eVar.a(new f(eVar, bVar, c));
                return Boolean.valueOf(true);
            } else {
                f.a().a("Answers", "Analytics collection disabled");
                r1 = this.a;
                b.a.a.a.a aVar = r1.c;
                if (aVar.a != null) {
                    b.a.a.a.b bVar2 = aVar.a;
                    for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : bVar2.a) {
                        bVar2.b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
                    }
                }
                e eVar2 = r1.b;
                eVar2.a(new g(eVar2));
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            f.a().c("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public final String a() {
        return "1.3.6.97";
    }

    public final void a(aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(aaVar);
        }
    }

    public final void a(ac acVar) {
        if (acVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(acVar);
        }
    }

    public final void a(ar arVar) {
        if (arVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(arVar);
        }
    }

    public final void a(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(sVar);
        }
    }

    public final void a(y yVar) {
        if (yVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(yVar);
        }
    }

    @SuppressLint({"NewApi"})
    protected final boolean a_() {
        try {
            Object obj;
            n nVar;
            Context context = this.p;
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            long lastModified = VERSION.SDK_INT >= 9 ? packageInfo.firstInstallTime : new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            ap apVar = new ap(context, this.r, num, str);
            l lVar = new l(context, new b.a.a.a.a.f.b(this));
            m bVar = new b.a.a.a.a.e.b(f.a());
            b.a.a.a.a aVar = new b.a.a.a.a(context);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(t.a("Answers Events Handler"));
            t.a("Answers Events Handler", newSingleThreadScheduledExecutor);
            this.a = new ai(new e(this, context, lVar, apVar, bVar, newSingleThreadScheduledExecutor), aVar, new p(newSingleThreadScheduledExecutor), new n(new d(context, "settings")), lastModified);
            ai aiVar = this.a;
            e eVar = aiVar.b;
            eVar.a(new i(eVar));
            aiVar.c.a(new m(aiVar, aiVar.d));
            aiVar.d.b.add(aiVar);
            long j = aiVar.a;
            if (!aiVar.e.a.a().getBoolean("analytics_launched", false)) {
                if ((System.currentTimeMillis() - j < 3600000 ? 1 : null) != null) {
                    obj = 1;
                    if (obj != null) {
                        f.a().a("Answers", "Logged install");
                        aiVar.b.a(new al(am.INSTALL), false, true);
                        nVar = aiVar.e;
                        nVar.a.a(nVar.a.b().putBoolean("analytics_launched", true));
                    }
                    return true;
                }
            }
            obj = null;
            if (obj != null) {
                f.a().a("Answers", "Logged install");
                aiVar.b.a(new al(am.INSTALL), false, true);
                nVar = aiVar.e;
                nVar.a.a(nVar.a.b().putBoolean("analytics_launched", true));
            }
            return true;
        } catch (Throwable e) {
            f.a().c("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    public final String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    protected final /* synthetic */ Object e() {
        return f();
    }
}
