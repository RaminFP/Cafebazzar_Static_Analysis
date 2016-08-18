package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.List;

public final class r {
    private static final s b;
    public final Object a;

    static {
        if (VERSION.SDK_INT >= 19) {
            b = new v();
        } else if (VERSION.SDK_INT >= 16) {
            b = new t();
        } else {
            b = new x();
        }
    }

    public r() {
        this.a = b.a(this);
    }

    public r(Object obj) {
        this.a = obj;
    }

    public static f a() {
        return null;
    }

    public static boolean b() {
        return false;
    }

    public static List c() {
        return null;
    }

    public static f d() {
        return null;
    }
}
