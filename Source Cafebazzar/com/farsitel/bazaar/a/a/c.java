package com.farsitel.bazaar.a.a;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.a.a.a.a;
import com.a.a.a.ac;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.cf;
import com.farsitel.bazaar.database.m;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.g.l;
import com.farsitel.bazaar.h.b.aw;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.q;

final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        int i;
        try {
            i = BazaarApplication.c().getApplicationContext().getPackageManager().getPackageInfo(a.b, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            i = 0;
        }
        m.a().a(new l(a.b, a.c, "", i));
        if (q.e()) {
            d.INSTANCE.a(new cf(a.b, false, true), new aw(), j.a().b, a.b, Integer.valueOf(a.c), "", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i));
            a.c().a(new ac().a(a.b).a(a.c).b("quick rate"));
            BazaarApplication.c().d();
            i.a("/QuickRate/" + a.b);
        }
    }
}
