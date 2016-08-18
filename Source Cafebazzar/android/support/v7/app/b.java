package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class b extends MarginLayoutParams {
    public int gravity;

    public b(int i) {
        this(-2, -1, i);
    }

    public b(int i, int i2) {
        super(i, i2);
        this.gravity = 0;
        this.gravity = 8388627;
    }

    public b(int i, int i2, int i3) {
        super(i, i2);
        this.gravity = 0;
        this.gravity = i3;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gravity = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ActionBarLayout);
        this.gravity = obtainStyledAttributes.getInt(l.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public b(b bVar) {
        super(bVar);
        this.gravity = 0;
        this.gravity = bVar.gravity;
    }

    public b(LayoutParams layoutParams) {
        super(layoutParams);
        this.gravity = 0;
    }
}
