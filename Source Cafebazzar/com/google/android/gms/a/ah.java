package com.google.android.gms.a;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.ae;

final class ah extends bb {
    final /* synthetic */ ac a;
    final /* synthetic */ ResolveAccountResponse b;
    final /* synthetic */ ag c;

    ah(ag agVar, az azVar, ac acVar, ResolveAccountResponse resolveAccountResponse) {
        this.c = agVar;
        this.a = acVar;
        this.b = resolveAccountResponse;
        super(azVar);
    }

    public final void a() {
        ac acVar = this.a;
        ResolveAccountResponse resolveAccountResponse = this.b;
        if (acVar.b(0)) {
            ConnectionResult connectionResult = resolveAccountResponse.c;
            if (connectionResult.b()) {
                acVar.g = ae.a(resolveAccountResponse.b);
                acVar.f = true;
                acVar.h = resolveAccountResponse.d;
                acVar.i = resolveAccountResponse.e;
                acVar.e();
            } else if (acVar.a(connectionResult)) {
                acVar.h();
                acVar.e();
            } else {
                acVar.b(connectionResult);
            }
        }
    }
}
