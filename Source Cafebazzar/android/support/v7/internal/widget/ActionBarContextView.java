package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bp;
import android.support.v4.view.di;
import android.support.v4.view.dy;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.a.l;
import android.support.v7.e.a;
import android.support.v7.internal.view.i;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a implements dy {
    public View j;
    public boolean k;
    public i l;
    public int m;
    private CharSequence n;
    private CharSequence o;
    private View p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private boolean x;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.a(context, attributeSet, l.ActionMode, i, 0);
        setBackgroundDrawable(a.a(l.ActionMode_background));
        this.t = a.e(l.ActionMode_titleTextStyle, 0);
        this.u = a.e(l.ActionMode_subtitleTextStyle, 0);
        this.h = a.d(l.ActionMode_height, 0);
        this.v = a.a(l.ActionMode_backgroundSplit);
        this.w = a.e(l.ActionMode_closeItemLayout, android.support.v7.a.i.abc_action_mode_close_item_material);
        a.a.recycle();
    }

    private void e() {
        int i = 8;
        Object obj = 1;
        if (this.q == null) {
            LayoutInflater.from(getContext()).inflate(android.support.v7.a.i.abc_action_bar_title_item, this);
            this.q = (LinearLayout) getChildAt(getChildCount() - 1);
            this.r = (TextView) this.q.findViewById(g.action_bar_title);
            this.s = (TextView) this.q.findViewById(g.action_bar_subtitle);
            if (this.t != 0) {
                this.r.setTextAppearance(getContext(), this.t);
            }
            if (this.u != 0) {
                this.s.setTextAppearance(getContext(), this.u);
            }
        }
        this.r.setText(this.n);
        this.s.setText(this.o);
        Object obj2 = !TextUtils.isEmpty(this.n) ? 1 : null;
        if (TextUtils.isEmpty(this.o)) {
            obj = null;
        }
        this.s.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.q;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.q.getParent() == null) {
            addView(this.q);
        }
    }

    public final void a(a aVar) {
        if (this.j == null) {
            this.j = LayoutInflater.from(getContext()).inflate(this.w, this, false);
            addView(this.j);
        } else if (this.j.getParent() == null) {
            addView(this.j);
        }
        this.j.findViewById(g.action_mode_close_button).setOnClickListener(new g(this, aVar));
        android.support.v7.internal.view.menu.i iVar = (android.support.v7.internal.view.menu.i) aVar.b();
        if (this.d != null) {
            this.d.dismissPopupMenus();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.setReserveOverflow(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.f) {
            this.d.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.d.setItemLimit(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.h;
            iVar.a(this.d, this.b);
            this.c = (ActionMenuView) this.d.getMenuView(this);
            this.c.setBackgroundDrawable(this.v);
            this.e.addView(this.c, layoutParams);
        } else {
            iVar.a(this.d, this.b);
            this.c = (ActionMenuView) this.d.getMenuView(this);
            this.c.setBackgroundDrawable(null);
            addView(this.c, layoutParams);
        }
        this.x = true;
    }

    public final boolean a() {
        return this.d != null ? this.d.showOverflowMenu() : false;
    }

    public void b() {
        i iVar = this.l;
        if (iVar != null) {
            this.l = null;
            iVar.b();
        }
    }

    public final void c() {
        b();
        removeAllViews();
        if (this.e != null) {
            this.e.removeView(this.c);
        }
        this.p = null;
        this.c = null;
        this.x = false;
    }

    public i d() {
        di b = bp.r(this.j).b((float) ((-this.j.getWidth()) - ((MarginLayoutParams) this.j.getLayoutParams()).leftMargin));
        b.a(200);
        b.a((dy) this);
        b.a(new DecelerateInterpolator());
        i iVar = new i();
        iVar.a(b);
        if (this.c != null) {
            this.c.getChildCount();
        }
        return iVar;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.o;
    }

    public CharSequence getTitle() {
        return this.n;
    }

    public void onAnimationCancel(View view) {
    }

    public void onAnimationEnd(View view) {
        if (this.m == 2) {
            c();
        }
        this.m = 0;
    }

    public void onAnimationStart(View view) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.hideOverflowMenu();
            this.d.hideSubMenus();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.n);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bq.a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.j == null || this.j.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.j.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.a(paddingRight, i6, a);
            paddingRight = a.a(paddingRight + a.a(this.j, paddingRight, paddingTop, paddingTop2, a), i5, a);
            if (this.x) {
                this.m = 1;
                bp.a(this.j, (float) ((-this.j.getWidth()) - ((MarginLayoutParams) this.j.getLayoutParams()).leftMargin));
                di b = bp.r(this.j).b(0.0f);
                b.a(200);
                b.a((dy) this);
                b.a(new DecelerateInterpolator());
                i iVar = new i();
                iVar.a(b);
                if (this.c != null) {
                    i5 = this.c.getChildCount();
                    if (i5 > 0) {
                        for (i6 = i5 - 1; i6 >= 0; i6--) {
                            View childAt = this.c.getChildAt(i6);
                            bp.d(childAt, 0.0f);
                            di r = bp.r(childAt);
                            childAt = (View) r.a.get();
                            if (childAt != null) {
                                di.b.d(r, childAt, 1.0f);
                            }
                            r.a(300);
                            iVar.a(r);
                        }
                    }
                }
                this.l = iVar;
                this.l.a();
                this.x = false;
            }
        }
        if (!(this.q == null || this.p != null || this.q.getVisibility() == 8)) {
            paddingRight += a.a(this.q, paddingRight, paddingTop, paddingTop2, a);
        }
        if (this.p != null) {
            a.a(this.p, paddingRight, paddingTop, paddingTop2, a);
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a.a(this.c, i5, paddingTop, paddingTop2, !a);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.h > 0 ? this.h : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.j != null) {
                a = a.a(this.j, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.j.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = a.a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.q != null && this.p == null) {
                if (this.k) {
                    this.q.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.q.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.q.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.a(this.q, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.p != null) {
                LayoutParams layoutParams = this.p.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.p.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.h <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        if (this.p != null) {
            removeView(this.p);
        }
        this.p = view;
        if (this.q != null) {
            removeView(this.q);
            this.q = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        if (this.f != z) {
            if (this.d != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.d.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.d.setItemLimit(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.h;
                    this.c = (ActionMenuView) this.d.getMenuView(this);
                    this.c.setBackgroundDrawable(this.v);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    this.e.addView(this.c, layoutParams);
                } else {
                    this.c = (ActionMenuView) this.d.getMenuView(this);
                    this.c.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    addView(this.c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.o = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.n = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.k) {
            requestLayout();
        }
        this.k = z;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
