package android.support.v7.internal.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class o implements Comparable {
    public final ResolveInfo a;
    public float b;
    final /* synthetic */ n c;

    public o(n nVar, ResolveInfo resolveInfo) {
        this.c = nVar;
        this.a = resolveInfo;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.floatToIntBits(((o) obj).b) - Float.floatToIntBits(this.b);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.b) != Float.floatToIntBits(((o) obj).b)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + 31;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
