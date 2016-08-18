package android.support.v7.internal.view;

import android.support.v4.view.dz;
import android.view.View;

final class j extends dz {
    final /* synthetic */ i a;
    private boolean b = false;
    private int c = 0;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onAnimationEnd(View view) {
        int i = this.c + 1;
        this.c = i;
        if (i == this.a.a.size()) {
            if (this.a.b != null) {
                this.a.b.onAnimationEnd(null);
            }
            this.c = 0;
            this.b = false;
            this.a.c = false;
        }
    }

    public final void onAnimationStart(View view) {
        if (!this.b) {
            this.b = true;
            if (this.a.b != null) {
                this.a.b.onAnimationStart(null);
            }
        }
    }
}
