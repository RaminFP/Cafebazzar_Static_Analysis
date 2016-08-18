package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.f.r;
import android.util.Log;

public final class f {
    private final long a;
    private final int b;
    private final r c;

    public f() {
        this.a = 60000;
        this.b = 10;
        this.c = new r(10);
    }

    public f(int i, long j) {
        this.a = j;
        this.b = 1024;
        this.c = new r();
    }

    public final Long a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.a;
        synchronized (this) {
            long j2 = j;
            while (this.c.size() >= this.b) {
                for (int size = this.c.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - ((Long) this.c.c(size)).longValue() > j2) {
                        this.c.d(size);
                    }
                }
                j = j2 / 2;
                Log.w("ConnectionTracker", "The max capacity " + this.b + " is not enough. Current durationThreshold is: " + j);
                j2 = j;
            }
            l = (Long) this.c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public final boolean b(String str) {
        boolean z;
        synchronized (this) {
            z = this.c.remove(str) != null;
        }
        return z;
    }
}
