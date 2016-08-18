package com.a.a.c;

import b.a.a.a.f;
import java.util.concurrent.Callable;

final class x implements Callable {
    final /* synthetic */ Callable a;
    final /* synthetic */ v b;

    x(v vVar, Callable callable) {
        this.b = vVar;
        this.a = callable;
    }

    public final Object call() {
        try {
            return this.a.call();
        } catch (Throwable e) {
            f.a().c("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
