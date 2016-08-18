package com.c.a;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public final class al {
    final ab a;
    public final String b;
    public final z c;
    public final an d;
    final Object e;
    private volatile URL f;
    private volatile URI g;
    private volatile j h;

    private al(am amVar) {
        Object obj;
        this.a = amVar.a;
        this.b = amVar.b;
        this.c = amVar.c.a();
        this.d = amVar.d;
        if (amVar.e != null) {
            obj = amVar.e;
        } else {
            al alVar = this;
        }
        this.e = obj;
    }

    public final String a(String str) {
        return this.c.a(str);
    }

    public final URL a() {
        URL url = this.f;
        if (url != null) {
            return url;
        }
        url = this.a.a();
        this.f = url;
        return url;
    }

    public final URI b() {
        try {
            URI uri = this.g;
            if (uri == null) {
                uri = this.a.b();
                this.g = uri;
            }
            return uri;
        } catch (IllegalStateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public final am c() {
        return new am();
    }

    public final j d() {
        j jVar = this.h;
        if (jVar != null) {
            return jVar;
        }
        jVar = j.a(this.c);
        this.h = jVar;
        return jVar;
    }

    public final boolean e() {
        return this.a.a.equals("https");
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tag=" + (this.e != this ? this.e : null) + '}';
    }
}
