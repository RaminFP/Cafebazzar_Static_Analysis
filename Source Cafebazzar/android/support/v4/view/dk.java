package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

final class dk implements Runnable {
    WeakReference a;
    di b;
    final /* synthetic */ dj c;

    private dk(dj djVar, di diVar, View view) {
        this.c = djVar;
        this.a = new WeakReference(view);
        this.b = diVar;
    }

    public final void run() {
        View view = (View) this.a.get();
        if (view != null) {
            this.c.c(this.b, view);
        }
    }
}
