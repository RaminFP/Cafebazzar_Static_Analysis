package com.android.a;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class g implements u {
    private final Executor a;

    public g(Handler handler) {
        this.a = new h(this, handler);
    }

    public final void a(o oVar, s sVar) {
        a(oVar, sVar, null);
    }

    public final void a(o oVar, s sVar, Runnable runnable) {
        oVar.i = true;
        oVar.a("post-response");
        this.a.execute(new i(this, oVar, sVar, runnable));
    }

    public final void a(o oVar, y yVar) {
        oVar.a("post-error");
        this.a.execute(new i(this, oVar, s.a(yVar), null));
    }
}
