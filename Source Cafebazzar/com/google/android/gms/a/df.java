package com.google.android.gms.a;

public abstract class df extends dl {
    protected dh a;

    private df e() {
        df dfVar = (df) super.a();
        dj.a(this, dfVar);
        return dfVar;
    }

    public final /* synthetic */ dl a() {
        return e();
    }

    public void a(dd ddVar) {
        if (this.a != null) {
            for (int i = 0; i < this.a.b(); i++) {
                this.a.a(i).a(ddVar);
            }
        }
    }

    protected final boolean a(dc dcVar, int i) {
        int i2 = dcVar.i();
        if (!dcVar.a(i)) {
            return false;
        }
        byte[] bArr;
        di diVar;
        int b = do.b(i);
        int i3 = dcVar.i() - i2;
        if (i3 == 0) {
            bArr = do.h;
        } else {
            bArr = new byte[i3];
            System.arraycopy(dcVar.a, i2 + dcVar.b, bArr, 0, i3);
        }
        dn dnVar = new dn(i, bArr);
        if (this.a == null) {
            this.a = new dh();
            diVar = null;
        } else {
            dh dhVar = this.a;
            i3 = dhVar.c(b);
            diVar = (i3 < 0 || dhVar.d[i3] == dh.a) ? null : dhVar.d[i3];
        }
        if (diVar == null) {
            diVar = new di();
            dh dhVar2 = this.a;
            int c = dhVar2.c(b);
            if (c >= 0) {
                dhVar2.d[c] = diVar;
            } else {
                c ^= -1;
                if (c >= dhVar2.e || dhVar2.d[c] != dh.a) {
                    if (dhVar2.b && dhVar2.e >= dhVar2.c.length) {
                        dhVar2.a();
                        c = dhVar2.c(b) ^ -1;
                    }
                    if (dhVar2.e >= dhVar2.c.length) {
                        int b2 = dhVar2.b(dhVar2.e + 1);
                        Object obj = new int[b2];
                        Object obj2 = new di[b2];
                        System.arraycopy(dhVar2.c, 0, obj, 0, dhVar2.c.length);
                        System.arraycopy(dhVar2.d, 0, obj2, 0, dhVar2.d.length);
                        dhVar2.c = obj;
                        dhVar2.d = obj2;
                    }
                    if (dhVar2.e - c != 0) {
                        System.arraycopy(dhVar2.c, c, dhVar2.c, c + 1, dhVar2.e - c);
                        System.arraycopy(dhVar2.d, c, dhVar2.d, c + 1, dhVar2.e - c);
                    }
                    dhVar2.c[c] = b;
                    dhVar2.d[c] = diVar;
                    dhVar2.e++;
                } else {
                    dhVar2.c[c] = b;
                    dhVar2.d[c] = diVar;
                }
            }
        }
        diVar.a.add(dnVar);
        return true;
    }

    protected int b() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.a.b()) {
            i2 += this.a.a(i).a();
            i++;
        }
        return i2;
    }

    public /* synthetic */ Object clone() {
        return e();
    }
}
