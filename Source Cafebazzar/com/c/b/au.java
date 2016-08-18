package com.c.b;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class au extends ThreadPoolExecutor {
    au() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new bm());
    }

    void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public final Future submit(Runnable runnable) {
        Object avVar = new av((d) runnable);
        execute(avVar);
        return avVar;
    }
}
