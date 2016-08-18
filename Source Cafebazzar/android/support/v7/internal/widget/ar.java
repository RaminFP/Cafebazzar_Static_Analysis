package android.support.v7.internal.widget;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import android.support.v7.a.e;
import android.support.v7.a.l;
import android.support.v7.app.c;
import android.support.v7.internal.view.a;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;

public final class ar extends HorizontalScrollView implements ac {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private au d;
    private LinearLayoutCompat e;
    private SpinnerCompat f;
    private boolean g;
    private int h;
    private int i;

    static /* synthetic */ av a(ar arVar, c cVar, boolean z) {
        av avVar = new av(arVar, arVar.getContext(), cVar, true);
        avVar.setBackgroundDrawable(null);
        avVar.setLayoutParams(new LayoutParams(-1, arVar.h));
        return avVar;
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    private boolean b() {
        if (a()) {
            removeView(this.f);
            addView(this.e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
        }
        return false;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a a = a.a(getContext());
        TypedArray obtainStyledAttributes = a.a.obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(l.ActionBar_height, 0);
        Resources resources = a.a.getResources();
        if (!a.a()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.c = a.a.getResources().getDimensionPixelSize(e.abc_action_bar_stacked_tab_max_width);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.b = -1;
        } else {
            if (childCount > 2) {
                this.b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.b = MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (z || !this.g) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.e.measure(0, mode);
            if (this.e.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                b();
            } else if (!a()) {
                if (this.f == null) {
                    SpinnerCompat spinnerCompat = new SpinnerCompat(getContext(), null, b.actionDropDownStyle);
                    spinnerCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    spinnerCompat.a((ac) this);
                    this.f = spinnerCompat;
                }
                removeView(this.e);
                addView(this.f, new ViewGroup.LayoutParams(-2, -1));
                if (this.f.a == null) {
                    this.f.a(new at());
                }
                if (this.a != null) {
                    removeCallbacks(this.a);
                    this.a = null;
                }
                this.f.setSelection(this.i);
            }
        } else {
            b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.i);
        }
    }

    public final void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public final void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public final void setTabSelected(int i) {
        this.i = i;
        int childCount = this.e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                View childAt2 = this.e.getChildAt(i);
                if (this.a != null) {
                    removeCallbacks(this.a);
                }
                this.a = new as(this, childAt2);
                post(this.a);
            }
            i2++;
        }
        if (this.f != null && i >= 0) {
            this.f.setSelection(i);
        }
    }
}
