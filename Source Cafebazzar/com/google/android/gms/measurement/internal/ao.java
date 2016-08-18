package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.av;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

final class ao extends Thread {
    final /* synthetic */ al a;
    private final Object b = new Object();
    private final BlockingQueue c;

    public ao(al alVar, String str, BlockingQueue blockingQueue) {
        this.a = alVar;
        av.a((Object) str);
        this.c = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.b) {
            this.b.notifyAll();
        }
    }

    public final void run() {
        while (true) {
            FutureTask futureTask = (FutureTask) this.c.poll();
            if (futureTask == null) {
                synchronized (this.b) {
                    if (this.c.peek() == null && !this.a.e) {
                        try {
                            this.b.wait(30000);
                        } catch (InterruptedException e) {
                            this.a.l().b.a(getName() + " was interrupted", e);
                        }
                    }
                }
                synchronized (this.a.c) {
                    if (this.c.peek() == null) {
                        break;
                    }
                }
            }
            futureTask.run();
        }
        this.a.d.release();
        this.a.c.notifyAll();
        if (this == this.a.a) {
            this.a.a = null;
        } else if (this == this.a.b) {
            this.a.b = null;
        } else {
            this.a.l().a.a("Current scheduler thread is neither worker nor network");
        }
    }
}
