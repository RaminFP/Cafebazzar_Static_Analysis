package android.support.v4.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

final class j implements l {
    final Animator a;

    public j(Animator animator) {
        this.a = animator;
    }

    public final void a() {
        this.a.start();
    }

    public final void a(long j) {
        this.a.setDuration(j);
    }

    public final void a(b bVar) {
        this.a.addListener(new i(bVar, this));
    }

    public final void a(d dVar) {
        if (this.a instanceof ValueAnimator) {
            ((ValueAnimator) this.a).addUpdateListener(new k(this, dVar));
        }
    }

    public final void a(View view) {
        this.a.setTarget(view);
    }

    public final void c() {
        this.a.cancel();
    }

    public final float d() {
        return ((ValueAnimator) this.a).getAnimatedFraction();
    }
}
