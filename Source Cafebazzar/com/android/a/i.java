package com.android.a;

final class i implements Runnable {
    final /* synthetic */ g a;
    private final o b;
    private final s c;
    private final Runnable d;

    public i(g gVar, o oVar, s sVar, Runnable runnable) {
        this.a = gVar;
        this.b = oVar;
        this.c = sVar;
        this.d = runnable;
    }

    public final void run() {
        if (this.b.h) {
            this.b.b("canceled-at-delivery");
            return;
        }
        if ((this.c.c == null ? 1 : null) != null) {
            this.b.a(this.c.a);
        } else {
            o oVar = this.b;
            y yVar = this.c.c;
            if (oVar.d != null) {
                oVar.d.a(yVar);
            }
        }
        if (this.c.d) {
            this.b.a("intermediate-response");
        } else {
            this.b.b("done");
        }
        if (this.d != null) {
            this.d.run();
        }
    }
}
