package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class bk {
    public final TypedArray a;
    private final Context b;
    private bi c;

    bk(Context context, TypedArray typedArray) {
        this.b = context;
        this.a = typedArray;
    }

    public static bk a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bk(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public final int a(int i, int i2) {
        return this.a.getInt(i, i2);
    }

    public final Drawable a(int i) {
        if (this.a.hasValue(i)) {
            int resourceId = this.a.getResourceId(i, 0);
            if (resourceId != 0) {
                return a().a(resourceId, false);
            }
        }
        return this.a.getDrawable(i);
    }

    public final bi a() {
        if (this.c == null) {
            this.c = bi.a(this.b);
        }
        return this.c;
    }

    public final boolean a(int i, boolean z) {
        return this.a.getBoolean(i, z);
    }

    public final int b(int i, int i2) {
        return this.a.getDimensionPixelOffset(i, i2);
    }

    public final Drawable b(int i) {
        if (this.a.hasValue(i)) {
            int resourceId = this.a.getResourceId(i, 0);
            if (resourceId != 0) {
                return a().a(resourceId, true);
            }
        }
        return null;
    }

    public final int c(int i, int i2) {
        return this.a.getDimensionPixelSize(i, i2);
    }

    public final CharSequence c(int i) {
        return this.a.getText(i);
    }

    public final int d(int i, int i2) {
        return this.a.getLayoutDimension(i, i2);
    }

    public final boolean d(int i) {
        return this.a.hasValue(i);
    }

    public final int e(int i, int i2) {
        return this.a.getResourceId(i, i2);
    }
}
