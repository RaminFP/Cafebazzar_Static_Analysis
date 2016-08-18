package com.farsitel.bazaar.widget;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

final class q extends FrameLayout {
    final /* synthetic */ HeaderGridView a;

    public q(HeaderGridView headerGridView, Context context) {
        this.a = headerGridView;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec((this.a.getMeasuredWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight(), MeasureSpec.getMode(i)), i2);
    }
}
