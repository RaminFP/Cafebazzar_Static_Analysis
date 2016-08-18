package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.av;
import java.lang.Thread.UncaughtExceptionHandler;

final class an implements UncaughtExceptionHandler {
    final /* synthetic */ al a;
    private final String b;

    public an(al alVar, String str) {
        this.a = alVar;
        av.a((Object) str);
        this.b = str;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            this.a.l().a.a(this.b, th);
        }
    }
}
