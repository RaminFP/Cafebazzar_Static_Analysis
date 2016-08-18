package com.b.b;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class at {
    private static at c;
    final UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    final Map b = new WeakHashMap();

    private at() {
        Thread.setDefaultUncaughtExceptionHandler(new au());
    }

    public static at a() {
        synchronized (at.class) {
            try {
                if (c == null) {
                    c = new at();
                }
                at atVar = c;
                return atVar;
            } finally {
                Object obj = at.class;
            }
        }
    }

    Set b() {
        Set keySet;
        synchronized (this.b) {
            keySet = this.b.keySet();
        }
        return keySet;
    }
}
