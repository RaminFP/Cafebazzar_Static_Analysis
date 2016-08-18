package android.support.v7.internal.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class aa extends ViewGroup {
    @ExportedProperty(category = "list")
    int A;
    int B;
    int C = -1;
    long D = Long.MIN_VALUE;
    boolean E = false;
    private View a;
    private boolean b;
    private boolean c;
    private af d;
    @ExportedProperty(category = "scrolling")
    int j = 0;
    int k;
    int l;
    long m = Long.MIN_VALUE;
    long n;
    boolean o = false;
    int p;
    int q;
    boolean r = false;
    ae s;
    ac t;
    ad u;
    boolean v;
    @ExportedProperty(category = "list")
    int w = -1;
    long x = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    int y = -1;
    long z = Long.MIN_VALUE;

    aa(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private long a(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    private void a() {
        if (this.s != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                getSelectedView();
                getAdapter().getItemId(selectedItemPosition);
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            if (this.a != null) {
                this.a.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.v) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        setVisibility(0);
    }

    public final boolean a(View view, int i, long j) {
        if (this.t == null) {
            return false;
        }
        playSoundEffect(0);
        if (view == null) {
            return true;
        }
        view.sendAccessibilityEvent(1);
        return true;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    final void b() {
        boolean z = false;
        Adapter adapter = getAdapter();
        boolean z2 = adapter == null || adapter.getCount() == 0;
        boolean z3 = !z2;
        z2 = z3 && this.c;
        super.setFocusableInTouchMode(z2);
        z2 = z3 && this.b;
        super.setFocusable(z2);
        if (this.a != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            a(z);
        }
    }

    final void c() {
        Object obj;
        int i = this.A;
        if (i > 0) {
            int i2;
            Object obj2;
            if (this.o) {
                int i3;
                this.o = false;
                int i4 = this.A;
                if (i4 != 0) {
                    long j = this.m;
                    i2 = this.l;
                    if (j != Long.MIN_VALUE) {
                        i2 = Math.min(i4 - 1, Math.max(0, i2));
                        long uptimeMillis = SystemClock.uptimeMillis();
                        Adapter adapter = getAdapter();
                        if (adapter != null) {
                            Object obj3 = null;
                            i3 = i2;
                            int i5 = i2;
                            while (SystemClock.uptimeMillis() <= 100 + uptimeMillis) {
                                if (adapter.getItemId(i3) == j) {
                                    break;
                                }
                                Object obj4 = i2 == i4 + -1 ? 1 : null;
                                Object obj5 = i5 == 0 ? 1 : null;
                                if (obj4 != null && obj5 != null) {
                                    break;
                                } else if (obj5 != null || (r4 != null && obj4 == null)) {
                                    i2++;
                                    obj3 = null;
                                    i3 = i2;
                                } else if (obj4 != null || (r4 == null && obj5 == null)) {
                                    i5--;
                                    obj3 = 1;
                                    i3 = i5;
                                }
                            }
                        }
                    }
                }
                i3 = -1;
                if (i3 >= 0) {
                    setNextSelectedPositionInt(i3);
                    obj2 = 1;
                    if (obj2 == null) {
                        i2 = getSelectedItemPosition();
                        if (i2 >= i) {
                            i2 = i - 1;
                        }
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        if (i2 >= 0) {
                            if (i2 >= 0) {
                                setNextSelectedPositionInt(i2);
                                d();
                                obj = 1;
                            }
                        } else if (i2 >= 0) {
                            setNextSelectedPositionInt(i2);
                            d();
                            obj = 1;
                        }
                    }
                    obj = obj2;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                i2 = getSelectedItemPosition();
                if (i2 >= i) {
                    i2 = i - 1;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= 0) {
                    if (i2 >= 0) {
                        setNextSelectedPositionInt(i2);
                        d();
                        obj = 1;
                    }
                } else if (i2 >= 0) {
                    setNextSelectedPositionInt(i2);
                    d();
                    obj = 1;
                }
            }
            obj = obj2;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.y = -1;
            this.z = Long.MIN_VALUE;
            this.w = -1;
            this.x = Long.MIN_VALUE;
            this.o = false;
            d();
        }
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.A > 0;
    }

    final void d() {
        if (this.y != this.C || this.z != this.D) {
            if (this.s != null) {
                if (this.r || this.E) {
                    if (this.d == null) {
                        this.d = new af();
                    }
                    post(this.d);
                } else {
                    a();
                }
            }
            if (!(this.y == -1 || !isShown() || isInTouchMode())) {
                sendAccessibilityEvent(4);
            }
            this.C = this.y;
            this.D = this.z;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public abstract Adapter getAdapter();

    @CapturedViewProperty
    public int getCount() {
        return this.A;
    }

    public View getEmptyView() {
        return this.a;
    }

    public int getFirstVisiblePosition() {
        return this.j;
    }

    public int getLastVisiblePosition() {
        return (this.j + getChildCount()) - 1;
    }

    public final ac getOnItemClickListener() {
        return this.t;
    }

    public final ad getOnItemLongClickListener() {
        return this.u;
    }

    public final ae getOnItemSelectedListener() {
        return this.s;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        return (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) ? null : adapter.getItem(selectedItemPosition);
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.x;
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.w;
    }

    public abstract View getSelectedView();

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.d);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.q = getHeight();
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view) {
        this.a = view;
        Adapter adapter = getAdapter();
        boolean z = adapter == null || adapter.isEmpty();
        a(z);
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.b = z;
        if (!z) {
            this.c = false;
        }
        if (!z || z3) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.c = z;
        if (z) {
            this.b = true;
        }
        if (!z || z3) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    void setNextSelectedPositionInt(int i) {
        this.w = i;
        this.x = a(i);
        if (this.o && this.p == 0 && i >= 0) {
            this.l = i;
            this.m = this.x;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(ac acVar) {
        this.t = acVar;
    }

    public void setOnItemLongClickListener(ad adVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.u = adVar;
    }

    public void setOnItemSelectedListener(ae aeVar) {
        this.s = aeVar;
    }

    void setSelectedPositionInt(int i) {
        this.y = i;
        this.z = a(i);
    }

    public abstract void setSelection(int i);
}
