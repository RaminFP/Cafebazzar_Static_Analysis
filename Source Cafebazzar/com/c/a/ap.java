package com.c.a;

import com.c.a.a.a.u;
import java.util.Collections;
import java.util.List;

public final class ap {
    public final al a;
    public final ak b;
    public final int c;
    public final String d;
    public final y e;
    public final z f;
    public final ar g;
    public ap h;
    public ap i;
    final ap j;
    private volatile j k;

    private ap(aq aqVar) {
        this.a = aqVar.a;
        this.b = aqVar.b;
        this.c = aqVar.c;
        this.d = aqVar.d;
        this.e = aqVar.e;
        this.f = aqVar.f.a();
        this.g = aqVar.g;
        this.h = aqVar.h;
        this.i = aqVar.i;
        this.j = aqVar.j;
    }

    public final int a() {
        return this.c;
    }

    public final String a(String str) {
        String a = this.f.a(str);
        return a != null ? a : null;
    }

    public final String b() {
        return this.d;
    }

    public final ar c() {
        return this.g;
    }

    public final aq d() {
        return new aq();
    }

    public final ap e() {
        return this.i;
    }

    public final List f() {
        String str;
        if (this.c == 401) {
            str = "WWW-Authenticate";
        } else if (this.c != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return u.b(this.f, str);
    }

    public final j g() {
        j jVar = this.k;
        if (jVar != null) {
            return jVar;
        }
        jVar = j.a(this.f);
        this.k = jVar;
        return jVar;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a.toString() + '}';
    }
}
