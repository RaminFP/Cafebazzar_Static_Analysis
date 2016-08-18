package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.h;

public final class l extends com.google.android.gms.common.internal.l {
    public l(Context context, Looper looper, h hVar, k kVar, com.google.android.gms.common.api.l lVar) {
        super(context, looper, 40, hVar, kVar, lVar);
    }

    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        return q.a(iBinder);
    }

    protected final String f() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected final String g() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
