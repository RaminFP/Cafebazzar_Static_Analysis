package com.google.android.gms.a;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.n;
import java.util.concurrent.Executors;

final class cv extends b {
    cv() {
    }

    public final /* synthetic */ c a(Context context, Looper looper, h hVar, Object obj, k kVar, l lVar) {
        da daVar = (da) obj;
        return new n(context, looper, true, hVar, daVar == null ? da.a : daVar, kVar, lVar, Executors.newSingleThreadExecutor());
    }
}
