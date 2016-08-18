package android.support.v7.internal.a;

import android.support.v4.view.dz;
import android.view.View;

final class g extends dz {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationEnd(View view) {
        this.a.H = null;
        this.a.o.requestLayout();
    }
}
