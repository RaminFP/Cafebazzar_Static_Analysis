package com.viewpagerindicator;

final class i implements Runnable {
    final /* synthetic */ UnderlinePageIndicator a;

    i(UnderlinePageIndicator underlinePageIndicator) {
        this.a = underlinePageIndicator;
    }

    public final void run() {
        if (this.a.e) {
            this.a.post(this.a.r);
        }
    }
}
