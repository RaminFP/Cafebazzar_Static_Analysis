package com.farsitel.bazaar.widget;

final class ai implements au {
    final /* synthetic */ SlidingTabBar a;

    private ai(SlidingTabBar slidingTabBar) {
        this.a = slidingTabBar;
    }

    public final void a(int i) {
        if (this.a.a != null) {
            this.a.a.a(i);
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.a.k > 0) {
            SlidingTabBar slidingTabBar = this.a;
            int width = (int) (((float) this.a.i.getChildAt(i).getWidth()) * f);
            boolean z = f == 0.0f && this.a.m == 0.0f;
            slidingTabBar.a(i, width, z);
            this.a.invalidate();
        }
        this.a.l = i;
        this.a.m = f;
        if (this.a.a != null) {
            this.a.a.a(i, f, i2);
        }
    }

    public final void b(int i) {
        if (i == 0) {
            this.a.a(this.a.j.getCurrentItem(), 0, false);
            this.a.c();
        }
        if (this.a.a != null) {
            this.a.a.b(i);
        }
    }
}
