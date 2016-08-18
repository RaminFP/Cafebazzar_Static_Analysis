package com.farsitel.bazaar.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.e.f;

final class ae extends OnScrollListener {
    final /* synthetic */ f a;
    final /* synthetic */ ac b;

    ae(ac acVar, f fVar) {
        this.b = acVar;
        this.a = fVar;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "row";
        cVar = cVar.a("title", this.a.b);
        cVar.e = "scroll";
        a.a(cVar.b("row_type", this.a.a).b("referer", this.a.f));
        recyclerView.removeOnScrollListener(this);
    }
}
