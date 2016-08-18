package android.support.v4.e;

import android.os.Build.VERSION;
import java.util.Locale;

public final class a {
    private static final b a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new e();
        } else if (i >= 14) {
            a = new d();
        } else {
            a = new c();
        }
    }

    public static String a(Locale locale) {
        return a.a(locale);
    }
}
