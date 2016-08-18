package com.farsitel.bazaar.database;

import android.content.Context;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;

final class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        Context c = BazaarApplication.c();
        Toast.makeText(c, c.getResources().getString(2131165659), 1).show();
    }
}
