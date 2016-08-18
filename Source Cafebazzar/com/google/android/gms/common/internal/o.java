package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class o {
    private Object a;
    private boolean b = false;
    final /* synthetic */ l d;

    public o(l lVar, Object obj) {
        this.d = lVar;
        this.a = obj;
    }

    protected abstract void a(Object obj);

    public final void b() {
        synchronized (this) {
            Object obj = this.a;
            if (this.b) {
                Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.b = true;
        }
        c();
    }

    public final void c() {
        d();
        synchronized (this.d.m) {
            this.d.m.remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }
}
