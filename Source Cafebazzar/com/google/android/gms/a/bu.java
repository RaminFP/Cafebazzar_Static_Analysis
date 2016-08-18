package com.google.android.gms.a;

import java.util.Arrays;

public final class bu {
    public final int a;
    public final int b;

    public bu(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bu) {
            if (this == obj) {
                return true;
            }
            bu buVar = (bu) obj;
            if (buVar.a == this.a && buVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }
}
