package com.farsitel.bazaar.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.a;
import com.farsitel.bazaar.g.a.k;

final class f implements OnClickListener {
    final /* synthetic */ k a;
    final /* synthetic */ e b;

    f(e eVar, k kVar) {
        this.b = eVar;
        this.a = kVar;
    }

    public final void onClick(View view) {
        a.a(this.b.a, this.a.a, this.a.b, this.a.c, this.a.f, this.b.e + "|" + this.a.n);
    }
}
