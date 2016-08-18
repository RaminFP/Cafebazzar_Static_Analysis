package com.google.android.gms.a;

import android.os.Process;

final class ci implements Runnable {
    private final Runnable a;
    private final int b;

    public ci(Runnable runnable, int i) {
        this.a = runnable;
        this.b = i;
    }

    public final void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
