package com.farsitel.bazaar.activity;

final class dv implements Runnable {
    final /* synthetic */ dp a;

    dv(dp dpVar) {
        this.a = dpVar;
    }

    public final void run() {
        if (this.a.f != null) {
            this.a.f.setVisibility(8);
        }
    }
}
