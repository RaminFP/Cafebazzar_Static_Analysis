package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.BazaarApplication;

final class g implements Runnable {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        int i = BazaarApplication.c().b() ? 0 : 2;
        this.a.K.setCurrentTab(i);
        this.a.L.setCurrentTab(i);
        a.a(this.a, false);
    }
}
