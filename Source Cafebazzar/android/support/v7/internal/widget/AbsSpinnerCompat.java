package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.bp;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerCompat extends aa {
    private DataSetObserver F;
    SpinnerAdapter a;
    int b;
    int c;
    int d = 0;
    int e = 0;
    int f = 0;
    int g = 0;
    final Rect h = new Rect();
    final c i = new c(this);

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new d();
        long a;
        int b;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readLong();
            this.b = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " position=" + this.b + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.a);
            parcel.writeInt(this.b);
        }
    }

    AbsSpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(true);
        setWillNotDraw(false);
    }

    final void a() {
        this.v = false;
        this.o = false;
        removeAllViewsInLayout();
        this.C = -1;
        this.D = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public void a(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.F);
            a();
        }
        this.a = spinnerAdapter;
        this.C = -1;
        this.D = Long.MIN_VALUE;
        if (this.a != null) {
            this.B = this.A;
            this.A = this.a.getCount();
            b();
            this.F = new ab(this);
            this.a.registerDataSetObserver(this.F);
            if (this.A > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.A == 0) {
                d();
            }
        } else {
            b();
            a();
            d();
        }
        requestLayout();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.a;
    }

    public int getCount() {
        return this.A;
    }

    public View getSelectedView() {
        return (this.A <= 0 || this.y < 0) ? null : getChildAt(this.y - this.j);
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int mode = MeasureSpec.getMode(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.h;
        if (paddingLeft <= this.d) {
            paddingLeft = this.d;
        }
        rect.left = paddingLeft;
        this.h.top = paddingTop > this.e ? paddingTop : this.e;
        this.h.right = paddingRight > this.f ? paddingRight : this.f;
        this.h.bottom = paddingBottom > this.g ? paddingBottom : this.g;
        if (this.v) {
            c();
        }
        paddingTop = getSelectedItemPosition();
        if (paddingTop >= 0 && this.a != null && paddingTop < this.a.getCount()) {
            View a = this.i.a(paddingTop);
            if (a == null) {
                a = this.a.getView(paddingTop, null, this);
            }
            if (a != null) {
                this.i.a(paddingTop, a);
                if (a.getLayoutParams() == null) {
                    this.E = true;
                    a.setLayoutParams(generateDefaultLayoutParams());
                    this.E = false;
                }
                measureChild(a, i, i2);
                paddingTop = (a.getMeasuredHeight() + this.h.top) + this.h.bottom;
                paddingLeft = (a.getMeasuredWidth() + this.h.left) + this.h.right;
                z = false;
                if (z) {
                    paddingTop = this.h.top + this.h.bottom;
                    if (mode == 0) {
                        paddingLeft = this.h.left + this.h.right;
                    }
                }
                setMeasuredDimension(bp.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), bp.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
                this.b = i2;
                this.c = i;
            }
        }
        z = true;
        paddingTop = 0;
        paddingLeft = 0;
        if (z) {
            paddingTop = this.h.top + this.h.bottom;
            if (mode == 0) {
                paddingLeft = this.h.left + this.h.right;
            }
        }
        setMeasuredDimension(bp.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), bp.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
        this.b = i2;
        this.c = i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a >= 0) {
            this.v = true;
            this.o = true;
            this.m = savedState.a;
            this.l = savedState.b;
            this.p = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        Object savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getSelectedItemId();
        if (savedState.a >= 0) {
            savedState.b = getSelectedItemPosition();
        } else {
            savedState.b = -1;
        }
        return savedState;
    }

    public void requestLayout() {
        if (!this.E) {
            super.requestLayout();
        }
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        a((SpinnerAdapter) adapter);
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }
}
