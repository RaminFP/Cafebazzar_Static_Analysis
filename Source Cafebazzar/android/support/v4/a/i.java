package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class i implements AnimatorListener {
    final b a;
    final l b;

    public i(b bVar, l lVar) {
        this.a = bVar;
        this.b = lVar;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.onAnimationCancel(this.b);
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.onAnimationEnd(this.b);
    }

    public final void onAnimationRepeat(Animator animator) {
        this.a.onAnimationRepeat(this.b);
    }

    public final void onAnimationStart(Animator animator) {
        this.a.onAnimationStart(this.b);
    }
}
