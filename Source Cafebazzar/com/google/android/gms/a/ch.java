package com.google.android.gms.a;

import com.google.android.gms.common.internal.av;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ch implements ThreadFactory {
    private final String a;
    private final int b;
    private final AtomicInteger c;
    private final ThreadFactory d;

    public ch(String str) {
        this(str, 0);
    }

    private ch(String str, int i) {
        this.c = new AtomicInteger();
        this.d = Executors.defaultThreadFactory();
        this.a = (String) av.a((Object) str, (Object) "Name must not be null");
        this.b = 0;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.d.newThread(new ci(runnable, this.b));
        newThread.setName(this.a + "[" + this.c.getAndIncrement() + "]");
        return newThread;
    }
}
