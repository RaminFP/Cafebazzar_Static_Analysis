package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.g;
import android.support.v7.a.l;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VERSION.SDK_INT >= 21 ? new f(this) : new e(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ActionBar);
        this.a = obtainStyledAttributes.getDrawable(l.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(l.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(l.ActionBar_height, -1);
        if (getId() == g.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(l.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.d ? this.c == null : this.a == null && this.b == null;
        setWillNotDraw(z);
    }

    private static boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.a != null) {
                this.a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            if (this.c != null) {
                this.c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(g.action_bar);
        this.i = findViewById(g.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.d) {
            int i6;
            if (this.a != null) {
                if (this.h.getVisibility() == 0) {
                    this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i == null || this.i.getVisibility() != 0) {
                    this.a.setBounds(0, 0, 0, 0);
                } else {
                    this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.e = z2;
            if (!z2 || this.b == null) {
                i5 = i6;
            } else {
                this.b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.c != null) {
            this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.g != null && this.g.getVisibility() != 8 && mode != 1073741824) {
                int b = !a(this.h) ? b(this.h) : !a(this.i) ? b(this.i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + b(this.g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPrimaryBackground(android.graphics.drawable.Drawable r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r2 = r7.a;
        if (r2 == 0) goto L_0x0011;
    L_0x0006:
        r2 = r7.a;
        r3 = 0;
        r2.setCallback(r3);
        r2 = r7.a;
        r7.unscheduleDrawable(r2);
    L_0x0011:
        r7.a = r8;
        if (r8 == 0) goto L_0x0039;
    L_0x0015:
        r8.setCallback(r7);
        r2 = r7.h;
        if (r2 == 0) goto L_0x0039;
    L_0x001c:
        r2 = r7.a;
        r3 = r7.h;
        r3 = r3.getLeft();
        r4 = r7.h;
        r4 = r4.getTop();
        r5 = r7.h;
        r5 = r5.getRight();
        r6 = r7.h;
        r6 = r6.getBottom();
        r2.setBounds(r3, r4, r5, r6);
    L_0x0039:
        r2 = r7.d;
        if (r2 == 0) goto L_0x0049;
    L_0x003d:
        r2 = r7.c;
        if (r2 != 0) goto L_0x0042;
    L_0x0041:
        r0 = r1;
    L_0x0042:
        r7.setWillNotDraw(r0);
        r7.invalidate();
        return;
    L_0x0049:
        r2 = r7.a;
        if (r2 != 0) goto L_0x0042;
    L_0x004d:
        r2 = r7.b;
        if (r2 == 0) goto L_0x0041;
    L_0x0051:
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActionBarContainer.setPrimaryBackground(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSplitBackground(android.graphics.drawable.Drawable r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = 1;
        r2 = r5.c;
        if (r2 == 0) goto L_0x0011;
    L_0x0006:
        r2 = r5.c;
        r3 = 0;
        r2.setCallback(r3);
        r2 = r5.c;
        r5.unscheduleDrawable(r2);
    L_0x0011:
        r5.c = r6;
        if (r6 == 0) goto L_0x002d;
    L_0x0015:
        r6.setCallback(r5);
        r2 = r5.d;
        if (r2 == 0) goto L_0x002d;
    L_0x001c:
        r2 = r5.c;
        if (r2 == 0) goto L_0x002d;
    L_0x0020:
        r2 = r5.c;
        r3 = r5.getMeasuredWidth();
        r4 = r5.getMeasuredHeight();
        r2.setBounds(r0, r0, r3, r4);
    L_0x002d:
        r2 = r5.d;
        if (r2 == 0) goto L_0x003d;
    L_0x0031:
        r2 = r5.c;
        if (r2 != 0) goto L_0x0036;
    L_0x0035:
        r0 = r1;
    L_0x0036:
        r5.setWillNotDraw(r0);
        r5.invalidate();
        return;
    L_0x003d:
        r2 = r5.a;
        if (r2 != 0) goto L_0x0036;
    L_0x0041:
        r2 = r5.b;
        if (r2 == 0) goto L_0x0035;
    L_0x0045:
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActionBarContainer.setSplitBackground(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackedBackground(android.graphics.drawable.Drawable r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r2 = r7.b;
        if (r2 == 0) goto L_0x0011;
    L_0x0006:
        r2 = r7.b;
        r3 = 0;
        r2.setCallback(r3);
        r2 = r7.b;
        r7.unscheduleDrawable(r2);
    L_0x0011:
        r7.b = r8;
        if (r8 == 0) goto L_0x003d;
    L_0x0015:
        r8.setCallback(r7);
        r2 = r7.e;
        if (r2 == 0) goto L_0x003d;
    L_0x001c:
        r2 = r7.b;
        if (r2 == 0) goto L_0x003d;
    L_0x0020:
        r2 = r7.b;
        r3 = r7.g;
        r3 = r3.getLeft();
        r4 = r7.g;
        r4 = r4.getTop();
        r5 = r7.g;
        r5 = r5.getRight();
        r6 = r7.g;
        r6 = r6.getBottom();
        r2.setBounds(r3, r4, r5, r6);
    L_0x003d:
        r2 = r7.d;
        if (r2 == 0) goto L_0x004d;
    L_0x0041:
        r2 = r7.c;
        if (r2 != 0) goto L_0x0046;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r7.setWillNotDraw(r0);
        r7.invalidate();
        return;
    L_0x004d:
        r2 = r7.a;
        if (r2 != 0) goto L_0x0046;
    L_0x0051:
        r2 = r7.b;
        if (r2 == 0) goto L_0x0045;
    L_0x0055:
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActionBarContainer.setStackedBackground(android.graphics.drawable.Drawable):void");
    }

    public void setTabContainer(ar arVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = arVar;
        if (arVar != null) {
            addView(arVar);
            ViewGroup.LayoutParams layoutParams = arVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            arVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.a != null) {
            this.a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.a && !this.d) || ((drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable)));
    }
}
