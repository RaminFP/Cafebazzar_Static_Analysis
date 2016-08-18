package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class z {
    static final ad a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new ac();
        } else {
            a = new aa();
        }
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return a.a(keyEvent.getMetaState(), 1);
    }

    public static void b(KeyEvent keyEvent) {
        a.a(keyEvent);
    }
}
