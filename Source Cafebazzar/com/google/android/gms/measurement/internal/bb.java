package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.av;

final class bb {
    final Context a;

    bb(Context context) {
        av.a((Object) context);
        Object applicationContext = context.getApplicationContext();
        av.a(applicationContext);
        this.a = applicationContext;
    }

    static bc a(ap apVar) {
        return new bc(apVar);
    }

    static bg b(ap apVar) {
        return new bg(apVar);
    }

    static d c(ap apVar) {
        return new d(apVar);
    }
}
