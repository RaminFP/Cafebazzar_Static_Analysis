package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class p extends ak {
    private l a;
    private final int b;

    public p(l lVar, int i) {
        this.a = lVar;
        this.b = i;
    }

    public final void a(int i, Bundle bundle) {
        av.a(this.a, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
        l lVar = this.a;
        lVar.c.sendMessage(lVar.c.obtainMessage(5, this.b, -1, new u(lVar, i, bundle)));
        this.a = null;
    }

    public final void a(int i, IBinder iBinder, Bundle bundle) {
        av.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.a(i, iBinder, bundle, this.b);
        this.a = null;
    }
}
