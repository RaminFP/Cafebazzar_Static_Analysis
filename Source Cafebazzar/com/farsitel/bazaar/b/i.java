package com.farsitel.bazaar.b;

import android.app.Activity;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.b;
import com.farsitel.bazaar.h.d;

final class i extends o {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    i(e eVar, Activity activity, String str, int i, int i2, int i3, boolean z, String str2) {
        this.b = eVar;
        this.a = str2;
        super(activity, str, 2131165801, 0, 2131165463, true);
    }

    public final void a() {
        this.e.dismiss();
        this.b.a.setVisibility(8);
        this.b.c.setVisibility(8);
        this.b.b.setVisibility(0);
        d.INSTANCE.a(new j(this), new b(), j.a().b, BazaarApplication.c().a.getLanguage(), this.a);
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
