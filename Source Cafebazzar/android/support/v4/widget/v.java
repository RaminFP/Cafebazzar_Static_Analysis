package android.support.v4.widget;

import android.widget.EdgeEffect;

final class v extends t {
    v() {
    }

    public final boolean a(Object obj, float f, float f2) {
        ((EdgeEffect) obj).onPull(f, f2);
        return true;
    }
}
