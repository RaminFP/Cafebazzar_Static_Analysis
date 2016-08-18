package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class n extends MarginLayoutParams {
    public int a = 0;
    private float b;
    private boolean c;
    private int d;

    public n(int i, int i2) {
        super(-1, -1);
    }

    public n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f);
        this.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public n(n nVar) {
        super(nVar);
        this.a = nVar.a;
    }

    public n(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public n(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    static /* synthetic */ int b(n nVar, int i) {
        int i2 = nVar.d | i;
        nVar.d = i2;
        return i2;
    }
}
