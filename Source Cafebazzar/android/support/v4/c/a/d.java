package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class d extends b {
    d() {
    }

    public Drawable c(Drawable drawable) {
        return !(drawable instanceof o) ? new o(drawable) : drawable;
    }
}
