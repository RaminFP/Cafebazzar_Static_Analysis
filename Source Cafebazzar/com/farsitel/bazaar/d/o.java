package com.farsitel.bazaar.d;

import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;

final class o implements n {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "change_nickname";
        a.a(cVar.b("action", "changed"));
        this.a.a.r.setText(this.a.a.getString(2131165459, j.a().k()));
    }

    public final void b() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "change_nickname";
        a.a(cVar.b("action", "failed"));
    }
}
