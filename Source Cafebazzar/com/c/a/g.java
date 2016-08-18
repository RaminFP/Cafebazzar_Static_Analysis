package com.c.a;

import com.c.a.a.i;
import d.j;
import d.r;

final class g extends ar {
    private final i a;
    private final j b;
    private final String c;
    private final String d;

    public g(i iVar, String str, String str2) {
        this.a = iVar;
        this.c = str;
        this.d = str2;
        this.b = r.a(new h(this, iVar.c[1], iVar));
    }

    public final long a() {
        long j = -1;
        try {
            if (this.d != null) {
                j = Long.parseLong(this.d);
            }
        } catch (NumberFormatException e) {
        }
        return j;
    }

    public final j b() {
        return this.b;
    }
}
