package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class bt extends bs {
    bt() {
    }

    public final int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    final long a() {
        return ValueAnimator.getFrameDelay();
    }

    public final void a(View view, float f) {
        view.setTranslationX(f);
    }

    public final void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public void a(View view, Paint paint) {
        a(view, view.getLayerType(), paint);
        view.invalidate();
    }

    public final void a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public final void b(View view, float f) {
        view.setTranslationY(f);
    }

    public final void b(View view, boolean z) {
        view.setActivated(z);
    }

    public final void c(View view, float f) {
        view.setAlpha(f);
    }

    public final void d(View view, float f) {
        view.setScaleY(f);
    }

    public void d(View view, int i) {
        view.offsetLeftAndRight(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ce.a((View) parent);
        }
    }

    public void e(View view, int i) {
        view.offsetTopAndBottom(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ce.a((View) parent);
        }
    }

    public final float f(View view) {
        return view.getAlpha();
    }

    public final int g(View view) {
        return view.getLayerType();
    }

    public final int j(View view) {
        return view.getMeasuredWidthAndState();
    }

    public final int k(View view) {
        return view.getMeasuredState();
    }

    public final float o(View view) {
        return view.getTranslationX();
    }

    public final float p(View view) {
        return view.getTranslationY();
    }

    public final void x(View view) {
        view.jumpDrawablesToCurrentState();
    }
}
