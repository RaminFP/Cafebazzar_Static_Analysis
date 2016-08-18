package com.b.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public final class am {
    private static final String a = am.class.getSimpleName();

    public static String a(Context context) {
        PackageInfo b = b(context);
        return (b == null || b.packageName == null) ? "" : b.packageName;
    }

    private static PackageInfo b(Context context) {
        PackageInfo packageInfo = null;
        if (context != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 20815);
            } catch (NameNotFoundException e) {
                ba.a(a, "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return packageInfo;
    }
}
