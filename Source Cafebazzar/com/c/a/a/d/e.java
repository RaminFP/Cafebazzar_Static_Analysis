package com.c.a.a.d;

import d.k;

public final class e {
    public static final k a = k.a(":status");
    public static final k b = k.a(":method");
    public static final k c = k.a(":path");
    public static final k d = k.a(":scheme");
    public static final k e = k.a(":authority");
    public static final k f = k.a(":host");
    public static final k g = k.a(":version");
    public final k h;
    public final k i;
    final int j;

    public e(k kVar, k kVar2) {
        this.h = kVar;
        this.i = kVar2;
        this.j = (kVar.c.length + 32) + kVar2.c.length;
    }

    public e(k kVar, String str) {
        this(kVar, k.a(str));
    }

    public e(String str, String str2) {
        this(k.a(str), k.a(str2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.h.equals(eVar.h) && this.i.equals(eVar.i);
    }

    public final int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + this.i.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", new Object[]{this.h.a(), this.i.a()});
    }
}
