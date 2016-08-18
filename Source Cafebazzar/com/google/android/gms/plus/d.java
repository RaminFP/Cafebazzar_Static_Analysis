package com.google.android.gms.plus;

import com.google.android.gms.a.cp;
import com.google.android.gms.a.cq;
import com.google.android.gms.a.cr;
import com.google.android.gms.a.cs;
import com.google.android.gms.a.ct;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.plus.internal.g;

public final class d {
    public static final com.google.android.gms.common.api.d a = new com.google.android.gms.common.api.d();
    static final b b = new e();
    public static final a c = new a("Plus.API", b, a);
    public static final Scope d = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope e = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final b f = new cs();
    public static final c g = new ct();
    @Deprecated
    public static final a h = new cp();
    public static final h i = new cr();
    public static final g j = new cq();

    public static g a(h hVar, boolean z) {
        av.b(hVar != null, "GoogleApiClient parameter is required.");
        av.a(hVar.c(), (Object) "GoogleApiClient must be connected.");
        av.a(hVar.a(c), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean b = hVar.b(c);
        if (b) {
            return b ? (g) hVar.a(a) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
