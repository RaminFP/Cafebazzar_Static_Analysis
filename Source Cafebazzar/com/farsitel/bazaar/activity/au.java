package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.f.a.a;

final class au implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;
    final /* synthetic */ am d;

    au(am amVar, int i, String str, a aVar) {
        this.d = amVar;
        this.a = i;
        this.b = str;
        this.c = aVar;
    }

    public final void run() {
        this.d.e();
        if (this.d.j != null) {
            this.d.j.setVisibility(0);
            this.d.j.a(this.a, new av(this), this.c);
        }
    }
}
