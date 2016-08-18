package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.bp;
import android.support.v4.view.di;
import android.support.v7.a.b;
import android.support.v7.a.l;
import android.support.v7.internal.view.i;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

abstract class a extends ViewGroup {
    private static final Interpolator j = new DecelerateInterpolator();
    protected final b a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected ViewGroup e;
    protected boolean f;
    protected boolean g;
    protected int h;
    protected di i;

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void a(int i) {
        if (this.i != null) {
            this.i.a();
        }
        di a;
        if (i == 0) {
            if (getVisibility() != 0) {
                bp.c((View) this, 0.0f);
                if (!(this.e == null || this.c == null)) {
                    bp.c(this.c, 0.0f);
                }
            }
            a = bp.r(this).a(1.0f);
            a.a(200);
            a.a(j);
            if (this.e == null || this.c == null) {
                a.a(this.a.a(a, i));
                a.b();
                return;
            }
            i iVar = new i();
            di a2 = bp.r(this.c).a(1.0f);
            a2.a(200);
            iVar.a(this.a.a(a, i));
            iVar.a(a).a(a2);
            iVar.a();
            return;
        }
        a = bp.r(this).a(0.0f);
        a.a(200);
        a.a(j);
        if (this.e == null || this.c == null) {
            a.a(this.a.a(a, i));
            a.b();
            return;
        }
        iVar = new i();
        a2 = bp.r(this.c).a(0.0f);
        a2.a(200);
        iVar.a(this.a.a(a, i));
        iVar.a(a).a(a2);
        iVar.a();
    }

    public boolean a() {
        return this.d != null ? this.d.showOverflowMenu() : false;
    }

    public int getAnimatedVisibility() {
        return this.i != null ? this.a.a : getVisibility();
    }

    public int getContentHeight() {
        return this.h;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(l.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.onConfigurationChanged(configuration);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        this.f = z;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.g = z;
    }
}
