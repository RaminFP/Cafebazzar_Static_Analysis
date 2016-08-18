package com.farsitel.bazaar.util;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public enum af {
    INSTANCE;

    public static d a(String str, String str2) {
        try {
            PackageInfo packageInfo = BazaarApplication.c().getPackageManager().getPackageInfo(str, 0);
            return new d(str, (long) packageInfo.versionCode, packageInfo.versionName, true, str2);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static ArrayList a(boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = BazaarApplication.c().getApplicationContext().getPackageManager();
        List installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if (packageInfo.versionName != null) {
                try {
                    if ((packageManager.getApplicationInfo(packageInfo.packageName, 0).flags & 1) != 0) {
                        Intent intent = new Intent("android.intent.action.MAIN", null);
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.setPackage(packageInfo.packageName);
                        if (packageManager.queryIntentActivities(intent, 0).size() <= 0) {
                        }
                    }
                } catch (NameNotFoundException e) {
                }
                try {
                    ApplicationInfo applicationInfo = BazaarApplication.c().getPackageManager().getApplicationInfo(packageInfo.packageName, 0);
                    if (applicationInfo.enabled) {
                        arrayList.add(new d(packageInfo.packageName, VERSION.SDK_INT >= 9 ? packageInfo.lastUpdateTime : new File(applicationInfo.sourceDir).lastModified()));
                    }
                } catch (NameNotFoundException e2) {
                }
            }
        }
        return arrayList;
    }

    public static JSONArray a() {
        PackageManager packageManager = BazaarApplication.c().getPackageManager();
        JSONArray jSONArray = new JSONArray();
        Iterator it = ((ArrayList) packageManager.getInstalledApplications(0)).iterator();
        while (it.hasNext()) {
            ApplicationInfo applicationInfo = (ApplicationInfo) it.next();
            try {
                long j;
                long j2;
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(applicationInfo.packageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, 0);
                jSONArray2.put(packageInfo.versionCode);
                if (VERSION.SDK_INT >= 9) {
                    j = packageInfo.lastUpdateTime;
                    j2 = packageInfo.firstInstallTime;
                } else {
                    j = new File(applicationInfo.sourceDir).lastModified();
                    j2 = j;
                }
                j = (System.currentTimeMillis() - j) / 60000;
                long j3 = j < 0 ? 525600 : j;
                j = (System.currentTimeMillis() - j2) / 60000;
                if (j < 0) {
                    j = 525600;
                }
                jSONArray2.put(j);
                jSONArray2.put(j3);
                jSONArray.put(jSONArray2);
            } catch (NameNotFoundException e) {
            }
        }
        return jSONArray;
    }

    public static boolean a(String str) {
        try {
            return BazaarApplication.c().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (NameNotFoundException e) {
            return true;
        }
    }

    public static d b(String str) {
        PackageManager packageManager = BazaarApplication.c().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return new d(str, (long) packageInfo.versionCode, packageInfo.versionName, packageManager.getApplicationInfo(str, 0).enabled, true);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean c(String str) {
        boolean z = false;
        try {
            ApplicationInfo applicationInfo = BazaarApplication.c().getPackageManager().getPackageInfo(str, 0).applicationInfo;
            return true;
        } catch (Exception e) {
            return z;
        }
    }

    public static boolean d(String str) {
        boolean z = false;
        try {
            return BazaarApplication.c().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (Exception e) {
            return z;
        }
    }

    public static File e(String str) {
        try {
            return new File(BazaarApplication.c().getApplicationContext().getPackageManager().getApplicationInfo(str, 0).publicSourceDir);
        } catch (Exception e) {
            return null;
        }
    }
}
