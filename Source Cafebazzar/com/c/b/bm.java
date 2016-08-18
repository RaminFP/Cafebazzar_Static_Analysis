package com.c.b;

import java.util.concurrent.ThreadFactory;

final class bm implements ThreadFactory {
    bm() {
    }

    public final Thread newThread(Runnable runnable) {
        return new bl(runnable);
    }
}
