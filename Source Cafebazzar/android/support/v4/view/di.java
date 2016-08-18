package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class di {
    public static final dr b;
    public WeakReference a;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            b = new dq();
        } else if (i >= 19) {
            b = new dp();
        } else if (i >= 18) {
            b = new dn();
        } else if (i >= 16) {
            b = new do();
        } else if (i >= 14) {
            b = new dl();
        } else {
            b = new dj();
        }
    }

    di(View view) {
        this.a = new WeakReference(view);
    }

    public final di a(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, f);
        }
        return this;
    }

    public final di a(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, j);
        }
        return this;
    }

    public final di a(dy dyVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, dyVar);
        }
        return this;
    }

    public final di a(ea eaVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, eaVar);
        }
        return this;
    }

    public final di a(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, interpolator);
        }
        return this;
    }

    public final void a() {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view);
        }
    }

    public final di b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view, f);
        }
        return this;
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view);
        }
    }

    public final di c(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.c(this, view, f);
        }
        return this;
    }
}
