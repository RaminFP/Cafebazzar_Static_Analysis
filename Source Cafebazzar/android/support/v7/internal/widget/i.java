package android.support.v7.internal.widget;

import android.support.v4.view.dz;
import android.view.View;

final class i extends dz {
    final /* synthetic */ ActionBarOverlayLayout a;

    i(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void onAnimationCancel(View view) {
        this.a.z = null;
        this.a.m = false;
    }

    public final void onAnimationEnd(View view) {
        this.a.z = null;
        this.a.m = false;
    }
}
