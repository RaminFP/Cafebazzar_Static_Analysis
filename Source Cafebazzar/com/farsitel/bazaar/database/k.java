package com.farsitel.bazaar.database;

import android.os.Handler;
import android.os.Looper;

public final class k implements Runnable {
    final /* synthetic */ g a;

    public k(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        new Handler(Looper.getMainLooper()).post(new l(this));
    }
}
