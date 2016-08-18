package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class ae {
    static final af a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new ai();
        } else if (i >= 11) {
            a = new ah();
        } else {
            a = new ag();
        }
    }

    public static void a(LayoutInflater layoutInflater, an anVar) {
        a.a(layoutInflater, anVar);
    }
}
