package com.farsitel.bazaar.activity;

import android.support.v4.view.cw;
import com.farsitel.bazaar.d.aj;

final class bg implements cw {
    final /* synthetic */ HomeActivity a;

    bg(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    public final void a(int i) {
        this.a.b = i;
    }

    public final void a(int i, float f, int i2) {
        this.a.b = i;
        if (!(this.a.a.b[i].getChildFragmentManager().getBackStackEntryCount() > 0)) {
            this.a.a(aj.a(i), false, null);
        }
    }

    public final void b(int i) {
    }
}
