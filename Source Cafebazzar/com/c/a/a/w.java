package com.c.a.a;

import java.util.concurrent.ThreadFactory;

final class w implements ThreadFactory {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;

    w(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a);
        thread.setDaemon(this.b);
        return thread;
    }
}
