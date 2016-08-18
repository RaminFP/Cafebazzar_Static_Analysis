package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class dt extends AnimatorListenerAdapter {
    final /* synthetic */ dy a;
    final /* synthetic */ View b;

    dt(dy dyVar, View view) {
        this.a = dyVar;
        this.b = view;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.onAnimationCancel(this.b);
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.onAnimationEnd(this.b);
    }

    public final void onAnimationStart(Animator animator) {
        this.a.onAnimationStart(this.b);
    }
}
