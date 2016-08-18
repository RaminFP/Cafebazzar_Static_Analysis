package b.a.a.a.a.b;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;

public final class ag {
    public static int a(int i) {
        if (i < Callback.DEFAULT_DRAG_ANIMATION_DURATION || i > 299) {
            if (i >= 300 && i <= 399) {
                return 1;
            }
            if (i < 400 || i > 499) {
                return i >= 500 ? 1 : 1;
            }
        }
        return 0;
    }
}
