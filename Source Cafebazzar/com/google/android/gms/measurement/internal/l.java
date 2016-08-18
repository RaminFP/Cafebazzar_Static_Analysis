package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.av;

abstract class l {
    private static volatile Handler c;
    volatile long a;
    private final ap b;
    private final Runnable d = new m(this);
    private boolean e = true;

    l(ap apVar) {
        av.a((Object) apVar);
        this.b = apVar;
    }

    private Handler c() {
        if (c != null) {
            return c;
        }
        Handler handler;
        synchronized (l.class) {
            try {
                if (c == null) {
                    c = new Handler(this.b.a.getMainLooper());
                }
                handler = c;
            } catch (Throwable th) {
                Class cls = l.class;
            }
        }
        return handler;
    }

    public abstract void a();

    public final void a(long j) {
        b();
        if (j >= 0) {
            this.a = this.b.d.a();
            if (!c().postDelayed(this.d, j)) {
                this.b.e().a.a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void b() {
        this.a = 0;
        c().removeCallbacks(this.d);
    }
}
