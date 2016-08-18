package com.google.android.gms.a;

public final class cn extends dl {
    private static volatile cn[] B;
    public Integer a;
    public ck[] b;
    public co[] c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public String i;
    public String j;
    public String k;
    public String l;
    public Integer m;
    public String n;
    public String o;
    public String p;
    public Long q;
    public Long r;
    public String s;
    public Boolean t;
    public String u;
    public Long v;
    public Integer w;
    public String x;
    public String y;
    public Boolean z;

    public cn() {
        this.a = null;
        this.b = ck.d_();
        this.c = co.g_();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = -1;
    }

    public static cn[] f_() {
        if (B == null) {
            synchronized (dj.a) {
                if (B == null) {
                    B = new cn[0];
                }
            }
        }
        return B;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        return b(dcVar);
    }

    public final void a(dd ddVar) {
        int i = 0;
        if (this.a != null) {
            ddVar.a(1, this.a.intValue());
        }
        if (this.b != null && this.b.length > 0) {
            for (dl dlVar : this.b) {
                if (dlVar != null) {
                    ddVar.a(2, dlVar);
                }
            }
        }
        if (this.c != null && this.c.length > 0) {
            while (i < this.c.length) {
                dl dlVar2 = this.c[i];
                if (dlVar2 != null) {
                    ddVar.a(3, dlVar2);
                }
                i++;
            }
        }
        if (this.d != null) {
            ddVar.a(4, this.d.longValue());
        }
        if (this.e != null) {
            ddVar.a(5, this.e.longValue());
        }
        if (this.f != null) {
            ddVar.a(6, this.f.longValue());
        }
        if (this.h != null) {
            ddVar.a(7, this.h.longValue());
        }
        if (this.i != null) {
            ddVar.a(8, this.i);
        }
        if (this.j != null) {
            ddVar.a(9, this.j);
        }
        if (this.k != null) {
            ddVar.a(10, this.k);
        }
        if (this.l != null) {
            ddVar.a(11, this.l);
        }
        if (this.m != null) {
            ddVar.a(12, this.m.intValue());
        }
        if (this.n != null) {
            ddVar.a(13, this.n);
        }
        if (this.o != null) {
            ddVar.a(14, this.o);
        }
        if (this.p != null) {
            ddVar.a(16, this.p);
        }
        if (this.q != null) {
            ddVar.a(17, this.q.longValue());
        }
        if (this.r != null) {
            ddVar.a(18, this.r.longValue());
        }
        if (this.s != null) {
            ddVar.a(19, this.s);
        }
        if (this.t != null) {
            ddVar.a(20, this.t.booleanValue());
        }
        if (this.u != null) {
            ddVar.a(21, this.u);
        }
        if (this.v != null) {
            ddVar.a(22, this.v.longValue());
        }
        if (this.w != null) {
            ddVar.a(23, this.w.intValue());
        }
        if (this.x != null) {
            ddVar.a(24, this.x);
        }
        if (this.y != null) {
            ddVar.a(25, this.y);
        }
        if (this.g != null) {
            ddVar.a(26, this.g.longValue());
        }
        if (this.z != null) {
            ddVar.a(28, this.z.booleanValue());
        }
        super.a(ddVar);
    }

    protected final int b() {
        int i = 0;
        int b = super.b();
        if (this.a != null) {
            b += dd.b(1, this.a.intValue());
        }
        if (this.b != null && this.b.length > 0) {
            int i2 = b;
            for (dl dlVar : this.b) {
                if (dlVar != null) {
                    i2 += dd.b(2, dlVar);
                }
            }
            b = i2;
        }
        if (this.c != null && this.c.length > 0) {
            while (i < this.c.length) {
                dl dlVar2 = this.c[i];
                if (dlVar2 != null) {
                    b += dd.b(3, dlVar2);
                }
                i++;
            }
        }
        if (this.d != null) {
            b += dd.b(4, this.d.longValue());
        }
        if (this.e != null) {
            b += dd.b(5, this.e.longValue());
        }
        if (this.f != null) {
            b += dd.b(6, this.f.longValue());
        }
        if (this.h != null) {
            b += dd.b(7, this.h.longValue());
        }
        if (this.i != null) {
            b += dd.b(8, this.i);
        }
        if (this.j != null) {
            b += dd.b(9, this.j);
        }
        if (this.k != null) {
            b += dd.b(10, this.k);
        }
        if (this.l != null) {
            b += dd.b(11, this.l);
        }
        if (this.m != null) {
            b += dd.b(12, this.m.intValue());
        }
        if (this.n != null) {
            b += dd.b(13, this.n);
        }
        if (this.o != null) {
            b += dd.b(14, this.o);
        }
        if (this.p != null) {
            b += dd.b(16, this.p);
        }
        if (this.q != null) {
            b += dd.b(17, this.q.longValue());
        }
        if (this.r != null) {
            b += dd.b(18, this.r.longValue());
        }
        if (this.s != null) {
            b += dd.b(19, this.s);
        }
        if (this.t != null) {
            this.t.booleanValue();
            b += dd.b(20) + 1;
        }
        if (this.u != null) {
            b += dd.b(21, this.u);
        }
        if (this.v != null) {
            b += dd.b(22, this.v.longValue());
        }
        if (this.w != null) {
            b += dd.b(23, this.w.intValue());
        }
        if (this.x != null) {
            b += dd.b(24, this.x);
        }
        if (this.y != null) {
            b += dd.b(25, this.y);
        }
        if (this.g != null) {
            b += dd.b(26, this.g.longValue());
        }
        if (this.z == null) {
            return b;
        }
        this.z.booleanValue();
        return b + (dd.b(28) + 1);
    }

    public final cn b(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.a = Integer.valueOf(dcVar.e());
                    continue;
                case 18:
                    b = do.b(dcVar, 18);
                    a = this.b == null ? 0 : this.b.length;
                    obj = new ck[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ck();
                        dcVar.a(obj[a]);
                        dcVar.a();
                        a++;
                    }
                    obj[a] = new ck();
                    dcVar.a(obj[a]);
                    this.b = obj;
                    continue;
                case 26:
                    b = do.b(dcVar, 26);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new co[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new co();
                        dcVar.a(obj[a]);
                        dcVar.a();
                        a++;
                    }
                    obj[a] = new co();
                    dcVar.a(obj[a]);
                    this.c = obj;
                    continue;
                case 32:
                    this.d = Long.valueOf(dcVar.f());
                    continue;
                case 40:
                    this.e = Long.valueOf(dcVar.f());
                    continue;
                case 48:
                    this.f = Long.valueOf(dcVar.f());
                    continue;
                case 56:
                    this.h = Long.valueOf(dcVar.f());
                    continue;
                case 66:
                    this.i = dcVar.c();
                    continue;
                case 74:
                    this.j = dcVar.c();
                    continue;
                case 82:
                    this.k = dcVar.c();
                    continue;
                case 90:
                    this.l = dcVar.c();
                    continue;
                case 96:
                    this.m = Integer.valueOf(dcVar.e());
                    continue;
                case 106:
                    this.n = dcVar.c();
                    continue;
                case 114:
                    this.o = dcVar.c();
                    continue;
                case 130:
                    this.p = dcVar.c();
                    continue;
                case 136:
                    this.q = Long.valueOf(dcVar.f());
                    continue;
                case 144:
                    this.r = Long.valueOf(dcVar.f());
                    continue;
                case 154:
                    this.s = dcVar.c();
                    continue;
                case 160:
                    this.t = Boolean.valueOf(dcVar.b());
                    continue;
                case 170:
                    this.u = dcVar.c();
                    continue;
                case 176:
                    this.v = Long.valueOf(dcVar.f());
                    continue;
                case 184:
                    this.w = Integer.valueOf(dcVar.e());
                    continue;
                case 194:
                    this.x = dcVar.c();
                    continue;
                case 202:
                    this.y = dcVar.c();
                    continue;
                case 208:
                    this.g = Long.valueOf(dcVar.f());
                    continue;
                case 224:
                    this.z = Boolean.valueOf(dcVar.b());
                    continue;
                default:
                    if (!do.a(dcVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof cn)) {
                return false;
            }
            cn cnVar = (cn) obj;
            if (this.a == null) {
                if (cnVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(cnVar.a)) {
                return false;
            }
            if (!dj.a(this.b, cnVar.b) || !dj.a(this.c, cnVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (cnVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(cnVar.d)) {
                return false;
            }
            if (this.e == null) {
                if (cnVar.e != null) {
                    return false;
                }
            } else if (!this.e.equals(cnVar.e)) {
                return false;
            }
            if (this.f == null) {
                if (cnVar.f != null) {
                    return false;
                }
            } else if (!this.f.equals(cnVar.f)) {
                return false;
            }
            if (this.g == null) {
                if (cnVar.g != null) {
                    return false;
                }
            } else if (!this.g.equals(cnVar.g)) {
                return false;
            }
            if (this.h == null) {
                if (cnVar.h != null) {
                    return false;
                }
            } else if (!this.h.equals(cnVar.h)) {
                return false;
            }
            if (this.i == null) {
                if (cnVar.i != null) {
                    return false;
                }
            } else if (!this.i.equals(cnVar.i)) {
                return false;
            }
            if (this.j == null) {
                if (cnVar.j != null) {
                    return false;
                }
            } else if (!this.j.equals(cnVar.j)) {
                return false;
            }
            if (this.k == null) {
                if (cnVar.k != null) {
                    return false;
                }
            } else if (!this.k.equals(cnVar.k)) {
                return false;
            }
            if (this.l == null) {
                if (cnVar.l != null) {
                    return false;
                }
            } else if (!this.l.equals(cnVar.l)) {
                return false;
            }
            if (this.m == null) {
                if (cnVar.m != null) {
                    return false;
                }
            } else if (!this.m.equals(cnVar.m)) {
                return false;
            }
            if (this.n == null) {
                if (cnVar.n != null) {
                    return false;
                }
            } else if (!this.n.equals(cnVar.n)) {
                return false;
            }
            if (this.o == null) {
                if (cnVar.o != null) {
                    return false;
                }
            } else if (!this.o.equals(cnVar.o)) {
                return false;
            }
            if (this.p == null) {
                if (cnVar.p != null) {
                    return false;
                }
            } else if (!this.p.equals(cnVar.p)) {
                return false;
            }
            if (this.q == null) {
                if (cnVar.q != null) {
                    return false;
                }
            } else if (!this.q.equals(cnVar.q)) {
                return false;
            }
            if (this.r == null) {
                if (cnVar.r != null) {
                    return false;
                }
            } else if (!this.r.equals(cnVar.r)) {
                return false;
            }
            if (this.s == null) {
                if (cnVar.s != null) {
                    return false;
                }
            } else if (!this.s.equals(cnVar.s)) {
                return false;
            }
            if (this.t == null) {
                if (cnVar.t != null) {
                    return false;
                }
            } else if (!this.t.equals(cnVar.t)) {
                return false;
            }
            if (this.u == null) {
                if (cnVar.u != null) {
                    return false;
                }
            } else if (!this.u.equals(cnVar.u)) {
                return false;
            }
            if (this.v == null) {
                if (cnVar.v != null) {
                    return false;
                }
            } else if (!this.v.equals(cnVar.v)) {
                return false;
            }
            if (this.w == null) {
                if (cnVar.w != null) {
                    return false;
                }
            } else if (!this.w.equals(cnVar.w)) {
                return false;
            }
            if (this.x == null) {
                if (cnVar.x != null) {
                    return false;
                }
            } else if (!this.x.equals(cnVar.x)) {
                return false;
            }
            if (this.y == null) {
                if (cnVar.y != null) {
                    return false;
                }
            } else if (!this.y.equals(cnVar.y)) {
                return false;
            }
            if (this.z == null) {
                if (cnVar.z != null) {
                    return false;
                }
            } else if (!this.z.equals(cnVar.z)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int hashCode2 = this.a == null ? 0 : this.a.hashCode();
        int a = dj.a(this.b);
        int a2 = dj.a(this.c);
        int hashCode3 = this.d == null ? 0 : this.d.hashCode();
        int hashCode4 = this.e == null ? 0 : this.e.hashCode();
        int hashCode5 = this.f == null ? 0 : this.f.hashCode();
        int hashCode6 = this.g == null ? 0 : this.g.hashCode();
        int hashCode7 = this.h == null ? 0 : this.h.hashCode();
        int hashCode8 = this.i == null ? 0 : this.i.hashCode();
        int hashCode9 = this.j == null ? 0 : this.j.hashCode();
        int hashCode10 = this.k == null ? 0 : this.k.hashCode();
        int hashCode11 = this.l == null ? 0 : this.l.hashCode();
        int hashCode12 = this.m == null ? 0 : this.m.hashCode();
        int hashCode13 = this.n == null ? 0 : this.n.hashCode();
        int hashCode14 = this.o == null ? 0 : this.o.hashCode();
        int hashCode15 = this.p == null ? 0 : this.p.hashCode();
        int hashCode16 = this.q == null ? 0 : this.q.hashCode();
        int hashCode17 = this.r == null ? 0 : this.r.hashCode();
        int hashCode18 = this.s == null ? 0 : this.s.hashCode();
        int hashCode19 = this.t == null ? 0 : this.t.hashCode();
        int hashCode20 = this.u == null ? 0 : this.u.hashCode();
        int hashCode21 = this.v == null ? 0 : this.v.hashCode();
        int hashCode22 = this.w == null ? 0 : this.w.hashCode();
        int hashCode23 = this.x == null ? 0 : this.x.hashCode();
        int hashCode24 = this.y == null ? 0 : this.y.hashCode();
        if (this.z != null) {
            i = this.z.hashCode();
        }
        return ((((((((((((((((((((((((((((((((((((((((((((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + a) * 31) + a2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + i;
    }
}
