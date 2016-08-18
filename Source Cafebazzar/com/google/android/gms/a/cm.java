package com.google.android.gms.a;

public final class cm extends dl {
    public cn[] a;

    public cm() {
        this.a = cn.f_();
        this.A = -1;
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
                    Object obj = new cn[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new cn();
                        dcVar.a(obj[a]);
                        dcVar.a();
                        a++;
                    }
                    obj[a] = new cn();
                    dcVar.a(obj[a]);
                    this.a = obj;
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
        return b;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof cm)) {
                return false;
            }
            if (!dj.a(this.a, ((cm) obj).a)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((getClass().getName().hashCode() + 527) * 31) + dj.a(this.a);
    }
}
