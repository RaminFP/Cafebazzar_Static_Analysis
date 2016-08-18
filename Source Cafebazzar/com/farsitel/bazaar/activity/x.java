package com.farsitel.bazaar.activity;

import android.view.ViewTreeObserver.OnPreDrawListener;
import com.farsitel.bazaar.BazaarApplication;

final class x implements OnPreDrawListener {
    final /* synthetic */ u a;

    x(u uVar) {
        this.a = uVar;
    }

    public final boolean onPreDraw() {
        this.a.v.getChildAt(0).getViewTreeObserver().removeOnPreDrawListener(this);
        if (BazaarApplication.c().b()) {
            this.a.v.setSmoothScrollingEnabled(false);
            this.a.v.fullScroll(66);
            this.a.v.setSmoothScrollingEnabled(true);
        }
        return true;
    }
}
