package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.av;
import java.util.concurrent.FutureTask;

final class am extends FutureTask {
    final /* synthetic */ al a;
    private final String b;

    am(al alVar, Runnable runnable, String str) {
        this.a = alVar;
        super(runnable, null);
        av.a((Object) str);
        this.b = str;
    }

    protected final void setException(Throwable th) {
        this.a.l().a.a(this.b, th);
        super.setException(th);
    }
}
