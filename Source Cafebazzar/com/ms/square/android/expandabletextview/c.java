package com.ms.square.android.expandabletextview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class c extends Animation {
    final /* synthetic */ ExpandableTextView a;
    private final View b;
    private final int c;
    private final int d;

    public c(ExpandableTextView expandableTextView, View view, int i, int i2) {
        this.a = expandableTextView;
        this.b = view;
        this.c = i;
        this.d = i2;
        setDuration((long) expandableTextView.l);
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        int i = (int) ((((float) (this.d - this.c)) * f) + ((float) this.c));
        this.a.a.setMaxHeight(i - this.a.i);
        if (Float.compare(this.a.m, 1.0f) != 0) {
            ExpandableTextView.a(this.a.a, this.a.m + ((1.0f - this.a.m) * f));
        }
        this.b.getLayoutParams().height = i;
        this.b.requestLayout();
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
