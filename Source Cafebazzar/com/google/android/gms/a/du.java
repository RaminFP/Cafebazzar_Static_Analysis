package com.google.android.gms.a;

public final class du extends df {
    private static volatile du[] d;
    public String b;
    public String c;

    public du() {
        this.b = "";
        this.c = "";
        this.a = null;
        this.A = -1;
    }

    public static du[] e() {
        if (d == null) {
            synchronized (dj.a) {
                if (d == null) {
                    d = new du[0];
                }
            }
        }
        return d;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.b = dcVar.c();
                    continue;
                case 18:
                    this.c = dcVar.c();
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
        if (!this.b.equals("")) {
            ddVar.a(1, this.b);
        }
        if (!this.c.equals("")) {
            ddVar.a(2, this.c);
        }
        super.a(ddVar);
    }

    protected final int b() {
        int b = super.b();
        if (!this.b.equals("")) {
            b += dd.b(1, this.b);
        }
        return !this.c.equals("") ? b + dd.b(2, this.c) : b;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof du)) {
                return false;
            }
            du duVar = (du) obj;
            if (this.b == null) {
                if (duVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(duVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (duVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(duVar.c)) {
                return false;
            }
            if (this.a != null && !this.a.c()) {
                return this.a.equals(duVar.a);
            }
            if (!(duVar.a == null || duVar.a.c())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int hashCode2 = this.b == null ? 0 : this.b.hashCode();
        int hashCode3 = this.c == null ? 0 : this.c.hashCode();
        if (!(this.a == null || this.a.c())) {
            i = this.a.hashCode();
        }
        return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
    }
}
