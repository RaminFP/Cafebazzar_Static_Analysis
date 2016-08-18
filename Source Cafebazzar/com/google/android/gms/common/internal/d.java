package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;

public final class d extends l {
    private final e f;

    public d(Context context, Looper looper, int i, k kVar, l lVar, h hVar, e eVar) {
        super(context, looper, i, hVar, kVar, lVar);
        this.f = eVar;
    }

    protected final IInterface a(IBinder iBinder) {
        return this.f.c();
    }

    protected final String f() {
        return this.f.a();
    }

    protected final String g() {
        return this.f.b();
    }
}
