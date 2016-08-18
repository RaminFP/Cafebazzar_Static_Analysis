package com.google.android.gms.a;

import java.util.Arrays;

public final class ds extends df {
    public byte[] b;
    public byte[][] c;
    public boolean d;

    public ds() {
        this.b = do.h;
        this.c = do.g;
        this.d = false;
        this.a = null;
        this.A = -1;
    }

    public final /* synthetic */ dl a(dc dcVar) {
        while (true) {
            int a = dcVar.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.b = dcVar.d();
                    continue;
                case 18:
                    int b = do.b(dcVar, 18);
                    a = this.c == null ? 0 : this.c.length;
                    Object obj = new byte[(b + a)][];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = dcVar.d();
                        dcVar.a();
                        a++;
                    }
                    obj[a] = dcVar.d();
                    this.c = obj;
                    continue;
                case 24:
                    this.d = dcVar.b();
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
        if (!Arrays.equals(this.b, do.h)) {
            ddVar.a(1, this.b);
        }
        if (this.c != null && this.c.length > 0) {
            for (byte[] bArr : this.c) {
                if (bArr != null) {
                    ddVar.a(2, bArr);
                }
            }
        }
        if (this.d) {
            ddVar.a(3, this.d);
        }
        super.a(ddVar);
    }

    protected final int b() {
        int i = 0;
        int b = super.b();
        if (!Arrays.equals(this.b, do.h)) {
            b += dd.b(1, this.b);
        }
        if (this.c != null && this.c.length > 0) {
            int i2 = 0;
            for (byte[] bArr : this.c) {
                if (bArr != null) {
                    i++;
                    i2 += dd.b(bArr);
                }
            }
            b = (b + i2) + (i * 1);
        }
        if (!this.d) {
            return b;
        }
        boolean z = this.d;
        return b + (dd.b(3) + 1);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ds)) {
                return false;
            }
            ds dsVar = (ds) obj;
            if (!Arrays.equals(this.b, dsVar.b) || !dj.a(this.c, dsVar.c) || this.d != dsVar.d) {
                return false;
            }
            if (this.a != null && !this.a.c()) {
                return this.a.equals(dsVar.a);
            }
            if (!(dsVar.a == null || dsVar.a.c())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = getClass().getName().hashCode();
        int hashCode2 = Arrays.hashCode(this.b);
        int a = dj.a(this.c);
        int i = this.d ? 1231 : 1237;
        int hashCode3 = (this.a == null || this.a.c()) ? 0 : this.a.hashCode();
        return ((i + ((((((hashCode + 527) * 31) + hashCode2) * 31) + a) * 31)) * 31) + hashCode3;
    }
}
