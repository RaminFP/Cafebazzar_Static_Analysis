package com.google.android.gms.a;

public final class dq extends df {
    public String[] b;
    public String[] c;
    public int[] d;
    public long[] e;

    public dq() {
        this.b = do.f;
        this.c = do.f;
        this.d = do.a;
        this.e = do.b;
        this.a = null;
        this.A = -1;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            int b;
            Object obj;
            int b2;
            Object obj2;
            switch (a) {
                case 0:
                    break;
                case 10:
                    b = do.b(dcVar, 10);
                    a = this.b == null ? 0 : this.b.length;
                    obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.c();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.c();
                    this.b = obj;
                    continue;
                case 18:
                    b = do.b(dcVar, 18);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.c();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.c();
                    this.c = obj;
                    continue;
                case 24:
                    b = do.b(dcVar, 24);
                    a = this.d == null ? 0 : this.d.length;
                    obj = new int[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.e();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.e();
                    this.d = obj;
                    continue;
                case 26:
                    b2 = dcVar.b(dcVar.e());
                    b = dcVar.i();
                    a = 0;
                    while (dcVar.h() > 0) {
                        dcVar.e();
                        a++;
                    }
                    dcVar.d(b);
                    b = this.d == null ? 0 : this.d.length;
                    obj2 = new int[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.d, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = dcVar.e();
                        b++;
                    }
                    this.d = obj2;
                    dcVar.c(b2);
                    continue;
                case 32:
                    b = do.b(dcVar, 32);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.f();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.f();
                    this.e = obj;
                    continue;
                case 34:
                    b2 = dcVar.b(dcVar.e());
                    b = dcVar.i();
                    a = 0;
                    while (dcVar.h() > 0) {
                        dcVar.f();
                        a++;
                    }
                    dcVar.d(b);
                    b = this.e == null ? 0 : this.e.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.e, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = dcVar.f();
                        b++;
                    }
                    this.e = obj2;
                    dcVar.c(b2);
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
        if (this.b != null && this.b.length > 0) {
            for (String str : this.b) {
                if (str != null) {
                    ddVar.a(1, str);
                }
            }
        }
        if (this.c != null && this.c.length > 0) {
            for (String str2 : this.c) {
                if (str2 != null) {
                    ddVar.a(2, str2);
                }
            }
        }
        if (this.d != null && this.d.length > 0) {
            for (int a : this.d) {
                ddVar.a(3, a);
            }
        }
        if (this.e != null && this.e.length > 0) {
            while (i < this.e.length) {
                ddVar.a(4, this.e[i]);
                i++;
            }
        }
        super.a(ddVar);
    }

    protected final int b() {
        int i;
        int i2;
        int i3 = 0;
        int b = super.b();
        if (this.b != null && this.b.length > 0) {
            i = 0;
            i2 = 0;
            for (String str : this.b) {
                if (str != null) {
                    i++;
                    i2 += dd.a(str);
                }
            }
            b = (i * 1) + (i2 + b);
        }
        if (this.c != null && this.c.length > 0) {
            i = 0;
            i2 = 0;
            for (String str2 : this.c) {
                if (str2 != null) {
                    i++;
                    i2 += dd.a(str2);
                }
            }
            b = (i2 + b) + (i * 1);
        }
        if (this.d != null && this.d.length > 0) {
            i = 0;
            for (int a : this.d) {
                i += dd.a(a);
            }
            b = (i + b) + (this.d.length * 1);
        }
        if (this.e == null || this.e.length <= 0) {
            return b;
        }
        for (long b2 : this.e) {
            i3 += dd.b(b2);
        }
        return (b + i3) + (this.e.length * 1);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof dq)) {
                return false;
            }
            dq dqVar = (dq) obj;
            if (!dj.a(this.b, dqVar.b) || !dj.a(this.c, dqVar.c) || !dj.a(this.d, dqVar.d) || !dj.a(this.e, dqVar.e)) {
                return false;
            }
            if (this.a != null && !this.a.c()) {
                return this.a.equals(dqVar.a);
            }
            if (!(dqVar.a == null || dqVar.a.c())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = getClass().getName().hashCode();
        int a = dj.a(this.b);
        int a2 = dj.a(this.c);
        int a3 = dj.a(this.d);
        int a4 = dj.a(this.e);
        int hashCode2 = (this.a == null || this.a.c()) ? 0 : this.a.hashCode();
        return hashCode2 + ((((((((((hashCode + 527) * 31) + a) * 31) + a2) * 31) + a3) * 31) + a4) * 31);
    }
}
