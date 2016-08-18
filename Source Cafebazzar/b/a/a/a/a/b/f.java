package b.a.a.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesUtil;

final class f implements i {
    private final Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    public final b a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b.a.a.a.f.a().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.a.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            ServiceConnection gVar = new g();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.a.bindService(intent, gVar, 1)) {
                    h hVar = new h(gVar.a());
                    b bVar = new b(hVar.a(), hVar.b());
                    this.a.unbindService(gVar);
                    return bVar;
                }
                b.a.a.a.f.a().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                b.a.a.a.f.a().b("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.a.unbindService(gVar);
                return null;
            } catch (Throwable e2) {
                b.a.a.a.f.a().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            b.a.a.a.f.a().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            b.a.a.a.f.a().a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
