package com.google.android.gms.signin.internal;

import android.util.Log;

final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;
    final /* synthetic */ o d;

    q(o oVar, String str, String str2, i iVar) {
        this.d = oVar;
        this.a = str;
        this.b = str2;
        this.c = iVar;
    }

    public final void run() {
        try {
            this.c.a(this.d.a.e.b());
        } catch (Throwable e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
        }
    }
}
