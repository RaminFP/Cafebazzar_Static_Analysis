package com.farsitel.bazaar;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.a.a.a;
import com.congenialmobile.util.f;
import com.congenialmobile.util.h;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.database.UpgradablesWidgetProvider;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.av;
import com.farsitel.bazaar.util.c;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.util.q;
import com.farsitel.bazaar.util.s;
import com.farsitel.bazaar.util.u;
import java.util.UUID;

public class BazaarApplication extends f {
    private static BazaarApplication d;
    private i e;

    public BazaarApplication() {
        d = this;
    }

    public static BazaarApplication c() {
        return d;
    }

    public final void a() {
        super.a();
        av.a(getAssets());
        a(false);
    }

    public final void a(Intent intent, boolean z) {
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        intent.addFlags(268435456);
        try {
            if (VERSION.SDK_INT > 16) {
                ActivityOptions makeCustomAnimation = ActivityOptions.makeCustomAnimation(this, 0, 0);
                c.a(intent);
                startActivity(intent, makeCustomAnimation.toBundle());
            } else {
                c.a(intent);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(d, 2131165703, 0).show();
        }
        Intent intent2 = new Intent(getBaseContext(), UpgradablesWidgetProvider.class);
        intent2.setAction("com.faristel.bazaar.appwidget.upgradableswidget.UPDATE_ACTION");
        sendBroadcast(intent2);
        if (z) {
            System.exit(2);
        }
    }

    public final void a(boolean z) {
        a(new Intent(this, HomeActivity.class), z);
    }

    public final i d() {
        if (this.e == null) {
            this.e = new i(k.a);
        }
        return this.e;
    }

    @TargetApi(11)
    public final void onCreate() {
        int i;
        super.onCreate();
        b.a.a.a.f.a((Context) this, new a());
        SharedPreferences sharedPreferences = d.getSharedPreferences("BazaarPreferences", 0);
        if (sharedPreferences.getString("bazaar_unique_id", null) == null) {
            String a = com.congenialmobile.util.a.a(h.a(UUID.randomUUID()), false);
            if (a.length() > 31) {
                a = a.substring(0, 31);
            }
            Editor edit = sharedPreferences.edit();
            edit.putString("bazaar_unique_id", a);
            edit.commit();
        }
        k.a();
        new Thread(new u()).start();
        o.a(this);
        s.a();
        a.d();
        a.a(p.a());
        a.d();
        a.b(j.a().g());
        a.d();
        a.a("device_id_int", j.a().m());
        a.d();
        a.a("logged_in", j.a().n());
        a.d();
        a.a("is_tablet", o.e());
        a.d();
        a.a("is_on_wifi", q.f());
        a.d();
        a.a("net_type", q.g());
        a.d();
        a.a("net_operator", q.a());
        sharedPreferences = d.getSharedPreferences("BazaarPreferences", 0);
        if (sharedPreferences.getString("locale", null) == null) {
            switch (a.a[q.b() - 1]) {
                case 1:
                    sharedPreferences.edit().putString("locale", "fa").commit();
                    break;
                case 2:
                    sharedPreferences.edit().putString("locale", "en").commit();
                    break;
            }
        }
        a((ContextWrapper) this);
        av.a(getAssets());
        System.setProperty("http.keepAlive", "false");
        try {
            i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            i = -1;
        }
        if ((sharedPreferences.contains("registeredVersion") ? sharedPreferences.getInt("registeredVersion", -1) : getSharedPreferences("Bazaar.prefs", 0).getInt("registeredVersion", i)) < i) {
            sharedPreferences.edit().putInt("registeredVersion", i).commit();
        }
        new ir.cafebazaar.pardakht.a.f(getApplicationContext()).getWritableDatabase().close();
        com.farsitel.bazaar.util.h.INSTANCE.a();
        startService(new Intent(this, AppDownloadService.class));
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.e != null) {
            i.a();
        }
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1);
        } catch (Exception e) {
        }
    }
}
