package com.android.a;

import android.os.Handler;
import java.util.concurrent.Executor;

final class h implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ g b;

    h(g gVar, Handler handler) {
        this.b = gVar;
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
