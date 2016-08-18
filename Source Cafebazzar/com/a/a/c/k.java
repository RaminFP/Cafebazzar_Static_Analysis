package com.a.a.c;

import b.a.a.a.f;
import java.util.concurrent.Callable;

final class k implements Callable {
    final /* synthetic */ h a;

    k(h hVar) {
        this.a = hVar;
    }

    private Boolean a() {
        try {
            boolean delete = this.a.v.b().delete();
            f.a().a("CrashlyticsCore", "Initialization marker file removed: " + delete);
            return Boolean.valueOf(delete);
        } catch (Throwable e) {
            f.a().c("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
            return Boolean.valueOf(false);
        }
    }

    public final /* synthetic */ Object call() {
        return a();
    }
}
