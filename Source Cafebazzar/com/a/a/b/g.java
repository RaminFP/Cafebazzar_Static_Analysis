package com.a.a.b;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import b.a.a.a.a.b.a;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.a.e.m;
import b.a.a.a.f;
import b.a.a.a.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class g extends a {
    private final i c;

    public g(p pVar, String str, String str2, m mVar, i iVar) {
        super(pVar, str, str2, mVar, d.a);
        this.c = iVar;
    }

    public final h a(String str, String str2, f fVar) {
        e a;
        Throwable e;
        e a2;
        try {
            Map hashMap = new HashMap();
            hashMap.put("build_version", fVar.a);
            hashMap.put("display_version", fVar.b);
            hashMap.put("instance", fVar.c);
            hashMap.put("source", "3");
            a = a(hashMap);
            try {
                a2 = a.a("Accept", "application/json").a("User-Agent", "Crashlytics Android SDK/" + this.b.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.b.a()).a("X-CRASHLYTICS-API-KEY", str).a("X-CRASHLYTICS-BETA-TOKEN", "3:" + str2);
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a().c("Beta", "Error while checking for updates from " + this.a, e);
                    if (a != null) {
                        f.a().a("Fabric", "Checking for updates request ID: " + a.a("X-REQUEST-ID"));
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    a2 = a;
                    if (a2 != null) {
                        f.a().a("Fabric", "Checking for updates request ID: " + a2.a("X-REQUEST-ID"));
                    }
                    throw e;
                }
            }
            try {
                f.a().a("Beta", "Checking for updates from " + this.a);
                f.a().a("Beta", "Checking for updates query params are: " + hashMap);
                if ((Callback.DEFAULT_DRAG_ANIMATION_DURATION == a2.b() ? 1 : null) != null) {
                    f.a().a("Beta", "Checking for updates was successful");
                    JSONObject jSONObject = new JSONObject(a2.c());
                    h hVar = new h(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
                    if (a2 == null) {
                        return hVar;
                    }
                    f.a().a("Fabric", "Checking for updates request ID: " + a2.a("X-REQUEST-ID"));
                    return hVar;
                }
                f.a().e("Beta", "Checking for updates failed. Response code: " + a2.b());
                if (a2 != null) {
                    f.a().a("Fabric", "Checking for updates request ID: " + a2.a("X-REQUEST-ID"));
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                a = a2;
                f.a().c("Beta", "Error while checking for updates from " + this.a, e);
                if (a != null) {
                    f.a().a("Fabric", "Checking for updates request ID: " + a.a("X-REQUEST-ID"));
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                if (a2 != null) {
                    f.a().a("Fabric", "Checking for updates request ID: " + a2.a("X-REQUEST-ID"));
                }
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            f.a().c("Beta", "Error while checking for updates from " + this.a, e);
            if (a != null) {
                f.a().a("Fabric", "Checking for updates request ID: " + a.a("X-REQUEST-ID"));
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            a2 = null;
            if (a2 != null) {
                f.a().a("Fabric", "Checking for updates request ID: " + a2.a("X-REQUEST-ID"));
            }
            throw e;
        }
    }
}
