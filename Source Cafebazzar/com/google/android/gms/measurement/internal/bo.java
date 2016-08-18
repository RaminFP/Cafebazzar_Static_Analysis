package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class bo implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ bm b;

    bo(bm bmVar, ComponentName componentName) {
        this.b = bmVar;
        this.a = componentName;
    }

    public final void run() {
        bg.a(this.b.c, this.a);
    }
}
