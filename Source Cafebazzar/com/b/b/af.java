package com.b.b;

import java.util.TimerTask;

final class af extends TimerTask {
    final /* synthetic */ ae a;
    private ag b;

    af(ae aeVar, ag agVar) {
        this.a = aeVar;
        this.b = agVar;
    }

    public final void run() {
        this.a.a();
        if (this.b != null) {
            this.b.e();
        }
    }
}
