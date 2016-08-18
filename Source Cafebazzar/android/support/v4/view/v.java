package android.support.v4.view;

import android.os.Build.VERSION;

public final class v {
    static final w a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new y();
        } else {
            a = new x();
        }
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }
}
