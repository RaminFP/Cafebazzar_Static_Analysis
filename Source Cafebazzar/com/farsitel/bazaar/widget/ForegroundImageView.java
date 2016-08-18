package com.farsitel.bazaar.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ForegroundImageView extends FrameLayout {
    private ImageView a;
    private View b;

    public ForegroundImageView(Context context) {
        this(context, null);
    }

    public ForegroundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ImageView(context, attributeSet, i);
        this.a.setAdjustViewBounds(true);
        this.b = new View(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.a, layoutParams);
        addView(this.b, layoutParams);
    }

    public ImageView getImageView() {
        return this.a;
    }

    public void setForegroundResource(int i) {
        this.b.setBackgroundResource(i);
        setClickable(true);
        setFocusable(true);
    }

    public void setImageDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        this.a.setImageResource(i);
    }
}
