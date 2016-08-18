package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class ap extends MarginLayoutParams {
    private static final int[] e = new int[]{16843137};
    public float a = 0.0f;
    boolean b;
    boolean c;
    Paint d;

    public ap() {
        super(-1, -1);
    }

    public ap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
        this.a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public ap(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ap(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
