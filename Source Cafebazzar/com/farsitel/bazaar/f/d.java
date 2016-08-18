package com.farsitel.bazaar.f;

import android.os.Build.VERSION;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.a.a;
import com.farsitel.bazaar.h.b.j;
import com.farsitel.bazaar.h.v;

public final class d {
    final String a;
    b b;
    public a c = null;
    private final String d;
    private final String e;
    private Object f;
    private v g = new e(this);

    public d(String str, String str2, b bVar, String str3) {
        this.a = str.trim();
        this.d = str2;
        this.b = bVar;
        this.e = str3;
    }

    public final void a() {
        this.b.a();
        this.f = com.farsitel.bazaar.h.d.INSTANCE.a(this.g, this.e, new j(), this.d, this.a, Integer.valueOf(VERSION.SDK_INT));
    }
}
