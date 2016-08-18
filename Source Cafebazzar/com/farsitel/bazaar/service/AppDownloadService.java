package com.farsitel.bazaar.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.b.j;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.c.a.a;
import com.farsitel.bazaar.c.a.c;
import com.farsitel.bazaar.c.a.f;
import com.farsitel.bazaar.g.a.i;
import com.farsitel.bazaar.util.ak;
import com.farsitel.bazaar.util.n;
import com.farsitel.bazaar.util.q;
import com.farsitel.bazaar.util.t;
import com.farsitel.bazaar.util.x;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class AppDownloadService extends Service {
    private boolean a = false;

    public static void a() {
        Context c = BazaarApplication.c();
        c.startService(new Intent(c, AppDownloadService.class));
    }

    private void a(a aVar) {
        int i = 0;
        if (q.e()) {
            if (aVar.j || aVar.i == 11) {
                i = 1;
            }
            if (i == 0) {
                aVar.a(14);
                if (aVar.f == null) {
                    new com.farsitel.bazaar.f.a(aVar.a, aVar.c, aVar.d + "|" + f.c(aVar.e), new c(aVar)).a();
                } else {
                    aVar.a();
                }
            }
            d();
            return;
        }
        e();
        Toast.makeText(this, 2131165466, 0).show();
    }

    public static void a(String str) {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, AppDownloadService.class);
        intent.setAction("com.farsitel.bazaar.PAUSE_DOWNLOAD_APP");
        intent.putExtra("p", str);
        c.startService(intent);
    }

    public static void a(String str, long j, long j2, int i) {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, AppDownloadService.class);
        intent.setAction("com.farsitel.bazaar.ON_DOWNLOAD_PROGRESS");
        intent.putExtra("package_name", str);
        intent.putExtra("downloaded_size", j);
        intent.putExtra("total_size", j2);
        intent.putExtra("progress_status", i);
        c.startService(intent);
    }

    private void a(String str, File file, boolean z) {
        boolean z2 = BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).getBoolean("save_apks", false);
        File file2 = new File(t.c().getPath() + "/" + file.getName());
        if (z && z2 && !file2.exists()) {
            new Thread(new c(this, file, file2)).start();
        }
        if (ak.a()) {
            new Thread(new a(this, file, str)).start();
        } else {
            new Handler().postDelayed(new b(this, file), 600);
        }
    }

    public static void a(String str, String str2, boolean z, String str3) {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, AppDownloadService.class);
        intent.setAction("com.farsitel.bazaar.START_DOWNLOAD_APP");
        intent.setData(Uri.parse("bazaar://download?p=" + str + "&n" + "=" + Uri.encode(str2) + "&f" + "=" + z + "&r" + "=" + Uri.encode(str3)));
        c.startService(intent);
    }

    public static void a(String str, String str2, boolean z, String str3, String str4, String str5, BigInteger bigInteger, long j, String str6, BigInteger bigInteger2, long j2) {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, AppDownloadService.class);
        intent.setAction("com.farsitel.bazaar.START_DOWNLOAD_APP");
        String str7 = "bazaar://download?p=" + str + "&n" + "=" + Uri.encode(str2) + "&f" + "=" + z + "&r" + "=" + Uri.encode(str3);
        if (str4 != null) {
            str7 = str7 + "&c=" + str4;
        }
        if (str5 != null) {
            if (((j > 0 ? 1 : 0) & (bigInteger != null ? 1 : 0)) != 0) {
                str7 = str7 + "&t=" + str5 + "&h" + "=" + bigInteger.toString(16) + "&s" + "=" + j;
            }
        }
        if (str6 != null) {
            if (((j2 > 0 ? 1 : 0) & (bigInteger2 != null ? 1 : 0)) != 0) {
                str7 = str7 + "&dt=" + str6 + "&dh" + "=" + bigInteger2.toString(16) + "&ds" + "=" + j2;
            }
        }
        intent.setData(Uri.parse(str7));
        c.startService(intent);
    }

    public static void b() {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, AppDownloadService.class);
        intent.setAction("com.farsitel.bazaar.PAUSE_ALL_DOWNLOADS");
        c.startService(intent);
    }

    private void b(String str) {
        a a;
        if (!g()) {
            a = x.a(str);
            if (a != null) {
                a(a);
            } else if (x.d()) {
                e();
            }
        } else if (!x.b()) {
            a = x.a();
            if (a != null) {
                a(a);
            } else {
                e();
            }
        }
    }

    public static void b(String str, long j, long j2, int i) {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.DOWNLOAD_PROGRESS");
        intent.putExtra("package_name", str);
        intent.putExtra("downloaded_size", j);
        intent.putExtra("total_size", j2);
        intent.putExtra("progress_status", i);
        j.a(BazaarApplication.c()).a(intent);
        com.farsitel.bazaar.c.b.a.a().a(str, i);
    }

    public static boolean c() {
        if (!q.e()) {
            return false;
        }
        long j;
        AlarmManager alarmManager = (AlarmManager) BazaarApplication.c().getSystemService("alarm");
        boolean a = n.a();
        float b = n.b();
        if (a) {
            j = 60000;
        } else if (b == -1.0f || b > 40.0f) {
            j = 300000;
        } else if (b <= 15.0f) {
            return false;
        } else {
            j = 3600000;
        }
        alarmManager.set(0, j + System.currentTimeMillis(), PendingIntent.getService(BazaarApplication.c().getApplicationContext(), 0, new Intent(BazaarApplication.c(), AppDownloadService.class), 0));
        return true;
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        long j2 = 0;
        boolean z = false;
        Iterator it = x.c().iterator();
        float f = -1.0f;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.a.equals(BazaarApplication.c().getPackageName())) {
                if (aVar.i == 13) {
                    z = true;
                }
                j += aVar.d();
                j2 += aVar.e();
                float d = ((float) aVar.d()) / ((float) aVar.e());
                if (d > f) {
                    arrayList.add(0, aVar.b);
                    f = d;
                } else {
                    arrayList.add(aVar.b);
                }
            }
        }
        if (j2 > 0) {
            startForeground(1, com.farsitel.bazaar.widget.n.INSTANCE.a(arrayList, j, j2, !this.a, z));
            this.a = true;
            return;
        }
        e();
    }

    private void e() {
        stopForeground(true);
        this.a = false;
    }

    private void f() {
        ArrayList b = com.farsitel.bazaar.c.b.a.a().b();
        if (!b.isEmpty()) {
            x.a(b);
            if (g()) {
                b(null);
                return;
            }
            Iterator it = b.iterator();
            while (it.hasNext()) {
                b(((i) it.next()).g());
            }
        }
    }

    private static boolean g() {
        return BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).getBoolean("optimized_bandwidth", true);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            f();
        } else {
            String action = intent.getAction();
            if (action == null) {
                f();
            } else if (action.equals("com.farsitel.bazaar.START_DOWNLOAD_APP")) {
                Uri data = intent.getData();
                String queryParameter = data.getQueryParameter("p");
                String queryParameter2 = data.getQueryParameter("n");
                String queryParameter3 = data.getQueryParameter("c");
                r3 = data.getQueryParameter("f");
                boolean z = true;
                if (r3 != null) {
                    z = Boolean.parseBoolean(r3);
                }
                String queryParameter4 = data.getQueryParameter("r");
                String queryParameter5 = data.getQueryParameter("t");
                r3 = data.getQueryParameter("h");
                String queryParameter6 = data.getQueryParameter("s");
                BigInteger bigInteger = null;
                long j = 0;
                if (!(r3 == null || queryParameter6 == null)) {
                    bigInteger = new BigInteger(r3, 16);
                    j = Long.parseLong(queryParameter6);
                }
                String queryParameter7 = data.getQueryParameter("dt");
                r3 = data.getQueryParameter("dh");
                action = data.getQueryParameter("ds");
                BigInteger bigInteger2 = null;
                long j2 = 0;
                if (!(r3 == null || action == null)) {
                    bigInteger2 = new BigInteger(r3, 16);
                    j2 = Long.parseLong(action);
                }
                if ((com.farsitel.bazaar.c.b.a.a().a(queryParameter) == 3 ? 1 : null) != null && a.a(queryParameter)) {
                    a(queryParameter, a.b(queryParameter), z);
                    BazaarApplication.c().d();
                    com.farsitel.bazaar.i.a("/download/previously_downloaded/" + queryParameter);
                } else if (!x.b(queryParameter)) {
                    r8 = com.farsitel.bazaar.c.b.a.a().a(queryParameter);
                    x.b(queryParameter5 != null ? new a(queryParameter, queryParameter2, z, queryParameter4, r8, queryParameter3, queryParameter5, bigInteger, j, queryParameter7, bigInteger2, j2) : new a(queryParameter, queryParameter2, z, queryParameter4, r8));
                    com.farsitel.bazaar.c.b.a.a().a(queryParameter, queryParameter2, 12, z);
                    b(queryParameter, 0, 0, 12);
                    b(queryParameter);
                }
            } else if (action.equals("com.farsitel.bazaar.PAUSE_DOWNLOAD_APP")) {
                r3 = intent.getStringExtra("p");
                r2 = x.a(r3);
                if (r2 != null) {
                    r2.b();
                }
                com.farsitel.bazaar.c.b.a.a().a(r3, 11);
                b(r3, 0, 0, 11);
            } else if (action.equals("com.farsitel.bazaar.PAUSE_ALL_DOWNLOADS")) {
                x.e();
                Iterator it = com.farsitel.bazaar.c.b.a.a().d().iterator();
                while (it.hasNext()) {
                    b((String) it.next(), 0, 0, 11);
                }
                e();
            } else if (action.equals("com.farsitel.bazaar.ON_DOWNLOAD_PROGRESS")) {
                r3 = intent.getStringExtra("package_name");
                long longExtra = intent.getLongExtra("downloaded_size", 0);
                long longExtra2 = intent.getLongExtra("total_size", 0);
                r8 = intent.getIntExtra("progress_status", 0);
                b(r3, longExtra, longExtra2, r8);
                if (f.b(r8)) {
                    r2 = x.a(r3);
                    if (r2 != null) {
                        if (r8 == 3) {
                            a(r3, a.b(r3), r2.c);
                            BazaarApplication.c().d();
                            com.farsitel.bazaar.i.a("/download/just_downloaded/" + r3);
                            x.c(r2);
                            b(r3);
                        } else if (r8 == 4 || r8 == 5 || r8 == 6 || r8 == 7 || r8 == 8 || r8 == 12 || r8 == 11) {
                            x.c(r2);
                            b(r3);
                        } else if (r8 == 9) {
                            Toast.makeText(this, 2131165511, 0).show();
                            a aVar = new a(r2.a, r2.b, r2.c, r2.d, 9, r2.g(), r2.f, r2.g, r2.h, null, null, 0);
                            x.c(r2);
                            x.a(aVar);
                            b(r3);
                        }
                    }
                }
                d();
            }
        }
        return 1;
    }
}
