package com.farsitel.bazaar.e;

import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.farsitel.bazaar.BazaarApplication;

public final class a {
    public static String a() {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        String string = sharedPreferences.getString("registration_id", "");
        return string.equals("") ? "" : sharedPreferences.getInt("appVersion", Integer.MIN_VALUE) != b() ? "" : string;
    }

    static int b() {
        BazaarApplication c = BazaarApplication.c();
        try {
            return c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    static SharedPreferences c() {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
    }
}
