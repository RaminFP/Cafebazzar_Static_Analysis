package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.av;

public final class a {
    final f a = null;
    final g b;
    public final String c;
    private final b d;
    private final d e;

    public a(String str, b bVar, d dVar) {
        av.a((Object) bVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        av.a((Object) dVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.d = bVar;
        this.e = dVar;
        this.b = null;
    }

    public final b a() {
        av.a(this.d != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.d;
    }

    public final d b() {
        av.a(this.e != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.e;
    }
}
