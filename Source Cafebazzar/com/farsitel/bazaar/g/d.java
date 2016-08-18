package com.farsitel.bazaar.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.a.k;
import java.util.Locale;

public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public boolean e;
    public boolean f;
    public long g;

    private d(String str) {
        PackageInfo a = a(str);
        long j = (long) (a != null ? a.versionCode : 0);
        a = a(str);
        this(str, j, a != null ? a.versionName : "", true);
    }

    public d(String str, long j) {
        this(str);
        this.g = j;
    }

    private d(String str, long j, String str2, boolean z) {
        this(str, j, str2, true, true);
    }

    public d(String str, long j, String str2, boolean z, String str3) {
        this(str, a(str, str3), j, str2, true, true);
    }

    public d(String str, long j, String str2, boolean z, boolean z2) {
        this(str, a(str, "bazaar_locale"), j, str2, z, z2);
    }

    private d(String str, String str2, long j, String str3, boolean z, boolean z2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = z;
        this.f = z2;
    }

    private static PackageInfo a(String str) {
        try {
            return BazaarApplication.c().getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(String str, String str2) {
        PackageInfo a = a(str);
        if (a == null) {
            return "";
        }
        try {
            Configuration configuration = new Configuration();
            Resources resourcesForApplication = BazaarApplication.c().getPackageManager().getResourcesForApplication(a.applicationInfo);
            if ("device_locale".equals(str2)) {
                configuration.locale = new Locale(resourcesForApplication.getConfiguration().locale.getLanguage());
            } else {
                configuration.locale = BazaarApplication.c().a;
            }
            resourcesForApplication.updateConfiguration(configuration, BazaarApplication.c().getResources().getDisplayMetrics());
            return resourcesForApplication.getString(a.applicationInfo.labelRes);
        } catch (Exception e) {
            return a.applicationInfo.loadLabel(BazaarApplication.c().getPackageManager()).toString();
        }
    }

    public final k a() {
        return new k(this.a, this.b, "", 0.0f, true, this.f ? 0 : 1, "", "", this.e, this.d, this.c, false, null, null);
    }

    public final boolean equals(Object obj) {
        return ((d) obj).a.equals(this.a);
    }

    public final String toString() {
        return "AppPackage (" + this.a + " " + this.b + " free = " + this.f + ")";
    }
}
