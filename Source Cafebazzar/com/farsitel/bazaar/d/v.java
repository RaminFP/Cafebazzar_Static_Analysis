package com.farsitel.bazaar.d;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import java.util.Map;

final class v implements b {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        if (this.a.a.isShowing()) {
            this.a.a.dismiss();
        }
        this.a.e.dismiss();
    }

    public final void b() {
        if (this.a.a.isShowing()) {
            this.a.a.dismiss();
        }
        this.a.e.dismiss();
        BazaarApplication.c().a(true);
    }
}
