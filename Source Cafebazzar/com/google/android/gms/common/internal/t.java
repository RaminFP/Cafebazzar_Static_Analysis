package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class t extends m {
    final /* synthetic */ l e;

    public t(l lVar) {
        this.e = lVar;
        super(lVar, 0, null);
    }

    protected final void a(ConnectionResult connectionResult) {
        this.e.k.a(connectionResult);
        l.i_();
    }

    protected final boolean a() {
        this.e.k.a(ConnectionResult.a);
        return true;
    }
}
