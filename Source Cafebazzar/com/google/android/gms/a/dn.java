package com.google.android.gms.a;

import java.util.Arrays;

final class dn {
    final int a;
    final byte[] b;

    dn(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof dn)) {
                return false;
            }
            dn dnVar = (dn) obj;
            if (this.a != dnVar.a) {
                return false;
            }
            if (!Arrays.equals(this.b, dnVar.b)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
