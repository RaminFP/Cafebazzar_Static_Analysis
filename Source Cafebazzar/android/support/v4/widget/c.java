package android.support.v4.widget;

import android.support.v4.view.bp;
import android.view.animation.AnimationUtils;

final class c implements Runnable {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.o) {
            if (this.a.m) {
                this.a.m = false;
                b c = this.a.a;
                c.e = AnimationUtils.currentAnimationTimeMillis();
                c.i = -1;
                c.f = c.e;
                c.j = 0.5f;
                c.g = 0;
                c.h = 0;
            }
            b c2 = this.a.a;
            boolean z = c2.i > 0 && AnimationUtils.currentAnimationTimeMillis() > c2.i + ((long) c2.k);
            if (z || !this.a.a()) {
                this.a.o = false;
                return;
            }
            if (this.a.n) {
                this.a.n = false;
                a.f(this.a);
            }
            if (c2.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = c2.a(currentAnimationTimeMillis);
            a = (a * (-4.0f * a)) + (4.0f * a);
            long j = currentAnimationTimeMillis - c2.f;
            c2.f = currentAnimationTimeMillis;
            c2.g = (int) ((((float) j) * a) * c2.c);
            c2.h = (int) ((((float) j) * a) * c2.d);
            this.a.a(c2.h);
            bp.a(this.a.c, (Runnable) this);
        }
    }
}
