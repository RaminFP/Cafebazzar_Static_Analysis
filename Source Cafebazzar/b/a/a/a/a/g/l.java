package b.a.a.a.a.g;

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

final class l extends a implements z {
    public l(p pVar, String str, String str2, m mVar) {
        this(pVar, str, str2, mVar, d.a);
    }

    private l(p pVar, String str, String str2, m mVar, int i) {
        super(pVar, str, str2, mVar, i);
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            f.a().a("Fabric", "Failed to parse settings JSON from " + this.a, e);
            f.a().a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private static void a(e eVar, String str, String str2) {
        if (str2 != null) {
            eVar.a(str, str2);
        }
    }

    public final JSONObject a(y yVar) {
        Throwable th;
        e eVar;
        JSONObject jSONObject = null;
        try {
            Map hashMap = new HashMap();
            hashMap.put("build_version", yVar.j);
            hashMap.put("display_version", yVar.i);
            hashMap.put("source", Integer.toString(yVar.k));
            if (yVar.l != null) {
                hashMap.put("icon_hash", yVar.l);
            }
            String str = yVar.h;
            if (!b.a.a.a.a.b.l.c(str)) {
                hashMap.put("instance", str);
            }
            e a = a(hashMap);
            try {
                a(a, "X-CRASHLYTICS-API-KEY", yVar.a);
                a(a, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
                a(a, "X-CRASHLYTICS-API-CLIENT-VERSION", this.b.a());
                a(a, "Accept", "application/json");
                a(a, "X-CRASHLYTICS-DEVICE-MODEL", yVar.b);
                a(a, "X-CRASHLYTICS-OS-BUILD-VERSION", yVar.c);
                a(a, "X-CRASHLYTICS-OS-DISPLAY-VERSION", yVar.d);
                a(a, "X-CRASHLYTICS-ADVERTISING-TOKEN", yVar.e);
                a(a, "X-CRASHLYTICS-INSTALLATION-ID", yVar.f);
                a(a, "X-CRASHLYTICS-ANDROID-ID", yVar.g);
                f.a().a("Fabric", "Requesting settings from " + this.a);
                f.a().a("Fabric", "Settings query params were: " + hashMap);
                int b = a.b();
                f.a().a("Fabric", "Settings result was: " + b);
                Object obj = (b == Callback.DEFAULT_DRAG_ANIMATION_DURATION || b == 201 || b == 202 || b == 203) ? 1 : null;
                if (obj != null) {
                    jSONObject = a(a.c());
                } else {
                    f.a().e("Fabric", "Failed to retrieve settings from " + this.a);
                }
                if (a != null) {
                    f.a().a("Fabric", "Settings request ID: " + a.a("X-REQUEST-ID"));
                }
                return jSONObject;
            } catch (Throwable th2) {
                e eVar2 = a;
                th = th2;
                eVar = eVar2;
                if (eVar != null) {
                    f.a().a("Fabric", "Settings request ID: " + eVar.a("X-REQUEST-ID"));
                }
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            eVar = null;
            if (eVar != null) {
                f.a().a("Fabric", "Settings request ID: " + eVar.a("X-REQUEST-ID"));
            }
            throw th;
        }
    }
}
