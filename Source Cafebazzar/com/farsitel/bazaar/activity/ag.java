package com.farsitel.bazaar.activity;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class ag implements OnScrollListener {
    final /* synthetic */ AbsListView a;
    final /* synthetic */ u b;

    ag(u uVar, AbsListView absListView) {
        this.b = uVar;
        this.a = absListView;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "page";
        cVar = cVar.a("slug", this.b.a);
        cVar.e = "scroll";
        a.a(cVar.b("page_type", "list").b("referer", this.b.b));
        this.a.setOnScrollListener(null);
    }
}
