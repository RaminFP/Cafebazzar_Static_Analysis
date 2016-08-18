package com.farsitel.bazaar.a;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.e;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.receiver.g;

public final class q extends g {
    final /* synthetic */ p a;

    public q(p pVar) {
        this.a = pVar;
    }

    public final void a() {
        this.a.i.a(this.a.c.getString(2131165311), e.a().c());
        this.a.notifyDataSetChanged();
    }

    public final void b() {
        BazaarApplication.c().d();
        i.a("/User/Bookmarked/Error");
    }
}
