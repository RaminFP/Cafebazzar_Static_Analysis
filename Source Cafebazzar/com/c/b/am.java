package com.c.b;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

final class am extends Thread {
    private final ReferenceQueue a;
    private final Handler b;

    am(ReferenceQueue referenceQueue, Handler handler) {
        this.a = referenceQueue;
        this.b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b bVar = (b) this.a.remove(1000);
                Message obtainMessage = this.b.obtainMessage();
                if (bVar != null) {
                    obtainMessage.what = 3;
                    obtainMessage.obj = bVar.a;
                    this.b.sendMessage(obtainMessage);
                } else {
                    obtainMessage.recycle();
                }
            } catch (InterruptedException e) {
                return;
            } catch (Exception e2) {
                this.b.post(new an(this, e2));
                return;
            }
        }
    }
}
