package com.farsitel.bazaar.util;

public final class ai implements Runnable {
    final /* synthetic */ ah a;

    public ai(ah ahVar) {
        this.a = ahVar;
    }

    public final void run() {
        while (this.a.c && System.currentTimeMillis() - this.a.d < 15000) {
            try {
                Thread.sleep(20);
                if (this.a.a != null) {
                    this.a.a.sendEmptyMessage(0);
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
