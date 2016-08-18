package com.a.a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

final class p {
    final ScheduledExecutorService a;
    final List b = new ArrayList();
    volatile boolean c = true;
    final AtomicReference d = new AtomicReference();
    boolean e = true;

    public p(ScheduledExecutorService scheduledExecutorService) {
        this.a = scheduledExecutorService;
    }
}
