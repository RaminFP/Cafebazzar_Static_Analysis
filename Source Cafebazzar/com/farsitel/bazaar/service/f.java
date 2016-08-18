package com.farsitel.bazaar.service;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.util.aw;

final class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        h.c();
        if (BazaarApplication.c().getSharedPreferences("BazaarBackupPreferences", 0).getBoolean("notify_on_new_updates", true)) {
            aw.a();
        }
    }
}
