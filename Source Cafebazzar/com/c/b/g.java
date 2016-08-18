package com.c.b;

final class g implements Runnable {
    final /* synthetic */ bg a;
    final /* synthetic */ RuntimeException b;

    g(bg bgVar, RuntimeException runtimeException) {
        this.a = bgVar;
        this.b = runtimeException;
    }

    public final void run() {
        throw new RuntimeException("Transformation " + this.a.a() + " crashed with exception.", this.b);
    }
}
