package com.google.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

final class i implements n {
    private static i e;
    private static Object f = new Object();
    protected String a;
    protected String b;
    protected String c;
    protected String d;

    protected i() {
    }

    private i(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.c = context.getPackageName();
        this.d = packageManager.getInstallerPackageName(this.c);
        String str = this.c;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            as.a("Error retrieving package info: appName set to " + str);
        }
        this.a = str;
        this.b = str2;
    }

    public static i a() {
        return e;
    }

    public static void a(Context context) {
        synchronized (f) {
            if (e == null) {
                e = new i(context);
            }
        }
    }

    public final String a(String str) {
        return str.equals("&an") ? this.a : str.equals("&av") ? this.b : str.equals("&aid") ? this.c : str.equals("&aiid") ? this.d : null;
    }
}
