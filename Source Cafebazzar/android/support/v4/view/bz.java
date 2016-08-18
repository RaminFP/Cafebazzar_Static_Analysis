package android.support.v4.view;

import android.view.View;

class bz extends by {
    bz() {
    }

    public final boolean A(View view) {
        return view.isAttachedToWindow();
    }

    public final void c(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public final boolean z(View view) {
        return view.isLaidOut();
    }
}
