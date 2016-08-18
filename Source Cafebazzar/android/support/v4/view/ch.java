package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ch {
    static final cm a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new cl();
        } else if (VERSION.SDK_INT >= 11) {
            a = new ck();
        } else if (VERSION.SDK_INT >= 8) {
            a = new cj();
        } else {
            a = new ci();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
