package com.farsitel.bazaar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

public class BazaarViewFlipper extends ViewFlipper {
    public BazaarViewFlipper(Context context) {
        super(context);
    }

    public BazaarViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            stopFlipping();
        }
    }
}
