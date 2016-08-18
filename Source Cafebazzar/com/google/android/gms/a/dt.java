package com.google.android.gms.a;

import java.util.Arrays;

public final class dt extends df {
    public long b;
    public long c;
    public long d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public du[] i;
    public dr j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public dq n;
    public String o;
    public long p;
    public ds q;
    public byte[] r;
    public int s;
    public int[] t;

    public dt() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = du.e();
        this.j = null;
        this.k = do.h;
        this.l = do.h;
        this.m = do.h;
        this.n = null;
        this.o = "";
        this.p = 180000;
        this.q = null;
        this.r = do.h;
        this.s = 0;
        this.t = do.a;
        this.a = null;
        this.A = -1;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.b = dcVar.f();
                    continue;
                case 18:
                    this.e = dcVar.c();
                    continue;
                case 26:
                    b = do.b(dcVar, 26);
                    a = this.i == null ? 0 : this.i.length;
                    obj = new du[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.i, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new du();
                        dcVar.a(obj[a]);
                        dcVar.a();
                        a++;
                    }
                    obj[a] = new du();
                    dcVar.a(obj[a]);
                    this.i = obj;
                    continue;
                case 50:
                    this.k = dcVar.d();
                    continue;
                case 58:
                    if (this.n == null) {
                        this.n = new dq();
                    }
                    dcVar.a(this.n);
                    continue;
                case 66:
                    this.l = dcVar.d();
                    continue;
                case 74:
                    if (this.j == null) {
                        this.j = new dr();
                    }
                    dcVar.a(this.j);
                    continue;
                case 80:
                    this.h = dcVar.b();
                    continue;
                case 88:
                    this.f = dcVar.e();
                    continue;
                case 96:
                    this.g = dcVar.e();
                    continue;
                case 106:
                    this.m = dcVar.d();
                    continue;
                case 114:
                    this.o = dcVar.c();
                    continue;
                case 120:
                    long f = dcVar.f();
                    this.p = (f >>> 1) ^ (-(1 & f));
                    continue;
                case 130:
                    if (this.q == null) {
                        this.q = new ds();
                    }
                    dcVar.a(this.q);
                    continue;
                case 136:
                    this.c = dcVar.f();
                    continue;
                case 146:
                    this.r = dcVar.d();
                    continue;
                case 152:
                    a = dcVar.e();
                    switch (a) {
                        case 0:
                        case 1:
                        case 2:
                            this.s = a;
                            break;
                        default:
                            continue;
                    }
                case 160:
                    b = do.b(dcVar, 160);
                    a = this.t == null ? 0 : this.t.length;
                    obj = new int[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.t, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.e();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.e();
                    this.t = obj;
                    continue;
                case 162:
                    int b2 = dcVar.b(dcVar.e());
                    b = dcVar.i();
                    a = 0;
                    while (dcVar.h() > 0) {
                        dcVar.e();
                        a++;
                    }
                    dcVar.d(b);
                    b = this.t == null ? 0 : this.t.length;
                    Object obj2 = new int[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.t, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = dcVar.e();
                        b++;
                    }
                    this.t = obj2;
                    dcVar.c(b2);
                    continue;
                case 168:
                    this.d = dcVar.f();
                    continue;
                default:
                    if (!a(dcVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void a(dd ddVar) {
        int i = 0;
        if (this.b != 0) {
            ddVar.a(1, this.b);
        }
        if (!this.e.equals("")) {
            ddVar.a(2, this.e);
        }
        if (this.i != null && this.i.length > 0) {
            for (dl dlVar : this.i) {
                if (dlVar != null) {
                    ddVar.a(3, dlVar);
                }
            }
        }
        if (!Arrays.equals(this.k, do.h)) {
            ddVar.a(6, this.k);
        }
        if (this.n != null) {
            ddVar.a(7, this.n);
        }
        if (!Arrays.equals(this.l, do.h)) {
            ddVar.a(8, this.l);
        }
        if (this.j != null) {
            ddVar.a(9, this.j);
        }
        if (this.h) {
            ddVar.a(10, this.h);
        }
        if (this.f != 0) {
            ddVar.a(11, this.f);
        }
        if (this.g != 0) {
            ddVar.a(12, this.g);
        }
        if (!Arrays.equals(this.m, do.h)) {
            ddVar.a(13, this.m);
        }
        if (!this.o.equals("")) {
            ddVar.a(14, this.o);
        }
        if (this.p != 180000) {
            long j = this.p;
            ddVar.c(15, 0);
            ddVar.a(dd.c(j));
        }
        if (this.q != null) {
            ddVar.a(16, this.q);
        }
        if (this.c != 0) {
            ddVar.a(17, this.c);
        }
        if (!Arrays.equals(this.r, do.h)) {
            ddVar.a(18, this.r);
        }
        if (this.s != 0) {
            ddVar.a(19, this.s);
        }
        if (this.t != null && this.t.length > 0) {
            while (i < this.t.length) {
                ddVar.a(20, this.t[i]);
                i++;
            }
        }
        if (this.d != 0) {
            ddVar.a(21, this.d);
        }
        super.a(ddVar);
    }

    protected final int b() {
        int i;
        int i2 = 0;
        int b = super.b();
        if (this.b != 0) {
            b += dd.b(1, this.b);
        }
        if (!this.e.equals("")) {
            b += dd.b(2, this.e);
        }
        if (this.i != null && this.i.length > 0) {
            i = b;
            for (dl dlVar : this.i) {
                if (dlVar != null) {
                    i += dd.b(3, dlVar);
                }
            }
            b = i;
        }
        if (!Arrays.equals(this.k, do.h)) {
            b += dd.b(6, this.k);
        }
        if (this.n != null) {
            b += dd.b(7, this.n);
        }
        if (!Arrays.equals(this.l, do.h)) {
            b += dd.b(8, this.l);
        }
        if (this.j != null) {
            b += dd.b(9, this.j);
        }
        if (this.h) {
            boolean z = this.h;
            b += dd.b(10) + 1;
        }
        if (this.f != 0) {
            b += dd.b(11, this.f);
        }
        if (this.g != 0) {
            b += dd.b(12, this.g);
        }
        if (!Arrays.equals(this.m, do.h)) {
            b += dd.b(13, this.m);
        }
        if (!this.o.equals("")) {
            b += dd.b(14, this.o);
        }
        if (this.p != 180000) {
            b += dd.b(dd.c(this.p)) + dd.b(15);
        }
        if (this.q != null) {
            b += dd.b(16, this.q);
        }
        if (this.c != 0) {
            b += dd.b(17, this.c);
        }
        if (!Arrays.equals(this.r, do.h)) {
            b += dd.b(18, this.r);
        }
        if (this.s != 0) {
            b += dd.b(19, this.s);
        }
        if (this.t != null && this.t.length > 0) {
            for (int a : this.t) {
                i2 += dd.a(a);
            }
            b = (b + i2) + (this.t.length * 2);
        }
        return this.d != 0 ? b + dd.b(21, this.d) : b;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof dt)) {
                return false;
            }
            dt dtVar = (dt) obj;
            if (this.b != dtVar.b || this.c != dtVar.c || this.d != dtVar.d) {
                return false;
            }
            if (this.e == null) {
                if (dtVar.e != null) {
                    return false;
                }
            } else if (!this.e.equals(dtVar.e)) {
                return false;
            }
            if (this.f != dtVar.f || this.g != dtVar.g || this.h != dtVar.h || !dj.a(this.i, dtVar.i)) {
                return false;
            }
            if (this.j == null) {
                if (dtVar.j != null) {
                    return false;
                }
            } else if (!this.j.equals(dtVar.j)) {
                return false;
            }
            if (!Arrays.equals(this.k, dtVar.k) || !Arrays.equals(this.l, dtVar.l) || !Arrays.equals(this.m, dtVar.m)) {
                return false;
            }
            if (this.n == null) {
                if (dtVar.n != null) {
                    return false;
                }
            } else if (!this.n.equals(dtVar.n)) {
                return false;
            }
            if (this.o == null) {
                if (dtVar.o != null) {
                    return false;
                }
            } else if (!this.o.equals(dtVar.o)) {
                return false;
            }
            if (this.p != dtVar.p) {
                return false;
            }
            if (this.q == null) {
                if (dtVar.q != null) {
                    return false;
                }
            } else if (!this.q.equals(dtVar.q)) {
                return false;
            }
            if (!Arrays.equals(this.r, dtVar.r) || this.s != dtVar.s || !dj.a(this.t, dtVar.t)) {
                return false;
            }
            if (this.a != null && !this.a.c()) {
                return this.a.equals(dtVar.a);
            }
            if (!(dtVar.a == null || dtVar.a.c())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int i2 = (int) (this.b ^ (this.b >>> 32));
        int i3 = (int) (this.c ^ (this.c >>> 32));
        int i4 = (int) (this.d ^ (this.d >>> 32));
        int hashCode2 = this.e == null ? 0 : this.e.hashCode();
        int i5 = this.f;
        int i6 = this.g;
        int i7 = this.h ? 1231 : 1237;
        int a = dj.a(this.i);
        int hashCode3 = this.j == null ? 0 : this.j.hashCode();
        int hashCode4 = Arrays.hashCode(this.k);
        int hashCode5 = Arrays.hashCode(this.l);
        int hashCode6 = Arrays.hashCode(this.m);
        int hashCode7 = this.n == null ? 0 : this.n.hashCode();
        int hashCode8 = this.o == null ? 0 : this.o.hashCode();
        int i8 = (int) (this.p ^ (this.p >>> 32));
        int hashCode9 = this.q == null ? 0 : this.q.hashCode();
        int hashCode10 = Arrays.hashCode(this.r);
        int i9 = this.s;
        int a2 = dj.a(this.t);
        if (!(this.a == null || this.a.c())) {
            i = this.a.hashCode();
        }
        return ((((((((((((((((((((((((((((((((hashCode2 + ((((((((hashCode + 527) * 31) + i2) * 31) + i3) * 31) + i4) * 31)) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + a) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i9) * 31) + a2) * 31) + i;
    }
}
