package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

final class dm implements dy {
    di a;
    boolean b;

    dm(di diVar) {
        this.a = diVar;
    }

    public final void onAnimationCancel(View view) {
        Object tag = view.getTag(2113929216);
        dy dyVar = tag instanceof dy ? (dy) tag : null;
        if (dyVar != null) {
            dyVar.onAnimationCancel(view);
        }
    }

    public final void onAnimationEnd(View view) {
        if (this.a.e >= 0) {
            bp.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            if (this.a.d != null) {
                Runnable b = this.a.d;
                this.a.d = null;
                b.run();
            }
            Object tag = view.getTag(2113929216);
            dy dyVar = tag instanceof dy ? (dy) tag : null;
            if (dyVar != null) {
                dyVar.onAnimationEnd(view);
            }
            this.b = true;
        }
    }

    public final void onAnimationStart(View view) {
        this.b = false;
        if (this.a.e >= 0) {
            bp.a(view, 2, null);
        }
        if (this.a.c != null) {
            Runnable a = this.a.c;
            this.a.c = null;
            a.run();
        }
        Object tag = view.getTag(2113929216);
        dy dyVar = tag instanceof dy ? (dy) tag : null;
        if (dyVar != null) {
            dyVar.onAnimationStart(view);
        }
    }
}
