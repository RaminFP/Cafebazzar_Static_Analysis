package com.c.b;

final class an implements Runnable {
    final /* synthetic */ Exception a;
    final /* synthetic */ am b;

    an(am amVar, Exception exception) {
        this.b = amVar;
        this.a = exception;
    }

    public final void run() {
        throw new RuntimeException(this.a);
    }
}
