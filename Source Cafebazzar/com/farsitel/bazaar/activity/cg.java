package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.widget.au;

final class cg implements au {
    final /* synthetic */ ScreenshotActivity a;

    cg(ScreenshotActivity screenshotActivity) {
        this.a = screenshotActivity;
    }

    public final void a(int i) {
        if (!this.a.a) {
            if (i == this.a.c.getCount() - 1 && this.a.g.getVisibility() == 0) {
                this.a.h.startAnimation(this.a.j);
                this.a.h.setVisibility(8);
            } else if (i == 0 && this.a.g.getVisibility() == 0) {
                this.a.g.startAnimation(this.a.k);
                this.a.g.setVisibility(8);
            } else if (this.a.g.getVisibility() == 8) {
                this.a.g.setVisibility(0);
                this.a.g.startAnimation(this.a.l);
            } else if (this.a.h.getVisibility() == 8) {
                this.a.h.setVisibility(0);
                this.a.h.startAnimation(this.a.m);
            }
        }
    }

    public final void a(int i, float f, int i2) {
    }

    public final void b(int i) {
    }
}
