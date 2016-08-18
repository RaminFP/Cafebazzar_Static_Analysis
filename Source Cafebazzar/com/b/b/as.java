package com.b.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

public class as {
    private static final String a = as.class.getSimpleName();
    private static String b;
    private static String c;

    public static String a() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String b = b();
        c = b;
        return b;
    }

    public static void a(String str) {
        b = str;
    }

    private static String b() {
        try {
            Context context = ah.a.b;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return "Unknown";
        } catch (Throwable th) {
            ba.a(6, a, "", th);
        }
    }
}
