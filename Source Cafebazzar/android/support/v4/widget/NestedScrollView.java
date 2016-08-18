package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ay;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v4.view.bh;
import android.support.v4.view.bk;
import android.support.v4.view.bl;
import android.support.v4.view.bp;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public class NestedScrollView extends FrameLayout implements be, bg, bk {
    private static final y v = new y();
    private static final int[] w = new int[]{16843130};
    private z A;
    private long a;
    private final Rect b;
    private aj c;
    private r d;
    private r e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private SavedState u;
    private final bh x;
    private final bf y;
    private float z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new aa();
        public int a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        this.c = aj.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.x = new bh(this);
        this.y = new bf(this);
        setNestedScrollingEnabled(true);
        bp.a((View) this, v);
    }

    private int a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    private void a() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() >> 8) & 255;
        if (ay.b(motionEvent, action) == this.q) {
            action = action == 0 ? 1 : 0;
            this.f = (int) ay.d(motionEvent, action);
            this.q = ay.b(motionEvent, action);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private boolean a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.b.top = 0;
        this.b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.b.top = this.b.bottom - height;
            }
        }
        return a(i, this.b.top, this.b.bottom);
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        Object obj = i == 33 ? 1 : null;
        List focusables = getFocusables(2);
        View view = null;
        Object obj2 = null;
        int size = focusables.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj3;
            View view2 = (View) focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                Object obj4 = (i2 >= top || bottom >= i3) ? null : 1;
                if (view == null) {
                    obj3 = obj4;
                } else {
                    Object obj5 = ((obj == null || top >= view.getTop()) && (obj != null || bottom <= view.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj4 == null || obj5 == null)) {
                            obj3 = obj2;
                        }
                    } else if (obj4 != null) {
                        obj3 = 1;
                    } else if (obj5 != null) {
                        obj3 = obj2;
                    }
                }
                i5++;
                obj2 = obj3;
                view = view2;
            }
            view2 = view;
            obj3 = obj2;
            i5++;
            obj2 = obj3;
            view = view2;
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            c(obj != null ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        boolean z2;
        bp.a(this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i9 = i3 + i;
        int i10 = i4 + i2;
        int i11 = i6 + 0;
        if (i9 > 0) {
            i9 = 0;
            z = true;
        } else if (i9 < 0) {
            i9 = 0;
            z = true;
        } else {
            z = false;
        }
        if (i10 > i11) {
            z2 = true;
        } else if (i10 < 0) {
            i11 = 0;
            z2 = true;
        } else {
            z2 = false;
            i11 = i10;
        }
        if (z2) {
            this.c.a(i9, i11, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i9, i11, z, z2);
        return z || z2;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + i >= getScrollY() && this.b.top - i <= getScrollY() + i2;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private static int b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void b() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    private void b(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
                int height = getHeight();
                int paddingBottom = getPaddingBottom();
                height = Math.max(0, getChildAt(0).getHeight() - ((height - paddingBottom) - getPaddingTop()));
                int scrollY = getScrollY();
                int max = Math.max(0, Math.min(scrollY + i2, height));
                aj ajVar = this.c;
                ajVar.b.a(ajVar.a, getScrollX(), scrollY, 0, max - scrollY);
                bp.d(this);
            } else {
                if (!this.c.a()) {
                    this.c.h();
                }
                scrollBy(i, i2);
            }
            this.a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int a = a(this.b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean b(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            c(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findNextFocus, this.b);
            c(a(this.b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private void c() {
        this.j = false;
        b();
        stopNestedScroll();
        if (this.d != null) {
            this.d.c();
            this.e.c();
        }
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        if (this.m) {
            b(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void d() {
        if (bp.a(this) == 2) {
            this.d = null;
            this.e = null;
        } else if (this.d == null) {
            Context context = getContext();
            this.d = new r(context);
            this.e = new r(context);
        }
    }

    private void d(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z && getChildCount() > 0) {
                scrollY = (getHeight() - getPaddingBottom()) - getPaddingTop();
                int height = getChildAt(0).getHeight();
                aj ajVar = this.c;
                ajVar.b.a(ajVar.a, getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height - scrollY), 0, scrollY / 2);
                bp.d(this);
            }
        }
    }

    private int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.z;
    }

    public final void a(int i, int i2) {
        b(0 - getScrollX(), i2 - getScrollY());
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.c.g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.c.b();
            int c = this.c.c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = bp.a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0);
                if (i != 0) {
                    d();
                    if (c <= 0 && scrollY > 0) {
                        this.d.a((int) this.c.f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.e.a((int) this.c.f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            int i;
            boolean b;
            this.b.setEmpty();
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom() ? 1 : 0;
            } else {
                i = 0;
            }
            View childAt2;
            if (i != 0) {
                if (keyEvent.getAction() == 0) {
                    switch (keyEvent.getKeyCode()) {
                        case 19:
                            if (!keyEvent.isAltPressed()) {
                                b = b(33);
                                break;
                            }
                            b = a(33);
                            break;
                        case 20:
                            if (!keyEvent.isAltPressed()) {
                                b = b(130);
                                break;
                            }
                            b = a(130);
                            break;
                        case 62:
                            i = keyEvent.isShiftPressed() ? 33 : 130;
                            int i2 = i == 130 ? 1 : 0;
                            int height = getHeight();
                            if (i2 != 0) {
                                this.b.top = getScrollY() + height;
                                i2 = getChildCount();
                                if (i2 > 0) {
                                    childAt2 = getChildAt(i2 - 1);
                                    if (this.b.top + height > childAt2.getBottom()) {
                                        this.b.top = childAt2.getBottom() - height;
                                    }
                                }
                            } else {
                                this.b.top = getScrollY() - height;
                                if (this.b.top < 0) {
                                    this.b.top = 0;
                                }
                            }
                            this.b.bottom = height + this.b.top;
                            a(i, this.b.top, this.b.bottom);
                            break;
                    }
                }
                b = false;
            } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
                b = false;
            } else {
                childAt2 = findFocus();
                if (childAt2 == this) {
                    childAt2 = null;
                }
                childAt2 = FocusFinder.getInstance().findNextFocus(this, childAt2, 130);
                b = (childAt2 == null || childAt2 == this || !childAt2.requestFocus(130)) ? false : true;
            }
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.y.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.y.a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.y.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.y.a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d != null) {
            int save;
            int width;
            int paddingLeft;
            int scrollY = getScrollY();
            if (!this.d.a()) {
                save = canvas.save();
                width = getWidth();
                paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.d.a((width - paddingLeft) - paddingRight, getHeight());
                if (this.d.a(canvas)) {
                    bp.d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.e.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                paddingLeft = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + paddingLeft));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.e.a(width, paddingLeft);
                if (this.e.a(canvas)) {
                    bp.d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.x.a;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.y.a();
    }

    public boolean isNestedScrollingEnabled() {
        return this.y.a;
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        this.h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((ay.d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.j) {
                    return false;
                }
                float e = ay.e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.j = false;
                    b();
                    break;
                }
                this.f = y;
                this.q = ay.b(motionEvent, 0);
                if (this.k == null) {
                    this.k = VelocityTracker.obtain();
                } else {
                    this.k.clear();
                }
                this.k.addMovement(motionEvent);
                this.c.g();
                if (!this.c.a()) {
                    z = true;
                }
                this.j = z;
                startNestedScroll(2);
                break;
                break;
            case 1:
            case 3:
                this.j = false;
                this.q = -1;
                b();
                if (this.c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bp.d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.q;
                if (action != -1) {
                    y = ay.a(motionEvent, action);
                    if (y != -1) {
                        action = (int) ay.d(motionEvent, y);
                        if (Math.abs(action - this.f) > this.n && (getNestedScrollAxes() & 2) == 0) {
                            this.j = true;
                            this.f = action;
                            a();
                            this.k.addMovement(motionEvent);
                            this.t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        return this.j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g = false;
        if (this.i != null && a(this.i, (View) this)) {
            b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.u != null) {
                scrollTo(getScrollX(), this.u.a);
                this.u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        d((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.x.a = i;
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getScrollY();
        return savedState;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.A != null) {
            this.A.a();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findFocus, this.b);
            c(a(this.b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.x.a = 0;
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = ay.a(motionEvent);
        if (a == 0) {
            this.t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.c.a();
                    this.j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.c.a()) {
                        this.c.h();
                    }
                    this.f = (int) motionEvent.getY();
                    this.q = ay.b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.j) {
                    VelocityTracker velocityTracker = this.k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.p);
                    a = (int) bl.b(velocityTracker, this.q);
                    if (Math.abs(a) > this.o) {
                        d(-a);
                    } else if (this.c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        bp.d(this);
                    }
                }
                this.q = -1;
                c();
                break;
            case 2:
                int a2 = ay.a(motionEvent, this.q);
                if (a2 != -1) {
                    int i;
                    int d = (int) ay.d(motionEvent, a2);
                    a = this.f - d;
                    if (dispatchNestedPreScroll(0, a, this.s, this.r)) {
                        a -= this.s[1];
                        obtain.offsetLocation(0.0f, (float) this.r[1]);
                        this.t += this.r[1];
                    }
                    if (this.j || Math.abs(a) <= this.n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        i = a > 0 ? a - this.n : this.n + a;
                    }
                    if (this.j) {
                        this.f = d - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = bp.a(this);
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0) && !hasNestedScrollingParent()) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.r)) {
                            if (obj != null) {
                                d();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.d.a(((float) i) / ((float) getHeight()), ay.c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.e.a()) {
                                        this.e.c();
                                    }
                                } else if (a > scrollRange) {
                                    this.e.a(((float) i) / ((float) getHeight()), 1.0f - (ay.c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.d.a()) {
                                        this.d.c();
                                    }
                                }
                                if (!(this.d == null || (this.d.a() && this.e.a()))) {
                                    bp.d(this);
                                    break;
                                }
                            }
                        }
                        this.f -= this.r[1];
                        obtain.offsetLocation(0.0f, (float) this.r[1]);
                        this.t += this.r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.j && getChildCount() > 0 && this.c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bp.d(this);
                }
                this.q = -1;
                c();
                break;
            case 5:
                a = ay.b(motionEvent);
                this.f = (int) ay.d(motionEvent, a);
                this.q = ay.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.f = (int) ay.d(motionEvent, ay.a(motionEvent, this.q));
                break;
        }
        if (this.k != null) {
            this.k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.g) {
            this.i = view2;
        } else {
            b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int a = a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                b(0, a);
            }
        }
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            b();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.y.a(z);
    }

    public void setOnScrollChangeListener(z zVar) {
        this.A = zVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.y.a(i);
    }

    public void stopNestedScroll() {
        this.y.b();
    }
}
