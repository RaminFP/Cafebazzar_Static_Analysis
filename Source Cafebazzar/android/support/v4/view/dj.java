package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class dj implements dr {
    WeakHashMap a = null;

    dj() {
    }

    private void d(di diVar, View view) {
        Runnable runnable = null;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        }
        if (runnable == null) {
            runnable = new dk(this, diVar, view, (byte) 0);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public void a(di diVar, View view) {
        d(diVar, view);
    }

    public void a(di diVar, View view, float f) {
        d(diVar, view);
    }

    public void a(di diVar, View view, dy dyVar) {
        view.setTag(2113929216, dyVar);
    }

    public void a(View view, long j) {
    }

    public void a(View view, ea eaVar) {
    }

    public void a(View view, Interpolator interpolator) {
    }

    public void b(di diVar, View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
        c(diVar, view);
    }

    public void b(di diVar, View view, float f) {
        d(diVar, view);
    }

    void c(di diVar, View view) {
        Object tag = view.getTag(2113929216);
        dy dyVar = tag instanceof dy ? (dy) tag : null;
        Runnable a = diVar.c;
        Runnable b = diVar.d;
        diVar.c = null;
        diVar.d = null;
        if (a != null) {
            a.run();
        }
        if (dyVar != null) {
            dyVar.onAnimationStart(view);
            dyVar.onAnimationEnd(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    public void c(di diVar, View view, float f) {
        d(diVar, view);
    }

    public void d(di diVar, View view, float f) {
        d(diVar, view);
    }
}
