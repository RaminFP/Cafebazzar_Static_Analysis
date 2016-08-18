package b.a.a.a.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class w extends ThreadPoolExecutor {
    private static final int a;
    private static final int b;
    private static final int c = ((a << 1) + 1);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = availableProcessors + 1;
    }

    private w(int i, int i2, long j, TimeUnit timeUnit, m mVar, ThreadFactory threadFactory) {
        super(i, i2, 1, timeUnit, mVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static w a() {
        return new w(b, c, 1, TimeUnit.SECONDS, new m(), new x(10));
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        y yVar = (y) runnable;
        yVar.b(true);
        yVar.a(th);
        ((m) super.getQueue()).a();
        super.afterExecute(runnable, th);
    }

    public final void execute(Runnable runnable) {
        if (v.a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    public final /* bridge */ /* synthetic */ BlockingQueue getQueue() {
        return (m) super.getQueue();
    }

    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new t(runnable, obj);
    }

    protected final RunnableFuture newTaskFor(Callable callable) {
        return new t(callable);
    }
}
