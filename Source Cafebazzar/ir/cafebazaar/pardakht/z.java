package ir.cafebazaar.pardakht;

import com.congenialmobile.util.a;
import com.congenialmobile.util.h;
import java.util.UUID;

final class z {
    final String a;
    final String b;
    final String c;
    final String d;
    final /* synthetic */ PardakhtActivity e;

    private z(PardakhtActivity pardakhtActivity) {
        this(pardakhtActivity, null, null, null);
    }

    private z(PardakhtActivity pardakhtActivity, String str, String str2, String str3) {
        this.e = pardakhtActivity;
        this.a = str;
        this.b = str2;
        this.c = str3;
        String a = a.a(h.a(UUID.randomUUID()), false);
        if (a.length() > 31) {
            a = a.substring(0, 31);
        }
        this.d = a;
    }

    public final String toString() {
        return "PardakhtRequestData(packageName=" + this.a + ", sku=" + this.b + ")";
    }
}
