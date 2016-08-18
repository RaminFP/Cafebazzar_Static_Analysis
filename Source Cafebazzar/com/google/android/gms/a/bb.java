package com.google.android.gms.a;

abstract class bb {
    private final az a;

    protected bb(az azVar) {
        this.a = azVar;
    }

    protected abstract void a();

    public final void a(ba baVar) {
        baVar.a.lock();
        try {
            if (baVar.k == this.a) {
                a();
                baVar.a.unlock();
            }
        } finally {
            baVar.a.unlock();
        }
    }
}
