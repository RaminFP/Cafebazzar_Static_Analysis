package com.google.android.gms.measurement.internal;

import android.os.Looper;

final class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.a.b.f().a(this);
            return;
        }
        Object obj = this.a.a != 0 ? 1 : null;
        this.a.a = 0;
        if (obj != null && this.a.e) {
            this.a.a();
        }
    }
}
