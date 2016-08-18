package com.farsitel.bazaar.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class v implements OnClickListener {
    final /* synthetic */ x a;
    final /* synthetic */ HomeTabBar b;

    v(HomeTabBar homeTabBar, x xVar) {
        this.b = homeTabBar;
        this.a = xVar;
    }

    public final void onClick(View view) {
        this.b.a(this.a.a, true);
    }
}
