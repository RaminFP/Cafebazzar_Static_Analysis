package com.google.android.gms.a;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

final class ae extends b {
    private final WeakReference a;

    ae(ac acVar) {
        this.a = new WeakReference(acVar);
    }

    public final void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            acVar.a.a(new af(this, acVar, acVar, connectionResult));
        }
    }
}
