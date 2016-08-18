package com.google.android.gms.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class di implements Cloneable {
    List a = new ArrayList();
    private dg b;
    private Object c;

    di() {
    }

    private byte[] c() {
        byte[] bArr = new byte[a()];
        a(dd.a(bArr));
        return bArr;
    }

    final int a() {
        if (this.c != null) {
            return this.b.a(this.c);
        }
        int i = 0;
        for (dn dnVar : this.a) {
            i += dnVar.b.length + (dd.d(dnVar.a) + 0);
        }
        return i;
    }

    final void a(dd ddVar) {
        if (this.c != null) {
            this.b.a(this.c, ddVar);
            return;
        }
        for (dn dnVar : this.a) {
            ddVar.c(dnVar.a);
            ddVar.c(dnVar.b);
        }
    }

    public final di b() {
        int i = 0;
        di diVar = new di();
        try {
            diVar.b = this.b;
            if (this.a == null) {
                diVar.a = null;
            } else {
                diVar.a.addAll(this.a);
            }
            if (this.c != null) {
                if (this.c instanceof dl) {
                    diVar.c = ((dl) this.c).a();
                    return diVar;
                } else if (this.c instanceof byte[]) {
                    diVar.c = ((byte[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.c;
                    Object obj = new byte[bArr.length][];
                    diVar.c = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.c instanceof boolean[]) {
                    diVar.c = ((boolean[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof int[]) {
                    diVar.c = ((int[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof long[]) {
                    diVar.c = ((long[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof float[]) {
                    diVar.c = ((float[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof double[]) {
                    diVar.c = ((double[]) this.c).clone();
                    return diVar;
                } else if (this.c instanceof dl[]) {
                    dl[] dlVarArr = (dl[]) this.c;
                    Object obj2 = new dl[dlVarArr.length];
                    diVar.c = obj2;
                    while (i < dlVarArr.length) {
                        obj2[i] = dlVarArr[i].a();
                        i++;
                    }
                }
            }
            return diVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof di)) {
            return false;
        }
        di diVar = (di) obj;
        if (this.c != null && diVar.c != null) {
            return this.b == diVar.b ? !this.b.b.isArray() ? this.c.equals(diVar.c) : this.c instanceof byte[] ? Arrays.equals((byte[]) this.c, (byte[]) diVar.c) : this.c instanceof int[] ? Arrays.equals((int[]) this.c, (int[]) diVar.c) : this.c instanceof long[] ? Arrays.equals((long[]) this.c, (long[]) diVar.c) : this.c instanceof float[] ? Arrays.equals((float[]) this.c, (float[]) diVar.c) : this.c instanceof double[] ? Arrays.equals((double[]) this.c, (double[]) diVar.c) : this.c instanceof boolean[] ? Arrays.equals((boolean[]) this.c, (boolean[]) diVar.c) : Arrays.deepEquals((Object[]) this.c, (Object[]) diVar.c) : false;
        } else {
            if (this.a != null && diVar.a != null) {
                return this.a.equals(diVar.a);
            }
            try {
                return Arrays.equals(c(), diVar.c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
