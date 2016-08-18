package com.google.android.gms.a;

public final class ck extends dl {
    private static volatile ck[] f;
    public cl[] a;
    public String b;
    public Long c;
    public Long d;
    public Integer e;

    public ck() {
        this.a = cl.e_();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.A = -1;
    }

    public static ck[] d_() {
        if (f == null) {
            synchronized (dj.a) {
                if (f == null) {
                    f = new ck[0];
                }
            }
        }
        return f;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int b = do.b(dcVar, 10);
                    a = this.a == null ? 0 : this.a.length;
                    Object obj = new cl[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new cl();
                        dcVar.a(obj[a]);
                        dcVar.a();
                        a++;
                    }
                    obj[a] = new cl();
                    dcVar.a(obj[a]);
                    this.a = obj;
                    continue;
                case 18:
                    this.b = dcVar.c();
                    continue;
                case 24:
                    this.c = Long.valueOf(dcVar.f());
                    continue;
                case 32:
                    this.d = Long.valueOf(dcVar.f());
                    continue;
                case 40:
                    this.e = Integer.valueOf(dcVar.e());
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

    public final void a(dd ddVar) {
        if (this.a != null && this.a.length > 0) {
            for (dl dlVar : this.a) {
                if (dlVar != null) {
                    ddVar.a(1, dlVar);
                }
            }
        }
        if (this.b != null) {
            ddVar.a(2, this.b);
        }
        if (this.c != null) {
            ddVar.a(3, this.c.longValue());
        }
        if (this.d != null) {
            ddVar.a(4, this.d.longValue());
        }
        if (this.e != null) {
            ddVar.a(5, this.e.intValue());
        }
        super.a(ddVar);
    }

    protected final int b() {
        int b = super.b();
        if (this.a != null && this.a.length > 0) {
            for (dl dlVar : this.a) {
                if (dlVar != null) {
                    b += dd.b(1, dlVar);
                }
            }
        }
        if (this.b != null) {
            b += dd.b(2, this.b);
        }
        if (this.c != null) {
            b += dd.b(3, this.c.longValue());
        }
        if (this.d != null) {
            b += dd.b(4, this.d.longValue());
        }
        return this.e != null ? b + dd.b(5, this.e.intValue()) : b;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ck)) {
                return false;
            }
            ck ckVar = (ck) obj;
            if (!dj.a(this.a, ckVar.a)) {
                return false;
            }
            if (this.b == null) {
                if (ckVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(ckVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (ckVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(ckVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (ckVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(ckVar.d)) {
                return false;
            }
            if (this.e == null) {
                if (ckVar.e != null) {
                    return false;
                }
            } else if (!this.e.equals(ckVar.e)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int a = dj.a(this.a);
        int hashCode2 = this.b == null ? 0 : this.b.hashCode();
        int hashCode3 = this.c == null ? 0 : this.c.hashCode();
        int hashCode4 = this.d == null ? 0 : this.d.hashCode();
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return ((((((hashCode2 + ((((hashCode + 527) * 31) + a) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }
}
