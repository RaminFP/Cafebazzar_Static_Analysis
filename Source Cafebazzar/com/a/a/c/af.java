package com.a.a.c;

import b.a.a.a.f;
import com.a.a.c.a.a.d;
import java.util.concurrent.Callable;

final class af implements Callable {
    final /* synthetic */ ac a;

    af(ac acVar) {
        this.a = acVar;
    }

    public final /* synthetic */ Object call() {
        if (this.a.e.get()) {
            f.a().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE;
        }
        f.a().a("CrashlyticsCore", "Finalizing previously open sessions.");
        h e = this.a.g;
        d dVar = null;
        if (e.m != null) {
            dVar = e.m.a();
        }
        if (dVar != null) {
            ac.a(this.a, dVar);
        }
        this.a.a(true);
        f.a().a("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.TRUE;
    }
}
