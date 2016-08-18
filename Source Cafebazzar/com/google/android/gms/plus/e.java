package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.a.cg;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.g;

final class e extends b {
    e() {
    }

    public final int a() {
        return 2;
    }

    public final /* synthetic */ c a(Context context, Looper looper, h hVar, Object obj, k kVar, l lVar) {
        f fVar = (f) obj;
        if (fVar == null) {
            fVar = new f();
        }
        return new g(context, looper, hVar, new PlusSession(hVar.a().name, cg.a(hVar.c), (String[]) fVar.b.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), kVar, lVar);
    }
}
