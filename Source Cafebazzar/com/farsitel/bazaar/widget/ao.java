package com.farsitel.bazaar.widget;

final class ao implements Runnable {
    final /* synthetic */ ViewPager a;

    ao(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
