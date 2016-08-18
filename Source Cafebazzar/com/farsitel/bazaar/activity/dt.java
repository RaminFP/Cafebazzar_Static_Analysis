package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.au;

final class dt implements au {
    final /* synthetic */ dp a;

    dt(dp dpVar) {
        this.a = dpVar;
    }

    public final void a(int i) {
        String charSequence = this.a.c.getAdapter().getPageTitle(i).toString();
        BazaarApplication.c().d();
        i.a(charSequence);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void b(int i) {
    }
}
