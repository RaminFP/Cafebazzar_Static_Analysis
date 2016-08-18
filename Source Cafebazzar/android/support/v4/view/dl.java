package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class dl extends dj {
    WeakHashMap b = null;

    dl() {
    }

    public final void a(di diVar, View view) {
        view.animate().cancel();
    }

    public final void a(di diVar, View view, float f) {
        view.animate().alpha(f);
    }

    public void a(di diVar, View view, dy dyVar) {
        view.setTag(2113929216, dyVar);
        view.animate().setListener(new dt(new dm(diVar), view));
    }

    public final void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public final void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public final void b(di diVar, View view) {
        view.animate().start();
    }

    public final void b(di diVar, View view, float f) {
        view.animate().translationX(f);
    }

    public final void c(di diVar, View view, float f) {
        view.animate().translationY(f);
    }

    public final void d(di diVar, View view, float f) {
        view.animate().scaleY(f);
    }
}
