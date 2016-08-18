package com.google.android.gms.a;

import com.google.android.gms.clearcut.d;
import com.google.android.gms.common.api.h;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class g implements d {
    private static final Object a = new Object();
    private static final k b = new k();
    private static final long c = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private final bz d;
    private final i e;
    private final Object f;
    private long g;
    private final long h;
    private ScheduledFuture i;
    private h j;
    private final Runnable k;

    public g() {
        this(new ca(), c, new j());
    }

    private g(bz bzVar, long j, i iVar) {
        this.f = new Object();
        this.g = 0;
        this.i = null;
        this.j = null;
        this.k = new h(this);
        this.d = bzVar;
        this.h = j;
        this.e = iVar;
    }
}
