package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;

public final class lz {
    private static final lz a = new lz();

    private lz() {
    }

    static k a(PackageInfo packageInfo, k... kVarArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        k ckVar = new ck(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < kVarArr.length; i++) {
            if (kVarArr[i].equals(ckVar)) {
                return kVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(ckVar.a(), 0));
        }
        return null;
    }

    public static lz a() {
        return a;
    }

    private static boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        k ckVar = new ck(packageInfo.signatures[0].toByteArray());
        if ((z ? j.a() : j.b()).contains(ckVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(ckVar.a(), 0));
        }
        return false;
    }

    public final boolean a(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (GooglePlayServicesUtil.zzc(packageManager)) {
                return a(packageInfo, true);
            }
            boolean a = a(packageInfo, false);
            if (a || !a(packageInfo, true)) {
                return a;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            return a;
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("GoogleSignatureVerifier", 3)) {
                return false;
            }
            Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            return false;
        }
    }
}
