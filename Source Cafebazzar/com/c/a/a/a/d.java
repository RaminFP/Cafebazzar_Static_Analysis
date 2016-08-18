package com.c.a.a.a;

import com.c.a.al;
import com.c.a.am;
import com.c.a.ap;
import com.c.a.aq;
import com.c.a.j;
import com.c.a.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class d {
    final long a;
    final al b;
    final ap c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;

    public d(long j, al alVar, ap apVar) {
        this.a = j;
        this.b = alVar;
        this.c = apVar;
        if (apVar != null) {
            z zVar = apVar.f;
            int length = zVar.a.length / 2;
            for (int i = 0; i < length; i++) {
                String a = zVar.a(i);
                String b = zVar.b(i);
                if ("Date".equalsIgnoreCase(a)) {
                    this.d = m.a(b);
                    this.e = b;
                } else if ("Expires".equalsIgnoreCase(a)) {
                    this.h = m.a(b);
                } else if ("Last-Modified".equalsIgnoreCase(a)) {
                    this.f = m.a(b);
                    this.g = b;
                } else if ("ETag".equalsIgnoreCase(a)) {
                    this.k = b;
                } else if ("Age".equalsIgnoreCase(a)) {
                    this.l = e.b(b, -1);
                } else if (u.b.equalsIgnoreCase(a)) {
                    this.i = Long.parseLong(b);
                } else if (u.c.equalsIgnoreCase(a)) {
                    this.j = Long.parseLong(b);
                }
            }
        }
    }

    private static boolean a(al alVar) {
        return (alVar.a("If-Modified-Since") == null && alVar.a("If-None-Match") == null) ? false : true;
    }

    public final c a() {
        c cVar;
        if (this.c == null) {
            cVar = new c(this.b, null);
        } else if (this.b.e() && this.c.e == null) {
            cVar = new c(this.b, null);
        } else if (c.a(this.c, this.b)) {
            j d = this.b.d();
            if (d.c || a(this.b)) {
                cVar = new c(this.b, null);
            } else {
                long max = this.d != null ? Math.max(0, this.j - this.d.getTime()) : 0;
                if (this.l != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis((long) this.l));
                }
                long j = (max + (this.j - this.i)) + (this.a - this.j);
                j g = this.c.g();
                if (g.e != -1) {
                    max = TimeUnit.SECONDS.toMillis((long) g.e);
                } else if (this.h != null) {
                    max = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                    if (max <= 0) {
                        max = 0;
                    }
                } else if (this.f == null || this.c.a.a().getQuery() != null) {
                    max = 0;
                } else {
                    max = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
                    max = max > 0 ? max / 10 : 0;
                }
                if (d.e != -1) {
                    max = Math.min(max, TimeUnit.SECONDS.toMillis((long) d.e));
                }
                long j2 = 0;
                if (d.j != -1) {
                    j2 = TimeUnit.SECONDS.toMillis((long) d.j);
                }
                long j3 = 0;
                j g2 = this.c.g();
                if (!(g2.h || d.i == -1)) {
                    j3 = TimeUnit.SECONDS.toMillis((long) d.i);
                }
                if (g2.c || j + j2 >= r4 + max) {
                    am c = this.b.c();
                    if (this.k != null) {
                        c.a("If-None-Match", this.k);
                    } else if (this.f != null) {
                        c.a("If-Modified-Since", this.g);
                    } else if (this.d != null) {
                        c.a("If-Modified-Since", this.e);
                    }
                    al a = c.a();
                    cVar = a(a) ? new c(a, this.c) : new c(a, null);
                } else {
                    aq d2 = this.c.d();
                    if (j2 + j >= max) {
                        d2.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (j > 86400000) {
                        Object obj = (this.c.g().e == -1 && this.h == null) ? 1 : null;
                        if (obj != null) {
                            d2.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                    }
                    cVar = new c(null, d2.a());
                }
            }
        } else {
            cVar = new c(this.b, null);
        }
        return (cVar.a == null || !this.b.d().k) ? cVar : new c(null, null);
    }
}
