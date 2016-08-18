package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.BazaarApplication;

public final class ag {
    final String a;
    final String b;
    final String c;
    final long d;
    String e;
    public long f;
    public char g;

    private ag(long j) {
        this(BazaarApplication.c().getPackageName(), null, 0, null, j, null);
    }

    private ag(String str, String str2, long j, String str3, long j2, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str4;
        this.f = j2;
        this.e = str3;
        this.d = j;
    }

    public final void a(String str, long j, char c) {
        this.e = str;
        this.f = j;
        this.g = c;
    }

    public final String toString() {
        return "PaymentRequestData( packageName=" + this.a + ",  sku=" + this.b + " price=" + this.f + " packageId=" + this.d + " name=" + this.e + " kind=" + this.g + ")";
    }
}
