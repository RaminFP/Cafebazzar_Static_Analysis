package com.b.b;

import java.util.concurrent.ThreadFactory;

public final class bi implements ThreadFactory {
    private final ThreadGroup a;
    private final int b = 1;

    public bi(String str, int i) {
        this.a = new ThreadGroup(str);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.a, runnable);
        thread.setName(this.a.getName() + ":" + thread.getId());
        thread.setPriority(this.b);
        return thread;
    }
}
