package com.b.b;

import java.util.Timer;

final class ae {
    private Timer a;
    private af b;
    private ag c;

    ae(ag agVar) {
        this.c = agVar;
    }

    public final void a() {
        synchronized (this) {
            if (this.a != null) {
                this.a.cancel();
                this.a = null;
            }
            this.b = null;
        }
    }

    public final void a(long j) {
        synchronized (this) {
            if (b()) {
                a();
            }
            this.a = new Timer("FlurrySessionTimer");
            this.b = new af(this, this.c);
            this.a.schedule(this.b, j);
        }
    }

    public final boolean b() {
        return this.a != null;
    }
}
