package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.bg;
import android.support.v4.view.bh;
import android.support.v4.view.bp;
import android.support.v4.view.di;
import android.support.v4.view.dy;
import android.support.v4.widget.aj;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.internal.view.menu.y;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements bg, ai {
    static final int[] b = new int[]{b.actionBarSize, 16842841};
    private final dy A;
    private final dy B;
    private final Runnable C;
    private final Runnable D;
    private final bh E;
    public boolean a;
    private int c;
    private int d;
    private ContentFrameLayout e;
    private ActionBarContainer f;
    private ActionBarContainer g;
    private aj h;
    private Drawable i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private l v;
    private final int w;
    private aj x;
    private di y;
    private di z;

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.w = 600;
        this.A = new h(this);
        this.B = new i(this);
        this.C = new j(this);
        this.D = new k(this);
        a(context);
        this.E = new bh(this);
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(b);
        this.c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.i = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.i == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.j = z;
        this.x = aj.a(context, null);
    }

    private static boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        m mVar = (m) view.getLayoutParams();
        if (mVar.leftMargin != rect.left) {
            mVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && mVar.topMargin != rect.top) {
            mVar.topMargin = rect.top;
            z5 = true;
        }
        if (mVar.rightMargin != rect.right) {
            mVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || mVar.bottomMargin == rect.bottom) {
            return z5;
        }
        mVar.bottomMargin = rect.bottom;
        return true;
    }

    private void h() {
        if (this.e == null) {
            aj ajVar;
            this.e = (ContentFrameLayout) findViewById(g.action_bar_activity_content);
            this.g = (ActionBarContainer) findViewById(g.action_bar_container);
            View findViewById = findViewById(g.action_bar);
            if (findViewById instanceof aj) {
                ajVar = (aj) findViewById;
            } else if (findViewById instanceof Toolbar) {
                ajVar = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.h = ajVar;
            this.f = (ActionBarContainer) findViewById(g.split_action_bar);
        }
    }

    private void i() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        if (this.y != null) {
            this.y.a();
        }
        if (this.z != null) {
            this.z.a();
        }
    }

    public final void a(int i) {
        h();
        switch (i) {
            case 2:
                this.h.f();
                return;
            case 5:
                this.h.g();
                return;
            case 9:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public final void a(Menu menu, y yVar) {
        h();
        this.h.a(menu, yVar);
    }

    public final boolean a() {
        h();
        return this.h.h();
    }

    public final boolean b() {
        h();
        return this.h.i();
    }

    public final boolean c() {
        h();
        return this.h.j();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof m;
    }

    public final boolean d() {
        h();
        return this.h.k();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.i != null && !this.j) {
            int bottom = this.g.getVisibility() == 0 ? (int) ((((float) this.g.getBottom()) + bp.o(this.g)) + 0.5f) : 0;
            this.i.setBounds(0, bottom, getWidth(), this.i.getIntrinsicHeight() + bottom);
            this.i.draw(canvas);
        }
    }

    public final boolean e() {
        h();
        return this.h.l();
    }

    public final void f() {
        h();
        this.h.m();
    }

    protected boolean fitSystemWindows(Rect rect) {
        h();
        bp.t(this);
        boolean a = a(this.g, rect, true, true, false, true);
        if (this.f != null) {
            a |= a(this.f, rect, true, false, true, true);
        }
        this.s.set(rect);
        bq.a(this, this.s, this.p);
        if (!this.q.equals(this.p)) {
            this.q.set(this.p);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public final void g() {
        h();
        this.h.n();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new m(-1, -1);
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new m(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.g != null ? -((int) bp.o(this.g)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.E.a;
    }

    public CharSequence getTitle() {
        h();
        return this.h.e();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        bp.u(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                m mVar = (m) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = mVar.leftMargin + paddingLeft;
                int i7 = childAt == this.f ? (((i4 - i2) - paddingBottom) - measuredHeight) - mVar.bottomMargin : mVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int max2;
        int a;
        int i3;
        h();
        measureChildWithMargins(this.g, i, 0, i2, 0);
        m mVar = (m) this.g.getLayoutParams();
        int max3 = Math.max(0, (this.g.getMeasuredWidth() + mVar.leftMargin) + mVar.rightMargin);
        int max4 = Math.max(0, mVar.bottomMargin + (this.g.getMeasuredHeight() + mVar.topMargin));
        int a2 = bq.a(0, bp.k(this.g));
        if (this.f != null) {
            measureChildWithMargins(this.f, i, 0, i2, 0);
            mVar = (m) this.f.getLayoutParams();
            max = Math.max(max3, (this.f.getMeasuredWidth() + mVar.leftMargin) + mVar.rightMargin);
            max2 = Math.max(max4, mVar.bottomMargin + (this.f.getMeasuredHeight() + mVar.topMargin));
            a = bq.a(a2, bp.k(this.f));
        } else {
            max = max3;
            max2 = max4;
            a = a2;
        }
        boolean z = (bp.t(this) & NotificationCompat.FLAG_LOCAL_ONLY) != 0;
        if (z) {
            i3 = this.c;
            if (this.k && this.g.getTabContainer() != null) {
                i3 += this.c;
            }
        } else {
            i3 = this.g.getVisibility() != 8 ? this.g.getMeasuredHeight() : 0;
        }
        this.r.set(this.p);
        this.t.set(this.s);
        Rect rect;
        Rect rect2;
        if (this.a || z) {
            rect = this.t;
            rect.top = i3 + rect.top;
            rect2 = this.t;
            rect2.bottom = rect2.bottom;
        } else {
            rect = this.r;
            rect.top = i3 + rect.top;
            rect2 = this.r;
            rect2.bottom = rect2.bottom;
        }
        a(this.e, this.r, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.e.a(this.t);
        }
        measureChildWithMargins(this.e, i, 0, i2, 0);
        mVar = (m) this.e.getLayoutParams();
        int max5 = Math.max(max, (this.e.getMeasuredWidth() + mVar.leftMargin) + mVar.rightMargin);
        i3 = Math.max(max2, mVar.bottomMargin + (this.e.getMeasuredHeight() + mVar.topMargin));
        int a3 = bq.a(a, bp.k(this.e));
        setMeasuredDimension(bp.a(Math.max(max5 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a3), bp.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a3 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.l || !z) {
            return false;
        }
        this.x.a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.x.e() > this.g.getHeight()) {
            z2 = true;
        }
        if (z2) {
            i();
            this.D.run();
        } else {
            i();
            this.C.run();
        }
        this.m = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.n += i2;
        setActionBarHideOffset(this.n);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.E.a = i;
        this.n = getActionBarHideOffset();
        i();
        if (this.v != null) {
            this.v.f();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.g.getVisibility() != 0) ? false : this.l;
    }

    public void onStopNestedScroll(View view) {
        if (this.l && !this.m) {
            if (this.n <= this.g.getHeight()) {
                i();
                postDelayed(this.C, 600);
                return;
            }
            i();
            postDelayed(this.D, 600);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = false;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        h();
        int i2 = this.o;
        this.o = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & NotificationCompat.FLAG_LOCAL_ONLY) != 0;
        if (this.v != null) {
            l lVar = this.v;
            if (!z3) {
                z = true;
            }
            lVar.d(z);
            if (z2 || !z3) {
                this.v.d();
            } else {
                this.v.e();
            }
        }
        if (((i2 ^ i) & NotificationCompat.FLAG_LOCAL_ONLY) != 0 && this.v != null) {
            bp.u(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i;
        if (this.v != null) {
            this.v.a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        i();
        int height = this.g.getHeight();
        int max = Math.max(0, Math.min(i, height));
        bp.b(this.g, (float) (-max));
        if (this.f != null && this.f.getVisibility() != 8) {
            bp.b(this.f, (float) ((int) ((((float) max) / ((float) height)) * ((float) this.f.getHeight()))));
        }
    }

    public void setActionBarVisibilityCallback(l lVar) {
        this.v = lVar;
        if (getWindowToken() != null) {
            this.v.a(this.d);
            if (this.o != 0) {
                onWindowSystemUiVisibilityChanged(this.o);
                bp.u(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (!z) {
                i();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        h();
        this.h.a(i);
    }

    public void setIcon(Drawable drawable) {
        h();
        this.h.a(drawable);
    }

    public void setLogo(int i) {
        h();
        this.h.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.a = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.j = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        h();
        this.h.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        h();
        this.h.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
