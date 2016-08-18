package com.farsitel.bazaar.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class af implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ SlidingTabBar b;

    af(SlidingTabBar slidingTabBar, int i) {
        this.b = slidingTabBar;
        this.a = i;
    }

    public final void onClick(View view) {
        if (this.b.g != null) {
            this.b.g.a(this.a);
            this.b.c();
        }
    }
}
