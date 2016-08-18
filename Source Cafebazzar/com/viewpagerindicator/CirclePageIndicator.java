package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ay;
import android.support.v4.view.bj;
import android.support.v4.view.cw;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;

public class CirclePageIndicator extends View implements c {
    static final /* synthetic */ boolean a = (!CirclePageIndicator.class.desiredAssertionStatus());
    private final boolean c;
    private float d;
    private float e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private ViewPager i;
    private cw j;
    private int k;
    private int l;
    private float m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private float s;
    private int t;
    private boolean u;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new a();
        int a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    private int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || (this.i == null && !this.c)) {
            return size;
        }
        int count = getCount();
        count = (int) (((((float) (count - 1)) * this.e) + (((float) i2) + (((float) (count << 1)) * this.d))) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(count, size) : count;
    }

    private int b(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i3 = (int) (((2.0f * this.d) + ((float) i2)) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
    }

    private int getCount() {
        if (this.c) {
            return 5;
        }
        if (this.i != null) {
            bj adapter = this.i.getAdapter();
            if (adapter != null) {
                return adapter.getCount();
            }
        }
        return 0;
    }

    public final void a(int i) {
        if (this.q || this.n == 0) {
            this.k = i;
            this.l = i;
            invalidate();
        }
        if (this.j != null) {
            this.j.a(i);
        }
    }

    public final void a(int i, float f, int i2) {
        this.k = i;
        this.m = f;
        invalidate();
        if (this.j != null) {
            this.j.a(i, f, i2);
        }
    }

    public final void b(int i) {
        this.n = i;
        if (this.j != null) {
            this.j.b(i);
        }
    }

    public int getFillColor() {
        return this.h.getColor();
    }

    public float getGapWidth() {
        return this.e;
    }

    public int getOrientation() {
        return this.o;
    }

    public int getPageColor() {
        return this.f.getColor();
    }

    public float getRadius() {
        return this.d;
    }

    public int getStrokeColor() {
        return this.g.getColor();
    }

    public float getStrokeWidth() {
        return this.g.getStrokeWidth();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = getCount();
        if (count != 0) {
            if (this.k >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            if (this.o == 0) {
                width = getWidth();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
                paddingTop = getPaddingTop();
            } else {
                width = getHeight();
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
                paddingTop = getPaddingLeft();
            }
            float f = (this.d * 2.0f) + this.e;
            float f2 = this.d + ((float) paddingTop);
            float f3 = (((float) paddingLeft) + this.d) + (this.e / 2.0f);
            float f4 = this.p ? ((((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((float) count) * f) / 2.0f)) + f3 : f3;
            float f5 = this.d;
            if (this.g.getStrokeWidth() > 0.0f) {
                f5 -= this.g.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < count; i++) {
                float f6 = (((float) i) * f) + f4;
                if (this.o == 0) {
                    f3 = f2;
                } else {
                    f3 = f6;
                    f6 = f2;
                }
                if (this.f.getAlpha() > 0) {
                    canvas.drawCircle(f6, f3, f5, this.f);
                }
                if (f5 != this.d) {
                    canvas.drawCircle(f6, f3, this.d, this.g);
                }
            }
            f5 = this.q ? ((float) this.l) * f : (((float) this.k) + this.m) * f;
            if (this.o == 0) {
                f4 += f5;
            } else {
                float f7 = f4 + f5;
                f4 = f2;
                f2 = f7;
            }
            canvas.drawCircle(f4, f2, this.d, this.h);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.o == 0) {
            setMeasuredDimension(a(i, getPaddingLeft() + getPaddingRight()), b(i2, getPaddingTop() + getPaddingBottom()));
        } else {
            setMeasuredDimension(b(i, getPaddingLeft() + getPaddingRight()), a(i2, getPaddingTop() + getPaddingBottom()));
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.k = savedState.a;
        this.l = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.q ? this.l : this.k;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.i == null || this.i.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.t = ay.b(motionEvent, 0);
                this.s = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.u) {
                    int count = this.i.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.k <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.k < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.i.setCurrentItem(this.k + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.i.setCurrentItem(this.k - 1);
                        return true;
                    }
                }
                this.u = false;
                this.t = -1;
                if (!this.i.e()) {
                    return true;
                }
                this.i.d();
                return true;
            case 2:
                float c = ay.c(motionEvent, ay.a(motionEvent, this.t));
                float f3 = c - this.s;
                if (!this.u && Math.abs(f3) > ((float) this.r)) {
                    this.u = true;
                }
                if (!this.u) {
                    return true;
                }
                this.s = c;
                if (!this.i.e() && !this.i.c()) {
                    return true;
                }
                this.i.a(f3);
                return true;
            case 5:
                i = ay.b(motionEvent);
                this.s = ay.c(motionEvent, i);
                this.t = ay.b(motionEvent, i);
                return true;
            case 6:
                action = ay.b(motionEvent);
                if (ay.b(motionEvent, action) == this.t) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.t = ay.b(motionEvent, i);
                }
                this.s = ay.c(motionEvent, ay.a(motionEvent, this.t));
                return true;
            default:
                return true;
        }
    }

    public void setCentered(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.i == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.i.setCurrentItem(i);
        this.k = i;
        invalidate();
    }

    public void setFillColor(int i) {
        this.h.setColor(i);
        invalidate();
    }

    public void setGapWidth(float f) {
        this.e = f;
        invalidate();
    }

    public void setOnPageChangeListener(cw cwVar) {
        this.j = cwVar;
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.o = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public void setPageColor(int i) {
        this.f.setColor(i);
        invalidate();
    }

    public void setRadius(float f) {
        this.d = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.q = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.g.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.g.setStrokeWidth(f);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.i != viewPager) {
            if (this.i != null) {
                this.i.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.i = viewPager;
            this.i.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
