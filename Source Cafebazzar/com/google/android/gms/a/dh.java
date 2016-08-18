package com.google.android.gms.a;

public final class dh implements Cloneable {
    static final di a = new di();
    boolean b;
    int[] c;
    di[] d;
    int e;

    dh() {
        this(10);
    }

    private dh(int i) {
        this.b = false;
        int b = b(i);
        this.c = new int[b];
        this.d = new di[b];
        this.e = 0;
    }

    final di a(int i) {
        if (this.b) {
            a();
        }
        return this.d[i];
    }

    void a() {
        int i = this.e;
        int[] iArr = this.c;
        di[] diVarArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            di diVar = diVarArr[i3];
            if (diVar != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    diVarArr[i2] = diVar;
                    diVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    final int b() {
        if (this.b) {
            a();
        }
        return this.e;
    }

    int b(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    int c(int i) {
        int i2 = 0;
        int i3 = this.e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final boolean c() {
        return b() == 0;
    }

    public final /* synthetic */ Object clone() {
        return d();
    }

    public final dh d() {
        int i = 0;
        int b = b();
        dh dhVar = new dh(b);
        System.arraycopy(this.c, 0, dhVar.c, 0, b);
        while (i < b) {
            if (this.d[i] != null) {
                dhVar.d[i] = this.d[i].b();
            }
            i++;
        }
        dhVar.e = b;
        return dhVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dh)) {
            return false;
        }
        dh dhVar = (dh) obj;
        if (b() != dhVar.b()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.c;
        int[] iArr2 = dhVar.c;
        int i2 = this.e;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            di[] diVarArr = this.d;
            di[] diVarArr2 = dhVar.d;
            i2 = this.e;
            for (i = 0; i < i2; i++) {
                if (!diVarArr[i].equals(diVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.b) {
            a();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.e; i2++) {
            i = (((i * 31) + this.c[i2]) * 31) + this.d[i2].hashCode();
        }
        return i;
    }
}
