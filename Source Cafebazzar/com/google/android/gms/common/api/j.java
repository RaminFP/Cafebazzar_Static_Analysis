package com.google.android.gms.common.api;

import com.google.android.gms.a.bi;

final class j implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ i b;

    j(i iVar, h hVar) {
        this.b = iVar;
        this.a = hVar;
    }

    public final void run() {
        if (!this.b.d.isFinishing() && !this.b.d.getSupportFragmentManager().isDestroyed()) {
            this.b.a(bi.b(this.b.d), this.a);
        }
    }
}
