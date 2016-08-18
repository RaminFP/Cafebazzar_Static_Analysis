package android.support.v4.view;

import android.view.View;

class bw extends bu {
    bw() {
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public final void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public final void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public void c(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public final boolean c(View view) {
        return view.hasTransientState();
    }

    public final void d(View view) {
        view.postInvalidateOnAnimation();
    }

    public final int e(View view) {
        return view.getImportantForAccessibility();
    }

    public final boolean n(View view) {
        return view.hasOverlappingRendering();
    }

    public final int q(View view) {
        return view.getMinimumWidth();
    }

    public final int r(View view) {
        return view.getMinimumHeight();
    }

    public void u(View view) {
        view.requestFitSystemWindows();
    }

    public final boolean w(View view) {
        return view.getFitsSystemWindows();
    }
}
