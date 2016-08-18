package com.google.android.gms.measurement.internal;

import com.google.android.gms.a.bm;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.g;

public final class t {
    private final Object a;
    private final bm b;
    private Object c;

    private t(bm bmVar, Object obj) {
        av.a((Object) bmVar);
        this.b = bmVar;
        this.a = obj;
    }

    static t a(String str, int i) {
        return new t(bm.a(str, Integer.valueOf(i)), Integer.valueOf(i));
    }

    static t a(String str, long j) {
        return new t(bm.a(str, Long.valueOf(j)), Long.valueOf(j));
    }

    static t a(String str, String str2, String str3) {
        return new t(bm.a(str, str3), str2);
    }

    static t a(String str, boolean z) {
        return new t(bm.a(str, true), Boolean.valueOf(true));
    }

    public final Object a() {
        return this.c != null ? this.c : (g.a && bm.b()) ? this.b.d() : this.a;
    }
}
