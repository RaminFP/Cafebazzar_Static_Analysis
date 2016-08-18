package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.o;

public final class r implements o {
    final /* synthetic */ l a;

    public r(l lVar) {
        this.a = lVar;
    }

    public final void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.a.a(null, this.a.p);
        } else if (this.a.s != null) {
            this.a.s.a(connectionResult);
        }
    }

    public final void b(ConnectionResult connectionResult) {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
}
