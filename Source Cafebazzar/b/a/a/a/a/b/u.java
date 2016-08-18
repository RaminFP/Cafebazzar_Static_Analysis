package b.a.a.a.a.b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class u implements ThreadFactory {
    final /* synthetic */ String a;
    final /* synthetic */ AtomicLong b;

    u(String str, AtomicLong atomicLong) {
        this.a = str;
        this.b = atomicLong;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new v(this, runnable));
        newThread.setName(this.a + this.b.getAndIncrement());
        return newThread;
    }
}
