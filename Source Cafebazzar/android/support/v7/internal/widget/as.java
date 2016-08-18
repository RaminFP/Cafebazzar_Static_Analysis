package android.support.v7.internal.widget;

import android.view.View;

final class as implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ ar b;

    as(ar arVar, View view) {
        this.b = arVar;
        this.a = view;
    }

    public final void run() {
        this.b.smoothScrollTo(this.a.getLeft() - ((this.b.getWidth() - this.a.getWidth()) / 2), 0);
        this.b.a = null;
    }
}
