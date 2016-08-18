package android.support.v7.internal.widget;

import android.graphics.PorterDuff.Mode;
import android.support.v4.f.g;

final class bj extends g {
    public bj(int i) {
        super(6);
    }

    static int a(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }
}
