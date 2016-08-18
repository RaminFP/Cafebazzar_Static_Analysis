package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.util.ao;

final class y implements ao {
    final /* synthetic */ u a;

    y(u uVar) {
        this.a = uVar;
    }

    public final void a() {
        if (this.a.r != null) {
            this.a.r.removeCallbacks(this.a.f);
            this.a.r.postDelayed(this.a.f, 5000);
        }
    }
}
