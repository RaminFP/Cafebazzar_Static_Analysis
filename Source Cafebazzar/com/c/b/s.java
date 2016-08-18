package com.c.b;

import android.os.Message;

final class s implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ r b;

    s(r rVar, Message message) {
        this.b = rVar;
        this.a = message;
    }

    public final void run() {
        throw new AssertionError("Unknown handler message received: " + this.a.what);
    }
}
