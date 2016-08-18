package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class o extends l {
    o(Drawable drawable) {
        super(drawable);
    }

    o(m mVar, Resources resources) {
        super(mVar, resources);
    }

    protected final Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    final m b() {
        return new p(this.b, null);
    }
}
