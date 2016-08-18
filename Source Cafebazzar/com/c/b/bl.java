package com.c.b;

import android.os.Process;

final class bl extends Thread {
    public bl(Runnable runnable) {
        super(runnable);
    }

    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
