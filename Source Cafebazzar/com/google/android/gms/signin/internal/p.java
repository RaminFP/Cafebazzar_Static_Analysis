package com.google.android.gms.signin.internal;

import android.util.Log;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

final class p implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;
    final /* synthetic */ o d;

    p(o oVar, List list, String str, i iVar) {
        this.d = oVar;
        this.a = list;
        this.b = str;
        this.c = iVar;
    }

    public final void run() {
        try {
            m a = this.d.a.e;
            Collections.unmodifiableSet(new HashSet(this.a));
            n a2 = a.a();
            this.c.a(new CheckServerAuthResult(a2.a, a2.b));
        } catch (Throwable e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
        }
    }
}
