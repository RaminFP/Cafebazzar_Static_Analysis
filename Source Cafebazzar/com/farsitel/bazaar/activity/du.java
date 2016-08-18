package com.farsitel.bazaar.activity;

final class du implements Runnable {
    final /* synthetic */ dp a;

    du(dp dpVar) {
        this.a = dpVar;
    }

    public final void run() {
        if (this.a.f != null) {
            this.a.f.setVisibility(0);
        }
    }
}
