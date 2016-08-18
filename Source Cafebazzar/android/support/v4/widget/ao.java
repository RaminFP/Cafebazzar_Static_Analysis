package android.support.v4.widget;

import android.support.v4.view.bp;
import android.view.View;

final class ao implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    ao(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    public final void run() {
        if (this.a.getParent() == this.b) {
            bp.a(this.a, 0, null);
            this.b.a(this.a);
        }
        this.b.u.remove(this);
    }
}
