package android.support.v7.internal.widget;

import android.support.v4.view.bp;

final class k implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    k(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void run() {
        this.a.i();
        this.a.y = bp.r(this.a.g).c((float) (-this.a.g.getHeight())).a(this.a.A);
        if (this.a.f != null && this.a.f.getVisibility() != 8) {
            this.a.z = bp.r(this.a.f).c((float) this.a.f.getHeight()).a(this.a.B);
        }
    }
}
