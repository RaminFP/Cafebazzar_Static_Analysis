package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.c.a;
import android.util.TypedValue;

public final class be {
    static final int[] a = new int[]{-16842910};
    static final int[] b = new int[]{16842908};
    static final int[] c = new int[]{16843518};
    static final int[] d = new int[]{16842919};
    static final int[] e = new int[]{16842912};
    static final int[] f = new int[]{16842913};
    static final int[] g = new int[]{-16842919, -16842908};
    static final int[] h = new int[0];
    private static final ThreadLocal i = new ThreadLocal();
    private static final int[] j = new int[1];

    public static int a(Context context, int i) {
        j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int a(Context context, int i, float f) {
        int a = a(context, i);
        return a.b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    public static ColorStateList a(int i, int i2) {
        return new ColorStateList(new int[][]{a, h}, new int[]{i2, i});
    }

    public static ColorStateList b(Context context, int i) {
        j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int c(Context context, int i) {
        ColorStateList b = b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(a, b.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) i.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            i.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return a(context, i, typedValue.getFloat());
    }
}
