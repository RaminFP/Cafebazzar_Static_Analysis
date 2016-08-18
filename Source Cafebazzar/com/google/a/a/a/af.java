package com.google.a.a.a;

import java.util.TimerTask;

final class af extends TimerTask {
    final /* synthetic */ aa a;

    private af(aa aaVar) {
        this.a = aaVar;
    }

    public final void run() {
        if (this.a.b == ae.b && this.a.c.isEmpty() && this.a.a + this.a.f < this.a.e.a()) {
            as.c("Disconnecting due to inactivity");
            this.a.i();
            return;
        }
        this.a.d.schedule(new af(this.a), this.a.f);
    }
}
