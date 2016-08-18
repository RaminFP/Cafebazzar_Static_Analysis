package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

public final class y extends l {
    public y(Context context, Looper looper, h hVar, k kVar, com.google.android.gms.common.api.l lVar) {
        super(context, looper, 93, hVar, kVar, lVar);
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        return v.a(iBinder);
    }

    protected final String f() {
        return "com.google.android.gms.measurement.START";
    }

    protected final String g() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
