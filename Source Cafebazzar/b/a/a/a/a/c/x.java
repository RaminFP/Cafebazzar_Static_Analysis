package b.a.a.a.a.c;

import java.util.concurrent.ThreadFactory;

public final class x implements ThreadFactory {
    private final int a = 10;

    public x(int i) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.a);
        thread.setName("Queue");
        return thread;
    }
}
