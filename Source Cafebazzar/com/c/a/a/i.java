package com.c.a.a;

import d.ac;
import java.io.Closeable;

public final class i implements Closeable {
    public final String a;
    public final long b;
    public final ac[] c;
    public final /* synthetic */ b d;
    private final long[] e;

    private i(b bVar, String str, long j, ac[] acVarArr, long[] jArr) {
        this.d = bVar;
        this.a = str;
        this.b = j;
        this.c = acVarArr;
        this.e = jArr;
    }

    public final void close() {
        for (Closeable a : this.c) {
            v.a(a);
        }
    }
}
