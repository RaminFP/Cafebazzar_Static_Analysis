package com.farsitel.bazaar.d;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.au;

final class as implements au {
    final /* synthetic */ am a;

    as(am amVar) {
        this.a = amVar;
    }

    public final void a(int i) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "purchases_frag";
        cVar.e = "change_tab";
        a.a(cVar.a("last", Integer.valueOf(this.a.b.getCurrentItem())).b("current", Integer.valueOf(i)));
        String charSequence = this.a.b.getAdapter().getPageTitle(i).toString();
        BazaarApplication.c().d();
        i.a(charSequence);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void b(int i) {
    }
}
