package b.a.a.a.a.b;

import android.os.Process;

public abstract class k implements Runnable {
    public abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
