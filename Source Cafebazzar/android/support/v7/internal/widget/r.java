package android.support.v7.internal.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class r {
    public final ComponentName a;
    public final long b;
    public final float c;

    public r(ComponentName componentName, long j, float f) {
        this.a = componentName;
        this.b = j;
        this.c = f;
    }

    public r(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            r rVar = (r) obj;
            if (this.a == null) {
                if (rVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(rVar.a)) {
                return false;
            }
            if (this.b != rVar.b) {
                return false;
            }
            if (Float.floatToIntBits(this.c) != Float.floatToIntBits(rVar.c)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.a);
        stringBuilder.append("; time:").append(this.b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
