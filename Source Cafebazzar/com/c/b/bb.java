package com.c.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

final class bb extends az {
    private final Context a;

    bb(Context context) {
        this.a = context;
    }

    public final boolean a(aw awVar) {
        return awVar.e != 0 ? true : "android.resource".equals(awVar.d.getScheme());
    }

    public final ba b(aw awVar) {
        Resources a = bj.a(this.a, awVar);
        int a2 = bj.a(a, awVar);
        Options d = az.d(awVar);
        if (az.a(d)) {
            BitmapFactory.decodeResource(a, a2, d);
            az.a(awVar.h, awVar.i, d, awVar);
        }
        return new ba(BitmapFactory.decodeResource(a, a2, d), ap.DISK);
    }
}
