package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.widget.ah;

final class f implements ah {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void a(int i) {
        int currentPosition;
        boolean b = BazaarApplication.c().b();
        if (this.a.L.getVisibility() == 0) {
            currentPosition = this.a.L.getCurrentPosition();
            this.a.K.setCurrentTab(currentPosition);
        } else {
            currentPosition = this.a.K.getCurrentPosition();
            this.a.L.setCurrentTab(currentPosition);
        }
        if (i != currentPosition) {
            if ((i == 0 && !b) || (i == 2 && b)) {
                a.p(this.a);
            } else if ((i == 1 && !b) || (i == 1 && b)) {
                a.q(this.a);
            } else if ((i == 2 && !b) || (i == 0 && b)) {
                a.a(this.a, true);
            }
            this.a.K.setCurrentTab(i);
            this.a.L.setCurrentTab(i);
        } else if ((i == 0 && !b) || (i == 2 && b)) {
            this.a.v.a(0, 0);
        } else if ((i == 1 && !b) || (i == 1 && b)) {
            this.a.w.smoothScrollToPosition(0);
        } else if ((i == 2 && !b) || (i == 0 && b)) {
            this.a.x.a(0, 0);
        }
    }
}
