package com.a.a.c;

import java.util.concurrent.Callable;

final class l implements Callable {
    final /* synthetic */ h a;

    l(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ Object call() {
        return Boolean.valueOf(this.a.v.b().exists());
    }
}
