package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class u extends m {
    final /* synthetic */ l e;

    public u(l lVar, int i, Bundle bundle) {
        this.e = lVar;
        super(lVar, i, bundle);
    }

    protected final void a(ConnectionResult connectionResult) {
        this.e.k.b(connectionResult);
        l.i_();
    }

    protected final boolean a() {
        this.e.k.b(ConnectionResult.a);
        return true;
    }
}
