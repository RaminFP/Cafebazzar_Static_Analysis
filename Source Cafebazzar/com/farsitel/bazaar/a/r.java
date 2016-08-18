package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.z;
import com.farsitel.bazaar.h.d;

public final class r extends h {
    public r(Activity activity, LayoutInflater layoutInflater, b bVar) {
        super(activity, layoutInflater, false, bVar, false, "bought_apps");
        this.i = new a("bought");
    }

    public final void a() {
        this.f.a();
        d.INSTANCE.a(f(), new z(), j.a().b, BazaarApplication.c().a.getLanguage(), Integer.valueOf(this.g));
    }
}
