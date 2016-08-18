package com.farsitel.bazaar.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ag implements OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabBar a;

    ag(SlidingTabBar slidingTabBar) {
        this.a = slidingTabBar;
    }

    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.a.a(this.a.l, 0, false);
    }
}
