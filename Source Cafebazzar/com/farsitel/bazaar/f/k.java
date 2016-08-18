package com.farsitel.bazaar.f;

import android.text.TextUtils;
import com.farsitel.bazaar.h.f;

public class k {
    public final int a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    private f f;

    public k(String str, int i, f fVar, boolean z, boolean z2, boolean z3) {
        this.b = str;
        this.a = i;
        this.f = fVar;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    public final String a() {
        return (this.f == null || TextUtils.isEmpty(this.f.a())) ? "" : this.f.a() + this.b;
    }
}
