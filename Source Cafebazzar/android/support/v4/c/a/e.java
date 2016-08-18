package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class e extends d {
    e() {
    }

    public final void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public Drawable c(Drawable drawable) {
        return !(drawable instanceof q) ? new q(drawable) : drawable;
    }
}
