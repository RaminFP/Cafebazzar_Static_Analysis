package com.google.android.gms.measurement.internal;

abstract class ba extends az {
    private boolean a;
    private boolean b;
    boolean i;

    ba(ap apVar) {
        super(apVar);
        ap apVar2 = this.h;
        apVar2.f++;
    }

    protected abstract void a();

    final boolean t() {
        return this.a && !this.b;
    }

    protected final void u() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        a();
        ap apVar = this.h;
        apVar.g++;
        this.a = true;
    }
}
