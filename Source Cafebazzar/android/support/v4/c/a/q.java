package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class q extends l {
    q(Drawable drawable) {
        super(drawable);
    }

    q(m mVar, Resources resources) {
        super(mVar, resources);
    }

    m b() {
        return new r(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}
