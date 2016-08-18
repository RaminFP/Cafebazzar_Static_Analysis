package com.google.android.gms.a;

public final class co extends dl {
    private static volatile co[] f;
    public Long a;
    public String b;
    public String c;
    public Long d;
    public Float e;

    public co() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.A = -1;
    }

    public static co[] g_() {
        if (f == null) {
            synchronized (dj.a) {
                if (f == null) {
                    f = new co[0];
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
                case 8:
                    this.a = Long.valueOf(dcVar.f());
                    continue;
                case 18:
                    this.b = dcVar.c();
                    continue;
                case 26:
                    this.c = dcVar.c();
                    continue;
                case 32:
                    this.d = Long.valueOf(dcVar.f());
                    continue;
                case 45:
                    this.e = Float.valueOf(Float.intBitsToFloat(dcVar.g()));
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
        if (this.a != null) {
            ddVar.a(1, this.a.longValue());
        }
        if (this.b != null) {
            ddVar.a(2, this.b);
        }
        if (this.c != null) {
            ddVar.a(3, this.c);
        }
        if (this.d != null) {
            ddVar.a(4, this.d.longValue());
        }
        if (this.e != null) {
            ddVar.a(5, this.e.floatValue());
        }
        super.a(ddVar);
    }

    protected final int b() {
        int b = super.b();
        if (this.a != null) {
            b += dd.b(1, this.a.longValue());
        }
        if (this.b != null) {
            b += dd.b(2, this.b);
        }
        if (this.c != null) {
            b += dd.b(3, this.c);
        }
        if (this.d != null) {
            b += dd.b(4, this.d.longValue());
        }
        if (this.e == null) {
            return b;
        }
        this.e.floatValue();
        return b + (dd.b(5) + 4);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof co)) {
                return false;
            }
            co coVar = (co) obj;
            if (this.a == null) {
                if (coVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(coVar.a)) {
                return false;
            }
            if (this.b == null) {
                if (coVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(coVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (coVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(coVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (coVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(coVar.d)) {
                return false;
            }
            if (this.e == null) {
                if (coVar.e != null) {
                    return false;
                }
            } else if (!this.e.equals(coVar.e)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int hashCode2 = this.a == null ? 0 : this.a.hashCode();
        int hashCode3 = this.b == null ? 0 : this.b.hashCode();
        int hashCode4 = this.c == null ? 0 : this.c.hashCode();
        int hashCode5 = this.d == null ? 0 : this.d.hashCode();
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return ((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
    }
}
