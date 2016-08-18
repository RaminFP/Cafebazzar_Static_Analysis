package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.bp;
import android.support.v4.view.v;
import android.support.v7.a.l;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

final class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
    int F;
    private ForwardingListener G;
    private bd H;
    private az I;
    private int J;
    private boolean K;
    private Rect L;
    private final bi M;

    class SavedState extends SavedState {
        public static final Creator CREATOR = new bc();
        boolean c;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readByte() != (byte) 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.c ? 1 : 0));
        }
    }

    SpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, null, i, -1);
    }

    private SpinnerCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.L = new Rect();
        bk a = bk.a(context, attributeSet, l.Spinner, i, 0);
        if (a.d(l.Spinner_android_background)) {
            setBackgroundDrawable(a.a(l.Spinner_android_background));
        }
        switch (a.a(l.Spinner_spinnerMode, 0)) {
            case 0:
                this.H = new ay();
                break;
            case 1:
                Object baVar = new ba(this, context, attributeSet, i);
                this.F = a.d(l.Spinner_android_dropDownWidth, -2);
                baVar.setBackgroundDrawable(a.a(l.Spinner_android_popupBackground));
                this.H = baVar;
                this.G = new aw(this, this, baVar);
                break;
        }
        this.J = a.a(l.Spinner_android_gravity, 17);
        this.H.a(a.a.getString(l.Spinner_prompt));
        this.K = a.a(l.Spinner_disableChildrenWhenDisabled, false);
        a.a.recycle();
        if (this.I != null) {
            this.H.setAdapter(this.I);
            this.I = null;
        }
        this.M = a.a();
    }

    private View a(int i, boolean z) {
        View a;
        if (!this.v) {
            a = this.i.a(i);
            if (a != null) {
                a(a, z);
                return a;
            }
        }
        a = this.a.getView(i, null, this);
        a(a, z);
        return a;
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.K) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.c, this.h.left + this.h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.b, this.h.top + this.h.bottom, layoutParams.height));
        int measuredHeight = this.h.top + ((((getMeasuredHeight() - this.h.bottom) - this.h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    final void a(ac acVar) {
        super.setOnItemClickListener(acVar);
    }

    public final void a(SpinnerAdapter spinnerAdapter) {
        super.a(spinnerAdapter);
        this.i.a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.H != null) {
            this.H.setAdapter(new az(spinnerAdapter));
        } else {
            this.I = new az(spinnerAdapter);
        }
    }

    public final int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.a != null && this.a.getCount() > 0) {
            view = a(0, false);
            this.i.a(0, view);
        }
        if (view == null) {
            return -1;
        }
        int baseline = view.getBaseline();
        return baseline >= 0 ? view.getTop() + baseline : -1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.H != null && this.H.isShowing()) {
            this.H.dismiss();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.r = true;
        int i5 = this.h.left;
        int right = ((getRight() - getLeft()) - this.h.left) - this.h.right;
        if (this.v) {
            c();
        }
        if (this.A == 0) {
            a();
        } else {
            if (this.w >= 0) {
                setSelectedPositionInt(this.w);
            }
            int childCount = getChildCount();
            c cVar = this.i;
            int i6 = this.j;
            for (int i7 = 0; i7 < childCount; i7++) {
                cVar.a(i6 + i7, getChildAt(i7));
            }
            removeAllViewsInLayout();
            this.j = this.y;
            if (this.a != null) {
                View a = a(this.y, true);
                childCount = a.getMeasuredWidth();
                switch (v.a(this.J, bp.h(this)) & 7) {
                    case 1:
                        i5 = (i5 + (right / 2)) - (childCount / 2);
                        break;
                    case 5:
                        i5 = (i5 + right) - childCount;
                        break;
                }
                a.offsetLeftAndRight(i5);
            }
            this.i.a();
            invalidate();
            d();
            this.v = false;
            this.o = false;
            setNextSelectedPositionInt(this.y);
        }
        this.r = false;
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        if (this.H != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            SpinnerAdapter spinnerAdapter = this.a;
            Drawable background = getBackground();
            if (spinnerAdapter != null) {
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
                int max = Math.max(0, getSelectedItemPosition());
                int min = Math.min(spinnerAdapter.getCount(), max + 15);
                int max2 = Math.max(0, max - (15 - (min - max)));
                int i4 = 0;
                View view = null;
                while (max2 < min) {
                    int itemViewType = spinnerAdapter.getItemViewType(max2);
                    if (itemViewType != i4) {
                        view = null;
                    } else {
                        itemViewType = i4;
                    }
                    view = spinnerAdapter.getView(max2, view, this);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    max2++;
                    i3 = Math.max(i3, view.getMeasuredWidth());
                    i4 = itemViewType;
                }
                if (background != null) {
                    background.getPadding(this.L);
                    i3 += this.L.left + this.L.right;
                }
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.c) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ax(this));
            }
        }
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.H != null && this.H.isShowing();
        savedState.c = z;
        return savedState;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.G == null || !this.G.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.H.isShowing()) {
                this.H.show();
            }
        }
        return performClick;
    }

    public final /* synthetic */ void setAdapter(Adapter adapter) {
        a((SpinnerAdapter) adapter);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.K) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public final void setOnItemClickListener(ac acVar) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }
}
