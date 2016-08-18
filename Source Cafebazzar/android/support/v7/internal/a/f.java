package android.support.v7.internal.a;

import android.support.v4.view.bp;
import android.support.v4.view.dz;
import android.view.View;

final class f extends dz {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationEnd(View view) {
        if (this.a.C && this.a.s != null) {
            bp.b(this.a.s, 0.0f);
            bp.b(this.a.o, 0.0f);
        }
        if (this.a.r != null && this.a.z == 1) {
            this.a.r.setVisibility(8);
        }
        this.a.o.setVisibility(8);
        this.a.o.setTransitioning(false);
        this.a.H = null;
        e eVar = this.a;
        if (eVar.c != null) {
            eVar.c.a(eVar.b);
            eVar.b = null;
            eVar.c = null;
        }
        if (this.a.n != null) {
            bp.u(this.a.n);
        }
    }
}
