package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

final class ai extends ba {
    static final Pair a = new Pair("", Long.valueOf(0));
    public final ak b = new ak(this, "health_monitor", i.G());
    public final aj c = new aj(this, "last_upload", 0);
    public final aj d = new aj(this, "last_upload_attempt", 0);
    public final aj e = new aj(this, "backoff", 0);
    public final aj f = new aj(this, "last_delete_stale", 0);
    private SharedPreferences g;
    private String j;
    private boolean k;
    private long l;
    private final SecureRandom m = new SecureRandom();

    ai(ap apVar) {
        super(apVar);
    }

    private static MessageDigest a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    static String p() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private SharedPreferences s() {
        e();
        u();
        return this.g;
    }

    protected final void a() {
        this.g = i().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    final void a(boolean z) {
        e();
        l().g.a("Setting useService", Boolean.valueOf(z));
        Editor edit = s().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    final Pair b() {
        e();
        long b = h().b();
        if (this.j != null && b < this.l) {
            return new Pair(this.j, Boolean.valueOf(this.k));
        }
        this.l = b + i.w();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(i());
            this.j = advertisingIdInfo.getId();
            this.k = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            l().f.a("Unable to get advertising id", th);
            this.j = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.j, Boolean.valueOf(this.k));
    }

    final String o() {
        String str = (String) b().first;
        if (a("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, a("MD5").digest(str.getBytes()))});
    }

    final Boolean q() {
        e();
        return !s().contains("use_service") ? null : Boolean.valueOf(s().getBoolean("use_service", false));
    }

    final boolean r() {
        e();
        return s().getBoolean("measurement_enabled", true);
    }
}
