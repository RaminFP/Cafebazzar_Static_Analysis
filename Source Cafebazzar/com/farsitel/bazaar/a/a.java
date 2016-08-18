package com.farsitel.bazaar.a;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.widget.ak;
import com.farsitel.bazaar.widget.al;

public final class a extends ak {
    public final al[] a() {
        b bVar = new b(this);
        c cVar = new c(this);
        d dVar = new d(this);
        if (BazaarApplication.c().b()) {
            return new al[]{dVar, cVar, bVar};
        }
        return new al[]{bVar, cVar, dVar};
    }
}
