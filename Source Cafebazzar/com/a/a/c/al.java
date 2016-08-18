package com.a.a.c;

import java.util.Date;
import java.util.concurrent.Callable;

final class al implements Callable {
    final /* synthetic */ Date a;
    final /* synthetic */ Thread b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ ac d;

    al(ac acVar, Date date, Thread thread, Throwable th) {
        this.d = acVar;
        this.a = date;
        this.b = thread;
        this.c = th;
    }

    public final /* synthetic */ Object call() {
        ac.a(this.d, this.a, this.b, this.c);
        return null;
    }
}
