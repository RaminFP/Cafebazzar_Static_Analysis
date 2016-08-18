package com.farsitel.bazaar.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.farsitel.bazaar.BazaarApplication;

public final class k {
    private static int a = 0;
    private static String b = "";

    public static void a() {
        e();
    }

    public static void a(long j) {
        BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit().putLong("bazaar_fvc", j).commit();
    }

    public static void a(Activity activity) {
        if (d()) {
            new l(activity, 2131165287, 2131165482, 0, 0, false, activity).e.show();
        }
    }

    public static int b() {
        if (a == 0) {
            e();
        }
        return a;
    }

    public static String c() {
        if (b.equals("")) {
            e();
        }
        return b;
    }

    public static boolean d() {
        int b = b();
        return b > 0 && BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getLong("bazaar_fvc", 0) > ((long) b);
    }

    private static void e() {
        BazaarApplication c = BazaarApplication.c();
        try {
            PackageInfo packageInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                b = str;
                if (str == null) {
                    b = "";
                }
                a = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
        }
    }
}
