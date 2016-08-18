package android.support.v4.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.bp;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public final class SlidingPaneLayout extends ViewGroup {
    static final as a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private aq p;
    private final aw q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList u;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new ar();
        boolean a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            a = new av();
        } else if (i >= 16) {
            a = new au();
        } else {
            a = new at();
        }
    }

    private void a(View view) {
        a.a(this, view);
    }

    private void a(View view, float f, int i) {
        ap apVar = (ap) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (int) (((float) ((-16777216 & i) >>> 24)) * f);
            if (apVar.d == null) {
                apVar.d = new Paint();
            }
            apVar.d.setColorFilter(new PorterDuffColorFilter((i2 << 24) | (16777215 & i), Mode.SRC_OVER));
            if (bp.g(view) != 2) {
                bp.a(view, 2, apVar.d);
            }
            a(view);
        } else if (bp.g(view) != 0) {
            if (apVar.d != null) {
                apVar.d.setColorFilter(null);
            }
            Runnable aoVar = new ao(this, view);
            this.u.add(aoVar);
            bp.a((View) this, aoVar);
        }
    }

    private boolean a() {
        return bp.h(this) == 1;
    }

    private boolean a(float f) {
        if (!this.g) {
            return false;
        }
        int width;
        ap apVar = (ap) this.h.getLayoutParams();
        if (a()) {
            int paddingRight = getPaddingRight();
            width = (int) (((float) getWidth()) - ((((float) (apVar.rightMargin + paddingRight)) + (((float) this.k) * f)) + ((float) this.h.getWidth())));
        } else {
            width = (int) (((float) (apVar.leftMargin + getPaddingLeft())) + (((float) this.k) * f));
        }
        if (!this.q.a(this.h, width, this.h.getTop())) {
            return false;
        }
        paddingRight = getChildCount();
        for (width = 0; width < paddingRight; width++) {
            View childAt = getChildAt(width);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
        bp.d(this);
        return true;
    }

    private boolean a(int i) {
        if (!this.s && !a(0.0f)) {
            return false;
        }
        this.r = false;
        return true;
    }

    private boolean b(View view) {
        if (view == null) {
            return false;
        }
        return this.g && ((ap) view.getLayoutParams()).c && this.i > 0.0f;
    }

    protected final boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ap) && super.checkLayoutParams(layoutParams);
    }

    public final void computeScroll() {
        if (!this.q.a(true)) {
            return;
        }
        if (this.g) {
            bp.d(this);
        } else {
            this.q.b();
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = a() ? this.e : this.d;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (a()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    protected final boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        ap apVar = (ap) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.g || apVar.b || this.h == null)) {
            canvas.getClipBounds(this.t);
            if (a()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
            } else {
                this.t.right = Math.min(this.t.right, this.h.getLeft());
            }
            canvas.clipRect(this.t);
        }
        if (VERSION.SDK_INT < 11) {
            if (apVar.c && this.i > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), apVar.d);
                    z = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                    z = super.drawChild(canvas, view, j);
                }
                canvas.restoreToCount(save);
                return z;
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new ap();
    }

    public final LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ap(getContext(), attributeSet);
    }

    protected final LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new ap((MarginLayoutParams) layoutParams) : new ap(layoutParams);
    }

    public final int getCoveredFadeColor() {
        return this.c;
    }

    public final int getParallaxDistance() {
        return this.m;
    }

    public final int getSliderFadeColor() {
        return this.b;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            ((ao) this.u.get(i)).run();
        }
        this.u.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.ay.a(r7);
        r0 = r6.g;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r6.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r6.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.aw.b(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r6.r = r0;
    L_0x002b:
        r0 = r6.g;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r6.l;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r6.q;
        r0.a();
        r2 = super.onInterceptTouchEvent(r7);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r6.q;
        r0.a();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r6.q;
        r3 = r3.a(r7);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r6.l = r2;
        r0 = r7.getX();
        r3 = r7.getY();
        r6.n = r0;
        r6.o = r3;
        r4 = r6.h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.aw.b(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r6.h;
        r0 = r6.b(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r7.getX();
        r3 = r7.getY();
        r4 = r6.n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r6.o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r6.q;
        r4 = r4.b;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009d:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a1:
        r0 = r6.q;
        r0.a();
        r6.l = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean a = a();
        if (a) {
            this.q.k = 2;
        } else {
            this.q.k = 1;
        }
        int i7 = i3 - i;
        int paddingRight = a ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = a ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            float f = (this.g && this.r) ? 1.0f : 0.0f;
            this.i = f;
        }
        int i8 = 0;
        int i9 = paddingRight;
        while (i8 < childCount) {
            ap apVar;
            int measuredWidth;
            int i10;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                apVar = (ap) childAt.getLayoutParams();
                measuredWidth = childAt.getMeasuredWidth();
                if (apVar.b) {
                    int min = (Math.min(i9, (i7 - paddingLeft) - this.f) - paddingRight) - (apVar.leftMargin + apVar.rightMargin);
                    this.k = min;
                    i5 = a ? apVar.rightMargin : apVar.leftMargin;
                    apVar.c = ((paddingRight + i5) + min) + (measuredWidth / 2) > i7 - paddingLeft;
                    i6 = (int) (((float) min) * this.i);
                    i10 = paddingRight + (i5 + i6);
                    this.i = ((float) i6) / ((float) this.k);
                    i6 = 0;
                } else {
                    i6 = (!this.g || this.m == 0) ? 0 : (int) ((1.0f - this.i) * ((float) this.m));
                    i10 = i9;
                }
                if (a) {
                    i6 += i7 - i10;
                    i5 = i6 - measuredWidth;
                } else {
                    i5 = i10 - i6;
                    i6 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i6, childAt.getMeasuredHeight() + paddingTop);
                i6 = childAt.getWidth() + i9;
                i5 = i10;
            } else {
                i6 = i9;
                i5 = paddingRight;
            }
            i8++;
            paddingRight = i5;
            i9 = i6;
        }
        if (this.s) {
            View childAt2;
            if (this.g) {
                if (this.m != 0) {
                    Object obj;
                    View childAt3;
                    float f2 = this.i;
                    boolean a2 = a();
                    apVar = (ap) this.h.getLayoutParams();
                    if (apVar.c) {
                        if ((a2 ? apVar.rightMargin : apVar.leftMargin) <= 0) {
                            obj = 1;
                            paddingRight = getChildCount();
                            for (i5 = 0; i5 < paddingRight; i5++) {
                                childAt3 = getChildAt(i5);
                                if (childAt3 != this.h) {
                                    paddingLeft = (int) ((1.0f - this.j) * ((float) this.m));
                                    this.j = f2;
                                    paddingLeft -= (int) ((1.0f - f2) * ((float) this.m));
                                    if (a2) {
                                        paddingLeft = -paddingLeft;
                                    }
                                    childAt3.offsetLeftAndRight(paddingLeft);
                                    if (obj == null) {
                                        a(childAt3, a2 ? this.j - 1.0f : 1.0f - this.j, this.c);
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    paddingRight = getChildCount();
                    for (i5 = 0; i5 < paddingRight; i5++) {
                        childAt3 = getChildAt(i5);
                        if (childAt3 != this.h) {
                            paddingLeft = (int) ((1.0f - this.j) * ((float) this.m));
                            this.j = f2;
                            paddingLeft -= (int) ((1.0f - f2) * ((float) this.m));
                            if (a2) {
                                paddingLeft = -paddingLeft;
                            }
                            childAt3.offsetLeftAndRight(paddingLeft);
                            if (obj == null) {
                                if (a2) {
                                }
                                a(childAt3, a2 ? this.j - 1.0f : 1.0f - this.j, this.c);
                            }
                        }
                    }
                }
                if (((ap) this.h.getLayoutParams()).c) {
                    a(this.h, this.i, this.b);
                }
            } else {
                for (i6 = 0; i6 < childCount; i6++) {
                    a(getChildAt(i6), 0.0f, this.b);
                }
            }
            View view = this.h;
            boolean a3 = a();
            int width = a3 ? getWidth() - getPaddingRight() : getPaddingLeft();
            i6 = a3 ? getPaddingLeft() : getWidth() - getPaddingRight();
            paddingTop = getPaddingTop();
            childCount = getHeight();
            int paddingBottom = getPaddingBottom();
            if (view != null) {
                Object obj2;
                if (bp.i(view)) {
                    obj2 = 1;
                } else {
                    if (VERSION.SDK_INT < 18) {
                        Drawable background = view.getBackground();
                        if (background != null) {
                            obj2 = background.getOpacity() == -1 ? 1 : null;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    paddingLeft = view.getLeft();
                    i5 = view.getRight();
                    i10 = view.getTop();
                    i9 = view.getBottom();
                    measuredWidth = getChildCount();
                    for (i8 = 0; i8 < measuredWidth; i8++) {
                        childAt2 = getChildAt(i8);
                        if (childAt2 != view) {
                            break;
                        }
                        paddingRight = (Math.max(a3 ? i6 : width, childAt2.getLeft()) >= paddingLeft || Math.max(paddingTop, childAt2.getTop()) < i10 || Math.min(a3 ? width : i6, childAt2.getRight()) > i5 || Math.min(childCount - paddingBottom, childAt2.getBottom()) > i9) ? 0 : 4;
                        childAt2.setVisibility(paddingRight);
                    }
                }
            }
            i9 = 0;
            i10 = 0;
            i5 = 0;
            paddingLeft = 0;
            measuredWidth = getChildCount();
            for (i8 = 0; i8 < measuredWidth; i8++) {
                childAt2 = getChildAt(i8);
                if (childAt2 != view) {
                    break;
                }
                if (a3) {
                }
                if (a3) {
                }
                if (Math.max(a3 ? i6 : width, childAt2.getLeft()) >= paddingLeft) {
                }
                childAt2.setVisibility(paddingRight);
            }
        }
        this.s = false;
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int makeMeasureSpec;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = size;
                    i4 = Integer.MIN_VALUE;
                    size = 300;
                }
            }
            i3 = size;
            i4 = mode2;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = 300;
                i4 = mode2;
                size = size2;
            }
            i3 = size;
            i4 = mode2;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i4) {
            case Integer.MIN_VALUE:
                int paddingTop = (size - getPaddingTop()) - getPaddingBottom();
                size = 0;
                mode2 = paddingTop;
                break;
            case 1073741824:
                size = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size;
                break;
            default:
                size = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        float f = 0.0f;
        int i7 = size;
        while (i5 < childCount) {
            boolean z2;
            float f2;
            View childAt = getChildAt(i5);
            ap apVar = (ap) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                apVar.c = false;
                z2 = z;
                f2 = f;
                mode = i7;
                i7 = i6;
            } else {
                if (apVar.a > 0.0f) {
                    f += apVar.a;
                    if (apVar.width == 0) {
                        z2 = z;
                        f2 = f;
                        mode = i7;
                        i7 = i6;
                    }
                }
                int i8 = apVar.leftMargin + apVar.rightMargin;
                i8 = apVar.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - i8, Integer.MIN_VALUE) : apVar.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - i8, 1073741824) : MeasureSpec.makeMeasureSpec(apVar.width, 1073741824);
                makeMeasureSpec = apVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : apVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(apVar.height, 1073741824);
                childAt.measure(i8, makeMeasureSpec);
                i8 = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i4 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, mode2);
                }
                i6 -= i8;
                boolean z3 = i6 < 0;
                apVar.b = z3;
                if (apVar.b) {
                    this.h = childAt;
                }
                z2 = z3 | z;
                f2 = f;
                mode = i7;
                i7 = i6;
            }
            i5++;
            i6 = i7;
            i7 = mode;
            f = f2;
            z = z2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getVisibility() != 8) {
                    apVar = (ap) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (apVar.width != 0 || apVar.a <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.h) {
                            if (apVar.a > 0.0f) {
                                i8 = apVar.width == 0 ? apVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : apVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(apVar.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size = paddingLeft - (apVar.rightMargin + apVar.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size, 1073741824);
                                    if (makeMeasureSpec != size) {
                                        childAt2.measure(i5, i8);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((apVar.a * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, 1073741824), i8);
                                }
                            }
                        } else if (apVar.width < 0 && (makeMeasureSpec > i9 || apVar.a > 0.0f)) {
                            size = obj != null ? apVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : apVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(apVar.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i3, (getPaddingTop() + i7) + getPaddingBottom());
        this.g = z;
        if (this.q.a != 0 && !z) {
            this.q.b();
        }
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.a) {
            a(0);
        } else if (this.s || a(1.0f)) {
            this.r = true;
        }
        this.r = savedState.a;
    }

    protected final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.g ? !this.g || this.i == 1.0f : this.r;
        savedState.a = z;
        return savedState;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.s = true;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        this.q.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.n = x;
                this.o = y;
                break;
            case 1:
                if (b(this.h)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.n;
                    float f2 = y - this.o;
                    int i = this.q.b;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && aw.b(this.h, (int) x, (int) y)) {
                        a(0);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.g) {
            this.r = view == this.h;
        }
    }

    public final void setCoveredFadeColor(int i) {
        this.c = i;
    }

    public final void setPanelSlideListener(aq aqVar) {
        this.p = aqVar;
    }

    public final void setParallaxDistance(int i) {
        this.m = i;
        requestLayout();
    }

    @Deprecated
    public final void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public final void setShadowDrawableLeft(Drawable drawable) {
        this.d = drawable;
    }

    public final void setShadowDrawableRight(Drawable drawable) {
        this.e = drawable;
    }

    @Deprecated
    public final void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public final void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public final void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public final void setSliderFadeColor(int i) {
        this.b = i;
    }
}
