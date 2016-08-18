package com.google.android.gms.a;

import com.google.android.gms.common.ConnectionResult;

final class af extends bb {
    final /* synthetic */ ac a;
    final /* synthetic */ ConnectionResult b;
    final /* synthetic */ ae c;

    af(ae aeVar, az azVar, ac acVar, ConnectionResult connectionResult) {
        this.c = aeVar;
        this.a = acVar;
        this.b = connectionResult;
        super(azVar);
    }

    public final void a() {
        ac acVar = this.a;
        ConnectionResult connectionResult = this.b;
        if (!acVar.b(2)) {
            return;
        }
        if (connectionResult.b()) {
            acVar.g();
        } else if (acVar.a(connectionResult)) {
            acVar.h();
            acVar.g();
        } else {
            acVar.b(connectionResult);
        }
    }
}
