package com.farsitel.bazaar.c.a;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.widget.ac;

final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    d(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void run() {
        new ac(BazaarApplication.c(), this.a).show();
    }
}
