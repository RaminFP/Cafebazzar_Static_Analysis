package com.c.b;

import android.os.Message;

final class be implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ bd b;

    be(bd bdVar, Message message) {
        this.b = bdVar;
        this.a = message;
    }

    public final void run() {
        throw new AssertionError("Unhandled stats message." + this.a.what);
    }
}
