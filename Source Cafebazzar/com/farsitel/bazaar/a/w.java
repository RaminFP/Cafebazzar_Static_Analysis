package com.farsitel.bazaar.a;

final class w implements Runnable {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        this.a.a.c();
        this.a.a.notifyDataSetChanged();
        this.a.a.f.b();
    }
}
