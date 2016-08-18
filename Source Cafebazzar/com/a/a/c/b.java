package com.a.a.c;

final class b {
    public static final b b = new b(new byte[0]);
    final byte[] a;
    private volatile int c = 0;

    private b(byte[] bArr) {
        this.a = bArr;
    }

    public static b a(String str) {
        try {
            return new b(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static b a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, 0, obj, 0, i2);
        return new b(obj);
    }

    public final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int length = this.a.length;
            if (length != bVar.a.length) {
                return false;
            }
            byte[] bArr = this.a;
            byte[] bArr2 = bVar.a;
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.a;
            int length = this.a.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                byte b = bArr[i2];
                i2++;
                i = (i * 31) + b;
            }
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }
}
