package android.support.v4.view;

import android.view.WindowInsets;

final class ec extends eb {
    final WindowInsets a;

    ec(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    public final int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public final eb a(int i, int i2, int i3, int i4) {
        return new ec(this.a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public final int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public final int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public final int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public final boolean e() {
        return this.a.isConsumed();
    }
}
