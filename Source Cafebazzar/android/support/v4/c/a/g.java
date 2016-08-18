package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class g extends f {
    g() {
    }

    public final void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public final boolean b(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public Drawable c(Drawable drawable) {
        return !(drawable instanceof s) ? new s(drawable) : drawable;
    }
}
