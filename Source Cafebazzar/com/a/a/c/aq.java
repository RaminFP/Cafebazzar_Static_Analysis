package com.a.a.c;

import b.a.a.a.a.b.l;
import b.a.a.a.a.g.r;
import b.a.a.a.f;
import java.io.File;

final class aq implements Runnable {
    private final h a;
    private final File b;

    public aq(h hVar, File file) {
        this.a = hVar;
        this.b = file;
    }

    public final void run() {
        if (l.l(this.a.p)) {
            f.a().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            at a = this.a.a(r.a.a());
            if (a != null) {
                new by(a).a(new cc(this.b, ac.i));
            }
        }
    }
}
