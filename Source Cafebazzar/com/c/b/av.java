package com.c.b;

import java.util.concurrent.FutureTask;

final class av extends FutureTask implements Comparable {
    private final d a;

    public av(d dVar) {
        super(dVar, null);
        this.a = dVar;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        av avVar = (av) obj;
        int i = this.a.s;
        int i2 = avVar.a.s;
        return i == i2 ? this.a.a - avVar.a.a : (i2 - 1) - (i - 1);
    }
}
