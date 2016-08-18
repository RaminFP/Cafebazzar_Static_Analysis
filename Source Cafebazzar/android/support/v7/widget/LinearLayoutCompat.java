package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bp;
import android.support.v4.view.v;
import android.support.v7.a.l;
import android.support.v7.internal.widget.bk;
import android.support.v7.internal.widget.bq;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(l.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(l.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        bk a = bk.a(context, attributeSet, l.LinearLayoutCompat, i, 0);
        int a2 = a.a(l.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(l.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(l.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.mWeightSum = a.a.getFloat(l.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = a.a(l.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = a.a(l.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(l.LinearLayoutCompat_divider));
        this.mShowDividers = a.a(l.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = a.c(l.LinearLayoutCompat_dividerPadding, 0);
        a.a.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bq.a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, a ? layoutParams.rightMargin + virtualChildAt.getRight() : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            int paddingLeft;
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                paddingLeft = a ? (virtualChildAt2.getLeft() - layoutParams.leftMargin) - this.mDividerWidth : layoutParams.rightMargin + virtualChildAt2.getRight();
            }
            drawVerticalDivider(canvas, paddingLeft);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            int height;
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                height = layoutParams.bottomMargin + virtualChildAt2.getBottom();
            }
            drawHorizontalDivider(canvas, height);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -2) : this.mOrientation == 1 ? new LayoutParams(-1, -2) : null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                i = this.mGravity & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.mShowDividers & 1) == 0) {
                return false;
            }
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            int i2 = i - 1;
            while (i2 >= 0) {
                if (getChildAt(i2).getVisibility() == 8) {
                    i2--;
                }
            }
            return false;
        }
        return true;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bq.a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = getPaddingBottom();
        int paddingBottom2 = getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity;
        int i9 = this.mGravity;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (v.a(i8 & 8388615, bp.h(this))) {
            case 1:
                paddingLeft = (((i3 - i) - this.mTotalLength) / 2) + getPaddingLeft();
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i10 = 0;
        while (i10 < virtualChildCount) {
            int measureNullChild;
            int i11 = i5 + (i6 * i10);
            View virtualChildAt = getVirtualChildAt(i11);
            if (virtualChildAt == null) {
                measureNullChild = measureNullChild(i11) + paddingLeft;
                i8 = i10;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                measureNullChild = (!z || layoutParams.height == -1) ? -1 : virtualChildAt.getBaseline();
                int i12 = layoutParams.gravity;
                if (i12 < 0) {
                    i12 = i9 & 112;
                }
                switch (i12 & 112) {
                    case 16:
                        i12 = ((((((i7 - paddingTop) - paddingBottom2) - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i12 = layoutParams.topMargin + paddingTop;
                        if (measureNullChild != -1) {
                            i12 += iArr[1] - measureNullChild;
                            break;
                        }
                        break;
                    case 80:
                        i12 = ((i7 - paddingBottom) - measuredHeight) - layoutParams.bottomMargin;
                        if (measureNullChild != -1) {
                            i12 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - measureNullChild);
                            break;
                        }
                        break;
                    default:
                        i12 = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(i11)) {
                    paddingLeft += this.mDividerWidth;
                }
                int i13 = paddingLeft + layoutParams.leftMargin;
                setChildFrame(virtualChildAt, i13 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                measureNullChild = ((layoutParams.rightMargin + measuredWidth) + getNextLocationOffset(virtualChildAt)) + i13;
                i8 = getChildrenSkipCount(virtualChildAt, i11) + i10;
            } else {
                measureNullChild = paddingLeft;
                i8 = i10;
            }
            i10 = i8 + 1;
            paddingLeft = measureNullChild;
        }
    }

    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = getPaddingRight();
        int paddingRight2 = getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.mGravity;
        int i7 = this.mGravity;
        switch (i6 & 112) {
            case 16:
                i6 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
                break;
            case 80:
                i6 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                break;
            default:
                i6 = getPaddingTop();
                break;
        }
        int i8 = 0;
        int i9 = i6;
        while (i8 < virtualChildCount) {
            int i10;
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt == null) {
                i6 = measureNullChild(i8) + i9;
                i10 = i8;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i11;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                i6 = layoutParams.gravity;
                if (i6 < 0) {
                    i6 = 8388615 & i7;
                }
                switch (v.a(i6, bp.h(this)) & 7) {
                    case 1:
                        i11 = ((((((i5 - paddingLeft) - paddingRight2) - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i11 = ((i5 - paddingRight) - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i11 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i8)) {
                    i9 += this.mDividerHeight;
                }
                int i12 = i9 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i11, i12 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i6 = ((layoutParams.bottomMargin + measuredHeight) + getNextLocationOffset(virtualChildAt)) + i12;
                i10 = getChildrenSkipCount(virtualChildAt, i8) + i8;
            } else {
                i6 = i9;
                i10 = i8;
            }
            i8 = i10 + 1;
            i9 = i6;
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    void measureHorizontal(int i, int i2) {
        int i3;
        LayoutParams layoutParams;
        this.mTotalLength = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.mBaselineAligned;
        boolean z2 = this.mUseLargestChild;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i8 = Integer.MIN_VALUE;
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10;
            Object obj5;
            int i11;
            Object obj6;
            Object obj7;
            float f2;
            int i12;
            Object obj8;
            int measuredHeight;
            int baseline;
            Object obj9;
            View virtualChildAt = getVirtualChildAt(i9);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i9);
                i3 = i4;
                i10 = i5;
                obj5 = obj2;
                i11 = i7;
                obj6 = obj;
                obj7 = obj3;
                i4 = i8;
                f2 = f;
                i12 = i6;
            } else {
                Object obj10;
                float f3;
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i9)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f4 = f + layoutParams2.weight;
                    if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        if (obj4 != null) {
                            this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = this.mTotalLength;
                            this.mTotalLength = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(i3, i3);
                        } else {
                            obj3 = 1;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                            i3 = 0;
                            layoutParams2.width = -2;
                        }
                        int i13 = i3;
                        measureChildBeforeLayout(virtualChildAt, i9, i, f4 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        if (i13 != Integer.MIN_VALUE) {
                            layoutParams2.width = i13;
                        }
                        i3 = virtualChildAt.getMeasuredWidth();
                        if (obj4 != null) {
                            this.mTotalLength += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt);
                        } else {
                            i12 = this.mTotalLength;
                            this.mTotalLength = Math.max(i12, (((i12 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt));
                        }
                        if (z2) {
                            i8 = Math.max(i3, i8);
                        }
                    }
                    obj8 = null;
                    if (mode2 != 1073741824 && layoutParams2.height == -1) {
                        obj2 = 1;
                        obj8 = 1;
                    }
                    i11 = layoutParams2.bottomMargin + layoutParams2.topMargin;
                    measuredHeight = virtualChildAt.getMeasuredHeight() + i11;
                    i5 = bq.a(i5, bp.k(virtualChildAt));
                    if (z) {
                        baseline = virtualChildAt.getBaseline();
                        if (baseline != -1) {
                            i12 = ((((layoutParams2.gravity < 0 ? this.mGravity : layoutParams2.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i12] = Math.max(iArr[i12], baseline);
                            iArr2[i12] = Math.max(iArr2[i12], measuredHeight - baseline);
                        }
                    }
                    i4 = Math.max(i4, measuredHeight);
                    Object obj11 = (obj == null || layoutParams2.height != -1) ? null : 1;
                    if (layoutParams2.weight > 0.0f) {
                        i7 = Math.max(i7, obj8 != null ? i11 : measuredHeight);
                        i3 = i4;
                        measuredHeight = i6;
                        obj9 = obj2;
                        baseline = i7;
                        obj7 = obj11;
                        i12 = i5;
                        obj10 = obj3;
                        f3 = f4;
                        i5 = i8;
                    } else {
                        if (obj8 != null) {
                            measuredHeight = i11;
                        }
                        i3 = i4;
                        measuredHeight = Math.max(i6, measuredHeight);
                        obj9 = obj2;
                        baseline = i7;
                        obj7 = obj11;
                        i12 = i5;
                        obj10 = obj3;
                        f3 = f4;
                        i5 = i8;
                    }
                } else {
                    i3 = i4;
                    measuredHeight = i6;
                    obj9 = obj2;
                    baseline = i7;
                    obj7 = obj;
                    obj10 = obj3;
                    f3 = f;
                    i12 = i5;
                    i5 = i8;
                }
                i9 += getChildrenSkipCount(virtualChildAt, i9);
                i10 = i12;
                i12 = measuredHeight;
                obj5 = obj9;
                i11 = baseline;
                obj6 = obj7;
                obj7 = obj10;
                i4 = i5;
                f2 = f3;
            }
            i9++;
            obj3 = obj7;
            i8 = i4;
            i7 = i11;
            obj2 = obj5;
            obj = obj6;
            i6 = i12;
            i4 = i3;
            f = f2;
            i5 = i10;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        i9 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i4 : Math.max(i4, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            i10 = 0;
            while (i10 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i10);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i10);
                    i3 = i10;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt2, i10) + i10;
                } else {
                    layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (obj4 != null) {
                        this.mTotalLength = ((layoutParams.rightMargin + (layoutParams.leftMargin + i8)) + getNextLocationOffset(virtualChildAt2)) + this.mTotalLength;
                        i3 = i10;
                    } else {
                        i11 = this.mTotalLength;
                        this.mTotalLength = Math.max(i11, (layoutParams.rightMargin + (layoutParams.leftMargin + (i11 + i8))) + getNextLocationOffset(virtualChildAt2));
                        i3 = i10;
                    }
                }
                i10 = i3 + 1;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int a = bp.a(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i14 = (16777215 & a) - this.mTotalLength;
        if (obj3 != null || (i14 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            measuredHeight = -1;
            this.mTotalLength = 0;
            baseline = i6;
            obj9 = obj;
            float f5 = f;
            i12 = i5;
            i6 = 0;
            while (i6 < virtualChildCount) {
                float f6;
                View virtualChildAt3 = getVirtualChildAt(i6);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    obj8 = obj9;
                    i10 = baseline;
                    i9 = i12;
                    i12 = i14;
                    f6 = f5;
                } else {
                    layoutParams = (LayoutParams) virtualChildAt3.getLayoutParams();
                    f2 = layoutParams.weight;
                    if (f2 > 0.0f) {
                        i9 = (int) ((((float) i14) * f2) / f5);
                        int childMeasureSpec = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width == 0 && mode == 1073741824) {
                            i10 = i9 > 0 ? i9 : 0;
                        } else {
                            i10 = virtualChildAt3.getMeasuredWidth() + i9;
                            if (i10 < 0) {
                                i10 = 0;
                            }
                        }
                        virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), childMeasureSpec);
                        f2 = f5 - f2;
                        i4 = i14 - i9;
                        i14 = bq.a(i12, bp.k(virtualChildAt3) & -16777216);
                    } else {
                        f2 = f5;
                        i4 = i14;
                        i14 = i12;
                    }
                    if (obj4 != null) {
                        this.mTotalLength += ((virtualChildAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3);
                    } else {
                        i10 = this.mTotalLength;
                        this.mTotalLength = Math.max(i10, (((virtualChildAt3.getMeasuredWidth() + i10) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3));
                    }
                    Object obj12 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : 1;
                    i9 = layoutParams.topMargin + layoutParams.bottomMargin;
                    i12 = virtualChildAt3.getMeasuredHeight() + i9;
                    measuredHeight = Math.max(measuredHeight, i12);
                    i9 = Math.max(baseline, obj12 != null ? i9 : i12);
                    obj12 = (obj9 == null || layoutParams.height != -1) ? null : 1;
                    if (z) {
                        i11 = virtualChildAt3.getBaseline();
                        if (i11 != -1) {
                            i3 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i11);
                            iArr2[i3] = Math.max(iArr2[i3], i12 - i11);
                        }
                    }
                    obj8 = obj12;
                    i12 = i4;
                    f6 = f2;
                    i10 = i9;
                    i9 = i14;
                }
                i6++;
                i14 = i12;
                f5 = f6;
                obj9 = obj8;
                i12 = i9;
                baseline = i10;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            i3 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? measuredHeight : Math.max(measuredHeight, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            obj = obj9;
            i10 = i3;
            i5 = i12;
            i3 = baseline;
        } else {
            baseline = Math.max(i6, i7);
            if (z2 && mode != 1073741824) {
                for (i10 = 0; i10 < virtualChildCount; i10++) {
                    View virtualChildAt4 = getVirtualChildAt(i10);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i10 = i9;
            i3 = baseline;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i10;
        }
        setMeasuredDimension((-16777216 & i5) | a, bp.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i5 << 16));
        if (obj2 != null) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    int measureNullChild(int i) {
        return 0;
    }

    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        View virtualChildAt;
        this.mTotalLength = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i10 = this.mBaselineAlignedChildIndex;
        boolean z = this.mUseLargestChild;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i13;
            float f2;
            Object obj6;
            int i14;
            int i15;
            Object obj7;
            View virtualChildAt2 = getVirtualChildAt(i12);
            if (virtualChildAt2 == null) {
                this.mTotalLength += measureNullChild(i12);
                i3 = i6;
                i4 = i8;
                i5 = i7;
                obj4 = obj2;
                obj5 = obj;
                i13 = i9;
                i6 = i11;
                f2 = f;
                obj6 = obj3;
            } else {
                Object obj8;
                float f3;
                if (virtualChildAt2.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i12)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                    float f4 = f + layoutParams.weight;
                    if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        i3 = this.mTotalLength;
                        this.mTotalLength = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                        obj3 = 1;
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                            i3 = 0;
                            layoutParams.height = -2;
                        }
                        int i16 = i3;
                        measureChildBeforeLayout(virtualChildAt2, i12, i, 0, i2, f4 == 0.0f ? this.mTotalLength : 0);
                        if (i16 != Integer.MIN_VALUE) {
                            layoutParams.height = i16;
                        }
                        i3 = virtualChildAt2.getMeasuredHeight();
                        i14 = this.mTotalLength;
                        this.mTotalLength = Math.max(i14, (((i14 + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) + getNextLocationOffset(virtualChildAt2));
                        if (z) {
                            i11 = Math.max(i3, i11);
                        }
                    }
                    if (i10 >= 0 && i10 == i12 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i12 >= i10 || layoutParams.weight <= 0.0f) {
                        Object obj9 = null;
                        if (mode != 1073741824 && layoutParams.width == -1) {
                            obj2 = 1;
                            obj9 = 1;
                        }
                        i15 = layoutParams.rightMargin + layoutParams.leftMargin;
                        i5 = virtualChildAt2.getMeasuredWidth() + i15;
                        i6 = Math.max(i6, i5);
                        i7 = bq.a(i7, bp.k(virtualChildAt2));
                        obj6 = (obj == null || layoutParams.width != -1) ? null : 1;
                        if (layoutParams.weight > 0.0f) {
                            i9 = Math.max(i9, obj9 != null ? i15 : i5);
                            i3 = i6;
                            i15 = i7;
                            obj5 = obj2;
                            obj8 = obj6;
                            obj7 = obj3;
                            i14 = i8;
                            i6 = i9;
                            f3 = f4;
                            i8 = i11;
                        } else {
                            if (obj9 != null) {
                                i5 = i15;
                            }
                            i8 = Math.max(i8, i5);
                            i3 = i6;
                            i15 = i7;
                            obj5 = obj2;
                            obj8 = obj6;
                            obj7 = obj3;
                            i14 = i8;
                            i6 = i9;
                            f3 = f4;
                            i8 = i11;
                        }
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i3 = i6;
                i15 = i7;
                obj5 = obj2;
                obj8 = obj;
                obj7 = obj3;
                i6 = i9;
                f3 = f;
                i14 = i8;
                i8 = i11;
                i12 += getChildrenSkipCount(virtualChildAt2, i12);
                i4 = i14;
                obj6 = obj7;
                i5 = i15;
                obj4 = obj5;
                obj5 = obj8;
                i13 = i6;
                i6 = i8;
                f2 = f3;
            }
            i12++;
            obj3 = obj6;
            i11 = i6;
            i9 = i13;
            obj2 = obj4;
            obj = obj5;
            i7 = i5;
            i6 = i3;
            f = f2;
            i8 = i4;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                virtualChildAt = getVirtualChildAt(i4);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i4);
                    i3 = i4;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt, i4) + i4;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    i5 = this.mTotalLength;
                    this.mTotalLength = Math.max(i5, (layoutParams2.bottomMargin + (layoutParams2.topMargin + (i5 + i11))) + getNextLocationOffset(virtualChildAt));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int a = bp.a(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a) - this.mTotalLength;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            this.mTotalLength = 0;
            int i17 = 0;
            obj5 = obj;
            i13 = i8;
            float f5 = f;
            i14 = i7;
            while (i17 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i17);
                if (virtualChildAt3.getVisibility() != 8) {
                    layoutParams2 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    f2 = layoutParams2.weight;
                    if (f2 > 0.0f) {
                        i12 = (int) ((((float) i5) * f2) / f5);
                        int childMeasureSpec = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                        if (layoutParams2.height == 0 && mode2 == 1073741824) {
                            i4 = i12 > 0 ? i12 : 0;
                        } else {
                            i4 = virtualChildAt3.getMeasuredHeight() + i12;
                            if (i4 < 0) {
                                i4 = 0;
                            }
                        }
                        virtualChildAt3.measure(childMeasureSpec, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        i4 = bq.a(i14, bp.k(virtualChildAt3) & -256);
                        i12 = i5 - i12;
                        f = f5 - f2;
                    } else {
                        i4 = i14;
                        i12 = i5;
                        f = f5;
                    }
                    i5 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                    i15 = virtualChildAt3.getMeasuredWidth() + i5;
                    i6 = Math.max(i6, i15);
                    Object obj10 = (mode == 1073741824 || layoutParams2.width != -1) ? null : 1;
                    if (obj10 == null) {
                        i5 = i15;
                    }
                    i15 = Math.max(i13, i5);
                    obj7 = (obj5 == null || layoutParams2.width != -1) ? null : 1;
                    int i18 = this.mTotalLength;
                    this.mTotalLength = Math.max(i18, (layoutParams2.bottomMargin + ((virtualChildAt3.getMeasuredHeight() + i18) + layoutParams2.topMargin)) + getNextLocationOffset(virtualChildAt3));
                    i3 = i15;
                    f5 = f;
                    i14 = i12;
                    i12 = i6;
                } else {
                    i4 = i14;
                    i3 = i13;
                    i12 = i6;
                    i14 = i5;
                    obj7 = obj5;
                }
                i17++;
                i6 = i12;
                i13 = i3;
                obj5 = obj7;
                i5 = i14;
                i14 = i4;
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            obj = obj5;
            i7 = i14;
            i4 = i6;
            i3 = i13;
        } else {
            i13 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    virtualChildAt = getVirtualChildAt(i4);
                    if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || ((LayoutParams) virtualChildAt.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt.measure(MeasureSpec.makeMeasureSpec(virtualChildAt.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i4 = i6;
            i3 = i13;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(bp.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a);
        if (obj2 != null) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.mGravity & 8388615) != i2) {
            this.mGravity = i2 | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = i2 | (this.mGravity & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
