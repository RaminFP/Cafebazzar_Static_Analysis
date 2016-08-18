package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class ab {
    static final ah a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new ad();
        } else if (i >= 21) {
            a = new ac();
        } else if (i >= 19) {
            a = new ag();
        } else if (i >= 9) {
            a = new af();
        } else {
            a = new ae();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }
}
