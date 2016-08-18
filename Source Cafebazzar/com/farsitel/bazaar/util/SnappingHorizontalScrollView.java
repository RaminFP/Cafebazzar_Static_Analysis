package com.farsitel.bazaar.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;

public class SnappingHorizontalScrollView extends HorizontalScrollView {
    final float a = 3.0f;
    final float b = -4.0f;
    public int c = -1;
    private int d;
    private OverScroller e;
    private ao f;
    private int g;

    public SnappingHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                this.e = (OverScroller) declaredField.get(this);
                float signum = Math.signum((float) i) * Math.max(Math.abs((float) i) / ((float) this.g), 0.15f);
                float abs = (Math.abs(signum) * ((float) getWidth())) * 3.0f;
                float f = (-abs) / -4.0f;
                float signum2 = (Math.signum(signum) * ((f * abs) + ((((float) Math.pow((double) f, 2.0d)) * -4.0f) / 2.0f))) / 300.0f;
                int scrollX = i > 0 ? getScrollX() : getScrollX() + getWidth();
                int round = (Math.round((((float) scrollX) + signum2) / ((float) this.d)) * this.d) - scrollX;
                if (Math.signum((float) round) != Math.signum((float) i)) {
                    round = (Math.round((((float) scrollX) + (((float) this.d) * Math.signum((float) i))) / ((float) this.d)) * this.d) - scrollX;
                }
                int abs2 = (int) (Math.abs((((float) round) * 2.0f) / abs) * 300.0f);
                if (this.e == null) {
                    super.scrollBy(round, 0);
                } else if (this.e == null) {
                    smoothScrollBy(round, 0);
                } else if (getChildCount() != 0) {
                    int max = Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingRight()) - getPaddingLeft()));
                    scrollX = getScrollX();
                    this.e.startScroll(scrollX, getScrollY(), Math.max(0, Math.min(round + scrollX, max)) - scrollX, 0, abs2);
                    invalidate();
                }
            } catch (Throwable th) {
                super.fling(i / 2);
                th.printStackTrace();
            }
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f != null) {
            this.f.a();
        }
        if (i != i3 && i == 0) {
            this.c = 1;
        } else if (i != i3 && getChildAt(0).getRight() == getWidth() + i) {
            this.c = -1;
        }
    }

    public void setItemWidth(int i) {
        this.d = i;
    }

    public void setOnScrollChangedListener(ao aoVar) {
        this.f = aoVar;
    }
}
