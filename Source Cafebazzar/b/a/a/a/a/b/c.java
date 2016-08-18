package b.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import b.a.a.a.a.f.d;
import b.a.a.a.f;

final class c {
    private final Context a;
    private final b.a.a.a.a.f.c b;

    public c(Context context) {
        this.a = context.getApplicationContext();
        this.b = new d(context, "TwitterAdvertisingInfoPreferences");
    }

    private static boolean b(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.a)) ? false : true;
    }

    public final b a() {
        b bVar = new b(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
        if (b(bVar)) {
            f.a().a("Fabric", "Using AdvertisingInfo from Preference Store");
            new Thread(new d(this, bVar)).start();
            return bVar;
        }
        bVar = b();
        a(bVar);
        return bVar;
    }

    @SuppressLint({"CommitPrefEdits"})
    void a(b bVar) {
        if (b(bVar)) {
            this.b.a(this.b.b().putString("advertising_id", bVar.a).putBoolean("limit_ad_tracking_enabled", bVar.b));
        } else {
            this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    b b() {
        b a = new e(this.a).a();
        if (b(a)) {
            f.a().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = new f(this.a).a();
            if (b(a)) {
                f.a().a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                f.a().a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
