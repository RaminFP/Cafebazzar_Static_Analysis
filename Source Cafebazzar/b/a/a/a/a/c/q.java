package b.a.a.a.a.c;

import java.util.concurrent.Executor;

final class q implements Executor {
    private final Executor a;
    private final p b;

    public q(Executor executor, p pVar) {
        this.a = executor;
        this.b = pVar;
    }

    public final void execute(Runnable runnable) {
        this.a.execute(new r(this, runnable, null));
    }
}
