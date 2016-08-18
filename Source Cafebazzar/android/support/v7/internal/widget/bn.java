package android.support.v7.internal.widget;

import android.support.v4.view.dz;
import android.view.View;

final class bn extends dz {
    final /* synthetic */ bl a;
    private boolean b = false;

    bn(bl blVar) {
        this.a = blVar;
    }

    public final void onAnimationCancel(View view) {
        this.b = true;
    }

    public final void onAnimationEnd(View view) {
        if (!this.b) {
            this.a.a.setVisibility(8);
        }
    }
}
