package com.c.a.a;

import com.c.a.a.c.a;
import d.ab;
import d.i;
import d.r;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class b implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean b = (!b.class.desiredAssertionStatus());
    private static final ab u = new e();
    private final a c;
    private final File d;
    private final File e;
    private final File f;
    private final File g;
    private final int h;
    private long i;
    private final int j;
    private long k = 0;
    private i l;
    private final LinkedHashMap m = new LinkedHashMap(0, 0.75f, true);
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r = 0;
    private final Executor s;
    private final Runnable t = new c(this);

    private b(a aVar, File file, int i, int i2, long j, Executor executor) {
        this.c = aVar;
        this.d = file;
        this.h = i;
        this.e = new File(file, "journal");
        this.f = new File(file, "journal.tmp");
        this.g = new File(file, "journal.bkp");
        this.j = i2;
        this.i = j;
        this.s = executor;
    }

    public static b a(a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return new b(aVar, file, 201105, 2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), v.a("OkHttp DiskLruCache", true)));
    }

    private void a(f fVar, boolean z) {
        int i = 0;
        synchronized (this) {
            h hVar = fVar.a;
            if (hVar.f != fVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!hVar.e) {
                    int i2 = 0;
                    while (i2 < this.j) {
                        if (!fVar.b[i2]) {
                            fVar.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!this.c.e(hVar.d[i2])) {
                            fVar.b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.j) {
                File file = hVar.d[i];
                if (!z) {
                    this.c.d(file);
                } else if (this.c.e(file)) {
                    File file2 = hVar.c[i];
                    this.c.a(file, file2);
                    long j = hVar.b[i];
                    long f = this.c.f(file2);
                    hVar.b[i] = f;
                    this.k = (this.k - j) + f;
                }
                i++;
            }
            this.n++;
            hVar.f = null;
            if ((hVar.e | z) != 0) {
                hVar.e = true;
                this.l.b("CLEAN").h(32);
                this.l.b(hVar.a);
                hVar.a(this.l);
                this.l.h(10);
                if (z) {
                    long j2 = this.r;
                    this.r = 1 + j2;
                    hVar.g = j2;
                }
            } else {
                this.m.remove(hVar.a);
                this.l.b("REMOVE").h(32);
                this.l.b(hVar.a);
                this.l.h(10);
            }
            this.l.flush();
            if (this.k > this.i || g()) {
                this.s.execute(this.t);
            }
        }
    }

    private boolean a(h hVar) {
        if (hVar.f != null) {
            hVar.f.c = true;
        }
        for (int i = 0; i < this.j; i++) {
            this.c.d(hVar.c[i]);
            this.k -= hVar.b[i];
            hVar.b[i] = 0;
        }
        this.n++;
        this.l.b("REMOVE").h(32).b(hVar.a).h(10);
        this.m.remove(hVar.a);
        if (g()) {
            this.s.execute(this.t);
        }
        return true;
    }

    private void b() {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.p) {
            if (this.c.e(this.g)) {
                if (this.c.e(this.e)) {
                    this.c.d(this.g);
                } else {
                    this.c.a(this.g, this.e);
                }
            }
            if (this.c.e(this.e)) {
                try {
                    c();
                    e();
                    this.p = true;
                    return;
                } catch (IOException e) {
                    q.a();
                    q.a("DiskLruCache " + this.d + " is corrupt: " + e.getMessage() + ", removing");
                    close();
                    this.c.g(this.d);
                    this.q = false;
                }
            }
            f();
            this.p = true;
        }
    }

    private void c() {
        Closeable a = r.a(this.c.a(this.e));
        int i;
        try {
            String p = a.p();
            String p2 = a.p();
            String p3 = a.p();
            String p4 = a.p();
            String p5 = a.p();
            if ("libcore.io.DiskLruCache".equals(p) && "1".equals(p2) && Integer.toString(this.h).equals(p3) && Integer.toString(this.j).equals(p4) && "".equals(p5)) {
                i = 0;
                while (true) {
                    p3 = a.p();
                    int indexOf = p3.indexOf(32);
                    if (indexOf == -1) {
                        throw new IOException("unexpected journal line: " + p3);
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = p3.indexOf(32, i2);
                    h hVar;
                    if (indexOf2 != -1) {
                        p = p3.substring(i2, indexOf2);
                        hVar = (h) this.m.get(p);
                        if (hVar == null) {
                            hVar = new h(this, p);
                            this.m.put(p, hVar);
                        }
                        if (indexOf2 == -1) {
                        }
                        if (indexOf2 != -1) {
                        }
                        if (indexOf2 == -1) {
                            break;
                        }
                        break;
                    }
                    String substring = p3.substring(i2);
                    if (indexOf == 6 && p3.startsWith("REMOVE")) {
                        this.m.remove(substring);
                    } else {
                        p = substring;
                        hVar = (h) this.m.get(p);
                        if (hVar == null) {
                            hVar = new h(this, p);
                            this.m.put(p, hVar);
                        }
                        if (indexOf2 == -1 && indexOf == 5 && p3.startsWith("CLEAN")) {
                            String[] split = p3.substring(indexOf2 + 1).split(" ");
                            hVar.e = true;
                            hVar.f = null;
                            hVar.a(split);
                        } else if (indexOf2 != -1 && indexOf == 5 && p3.startsWith("DIRTY")) {
                            hVar.f = new f(this, hVar);
                        } else if (indexOf2 == -1 && indexOf == 4 && p3.startsWith("READ")) {
                        }
                    }
                    i++;
                }
                throw new IOException("unexpected journal line: " + p3);
            }
            throw new IOException("unexpected journal header: [" + p + ", " + p2 + ", " + p4 + ", " + p5 + "]");
        } catch (EOFException e) {
            this.n = i - this.m.size();
            if (a.e()) {
                this.l = d();
            } else {
                f();
            }
            v.a(a);
        } catch (Throwable th) {
            v.a(a);
        }
    }

    private static void c(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private i d() {
        return r.a(new d(this, this.c.c(this.e)));
    }

    private void e() {
        this.c.d(this.f);
        Iterator it = this.m.values().iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            int i;
            if (hVar.f == null) {
                for (i = 0; i < this.j; i++) {
                    this.k += hVar.b[i];
                }
            } else {
                hVar.f = null;
                for (i = 0; i < this.j; i++) {
                    this.c.d(hVar.c[i]);
                    this.c.d(hVar.d[i]);
                }
                it.remove();
            }
        }
    }

    private void f() {
        synchronized (this) {
            if (this.l != null) {
                this.l.close();
            }
            i a = r.a(this.c.b(this.f));
            try {
                a.b("libcore.io.DiskLruCache").h(10);
                a.b("1").h(10);
                a.j((long) this.h).h(10);
                a.j((long) this.j).h(10);
                a.h(10);
                for (h hVar : this.m.values()) {
                    if (hVar.f != null) {
                        a.b("DIRTY").h(32);
                        a.b(hVar.a);
                        a.h(10);
                    } else {
                        a.b("CLEAN").h(32);
                        a.b(hVar.a);
                        hVar.a(a);
                        a.h(10);
                    }
                }
                a.close();
                if (this.c.e(this.e)) {
                    this.c.a(this.e, this.g);
                }
                this.c.a(this.f, this.e);
                this.c.d(this.g);
                this.l = d();
                this.o = false;
            } catch (Throwable th) {
                a.close();
            }
        }
    }

    private boolean g() {
        return this.n >= 2000 && this.n >= this.m.size();
    }

    private boolean h() {
        boolean z;
        synchronized (this) {
            z = this.q;
        }
        return z;
    }

    private void i() {
        synchronized (this) {
            if (h()) {
                throw new IllegalStateException("cache is closed");
            }
        }
    }

    private void j() {
        while (this.k > this.i) {
            a((h) this.m.values().iterator().next());
        }
    }

    public f a(String str, long j) {
        f fVar;
        synchronized (this) {
            b();
            i();
            c(str);
            h hVar = (h) this.m.get(str);
            if (j == -1 || (hVar != null && hVar.g == j)) {
                if (hVar != null) {
                    if (hVar.f != null) {
                        fVar = null;
                    }
                }
                this.l.b("DIRTY").h(32).b(str).h(10);
                this.l.flush();
                if (this.o) {
                    fVar = null;
                } else {
                    h hVar2;
                    if (hVar == null) {
                        hVar = new h(this, str);
                        this.m.put(str, hVar);
                        hVar2 = hVar;
                    } else {
                        hVar2 = hVar;
                    }
                    fVar = new f(this, hVar2);
                    hVar2.f = fVar;
                }
            } else {
                fVar = null;
            }
        }
        return fVar;
    }

    public final i a(String str) {
        i iVar;
        synchronized (this) {
            b();
            i();
            c(str);
            h hVar = (h) this.m.get(str);
            if (hVar == null || !hVar.e) {
                iVar = null;
            } else {
                iVar = hVar.a();
                if (iVar == null) {
                    iVar = null;
                } else {
                    this.n++;
                    this.l.b("READ").h(32).b(str).h(10);
                    if (g()) {
                        this.s.execute(this.t);
                    }
                }
            }
        }
        return iVar;
    }

    public final boolean b(String str) {
        boolean a;
        synchronized (this) {
            b();
            i();
            c(str);
            h hVar = (h) this.m.get(str);
            a = hVar == null ? false : a(hVar);
        }
        return a;
    }

    public final void close() {
        synchronized (this) {
            if (!this.p || this.q) {
                this.q = true;
            } else {
                for (h hVar : (h[]) this.m.values().toArray(new h[this.m.size()])) {
                    if (hVar.f != null) {
                        hVar.f.b();
                    }
                }
                j();
                this.l.close();
                this.l = null;
                this.q = true;
            }
        }
    }
}
