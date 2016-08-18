package android.support.v4.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class k implements AnimatorUpdateListener {
    final /* synthetic */ d a;
    final /* synthetic */ j b;

    k(j jVar, d dVar) {
        this.b = jVar;
        this.a = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.onAnimationUpdate(this.b);
    }
}
