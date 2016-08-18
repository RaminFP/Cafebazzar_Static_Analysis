package com.farsitel.bazaar.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class y implements OnGlobalLayoutListener {
    final /* synthetic */ HorizontalListView a;

    y(HorizontalListView horizontalListView) {
        this.a = horizontalListView;
    }

    public final void onGlobalLayout() {
        if (this.a.c.getWidth() != this.a.g) {
            if (this.a.c.getWidth() < 0) {
                this.a.fullScroll(66);
            } else {
                this.a.scrollBy(this.a.c.getWidth() - this.a.g, 0);
                this.a.g = this.a.c.getWidth();
            }
        }
        if (this.a.g - this.a.getWidth() <= 0 && this.a.c.getWidth() - this.a.getWidth() > 0) {
            this.a.setHorizontalScrollBarEnabled(true);
        }
        if (this.a.g - this.a.getWidth() > 0 && this.a.c.getWidth() - this.a.getWidth() <= 0) {
            this.a.setHorizontalScrollBarEnabled(false);
        }
    }
}
