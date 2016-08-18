package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class f implements l {
    List a = new ArrayList();
    List b = new ArrayList();
    View c;
    long d;
    long e = 200;
    float f = 0.0f;
    Runnable g = new g(this);
    private boolean h = false;
    private boolean i = false;

    public final void a() {
        if (!this.h) {
            this.h = true;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ((b) this.a.get(size)).onAnimationStart(this);
            }
            this.f = 0.0f;
            this.d = this.c.getDrawingTime();
            this.c.postDelayed(this.g, 16);
        }
    }

    public final void a(long j) {
        if (!this.h) {
            this.e = j;
        }
    }

    public final void a(b bVar) {
        this.a.add(bVar);
    }

    public final void a(d dVar) {
        this.b.add(dVar);
    }

    public final void a(View view) {
        this.c = view;
    }

    void b() {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((b) this.a.get(size)).onAnimationEnd(this);
        }
    }

    public final void c() {
        if (!this.i) {
            this.i = true;
            if (this.h) {
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    ((b) this.a.get(size)).onAnimationCancel(this);
                }
            }
            b();
        }
    }

    public final float d() {
        return this.f;
    }
}
