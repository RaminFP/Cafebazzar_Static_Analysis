package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.av;
import java.io.IOException;

public class AdvertisingIdClient {
    private static boolean zzoN = false;
    private final Context mContext;
    h zzoH;
    d zzoI;
    boolean zzoJ;
    Object zzoK;
    a zzoL;
    final long zzoM;

    public final class Info {
        private final String zzoS;
        private final boolean zzoT;

        public Info(String str, boolean z) {
            this.zzoS = str;
            this.zzoT = z;
        }

        public final String getId() {
            return this.zzoS;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzoT;
        }

        public final String toString() {
            return "{" + this.zzoS + "}" + this.zzoT;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzoK = new Object();
        av.a((Object) context);
        this.mContext = context;
        this.zzoJ = false;
        this.zzoM = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
        zzoN = z;
    }

    static d zza(Context context, h hVar) {
        try {
            return e.a(hVar.a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaL() {
        synchronized (this.zzoK) {
            if (this.zzoL != null) {
                this.zzoL.a.countDown();
                try {
                    this.zzoL.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzoM > 0) {
                this.zzoL = new a(this, this.zzoM);
            }
        }
    }

    static h zzp(Context context) {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            if (zzoN) {
                Log.d("Ads", "Skipping gmscore version check");
                b.a();
                switch (b.a(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                GooglePlayServicesUtil.zzac(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            Object hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (com.google.android.gms.common.stats.b.a().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new c(9);
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.av.c(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzoH;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzoJ;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.b.a();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzoH;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzoJ = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoI = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoH = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        av.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzoJ) {
                synchronized (this.zzoK) {
                    if (this.zzoL == null || !this.zzoL.b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoJ) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            av.a(this.zzoH);
            av.a(this.zzoI);
            info = new Info(this.zzoI.a(), this.zzoI.a(true));
        }
        zzaL();
        return info;
    }

    public void start() {
        zzb(true);
    }

    protected void zzb(boolean z) {
        av.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoJ) {
                finish();
            }
            this.zzoH = zzp(this.mContext);
            this.zzoI = zza(this.mContext, this.zzoH);
            this.zzoJ = true;
            if (z) {
                zzaL();
            }
        }
    }
}
