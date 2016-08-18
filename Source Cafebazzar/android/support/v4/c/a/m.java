package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class m extends ConstantState {
    int a;
    ConstantState b;
    ColorStateList c = null;
    Mode d = l.a;

    m(m mVar) {
        if (mVar != null) {
            this.a = mVar.a;
            this.b = mVar.b;
            this.c = mVar.c;
            this.d = mVar.d;
        }
    }

    public int getChangingConfigurations() {
        return (this.b != null ? this.b.getChangingConfigurations() : 0) | this.a;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public abstract Drawable newDrawable(Resources resources);
}
