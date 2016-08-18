package com.farsitel.bazaar.database;

import android.content.Context;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;

final class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        Context c = BazaarApplication.c();
        Toast.makeText(c, c.getResources().getString(2131165659), 1).show();
    }
}
