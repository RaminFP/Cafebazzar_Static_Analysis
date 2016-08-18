package com.android.a;

final class e implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ d b;

    e(d dVar, o oVar) {
        this.b = dVar;
        this.a = oVar;
    }

    public final void run() {
        try {
            this.b.d.put(this.a);
        } catch (InterruptedException e) {
        }
    }
}
