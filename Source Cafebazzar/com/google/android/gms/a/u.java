package com.google.android.gms.a;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class u extends p {
    private final Object a;
    protected final v b;
    private final CountDownLatch c;
    private final ArrayList d;
    private s e;
    private volatile r f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    private ag j;

    public static void b(r rVar) {
        if (!(rVar instanceof q)) {
        }
    }

    private void c(r rVar) {
        this.f = rVar;
        this.j = null;
        this.c.countDown();
        this.f.a();
        if (this.e != null) {
            this.b.removeMessages(2);
            if (!this.h) {
                this.b.a(this.e, f());
            }
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.d.clear();
    }

    private r f() {
        r rVar;
        boolean z = true;
        synchronized (this.a) {
            if (this.g) {
                z = false;
            }
            av.a(z, (Object) "Result has already been consumed.");
            av.a(a(), (Object) "Result is not ready.");
            rVar = this.f;
            this.f = null;
            this.e = null;
            this.g = true;
        }
        c_();
        return rVar;
    }

    public final void a(r rVar) {
        boolean z = true;
        synchronized (this.a) {
            if (this.i || this.h) {
                b(rVar);
                return;
            }
            av.a(!a(), (Object) "Results have already been set");
            if (this.g) {
                z = false;
            }
            av.a(z, (Object) "Result has already been consumed");
            c(rVar);
        }
    }

    public final boolean a() {
        return this.c.getCount() == 0;
    }

    public final void b(Status status) {
        synchronized (this.a) {
            if (!a()) {
                a(b_());
                this.i = true;
            }
        }
    }

    protected abstract r b_();

    protected void c_() {
    }
}
