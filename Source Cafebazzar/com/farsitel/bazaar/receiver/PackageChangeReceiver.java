package com.farsitel.bazaar.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.c.b.a;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.ak;

public class PackageChangeReceiver extends BroadcastReceiver {
    private final BazaarApplication a = BazaarApplication.c();

    static /* synthetic */ void a(String str) {
        if (BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).getBoolean("add_shortcut_to_app", true) && a.a().c(str)) {
            try {
                ApplicationInfo applicationInfo = BazaarApplication.c().getPackageManager().getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    Intent intent = new Intent();
                    intent.putExtra("android.intent.extra.shortcut.NAME", applicationInfo.loadLabel(BazaarApplication.c().getPackageManager()));
                    intent.putExtra("duplicate", false);
                    intent.putExtra("android.intent.extra.shortcut.INTENT", BazaarApplication.c().getPackageManager().getLaunchIntentForPackage(str));
                    Parcelable bitmap = ((BitmapDrawable) applicationInfo.loadIcon(BazaarApplication.c().getPackageManager())).getBitmap();
                    int i = (int) (BazaarApplication.c().getResources().getDisplayMetrics().density * 48.0f);
                    if (!(bitmap.getWidth() == i && bitmap.getHeight() == i)) {
                        bitmap = Bitmap.createScaledBitmap(bitmap, i, i, true);
                    }
                    intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
                    intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                    BazaarApplication.c().sendBroadcast(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (schemeSpecificPart != null) {
                g a = g.a();
                d dVar = null;
                if (a.a.containsKey(schemeSpecificPart)) {
                    dVar = (d) a.a.get(schemeSpecificPart);
                } else if (a.b.containsKey(schemeSpecificPart)) {
                    dVar = (d) a.b.get(schemeSpecificPart);
                }
                if (dVar != null) {
                    try {
                        if (dVar.d <= ((long) BazaarApplication.c().getPackageManager().getPackageInfo(schemeSpecificPart, 0).versionCode)) {
                            a.a(schemeSpecificPart);
                        }
                    } catch (NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        new Thread(new f(schemeSpecificPart)).start();
                        if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                            new Thread(new e(schemeSpecificPart)).start();
                            if (a.a().c(schemeSpecificPart) && VERSION.SDK_INT >= 11) {
                                try {
                                    context.getPackageManager().setInstallerPackageName(schemeSpecificPart, this.a.getPackageName());
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (a.a().a(schemeSpecificPart) == 2) {
                            ak.a(1, ak.a(schemeSpecificPart), schemeSpecificPart);
                        }
                        AppDownloadService.b(schemeSpecificPart, 0, 0, 1);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action) && !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                        AppDownloadService.b(schemeSpecificPart, 0, 0, 0);
                    }
                    if (this.a.getPackageName().equals(schemeSpecificPart)) {
                        ((NotificationManager) this.a.getSystemService("notification")).cancel(2);
                    }
                }
                a.a(schemeSpecificPart);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    new Thread(new f(schemeSpecificPart)).start();
                    if (intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                        new Thread(new e(schemeSpecificPart)).start();
                        context.getPackageManager().setInstallerPackageName(schemeSpecificPart, this.a.getPackageName());
                    }
                    if (a.a().a(schemeSpecificPart) == 2) {
                        ak.a(1, ak.a(schemeSpecificPart), schemeSpecificPart);
                    }
                    AppDownloadService.b(schemeSpecificPart, 0, 0, 1);
                } else {
                    AppDownloadService.b(schemeSpecificPart, 0, 0, 0);
                }
                if (this.a.getPackageName().equals(schemeSpecificPart)) {
                    ((NotificationManager) this.a.getSystemService("notification")).cancel(2);
                }
            }
        }
    }
}
