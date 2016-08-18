package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class ao {
    static final ap a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new ar();
        } else {
            a = new aq();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }
}
