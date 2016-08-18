package com.farsitel.bazaar.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ak;

final class bh implements Runnable {
    final /* synthetic */ bg a;

    bh(bg bgVar) {
        this.a = bgVar;
    }

    public final void run() {
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        boolean z = sharedPreferences.getBoolean("asroot", false);
        if (!ak.b()) {
            new Handler(Looper.getMainLooper()).post(new bi(this));
        } else if (!z) {
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("asroot", true);
            edit.commit();
            BazaarApplication.c().d();
            i.b("enable_root_install");
        }
    }
}
