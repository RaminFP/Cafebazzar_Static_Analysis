package com.c.a;

import com.c.a.a.a.s;
import java.net.URL;

public final class am {
    ab a;
    String b;
    aa c;
    an d;
    Object e;

    public am() {
        this.b = "GET";
        this.c = new aa();
    }

    private am(al alVar) {
        this.a = alVar.a;
        this.b = alVar.b;
        this.d = alVar.d;
        this.e = alVar.e;
        this.c = alVar.c.a();
    }

    private am a(ab abVar) {
        if (abVar == null) {
            throw new IllegalArgumentException("url == null");
        }
        this.a = abVar;
        return this;
    }

    public final al a() {
        if (this.a != null) {
            return new al();
        }
        throw new IllegalStateException("url == null");
    }

    public final am a(j jVar) {
        String jVar2 = jVar.toString();
        return jVar2.isEmpty() ? b("Cache-Control") : a("Cache-Control", jVar2);
    }

    public final am a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else {
            if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
        }
        ab c = ab.c(str);
        if (c != null) {
            return a(c);
        }
        throw new IllegalArgumentException("unexpected url: " + str);
    }

    public final am a(String str, an anVar) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        } else if (anVar != null && !s.c(str)) {
            throw new IllegalArgumentException("method " + str + " must not have a request body.");
        } else if (anVar == null && s.b(str)) {
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        } else {
            this.b = str;
            this.d = anVar;
            return this;
        }
    }

    public final am a(String str, String str2) {
        this.c.b(str, str2);
        return this;
    }

    public final am a(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }
        ab a = ab.a(url);
        if (a != null) {
            return a(a);
        }
        throw new IllegalArgumentException("unexpected url: " + url);
    }

    public final am b(String str) {
        this.c.b(str);
        return this;
    }

    public final am b(String str, String str2) {
        this.c.a(str, str2);
        return this;
    }
}
