package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

final class h implements c {
    private TimeInterpolator a;

    h() {
    }

    public final l a() {
        return new j(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public final void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }
}
