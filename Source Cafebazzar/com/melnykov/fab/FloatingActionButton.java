package com.melnykov.fab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;

public class FloatingActionButton extends ImageButton {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private final Interpolator j;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new AccelerateDecelerateInterpolator();
        a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new AccelerateDecelerateInterpolator();
        a(context, attributeSet);
    }

    private Drawable a(int i) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        if (!this.e || b()) {
            return shapeDrawable;
        }
        Resources resources = getResources();
        int i2 = this.f == 0 ? e.shadow : e.shadow_mini;
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{resources.getDrawable(i2), shapeDrawable});
        layerDrawable.setLayerInset(1, this.g, this.g, this.g, this.g);
        return layerDrawable;
    }

    private void a() {
        Drawable stateListDrawable = new StateListDrawable();
        int[] iArr = new int[]{16842919};
        stateListDrawable.addState(iArr, a(this.c));
        stateListDrawable.addState(new int[0], a(this.b));
        setBackgroundCompat(stateListDrawable);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = true;
        this.b = b(c.material_blue_500);
        this.c = b(c.material_blue_600);
        this.d = b(17170443);
        this.f = 0;
        this.e = true;
        this.h = getResources().getDimensionPixelOffset(d.fab_scroll_threshold);
        this.g = c(d.fab_shadow_size);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.FloatingActionButton, 0, 0);
            if (obtainStyledAttributes != null) {
                try {
                    this.b = obtainStyledAttributes.getColor(f.FloatingActionButton_fab_colorNormal, b(c.material_blue_500));
                    this.c = obtainStyledAttributes.getColor(f.FloatingActionButton_fab_colorPressed, b(c.material_blue_600));
                    this.d = obtainStyledAttributes.getColor(f.FloatingActionButton_fab_colorRipple, b(17170443));
                    this.e = obtainStyledAttributes.getBoolean(f.FloatingActionButton_fab_shadow, true);
                    this.f = obtainStyledAttributes.getInt(f.FloatingActionButton_fab_type, 0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        a();
    }

    private int b(int i) {
        return getResources().getColor(i);
    }

    private static boolean b() {
        return VERSION.SDK_INT >= 21;
    }

    private int c(int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private int getMarginBottom() {
        LayoutParams layoutParams = getLayoutParams();
        return layoutParams instanceof MarginLayoutParams ? ((MarginLayoutParams) layoutParams).bottomMargin : 0;
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (b()) {
            setElevation(this.e ? (float) c(d.fab_elevation_lollipop) : 0.0f);
            int[] iArr = new int[0];
            int i = this.d;
            Drawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{iArr}, new int[]{i}), drawable, null);
            setOutlineProvider(new a(this));
            setClipToOutline(true);
            setBackground(rippleDrawable);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public int getColorNormal() {
        return this.b;
    }

    public int getColorPressed() {
        return this.c;
    }

    public int getColorRipple() {
        return this.d;
    }

    public int getType() {
        return this.f;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int c = c(this.f == 0 ? d.fab_size_normal : d.fab_size_mini);
        if (!this.e || b()) {
            i3 = c;
        } else {
            int i4 = this.g;
            if (!this.i && (getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin - this.g, marginLayoutParams.topMargin - this.g, marginLayoutParams.rightMargin - this.g, marginLayoutParams.bottomMargin - this.g);
                requestLayout();
                this.i = true;
            }
            i3 = (i4 << 1) + c;
        }
        setMeasuredDimension(i3, i3);
    }

    public void setColorNormal(int i) {
        if (i != this.b) {
            this.b = i;
            a();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(b(i));
    }

    public void setColorPressed(int i) {
        if (i != this.c) {
            this.c = i;
            a();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(b(i));
    }

    public void setColorRipple(int i) {
        if (i != this.d) {
            this.d = i;
            a();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(b(i));
    }

    public void setShadow(boolean z) {
        if (z != this.e) {
            this.e = z;
            a();
        }
    }

    public void setType(int i) {
        if (i != this.f) {
            this.f = i;
            a();
        }
    }
}
