package b.a.a.a.a.c;

import java.util.LinkedList;
import java.util.concurrent.Executor;

final class h implements Executor {
    final LinkedList a;
    Runnable b;

    private h() {
        this.a = new LinkedList();
    }

    protected final void a() {
        synchronized (this) {
            Runnable runnable = (Runnable) this.a.poll();
            this.b = runnable;
            if (runnable != null) {
                a.b.execute(this.b);
            }
        }
    }

    public final void execute(Runnable runnable) {
        synchronized (this) {
            this.a.offer(new i(this, runnable));
            if (this.b == null) {
                a();
            }
        }
    }
}
