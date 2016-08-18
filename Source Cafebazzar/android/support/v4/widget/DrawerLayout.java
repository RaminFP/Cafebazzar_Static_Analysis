package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.c.a.a;
import android.support.v4.view.bp;
import android.support.v4.view.v;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class DrawerLayout extends ViewGroup {
    static final j e;
    private static final int[] f = new int[]{16842931};
    private static final boolean g = (VERSION.SDK_INT >= 19);
    private static final boolean h;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private Object E;
    private boolean F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private final ArrayList K;
    final aw a;
    final aw b;
    int c;
    List d;
    private final i i;
    private float j;
    private int k;
    private int l;
    private float m;
    private Paint n;
    private final p o;
    private final p p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    @Deprecated
    private m y;
    private float z;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new o();
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        h = z;
        if (VERSION.SDK_INT >= 21) {
            e = new k();
        } else {
            e = new l();
        }
    }

    private void a(int i, int i2) {
        int a = v.a(i2, bp.h(this));
        switch (i2) {
            case 3:
                this.s = i;
                break;
            case 5:
                this.t = i;
                break;
            case 8388611:
                this.u = i;
                break;
            case 8388613:
                this.v = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.a : this.b).a();
        }
        View a2;
        switch (i) {
            case 1:
                a2 = a(a);
                if (a2 != null) {
                    e(a2);
                    return;
                }
                return;
            case 2:
                a2 = a(a);
                if (a2 != null) {
                    d(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            n nVar = (n) childAt.getLayoutParams();
            if (c(childAt) && (!z || nVar.c)) {
                i = a(childAt, 3) ? i | this.a.a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.b.a(childAt, getWidth(), childAt.getTop());
                nVar.c = false;
            }
        }
        this.o.a();
        this.p.a();
        if (i != 0) {
            invalidate();
        }
    }

    private static boolean a(Drawable drawable, int i) {
        if (drawable == null || !a.b(drawable)) {
            return false;
        }
        a.b(drawable, i);
        return true;
    }

    static float b(View view) {
        return ((n) view.getLayoutParams()).b;
    }

    private View b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((n) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public static String b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private View c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (c(childAt) && f(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    static boolean c(View view) {
        int a = v.a(((n) view.getLayoutParams()).a, bp.h(view));
        return (a & 3) != 0 ? true : (a & 5) != 0;
    }

    static /* synthetic */ boolean g(View view) {
        return (bp.e(view) == 4 || bp.e(view) == 2) ? false : true;
    }

    private int h(View view) {
        return v.a(((n) view.getLayoutParams()).a, bp.h(this));
    }

    private static boolean i(View view) {
        return ((n) view.getLayoutParams()).a == 0;
    }

    private boolean j(View view) {
        if (c(view)) {
            return (((n) view.getLayoutParams()).d & 1) == 1;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public final int a(View view) {
        if (c(view)) {
            int i = ((n) view.getLayoutParams()).a;
            int h = bp.h(this);
            switch (i) {
                case 3:
                    if (this.s != 3) {
                        return this.s;
                    }
                    i = h == 0 ? this.u : this.v;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.t != 3) {
                        return this.t;
                    }
                    i = h == 0 ? this.v : this.u;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.u != 3) {
                        return this.u;
                    }
                    i = h == 0 ? this.s : this.t;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.v != 3) {
                        return this.v;
                    }
                    i = h == 0 ? this.t : this.s;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final View a(int i) {
        int a = v.a(i, bp.h(this));
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((h(childAt) & 7) == (a & 7)) {
                return childAt;
            }
        }
        return null;
    }

    final void a(View view, float f) {
        n nVar = (n) view.getLayoutParams();
        if (f != nVar.b) {
            nVar.b = f;
            if (this.d != null) {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    ((m) this.d.get(size)).onDrawerSlide(view, f);
                }
            }
        }
    }

    void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || c(childAt)) && !(z && childAt == view)) {
                bp.c(childAt, 4);
            } else {
                bp.c(childAt, 1);
            }
        }
    }

    final boolean a(View view, int i) {
        return (h(view) & i) == i;
    }

    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!c(childAt)) {
                    this.K.add(childAt);
                } else if (j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.K.size();
                while (i3 < i4) {
                    View view = (View) this.K.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.K.clear();
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (b() != null || c(view)) {
            bp.c(view, 4);
        } else {
            bp.c(view, 1);
        }
        if (!g) {
            bp.a(view, this.i);
        }
    }

    public final boolean c(int i) {
        View a = a(8388611);
        return a != null ? j(a) : false;
    }

    protected final boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof n) && super.checkLayoutParams(layoutParams);
    }

    public final void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((n) getChildAt(i).getLayoutParams()).b);
        }
        this.m = f;
        if ((this.a.a(true) | this.b.a(true)) != 0) {
            bp.d(this);
        }
    }

    public final void d(View view) {
        if (c(view)) {
            n nVar = (n) view.getLayoutParams();
            if (this.r) {
                nVar.b = 1.0f;
                nVar.d = 1;
                a(view, true);
            } else {
                n.b(nVar, 2);
                if (a(view, 3)) {
                    this.a.a(view, 0, view.getTop());
                } else {
                    this.b.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected final boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean i = i(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (i) {
            int childCount = getChildCount();
            i2 = 0;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    Object obj = background != null ? background.getOpacity() == -1 ? 1 : null : null;
                    if (obj != null && c(childAt) && childAt.getHeight() >= height) {
                        if (a(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i2) {
                                right = i2;
                            }
                            i2 = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i3++;
                        width = right;
                    }
                }
                right = width;
                i3++;
                width = right;
            }
            canvas.clipRect(i2, 0, width, getHeight());
            right = width;
        } else {
            right = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.m > 0.0f && i) {
            this.n.setColor((((int) (((float) ((this.l & -16777216) >>> 24)) * this.m)) << 24) | (this.l & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) right, (float) getHeight(), this.n);
        } else if (this.C != null && a(view, 3)) {
            right = this.C.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.a.j), 1.0f));
            this.C.setBounds(i2, view.getTop(), right + i2, view.getBottom());
            this.C.setAlpha((int) (255.0f * r2));
            this.C.draw(canvas);
            return drawChild;
        } else if (this.D != null && a(view, 5)) {
            right = this.D.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.b.j), 1.0f));
            this.D.setBounds(i2 - right, view.getTop(), i2, view.getBottom());
            this.D.setAlpha((int) (255.0f * r2));
            this.D.draw(canvas);
            return drawChild;
        }
        return drawChild;
    }

    public final void e(View view) {
        if (c(view)) {
            n nVar = (n) view.getLayoutParams();
            if (this.r) {
                nVar.b = 0.0f;
                nVar.d = 0;
            } else {
                n.b(nVar, 4);
                if (a(view, 3)) {
                    this.a.a(view, -view.getWidth(), view.getTop());
                } else {
                    this.b.a(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final boolean f(View view) {
        if (c(view)) {
            return ((n) view.getLayoutParams()).b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new n(-1, -1);
    }

    public final LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new n(getContext(), attributeSet);
    }

    protected final LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof n ? new n((n) layoutParams) : layoutParams instanceof MarginLayoutParams ? new n((MarginLayoutParams) layoutParams) : new n(layoutParams);
    }

    public final float getDrawerElevation() {
        return h ? this.j : 0.0f;
    }

    public final Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.F && this.B != null) {
            int a = e.a(this.E);
            if (a > 0) {
                this.B.setBounds(0, 0, getWidth(), a);
                this.B.draw(canvas);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        r2 = 1;
        r1 = 0;
        r0 = android.support.v4.view.ay.a(r11);
        r3 = r10.a;
        r4 = r3.a(r11);
        r3 = r10.b;
        r5 = r3.a(r11);
        switch(r0) {
            case 0: goto L_0x003c;
            case 1: goto L_0x00b5;
            case 2: goto L_0x0065;
            case 3: goto L_0x00b5;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r3 = r5 | r4;
        if (r3 != 0) goto L_0x003a;
    L_0x001a:
        if (r0 != 0) goto L_0x003a;
    L_0x001c:
        r4 = r10.getChildCount();
        r3 = r1;
    L_0x0021:
        if (r3 >= r4) goto L_0x00c3;
    L_0x0023:
        r0 = r10.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.n) r0;
        r0 = r0.c;
        if (r0 == 0) goto L_0x00be;
    L_0x0033:
        r0 = r2;
    L_0x0034:
        if (r0 != 0) goto L_0x003a;
    L_0x0036:
        r0 = r10.x;
        if (r0 == 0) goto L_0x00c8;
    L_0x003a:
        r0 = r2;
    L_0x003b:
        return r0;
    L_0x003c:
        r0 = r11.getX();
        r3 = r11.getY();
        r10.z = r0;
        r10.A = r3;
        r6 = r10.m;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 <= 0) goto L_0x00c6;
    L_0x004f:
        r6 = r10.a;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r6.a(r0, r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x0059:
        r0 = i(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x005f:
        r0 = r2;
    L_0x0060:
        r10.w = r1;
        r10.x = r1;
        goto L_0x0016;
    L_0x0065:
        r6 = r10.a;
        r0 = r6.d;
        r7 = r0.length;
        r3 = r1;
    L_0x006b:
        if (r3 >= r7) goto L_0x00b3;
    L_0x006d:
        r0 = r6.h;
        r8 = r2 << r3;
        r0 = r0 & r8;
        if (r0 == 0) goto L_0x00a9;
    L_0x0074:
        r0 = r2;
    L_0x0075:
        if (r0 == 0) goto L_0x00ad;
    L_0x0077:
        r0 = r6.f;
        r0 = r0[r3];
        r8 = r6.d;
        r8 = r8[r3];
        r0 = r0 - r8;
        r8 = r6.g;
        r8 = r8[r3];
        r9 = r6.e;
        r9 = r9[r3];
        r8 = r8 - r9;
        r0 = r0 * r0;
        r8 = r8 * r8;
        r0 = r0 + r8;
        r8 = r6.b;
        r9 = r6.b;
        r8 = r8 * r9;
        r8 = (float) r8;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x00ab;
    L_0x0096:
        r0 = r2;
    L_0x0097:
        if (r0 == 0) goto L_0x00af;
    L_0x0099:
        r0 = r2;
    L_0x009a:
        if (r0 == 0) goto L_0x0015;
    L_0x009c:
        r0 = r10.o;
        r0.a();
        r0 = r10.p;
        r0.a();
        r0 = r1;
        goto L_0x0016;
    L_0x00a9:
        r0 = r1;
        goto L_0x0075;
    L_0x00ab:
        r0 = r1;
        goto L_0x0097;
    L_0x00ad:
        r0 = r1;
        goto L_0x0097;
    L_0x00af:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x006b;
    L_0x00b3:
        r0 = r1;
        goto L_0x009a;
    L_0x00b5:
        r10.a(r2);
        r10.w = r1;
        r10.x = r1;
        goto L_0x0015;
    L_0x00be:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0021;
    L_0x00c3:
        r0 = r1;
        goto L_0x0034;
    L_0x00c6:
        r0 = r1;
        goto L_0x0060;
    L_0x00c8:
        r0 = r1;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (c() != null) {
                z.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View c = c();
        if (c != null && a(c) == 0) {
            a(false);
        }
        return c != null;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.q = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                n nVar = (n) childAt.getLayoutParams();
                if (i(childAt)) {
                    childAt.layout(nVar.leftMargin, nVar.topMargin, nVar.leftMargin + childAt.getMeasuredWidth(), nVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        a = (-measuredWidth) + ((int) (((float) measuredWidth) * nVar.b));
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * nVar.b));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != nVar.b ? 1 : null;
                    int i7;
                    switch (nVar.a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < nVar.topMargin) {
                                i7 = nVar.topMargin;
                            } else if (i7 + measuredHeight > i8 - nVar.bottomMargin) {
                                i7 = (i8 - nVar.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - nVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - nVar.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, nVar.topMargin, measuredWidth + a, measuredHeight + nVar.topMargin);
                            break;
                    }
                    if (obj != null) {
                        a(childAt, f);
                    }
                    int i9 = nVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.q = false;
        this.r = false;
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        Object obj;
        int h;
        Object obj2;
        Object obj3;
        int childCount;
        int i4;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int a;
        Object obj4;
        int h2;
        Object obj5;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    mode2 = size;
                    i3 = 300;
                    setMeasuredDimension(mode2, i3);
                    obj = (this.E == null && bp.v(this)) ? 1 : null;
                    h = bp.h(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    i4 = 0;
                    while (i4 < childCount) {
                        childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 8) {
                            marginLayoutParams = (n) childAt.getLayoutParams();
                            if (obj != null) {
                                a = v.a(marginLayoutParams.a, h);
                                if (bp.v(childAt)) {
                                    e.a(marginLayoutParams, this.E, a);
                                } else {
                                    e.a(childAt, this.E, a);
                                }
                            }
                            if (i(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((i3 - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                                obj4 = obj2;
                                obj2 = obj3;
                            } else if (c(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            } else {
                                if (h && bp.s(childAt) != this.j) {
                                    bp.e(childAt, this.j);
                                }
                                h2 = h(childAt) & 7;
                                obj5 = h2 != 3 ? 1 : null;
                                if ((obj5 != null || obj2 == null) && (obj5 != null || obj3 == null)) {
                                    if (obj5 == null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.k + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                    obj4 = obj2;
                                    obj2 = obj3;
                                } else {
                                    throw new IllegalStateException("Child drawer has absolute gravity " + b(h2) + " but this DrawerLayout" + " already has a drawer view along that edge");
                                }
                            }
                        }
                        obj4 = obj2;
                        obj2 = obj3;
                        i4++;
                        obj3 = obj2;
                        obj2 = obj4;
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode2 = size;
        i3 = size2;
        setMeasuredDimension(mode2, i3);
        if (this.E == null) {
        }
        h = bp.h(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        i4 = 0;
        while (i4 < childCount) {
            childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                obj4 = obj2;
                obj2 = obj3;
            } else {
                marginLayoutParams = (n) childAt.getLayoutParams();
                if (obj != null) {
                    a = v.a(marginLayoutParams.a, h);
                    if (bp.v(childAt)) {
                        e.a(marginLayoutParams, this.E, a);
                    } else {
                        e.a(childAt, this.E, a);
                    }
                }
                if (i(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((i3 - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                    obj4 = obj2;
                    obj2 = obj3;
                } else if (c(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    bp.e(childAt, this.j);
                    h2 = h(childAt) & 7;
                    if (h2 != 3) {
                    }
                    if (obj5 != null) {
                    }
                    if (obj5 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.k + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                    obj4 = obj2;
                    obj2 = obj3;
                }
            }
            i4++;
            obj3 = obj2;
            obj2 = obj4;
        }
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a != 0) {
            View a = a(savedState.a);
            if (a != null) {
                d(a);
            }
        }
        if (savedState.b != 3) {
            a(savedState.b, 3);
        }
        if (savedState.c != 3) {
            a(savedState.c, 5);
        }
        if (savedState.d != 3) {
            a(savedState.d, 8388611);
        }
        if (savedState.e != 3) {
            a(savedState.e, 8388613);
        }
    }

    public final void onRtlPropertiesChanged(int i) {
        if (!h) {
            Drawable drawable;
            int h = bp.h(this);
            if (h == 0) {
                if (this.G != null) {
                    a(this.G, h);
                    drawable = this.G;
                }
                drawable = this.I;
            } else {
                if (this.H != null) {
                    a(this.H, h);
                    drawable = this.H;
                }
                drawable = this.I;
            }
            this.C = drawable;
            h = bp.h(this);
            if (h == 0) {
                if (this.H != null) {
                    a(this.H, h);
                    drawable = this.H;
                }
                drawable = this.J;
            } else {
                if (this.G != null) {
                    a(this.G, h);
                    drawable = this.G;
                }
                drawable = this.J;
            }
            this.D = drawable;
        }
    }

    protected final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            n nVar = (n) getChildAt(i).getLayoutParams();
            Object obj = nVar.d == 1 ? 1 : null;
            Object obj2 = nVar.d == 2 ? 1 : null;
            if (obj != null || obj2 != null) {
                savedState.a = nVar.a;
                break;
            }
        }
        savedState.b = this.s;
        savedState.c = this.t;
        savedState.d = this.u;
        savedState.e = this.v;
        return savedState;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.b(motionEvent);
        this.b.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.z = x;
                this.A = y;
                this.w = false;
                this.x = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View a = this.a.a((int) x, (int) y);
                if (a != null && i(a)) {
                    x -= this.z;
                    y -= this.A;
                    int i = this.a.b;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View b = b();
                        if (b != null) {
                            z = a(b) == 2;
                            a(z);
                            this.w = false;
                            break;
                        }
                    }
                }
                z = true;
                a(z);
                this.w = false;
            case 3:
                a(true);
                this.w = false;
                this.x = false;
                break;
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.w = z;
        if (z) {
            a(true);
        }
    }

    public final void requestLayout() {
        if (!this.q) {
            super.requestLayout();
        }
    }

    public final void setDrawerElevation(float f) {
        this.j = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (c(childAt)) {
                bp.e(childAt, this.j);
            }
        }
    }

    @Deprecated
    public final void setDrawerListener(m mVar) {
        if (this.y != null) {
            m mVar2 = this.y;
            if (mVar2 != null) {
                this.d.remove(mVar2);
            }
        }
        if (!(mVar == null || mVar == null)) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(mVar);
        }
        this.y = mVar;
    }

    public final void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public final void setScrimColor(int i) {
        this.l = i;
        invalidate();
    }

    public final void setStatusBarBackground(int i) {
        this.B = i != 0 ? android.support.v4.b.a.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public final void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public final void setStatusBarBackgroundColor(int i) {
        this.B = new ColorDrawable(i);
        invalidate();
    }
}
