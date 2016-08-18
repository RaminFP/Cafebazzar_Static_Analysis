package android.support.v7.internal.view;

import android.support.v4.view.di;
import android.support.v4.view.dy;
import android.support.v4.view.dz;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class i {
    final ArrayList a = new ArrayList();
    dy b;
    boolean c;
    private long d = -1;
    private Interpolator e;
    private final dz f = new j(this);

    public final i a(long j) {
        if (!this.c) {
            this.d = 250;
        }
        return this;
    }

    public final i a(di diVar) {
        if (!this.c) {
            this.a.add(diVar);
        }
        return this;
    }

    public final i a(dy dyVar) {
        if (!this.c) {
            this.b = dyVar;
        }
        return this;
    }

    public final i a(Interpolator interpolator) {
        if (!this.c) {
            this.e = interpolator;
        }
        return this;
    }

    public final void a() {
        if (!this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                di diVar = (di) it.next();
                if (this.d >= 0) {
                    diVar.a(this.d);
                }
                if (this.e != null) {
                    diVar.a(this.e);
                }
                if (this.b != null) {
                    diVar.a(this.f);
                }
                diVar.b();
            }
            this.c = true;
        }
    }

    public final void b() {
        if (this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((di) it.next()).a();
            }
            this.c = false;
        }
    }
}
