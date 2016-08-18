package com.farsitel.bazaar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public final class ar extends LayoutParams {
    public boolean a;
    public int b;
    float c = 0.0f;
    boolean d;
    int e;
    int f;

    public ar() {
        super(-1, -1);
    }

    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.a);
        this.b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
