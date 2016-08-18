package com.google.android.gms.a;

public final class cl extends dl {
    private static volatile cl[] e;
    public String a;
    public String b;
    public Long c;
    public Float d;

    public cl() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.A = -1;
    }

    public static cl[] e_() {
        if (e == null) {
            synchronized (dj.a) {
                if (e == null) {
                    e = new cl[0];
                }
            }
        }
        return e;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.a = dcVar.c();
                    continue;
                case 18:
                    this.b = dcVar.c();
                    continue;
                case 24:
                    this.c = Long.valueOf(dcVar.f());
                    continue;
                case 37:
                    this.d = Float.valueOf(Float.intBitsToFloat(dcVar.g()));
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
            ddVar.a(1, this.a);
        }
        if (this.b != null) {
            ddVar.a(2, this.b);
        }
        if (this.c != null) {
            ddVar.a(3, this.c.longValue());
        }
        if (this.d != null) {
            ddVar.a(4, this.d.floatValue());
        }
        super.a(ddVar);
    }

    protected final int b() {
        int b = super.b();
        if (this.a != null) {
            b += dd.b(1, this.a);
        }
        if (this.b != null) {
            b += dd.b(2, this.b);
        }
        if (this.c != null) {
            b += dd.b(3, this.c.longValue());
        }
        if (this.d == null) {
            return b;
        }
        this.d.floatValue();
        return b + (dd.b(4) + 4);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof cl)) {
                return false;
            }
            cl clVar = (cl) obj;
            if (this.a == null) {
                if (clVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(clVar.a)) {
                return false;
            }
            if (this.b == null) {
                if (clVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(clVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (clVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(clVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (clVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(clVar.d)) {
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
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }
}
