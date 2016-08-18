package com.android.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class aa {
    public static final boolean a = z.b;
    private final List b = new ArrayList();
    private boolean c = false;

    aa() {
    }

    public final void a(String str) {
        synchronized (this) {
            long j;
            this.c = true;
            if (this.b.size() == 0) {
                j = 0;
            } else {
                j = ((ab) this.b.get(this.b.size() - 1)).c - ((ab) this.b.get(0)).c;
            }
            if (j > 0) {
                long j2 = ((ab) this.b.get(0)).c;
                z.b("(%-4d ms) %s", Long.valueOf(j), str);
                j = j2;
                for (ab abVar : this.b) {
                    z.b("(+%-4d) [%2d] %s", Long.valueOf(abVar.c - j), Long.valueOf(abVar.b), abVar.a);
                    j = abVar.c;
                }
            }
        }
    }

    public final void a(String str, long j) {
        synchronized (this) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new ab(str, j, SystemClock.elapsedRealtime()));
        }
    }

    protected final void finalize() {
        if (!this.c) {
            a("Request on the loose");
            z.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
