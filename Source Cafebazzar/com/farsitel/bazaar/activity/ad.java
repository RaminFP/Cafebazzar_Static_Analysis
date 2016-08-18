package com.farsitel.bazaar.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.z;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class ad implements z {
    final /* synthetic */ NestedScrollView a;
    final /* synthetic */ u b;

    ad(u uVar, NestedScrollView nestedScrollView) {
        this.b = uVar;
        this.a = nestedScrollView;
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "page";
        cVar = cVar.a("slug", this.b.a);
        cVar.e = "scroll";
        a.a(cVar.b("page_type", "vitrin").b("referer", this.b.b));
        this.a.setOnScrollChangeListener(null);
    }
}
