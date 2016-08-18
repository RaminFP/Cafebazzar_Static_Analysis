package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.f.a.a;

final class dw implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;
    final /* synthetic */ dp d;

    dw(dp dpVar, int i, String str, a aVar) {
        this.d = dpVar;
        this.a = i;
        this.b = str;
        this.c = aVar;
    }

    public final void run() {
        this.d.e();
        if (this.d.e != null) {
            this.d.e.setVisibility(0);
            this.d.e.a(this.a, new dx(this), this.c);
        }
    }
}
