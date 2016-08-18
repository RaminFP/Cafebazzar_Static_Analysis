package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map a = new HashMap();
    public static j c;
    public static String g;
    private static h h;
    Context b;
    KeyPair d;
    public String e = "";
    long f;

    private a(Context context, String str) {
        this.b = context.getApplicationContext();
        this.e = str;
    }

    static int a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    public static a a(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            try {
                Context applicationContext = context.getApplicationContext();
                if (c == null) {
                    c = new j(applicationContext);
                    h = new h(applicationContext);
                }
                g = Integer.toString(a(applicationContext));
                aVar = (a) a.get(str);
                if (aVar == null) {
                    aVar = new a(applicationContext, str);
                    a.put(str, aVar);
                }
            } catch (Throwable th) {
                Class cls = a.class;
            }
        }
        return aVar;
    }

    static j a() {
        return c;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static a b(Context context) {
        return a(context, null);
    }

    static h b() {
        return h;
    }

    public static boolean c() {
        String a = c.a("appVersion");
        if (a != null && a.equals(g)) {
            a = c.a("lastToken");
            if (a != null) {
                if ((System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() <= 604800) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String a(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.e) ? str : this.e;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        h hVar = h;
        if (this.d == null) {
            this.d = c.d(this.e);
        }
        if (this.d == null) {
            this.f = System.currentTimeMillis();
            this.d = c.a(this.e, this.f);
        }
        KeyPair keyPair = this.d;
        Intent a = hVar.a(bundle, keyPair);
        if (a != null && a.hasExtra("google.messenger")) {
            a = hVar.a(bundle, keyPair);
        }
        return h.a(a);
    }
}
