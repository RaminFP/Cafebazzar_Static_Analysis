package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class dx implements AnimatorUpdateListener {
    final /* synthetic */ ea a;
    final /* synthetic */ View b;

    dx(ea eaVar, View view) {
        this.a = eaVar;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
