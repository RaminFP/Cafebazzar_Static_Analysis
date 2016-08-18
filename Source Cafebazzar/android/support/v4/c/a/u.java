package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

final class u extends s {
    u(Drawable drawable) {
        super(drawable);
    }

    u(m mVar, Resources resources) {
        super(mVar, resources);
    }

    final m b() {
        return new v(this.b, null);
    }

    protected final boolean c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
    }

    public final Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public final void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public final void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public final void setTint(int i) {
        if (c()) {
            a(i);
        } else {
            this.c.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (c()) {
            a(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (c()) {
            a(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }
}
