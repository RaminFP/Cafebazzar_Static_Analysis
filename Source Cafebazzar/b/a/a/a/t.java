package b.a.a.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.a.a.a.a.b.j;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.r;
import b.a.a.a.a.e.b;
import b.a.a.a.a.e.m;
import b.a.a.a.a.g.aa;
import b.a.a.a.a.g.d;
import b.a.a.a.a.g.e;
import b.a.a.a.a.g.h;
import b.a.a.a.a.g.n;
import b.a.a.a.a.g.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

final class t extends p {
    private final m a = new b();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private final Future j;
    private final Collection k;

    public t(Future future, Collection collection) {
        this.j = future;
        this.k = collection;
    }

    private d a(n nVar, Collection collection) {
        return new d(new j().a(this.p), this.r.d, this.f, this.e, l.a(l.k(r0)), this.h, r.a(this.g).e, this.i, "0", nVar, collection);
    }

    private static Map a(Map map, Collection collection) {
        for (p pVar : collection) {
            if (!map.containsKey(pVar.b())) {
                map.put(pVar.b(), new r(pVar.b(), pVar.a(), "binary"));
            }
        }
        return map;
    }

    private Boolean c() {
        boolean z;
        String i = l.i(this.p);
        v f = f();
        if (f != null) {
            try {
                Map a = a(this.j != null ? (Map) this.j.get() : new HashMap(), this.k);
                e eVar = f.a;
                Collection values = a.values();
                z = true;
                if ("new".equals(eVar.b)) {
                    if (new h(this, g(), eVar.c, this.a).a(a(n.a(this.p, i), values))) {
                        z = b.a.a.a.a.g.r.a.c();
                    } else {
                        f.a().c("Fabric", "Failed to create app with Crashlytics service.", null);
                        z = false;
                    }
                } else if ("configured".equals(eVar.b)) {
                    z = b.a.a.a.a.g.r.a.c();
                } else if (eVar.e) {
                    f.a().a("Fabric", "Server says an update is required - forcing a full App update.");
                    new aa(this, g(), eVar.c, this.a).a(a(n.a(this.p, i), values));
                }
            } catch (Throwable e) {
                f.a().c("Fabric", "Error performing auto configuration.", e);
                z = false;
            }
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private v f() {
        try {
            b.a.a.a.a.g.r.a.a(this, this.r, this.a, this.e, this.f, g()).b();
            return b.a.a.a.a.g.r.a.a();
        } catch (Throwable e) {
            f.a().c("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    private String g() {
        return l.c(this.p, "com.crashlytics.ApiEndpoint");
    }

    public final String a() {
        return "1.3.10.97";
    }

    protected final boolean a_() {
        try {
            this.g = this.r.d();
            this.b = this.p.getPackageManager();
            this.c = this.p.getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.e = Integer.toString(this.d.versionCode);
            this.f = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.h = this.b.getApplicationLabel(this.p.getApplicationInfo()).toString();
            this.i = Integer.toString(this.p.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            f.a().c("Fabric", "Failed init", e);
            return false;
        }
    }

    public final String b() {
        return "io.fabric.sdk.android:fabric";
    }

    protected final /* synthetic */ Object e() {
        return c();
    }
}
