package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.b.j;
import c.a.a.b;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.g;

public abstract class h extends BroadcastReceiver {
    public static void c() {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.ON_UPGRADABLES_CHANGED");
        j.a(BazaarApplication.c()).a(intent);
    }

    public void a() {
        j.a(BazaarApplication.c()).a(this, new IntentFilter("com.farsitel.bazaar.ON_UPGRADABLES_CHANGED"));
        a(g.a().a.size());
    }

    public abstract void a(int i);

    public void b() {
        j.a(BazaarApplication.c()).a((BroadcastReceiver) this);
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.ON_UPGRADABLES_CHANGED".equals(intent.getAction())) {
            a(g.a().a.size());
            if (BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).getBoolean("update_launcher_badge", false)) {
                b.a(context).b(g.a().a.size());
            } else {
                b.a(context).d();
            }
        }
    }
}
