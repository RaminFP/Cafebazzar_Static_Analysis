package android.support.v7.internal.widget;

import android.support.v4.view.di;
import android.support.v4.view.dy;
import android.view.View;

public final class b implements dy {
    int a;
    final /* synthetic */ a b;
    private boolean c = false;

    protected b(a aVar) {
        this.b = aVar;
    }

    public final b a(di diVar, int i) {
        this.b.i = diVar;
        this.a = i;
        return this;
    }

    public final void onAnimationCancel(View view) {
        this.c = true;
    }

    public final void onAnimationEnd(View view) {
        if (!this.c) {
            this.b.i = null;
            this.b.setVisibility(this.a);
            if (this.b.e != null && this.b.c != null) {
                this.b.c.setVisibility(this.a);
            }
        }
    }

    public final void onAnimationStart(View view) {
        this.b.setVisibility(0);
        this.c = false;
    }
}
