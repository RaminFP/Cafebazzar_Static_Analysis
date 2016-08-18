package com.a.a.c;

import java.util.concurrent.CountDownLatch;

final class u {
    boolean a;
    final CountDownLatch b;

    private u() {
        this.a = false;
        this.b = new CountDownLatch(1);
    }

    final void a(boolean z) {
        this.a = z;
        this.b.countDown();
    }
}
