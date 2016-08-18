package b.a.a.a.a.g;

import android.content.res.Resources.NotFoundException;
import b.a.a.a.a.b.ag;
import b.a.a.a.a.b.l;
import b.a.a.a.a.e.e;
import b.a.a.a.a.e.m;
import b.a.a.a.f;
import b.a.a.a.p;
import b.a.a.a.r;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

abstract class a extends b.a.a.a.a.b.a {
    public a(p pVar, String str, String str2, m mVar, int i) {
        super(pVar, str, str2, mVar, i);
    }

    private e a(e eVar, d dVar) {
        Throwable e;
        Closeable closeable = null;
        e a = eVar.a("app[identifier]", null, dVar.b).a("app[name]", null, dVar.f).a("app[display_version]", null, dVar.c).a("app[build_version]", null, dVar.d).a("app[source]", Integer.valueOf(dVar.g)).a("app[minimum_sdk_version]", null, dVar.h).a("app[built_sdk_version]", null, dVar.i);
        if (!l.c(dVar.e)) {
            a.a("app[instance_identifier]", null, dVar.e);
        }
        if (dVar.j != null) {
            Closeable openRawResource;
            try {
                openRawResource = this.b.p.getResources().openRawResource(dVar.j.b);
                try {
                    a.a("app[icon][hash]", null, dVar.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) openRawResource).a("app[icon][width]", Integer.valueOf(dVar.j.c)).a("app[icon][height]", Integer.valueOf(dVar.j.d));
                    l.a(openRawResource, "Failed to close app icon InputStream.");
                } catch (NotFoundException e2) {
                    e = e2;
                    try {
                        f.a().c("Fabric", "Failed to find app icon with resource ID: " + dVar.j.b, e);
                        l.a(openRawResource, "Failed to close app icon InputStream.");
                        if (dVar.k != null) {
                            for (r rVar : dVar.k) {
                                a.a(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{rVar.a}), null, rVar.b);
                                a.a(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{rVar.a}), null, rVar.c);
                            }
                        }
                        return a;
                    } catch (Throwable th) {
                        e = th;
                        closeable = openRawResource;
                        l.a(closeable, "Failed to close app icon InputStream.");
                        throw e;
                    }
                }
            } catch (NotFoundException e3) {
                e = e3;
                openRawResource = null;
                f.a().c("Fabric", "Failed to find app icon with resource ID: " + dVar.j.b, e);
                l.a(openRawResource, "Failed to close app icon InputStream.");
                if (dVar.k != null) {
                    for (r rVar2 : dVar.k) {
                        a.a(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{rVar2.a}), null, rVar2.b);
                        a.a(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{rVar2.a}), null, rVar2.c);
                    }
                }
                return a;
            } catch (Throwable th2) {
                e = th2;
                l.a(closeable, "Failed to close app icon InputStream.");
                throw e;
            }
        }
        if (dVar.k != null) {
            for (r rVar22 : dVar.k) {
                a.a(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{rVar22.a}), null, rVar22.b);
                a.a(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{rVar22.a}), null, rVar22.c);
            }
        }
        return a;
    }

    public boolean a(d dVar) {
        e a = a(a().a("X-CRASHLYTICS-API-KEY", dVar.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.b.a()), dVar);
        f.a().a("Fabric", "Sending app info to " + this.a);
        if (dVar.j != null) {
            f.a().a("Fabric", "App icon hash is " + dVar.j.a);
            f.a().a("Fabric", "App icon size is " + dVar.j.c + "x" + dVar.j.d);
        }
        int b = a.b();
        f.a().a("Fabric", ("POST".equals(a.a().getRequestMethod()) ? "Create" : "Update") + " app request ID: " + a.a("X-REQUEST-ID"));
        f.a().a("Fabric", "Result was " + b);
        return ag.a(b) == 0;
    }
}
