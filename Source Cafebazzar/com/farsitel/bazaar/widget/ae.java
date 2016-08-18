package com.farsitel.bazaar.widget;

final class ae implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ SlidingTabBar b;

    ae(SlidingTabBar slidingTabBar, int i) {
        this.b = slidingTabBar;
        this.a = i;
    }

    public final void run() {
        this.b.smoothScrollTo(this.a, 0);
    }
}
