package com.a.a.c;

import b.a.a.a.f;
import java.util.concurrent.Callable;

final class j implements Callable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ Object call() {
        this.a.v.a();
        f.a().a("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
