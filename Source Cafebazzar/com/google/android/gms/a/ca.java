package com.google.android.gms.a;

import android.os.SystemClock;

public final class ca implements bz {
    private static ca a;

    public static bz c() {
        synchronized (ca.class) {
            try {
                if (a == null) {
                    a = new ca();
                }
                bz bzVar = a;
                return bzVar;
            } finally {
                Object obj = ca.class;
            }
        }
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }
}
