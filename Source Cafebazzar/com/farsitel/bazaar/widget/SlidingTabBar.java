package com.farsitel.bazaar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.h;
import java.util.Locale;

public class SlidingTabBar extends HorizontalScrollView {
    private static final int[] d = new int[]{16842901, 16842904};
    private int A;
    private int B;
    private int C;
    private int D;
    private Locale E;
    private int F;
    private int G;
    private boolean H;
    public au a;
    private int b;
    private int c;
    private final LayoutParams e;
    private final LayoutParams f;
    private ah g;
    private final ai h;
    private final LinearLayout i;
    private ViewPager j;
    private int k;
    private int l;
    private float m;
    private final Paint n;
    private final Paint o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new aj();
        int a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public SlidingTabBar(Context context) {
        this(context, null);
    }

    public SlidingTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = getResources().getColor(2131558471);
        this.c = getResources().getColor(2131558472);
        this.h = new ai();
        this.l = -1;
        this.m = 0.0f;
        this.p = false;
        this.q = getResources().getColor(2131558471);
        this.r = getResources().getColor(2131558471);
        this.s = 1442840575;
        this.t = true;
        this.u = true;
        this.v = 52;
        this.w = 3;
        this.x = 0;
        this.y = 12;
        this.z = 24;
        this.A = 0;
        this.B = 14;
        this.C = 0;
        this.D = g.selector;
        this.H = false;
        setFillViewport(true);
        setWillNotDraw(false);
        boolean b = BazaarApplication.c().b();
        this.i = new LinearLayout(context);
        this.i.setOrientation(0);
        this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i.setGravity((b ? 5 : 3) | 16);
        addView(this.i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.v = (int) TypedValue.applyDimension(1, (float) this.v, displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, (float) this.w, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, (float) this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, (float) this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, (float) this.z, displayMetrics);
        this.A = (int) TypedValue.applyDimension(1, (float) this.A, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, (float) this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d);
        this.B = obtainStyledAttributes.getDimensionPixelSize(0, this.B);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.SlidingTabBar);
        this.c = obtainStyledAttributes.getColor(1, this.c);
        this.b = obtainStyledAttributes.getColor(2, this.b);
        this.q = obtainStyledAttributes.getColor(0, this.q);
        this.r = obtainStyledAttributes.getColor(3, this.r);
        this.s = obtainStyledAttributes.getColor(4, this.s);
        this.w = obtainStyledAttributes.getDimensionPixelSize(5, this.w);
        this.x = obtainStyledAttributes.getDimensionPixelSize(6, this.x);
        this.y = obtainStyledAttributes.getDimensionPixelSize(7, this.y);
        this.z = obtainStyledAttributes.getDimensionPixelSize(8, this.z);
        this.D = obtainStyledAttributes.getResourceId(10, this.D);
        this.t = obtainStyledAttributes.getBoolean(11, this.t);
        this.v = obtainStyledAttributes.getDimensionPixelSize(9, this.v);
        this.u = false;
        obtainStyledAttributes.recycle();
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.n.setStyle(Style.FILL);
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.o.setStrokeWidth((float) this.A);
        this.e = new LayoutParams(-2, -1);
        this.f = new LayoutParams(0, -1, 1.0f);
        if (this.E == null) {
            this.E = getResources().getConfiguration().locale;
        }
        this.F = getContext().getResources().getInteger(2131296268);
        this.G = getContext().getResources().getInteger(2131296267);
    }

    private void b() {
        boolean z = this.k <= this.G && this.k >= this.F;
        this.t = z;
        for (int i = 0; i < this.k; i++) {
            View childAt = this.i.getChildAt(i);
            childAt.setLayoutParams(this.e);
            childAt.setBackgroundResource(this.D);
            if (this.t) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.z, 0, this.z, 0);
            }
        }
        c();
    }

    private void c() {
        for (int i = 0; i < this.k; i++) {
            View childAt = this.i.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.B);
                if (i == this.l) {
                    textView.setTextAppearance(getContext(), 2131427588);
                    textView.setTextColor(this.c);
                } else {
                    textView.setTextAppearance(getContext(), 2131427587);
                    textView.setTextColor(this.b);
                }
            }
        }
    }

    public final void a() {
        this.F = 0;
        this.G = Integer.MAX_VALUE;
    }

    void a(int i, int i2, boolean z) {
        if (this.k != 0) {
            int left = this.i.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.v;
            }
            if (left != this.C) {
                this.C = left;
                if (z && this.H) {
                    postDelayed(new ae(this, left), 600);
                } else {
                    scrollTo(left, 0);
                }
                this.H = true;
                return;
            }
            scrollTo(left, 0);
        }
    }

    public int getCurrentPosition() {
        return this.l;
    }

    public int getDividerColor() {
        return this.s;
    }

    public int getDividerPadding() {
        return this.y;
    }

    public int getIndicatorColor() {
        return this.q;
    }

    public int getIndicatorHeight() {
        return this.w;
    }

    public int getScrollOffset() {
        return this.v;
    }

    public boolean getShouldExpand() {
        return this.t;
    }

    public int getTabBackground() {
        return this.D;
    }

    public int getTabPaddingLeftRight() {
        return this.z;
    }

    public int getTextSize() {
        return this.B;
    }

    public int getUnderlineColor() {
        return this.r;
    }

    public int getUnderlineHeight() {
        return this.x;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.k != 0) {
            int height = getHeight();
            this.n.setColor(this.q);
            View childAt = this.i.getChildAt(this.l);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.m > 0.0f && this.l < this.k - 1) {
                childAt = this.i.getChildAt(this.l + 1);
                float left2 = (float) childAt.getLeft();
                float right2 = (float) childAt.getRight();
                left = (left * (1.0f - this.m)) + (left2 * this.m);
                right = (right2 * this.m) + ((1.0f - this.m) * right);
            }
            canvas.drawRect(left, (float) (height - this.w), right, (float) height, this.n);
            this.n.setColor(this.r);
            canvas.drawRect(0.0f, (float) (height - this.x), (float) this.i.getWidth(), (float) height, this.n);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        if (this.t && MeasureSpec.getMode(i) != 0) {
            int measuredWidth = getMeasuredWidth();
            int i4 = 0;
            for (int i5 = 0; i5 < this.k; i5++) {
                i4 += this.i.getChildAt(i5).getMeasuredWidth();
            }
            if (!this.p && i4 > 0 && measuredWidth > 0) {
                if (i4 <= measuredWidth) {
                    while (i3 < this.k) {
                        this.i.getChildAt(i3).setLayoutParams(this.f);
                        i3++;
                    }
                }
                this.p = true;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.l;
        return savedState;
    }

    public void setAdapter(ak akVar) {
        this.i.removeAllViews();
        this.k = akVar.a().length;
        boolean b = BazaarApplication.c().b();
        if (this.l == -1) {
            if (b) {
                this.l = this.k - 1;
            } else {
                this.l = 0;
            }
        }
        for (int i = 0; i < this.k; i++) {
            al alVar = akVar.a()[i];
            View textView = new TextView(getContext());
            textView.setText(alVar.a().toUpperCase(this.E));
            textView.setFocusable(true);
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setOnClickListener(new af(this, i));
            this.i.addView(textView);
        }
        b();
        this.p = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ag(this));
    }

    public void setAllCaps(boolean z) {
        this.u = z;
    }

    public void setCurrentTab(int i) {
        this.l = i;
        c();
    }

    public void setDividerColor(int i) {
        this.s = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.s = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.y = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.q = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.q = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.w = i;
        invalidate();
    }

    public void setListPager(ViewPager viewPager) {
        this.j = viewPager;
        viewPager.setOnPageChangeListener(this.h);
    }

    public void setOnPageChangeListener(au auVar) {
        this.a = auVar;
    }

    public void setOnTabChangeListener(ah ahVar) {
        this.g = ahVar;
    }

    public void setScrollOffset(int i) {
        this.v = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.t = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.D = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.z = i;
        b();
    }

    public void setTextSize(int i) {
        this.B = i;
        b();
    }

    public void setUnderlineColor(int i) {
        this.r = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.r = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.x = i;
        invalidate();
    }
}
