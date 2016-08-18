package b.a.a.a.a.c;

import android.support.v4.app.NotificationCompat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a {
    private static final int a;
    public static final Executor b = new ThreadPoolExecutor(f, g, 1, TimeUnit.SECONDS, i, h);
    public static final Executor c = new h();
    private static final int f;
    private static final int g = ((a << 1) + 1);
    private static final ThreadFactory h = new b();
    private static final BlockingQueue i = new LinkedBlockingQueue(NotificationCompat.FLAG_HIGH_PRIORITY);
    private static final g j = new g();
    private static volatile Executor k = c;
    volatile int d = j.a;
    public final AtomicBoolean e = new AtomicBoolean();
    private final k l = new c(this);
    private final FutureTask m = new d(this, this.l);
    private final AtomicBoolean n = new AtomicBoolean();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        f = availableProcessors + 1;
    }

    static /* synthetic */ void b(a aVar, Object obj) {
        if (!aVar.n.get()) {
            aVar.d(obj);
        }
    }

    static /* synthetic */ void c(a aVar, Object obj) {
        if (aVar.e.get()) {
            aVar.b(obj);
        } else {
            aVar.a(obj);
        }
        aVar.d = j.c;
    }

    private Object d(Object obj) {
        j.obtainMessage(1, new f(this, obj)).sendToTarget();
        return obj;
    }

    protected static void p_() {
    }

    public final a a(Executor executor, Object... objArr) {
        if (this.d != j.a) {
            switch (e.a[this.d - 1]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.d = j.b;
        b();
        this.l.b = objArr;
        executor.execute(this.m);
        return this;
    }

    public abstract Object a(Object... objArr);

    public void a(Object obj) {
    }

    public final boolean a(boolean z) {
        this.e.set(true);
        return this.m.cancel(true);
    }

    public void b() {
    }

    public void b(Object obj) {
    }
}
