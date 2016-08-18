package com.farsitel.bazaar.d;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class x implements OnScrollListener {
    final /* synthetic */ w a;
    private final int b = this.a.getResources().getInteger(2131296271);
    private int c = 0;
    private boolean d = false;

    x(w wVar) {
        this.a = wVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.a.b != null) {
            if (i3 <= 0 || i + i2 < i3) {
                this.a.a(false);
            } else if (!this.a.b.d() && this.a.b.getCount() > 0) {
                w.c(this.a);
            }
        }
        if (i > this.c) {
            w.c();
        } else if (i < this.c) {
            w.c();
        }
        this.c = i;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z = false;
        if (this.a.c) {
            if (i != 0) {
                z = true;
            }
            this.d = z;
            return;
        }
        this.d = false;
    }
}
