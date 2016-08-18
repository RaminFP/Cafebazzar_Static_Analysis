package com.farsitel.bazaar.util;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.TaskStackBuilder;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.activity.u;
import com.farsitel.bazaar.c.a.a;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.service.AppDownloadService;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class ak {
    private static final Context a = BazaarApplication.c();

    public static String a(String str) {
        File b = a.b(str);
        File file = new File(t.c().getPath() + "/" + b.getName());
        return file.exists() ? file.getPath() : b.getPath();
    }

    public static void a(int i, String str, String str2) {
        try {
            Builder autoCancel;
            Intent launchIntentForPackage;
            int b = com.farsitel.bazaar.c.b.a.a().b(str2);
            PackageManager packageManager = a.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
            packageArchiveInfo.applicationInfo.sourceDir = str;
            packageArchiveInfo.applicationInfo.publicSourceDir = str;
            Bitmap bitmap = ((BitmapDrawable) packageArchiveInfo.applicationInfo.loadIcon(packageManager)).getBitmap();
            String str3 = (String) packageArchiveInfo.applicationInfo.loadLabel(packageManager);
            if (1 == i) {
                autoCancel = new Builder(a).setSmallIcon(g.ic_stat_root_complete).setContentTitle(a.getString(2131165416, new Object[]{str3})).setLargeIcon(bitmap).setTicker(a.getString(2131165415, new Object[]{str3})).setAutoCancel(true);
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(str2);
                if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
                    autoCancel.setContentText(a.getString(2131165414));
                    launchIntentForPackage = BazaarApplication.c().getApplicationContext().getPackageManager().getLaunchIntentForPackage(str2);
                } else {
                    launchIntentForPackage = new Intent(a, HomeActivity.class);
                    launchIntentForPackage.setData(com.farsitel.bazaar.activity.a.a(str2, "root_install_notification_not_launchable"));
                }
            } else if (2 == i) {
                autoCancel = new Builder(a).setSmallIcon(g.ic_stat_root_install).setContentTitle(a.getString(2131165418, new Object[]{str3})).setLargeIcon(bitmap).setTicker(a.getString(2131165417, new Object[]{str3})).setProgress(0, 0, true);
                launchIntentForPackage = new Intent(a, HomeActivity.class);
                launchIntentForPackage.setData(com.farsitel.bazaar.activity.a.a(str2, "root_install_notification_installing"));
            } else {
                autoCancel = new Builder(a).setSmallIcon(g.ic_stat_root_failed).setContentTitle(a.getString(2131165413, new Object[]{str3})).setContentText(a.getString(2131165411)).setLargeIcon(bitmap).setTicker(a.getString(2131165412, new Object[]{str3})).setAutoCancel(true);
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                launchIntentForPackage.addFlags(268435456);
            }
            TaskStackBuilder create = TaskStackBuilder.create(a);
            create.addParentStack(u.class);
            create.addNextIntent(launchIntentForPackage);
            autoCancel.setContentIntent(create.getPendingIntent(0, 134217728));
            ((NotificationManager) a.getSystemService("notification")).notify(b, autoCancel.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        AppDownloadService.b(str2, 0, 0, i);
    }

    public static boolean a() {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("asroot", false);
    }

    public static final boolean a(String str, String str2) {
        boolean[] zArr = new boolean[1];
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pm install -r " + str);
            if (arrayList != null && arrayList.size() > 0) {
                if (t.a(new File(str).length())) {
                    a(2, str, str2);
                    com.d.a.a.a(true).a(new al(0, new String[]{"pm install -r " + str}, zArr, str, str2));
                } else {
                    a(3, str, str2);
                }
            }
        } catch (IOException e) {
            a(3, str, str2);
        } catch (SecurityException e2) {
            a(3, str, str2);
        } catch (Exception e3) {
            a(3, str, str2);
        }
        return false;
    }

    public static boolean b() {
        boolean z = true;
        try {
            Process exec = Runtime.getRuntime().exec("su");
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            if (dataOutputStream == null || dataInputStream == null) {
                return false;
            }
            boolean z2;
            dataOutputStream.writeBytes("id\n");
            dataOutputStream.flush();
            String readLine = dataInputStream.readLine();
            if (readLine == null) {
                z = false;
                z2 = false;
            } else if (true == readLine.contains("uid=0")) {
                z2 = true;
            } else {
                z2 = true;
                z = false;
            }
            if (!z2) {
                return z;
            }
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
