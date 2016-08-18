package com.c.a;

public final class aq {
    public al a;
    public ak b;
    public int c;
    public String d;
    public y e;
    aa f;
    public ar g;
    ap h;
    ap i;
    ap j;

    public aq() {
        this.c = -1;
        this.f = new aa();
    }

    private aq(ap apVar) {
        this.c = -1;
        this.a = apVar.a;
        this.b = apVar.b;
        this.c = apVar.c;
        this.d = apVar.d;
        this.e = apVar.e;
        this.f = apVar.f.a();
        this.g = apVar.g;
        this.h = apVar.h;
        this.i = apVar.i;
        this.j = apVar.j;
    }

    private static void a(String str, ap apVar) {
        if (apVar.g != null) {
            throw new IllegalArgumentException(str + ".body != null");
        } else if (apVar.h != null) {
            throw new IllegalArgumentException(str + ".networkResponse != null");
        } else if (apVar.i != null) {
            throw new IllegalArgumentException(str + ".cacheResponse != null");
        } else if (apVar.j != null) {
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }
    }

    public final ap a() {
        if (this.a == null) {
            throw new IllegalStateException("request == null");
        } else if (this.b == null) {
            throw new IllegalStateException("protocol == null");
        } else if (this.c >= 0) {
            return new ap();
        } else {
            throw new IllegalStateException("code < 0: " + this.c);
        }
    }

    public final aq a(ap apVar) {
        if (apVar != null) {
            a("networkResponse", apVar);
        }
        this.h = apVar;
        return this;
    }

    public final aq a(z zVar) {
        this.f = zVar.a();
        return this;
    }

    public final aq a(String str, String str2) {
        this.f.b(str, str2);
        return this;
    }

    public final aq b(ap apVar) {
        if (apVar != null) {
            a("cacheResponse", apVar);
        }
        this.i = apVar;
        return this;
    }

    public final aq b(String str, String str2) {
        this.f.a(str, str2);
        return this;
    }

    public final aq c(ap apVar) {
        if (apVar == null || apVar.g == null) {
            this.j = apVar;
            return this;
        }
        throw new IllegalArgumentException("priorResponse.body != null");
    }
}
