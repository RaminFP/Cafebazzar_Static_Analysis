package com.google.android.gms.a;

public final class dr extends df {
    public int b;
    public String c;
    public String d;

    public dr() {
        this.b = 0;
        this.c = "";
        this.d = "";
        this.a = null;
        this.A = -1;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    a = dcVar.e();
                    switch (a) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                            this.b = a;
                            break;
                        default:
                            continue;
                    }
                case 18:
                    this.c = dcVar.c();
                    continue;
                case 26:
                    this.d = dcVar.c();
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
        if (this.b != 0) {
            ddVar.a(1, this.b);
        }
        if (!this.c.equals("")) {
            ddVar.a(2, this.c);
        }
        if (!this.d.equals("")) {
            ddVar.a(3, this.d);
        }
        super.a(ddVar);
    }

    protected final int b() {
        int b = super.b();
        if (this.b != 0) {
            b += dd.b(1, this.b);
        }
        if (!this.c.equals("")) {
            b += dd.b(2, this.c);
        }
        return !this.d.equals("") ? b + dd.b(3, this.d) : b;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof dr)) {
                return false;
            }
            dr drVar = (dr) obj;
            if (this.b != drVar.b) {
                return false;
            }
            if (this.c == null) {
                if (drVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(drVar.c)) {
                return false;
            }
            if (this.d == null) {
                if (drVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(drVar.d)) {
                return false;
            }
            if (this.a != null && !this.a.c()) {
                return this.a.equals(drVar.a);
            }
            if (!(drVar.a == null || drVar.a.c())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int i2 = this.b;
        int hashCode2 = this.c == null ? 0 : this.c.hashCode();
        int hashCode3 = this.d == null ? 0 : this.d.hashCode();
        if (!(this.a == null || this.a.c())) {
            i = this.a.hashCode();
        }
        return ((((hashCode2 + ((((hashCode + 527) * 31) + i2) * 31)) * 31) + hashCode3) * 31) + i;
    }
}
