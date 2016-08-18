package com.farsitel.bazaar.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.a.h;
import com.farsitel.bazaar.h.a.l;
import com.farsitel.bazaar.h.a.m;
import com.farsitel.bazaar.h.a.t;
import com.farsitel.bazaar.h.a.u;
import com.farsitel.bazaar.h.b.aa;
import com.farsitel.bazaar.h.b.av;
import com.farsitel.bazaar.h.d;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class a {
    public static Object a(b bVar) {
        h hVar = new h();
        hVar.b = bVar;
        return d.INSTANCE.a(hVar.c, new aa(), hVar.c());
    }

    public static Object a(String str, String str2, b bVar) {
        t tVar = new t(str, str2);
        tVar.d = bVar;
        return d.INSTANCE.a(new u(tVar, bVar), new av(), tVar.b(tVar.b, tVar.c));
    }

    public static void a() {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.CHECK_UPGRADABLES");
        PendingIntent broadcast = PendingIntent.getBroadcast(BazaarApplication.c().getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) BazaarApplication.c().getApplicationContext().getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.setInexactRepeating(1, System.currentTimeMillis(), j.a().a.getLong("update_time_interval", 1440) * 60000, broadcast);
    }

    public static void a(boolean z) {
        if ((GooglePlayServicesUtil.isGooglePlayServicesAvailable(BazaarApplication.c()) == 0 ? 1 : 0) != 0 ? com.farsitel.bazaar.e.a.a().equals("") : false) {
            new com.farsitel.bazaar.e.b(new b()).execute(new Void[]{null, null, null});
        } else {
            b(k.d() | z);
        }
    }

    static void b(boolean z) {
        if (j.a().n()) {
            long currentTimeMillis = System.currentTimeMillis();
            j.a();
            long q = j.q();
            if (z || currentTimeMillis - q > 54000000) {
                new m().d();
                return;
            }
            return;
        }
        currentTimeMillis = System.currentTimeMillis();
        j.a();
        q = j.r();
        if (z || currentTimeMillis - q > 79200000) {
            new l().d();
        }
    }
}
