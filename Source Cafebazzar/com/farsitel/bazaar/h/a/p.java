package com.farsitel.bazaar.h.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.h.b.ar;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.q;

public final class p extends a {
    b b;
    private final String c;

    public p(String str) {
        this.c = str;
    }

    public final Object a(b bVar) {
        this.b = bVar;
        return d.INSTANCE.a(new q(this), new ar(), this.c, com.farsitel.bazaar.util.p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), k.c(), Integer.valueOf(k.b()), a.a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b());
    }
}
