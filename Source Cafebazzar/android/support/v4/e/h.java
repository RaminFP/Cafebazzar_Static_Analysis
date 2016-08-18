package android.support.v4.e;

import android.os.Build.VERSION;
import java.util.Locale;

public final class h {
    public static final Locale a = new Locale("", "");
    private static final i b;
    private static String c = "Arab";
    private static String d = "Hebr";

    static {
        if (VERSION.SDK_INT >= 17) {
            b = new j();
        } else {
            b = new i();
        }
    }

    public static int a(Locale locale) {
        return b.a(locale);
    }
}
