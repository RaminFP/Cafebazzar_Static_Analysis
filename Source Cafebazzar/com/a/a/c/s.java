package com.a.a.c;

import b.a.a.a.f;
import java.util.concurrent.Callable;

final class s implements Callable {
    private final y a;

    public s(y yVar) {
        this.a = yVar;
    }

    public final /* synthetic */ Object call() {
        if (!this.a.b().exists()) {
            return Boolean.FALSE;
        }
        f.a().a("CrashlyticsCore", "Found previous crash marker.");
        this.a.b().delete();
        return Boolean.TRUE;
    }
}
