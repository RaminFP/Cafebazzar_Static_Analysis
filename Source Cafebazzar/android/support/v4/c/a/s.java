package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class s extends q {
    s(Drawable drawable) {
        super(drawable);
    }

    s(m mVar, Resources resources) {
        super(mVar, resources);
    }

    m b() {
        return new t(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
