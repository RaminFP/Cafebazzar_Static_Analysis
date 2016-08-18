package com.c.a;

import com.c.a.a.a.s;
import com.c.a.a.a.u;
import com.c.a.a.b;
import com.c.a.a.c.a;
import com.c.a.a.f;
import com.c.a.a.l;
import com.c.a.a.v;
import d.j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class c {
    final l a = new d(this);
    int b;
    int c;
    private final b d;
    private int e;
    private int f;
    private int g;

    public c(File file, long j) {
        this.d = b.a(a.a, file, 201105, 2, j);
    }

    static int a(j jVar) {
        try {
            long l = jVar.l();
            String p = jVar.p();
            if (l >= 0 && l <= 2147483647L && p.isEmpty()) {
                return (int) l;
            }
            throw new IOException("expected an int but was \"" + l + p + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    static void a(f fVar) {
        if (fVar != null) {
            try {
                fVar.b();
            } catch (IOException e) {
            }
        }
    }

    private static String c(al alVar) {
        return v.b(alVar.a.toString());
    }

    com.c.a.a.a.b a(ap apVar) {
        f a;
        String str = apVar.a.b;
        if (s.a(apVar.a.b)) {
            try {
                b(apVar.a);
                return null;
            } catch (IOException e) {
                return null;
            }
        } else if (!str.equals("GET") || u.b(apVar)) {
            return null;
        } else {
            i iVar = new i(apVar);
            try {
                a = this.d.a(c(apVar.a), -1);
                if (a == null) {
                    return null;
                }
                try {
                    iVar.a(a);
                    return new e(this, a);
                } catch (IOException e2) {
                    a(a);
                    return null;
                }
            } catch (IOException e3) {
                a = null;
                a(a);
                return null;
            }
        }
    }

    final ap a(al alVar) {
        Object obj = null;
        try {
            Closeable a = this.d.a(c(alVar));
            if (a == null) {
                return null;
            }
            try {
                i iVar = new i(a.c[0]);
                String a2 = iVar.g.a("Content-Type");
                String a3 = iVar.g.a("Content-Length");
                am a4 = new am().a(iVar.a).a(iVar.c, null);
                a4.c = iVar.b.a();
                al a5 = a4.a();
                aq aqVar = new aq();
                aqVar.a = a5;
                aqVar.b = iVar.d;
                aqVar.c = iVar.e;
                aqVar.d = iVar.f;
                aq a6 = aqVar.a(iVar.g);
                a6.g = new g(a, a2, a3);
                a6.e = iVar.h;
                ap a7 = a6.a();
                if (iVar.a.equals(alVar.a.toString()) && iVar.c.equals(alVar.b) && u.a(a7, iVar.b, alVar)) {
                    obj = 1;
                }
                if (obj != null) {
                    return a7;
                }
                v.a(a7.g);
                return null;
            } catch (IOException e) {
                v.a(a);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    void a() {
        synchronized (this) {
            this.f++;
        }
    }

    void a(com.c.a.a.a.c cVar) {
        synchronized (this) {
            this.g++;
            if (cVar.a != null) {
                this.e++;
            } else if (cVar.b != null) {
                this.f++;
            }
        }
    }

    void b(al alVar) {
        this.d.b(c(alVar));
    }
}
