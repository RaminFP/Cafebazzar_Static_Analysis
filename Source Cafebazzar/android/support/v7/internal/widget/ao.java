package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.a;

final class ao extends a {
    boolean a = true;

    public ao(Drawable drawable) {
        super(drawable);
    }

    public final void draw(Canvas canvas) {
        if (this.a) {
            super.draw(canvas);
        }
    }

    public final void setHotspot(float f, float f2) {
        if (this.a) {
            super.setHotspot(f, f2);
        }
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public final boolean setState(int[] iArr) {
        return this.a ? super.setState(iArr) : false;
    }

    public final boolean setVisible(boolean z, boolean z2) {
        return this.a ? super.setVisible(z, z2) : false;
    }
}
