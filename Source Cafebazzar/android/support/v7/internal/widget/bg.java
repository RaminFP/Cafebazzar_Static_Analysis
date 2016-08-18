package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class bg extends ap {
    private final bi a;

    public bg(Resources resources, bi biVar) {
        super(resources);
        this.a = biVar;
    }

    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null) {
            this.a.a(i, drawable);
        }
        return drawable;
    }
}
