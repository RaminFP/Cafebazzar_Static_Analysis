package b.a.a.a.a.g;

import android.content.SharedPreferences.Editor;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.q;
import b.a.a.a.a.f.c;
import b.a.a.a.a.f.d;
import b.a.a.a.f;
import b.a.a.a.p;
import org.json.JSONObject;

final class j implements u {
    private final y a;
    private final x b;
    private final q c;
    private final g d;
    private final z e;
    private final p f;
    private final c g = new d(this.f);

    public j(p pVar, y yVar, q qVar, x xVar, g gVar, z zVar) {
        this.f = pVar;
        this.a = yVar;
        this.c = qVar;
        this.b = xVar;
        this.d = gVar;
        this.e = zVar;
    }

    private static void a(JSONObject jSONObject, String str) {
        f.a().a("Fabric", str + jSONObject.toString());
    }

    private v b(t tVar) {
        Throwable e;
        v a;
        try {
            if (!t.SKIP_CACHE_LOOKUP.equals(tVar)) {
                JSONObject a2 = this.d.a();
                if (a2 != null) {
                    a = this.b.a(this.c, a2);
                    a(a2, "Loaded cached settings: ");
                    long a3 = this.c.a();
                    if (!t.IGNORE_CACHE_EXPIRATION.equals(tVar)) {
                        if ((a.g < a3 ? 1 : null) != null) {
                            f.a().a("Fabric", "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        f.a().a("Fabric", "Returning cached settings.");
                        return a;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    f.a().a("Fabric", "No cached settings data found.");
                }
            }
            return null;
        } catch (Throwable e3) {
            e = e3;
            a = null;
            f.a().c("Fabric", "Failed to get cached settings", e);
            return a;
        }
    }

    private String b() {
        return l.a(l.k(this.f.p));
    }

    public final v a() {
        return a(t.USE_CACHE);
    }

    public final v a(t tVar) {
        v vVar;
        Throwable th;
        v vVar2 = null;
        try {
            if (!f.b()) {
                if ((!this.g.a().getString("existing_instance_identifier", "").equals(b()) ? 1 : null) == null) {
                    vVar2 = b(tVar);
                }
            }
            if (vVar2 == null) {
                try {
                    JSONObject a = this.e.a(this.a);
                    if (a != null) {
                        vVar2 = this.b.a(this.c, a);
                        this.d.a(vVar2.g, a);
                        a(a, "Loaded settings: ");
                        String b = b();
                        Editor b2 = this.g.b();
                        b2.putString("existing_instance_identifier", b);
                        this.g.a(b2);
                        vVar = vVar2;
                        if (vVar != null) {
                            try {
                            } catch (Throwable e) {
                                Throwable th2 = e;
                                vVar2 = vVar;
                                th = th2;
                                f.a().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th);
                                return vVar2;
                            }
                        }
                    }
                } catch (Exception e2) {
                    th = e2;
                    f.a().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th);
                    return vVar2;
                }
            }
            vVar = vVar2;
            return vVar != null ? vVar : b(t.IGNORE_CACHE_EXPIRATION);
        } catch (Exception e3) {
            th = e3;
            f.a().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th);
            return vVar2;
        }
    }
}
