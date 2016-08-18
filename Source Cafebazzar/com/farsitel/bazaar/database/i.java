package com.farsitel.bazaar.database;

import android.os.Handler;
import android.os.Looper;

final class i implements Runnable {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        new Handler(Looper.getMainLooper()).post(new j(this));
    }
}
