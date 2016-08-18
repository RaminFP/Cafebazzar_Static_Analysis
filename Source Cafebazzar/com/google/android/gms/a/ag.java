package com.google.android.gms.a;

import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.aq;
import java.lang.ref.WeakReference;

final class ag extends aq {
    private final WeakReference a;

    ag(ac acVar) {
        this.a = new WeakReference(acVar);
    }

    public final void a(ResolveAccountResponse resolveAccountResponse) {
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            acVar.a.a(new ah(this, acVar, acVar, resolveAccountResponse));
        }
    }
}
