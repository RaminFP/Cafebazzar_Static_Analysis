package com.farsitel.bazaar.a.a;

final class b extends Thread {
    b() {
    }

    public final void run() {
        try {
            Thread.sleep(3000);
            a.a.post(new c(this));
        } catch (InterruptedException e) {
        }
    }
}
