package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.util.SnappingHorizontalScrollView;

final class aa implements Runnable {
    final /* synthetic */ u a;

    aa(u uVar) {
        this.a = uVar;
    }

    public final void run() {
        if (this.a.v != null) {
            SnappingHorizontalScrollView d = this.a.v;
            d.fling(d.c * 100);
        }
        if (this.a.r != null) {
            this.a.r.removeCallbacks(this.a.f);
            this.a.r.postDelayed(this.a.f, 5000);
        }
    }
}
