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
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;

public class LinePageIndicator extends View implements c {
    static final /* synthetic */ boolean a = (!LinePageIndicator.class.desiredAssertionStatus());
    private final boolean c;
    private final Paint d;
    private final Paint e;
    private ViewPager f;
    private cw g;
    private int h;
    private boolean i;
    private float j;
    private float k;
    private int l;
    private float m;
    private int n;
    private boolean o;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new b();
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

    private int getCount() {
        if (this.c) {
            return 5;
        }
        if (this.f != null) {
            bj adapter = this.f.getAdapter();
            if (adapter != null) {
                return adapter.getCount();
            }
        }
        return 0;
    }

    public final void a(int i) {
        this.h = i;
        invalidate();
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.g != null) {
            this.g.a(i, f, i2);
        }
    }

    public final void b(int i) {
        if (this.g != null) {
            this.g.b(i);
        }
    }

    public float getGapWidth() {
        return this.k;
    }

    public float getLineWidth() {
        return this.j;
    }

    public int getSelectedColor() {
        return this.e.getColor();
    }

    public float getStrokeWidth() {
        return this.e.getStrokeWidth();
    }

    public int getUnselectedColor() {
        return this.d.getColor();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = getCount();
        if (count != 0) {
            if (this.h >= count) {
                setCurrentItem(count - 1);
                return;
            }
            float f = this.j + this.k;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            paddingTop += ((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f;
            float width = this.i ? paddingLeft + ((((((float) getWidth()) - paddingLeft) - ((float) getPaddingRight())) / 2.0f) - (((((float) count) * f) - this.k) / 2.0f)) : paddingLeft;
            int i = 0;
            while (i < count) {
                float f2 = width + (((float) i) * f);
                canvas.drawLine(f2, paddingTop, f2 + this.j, paddingTop, i == this.h ? this.e : this.d);
                i++;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || (this.f == null && !this.c)) {
            f = (float) size;
        } else {
            int count = getCount();
            f = (((float) (count - 1)) * this.k) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.j));
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        mode = (int) FloatMath.ceil(f);
        size = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 1073741824) {
            f = (float) size2;
        } else {
            f = (this.e.getStrokeWidth() + ((float) getPaddingTop())) + ((float) getPaddingBottom());
            if (size == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size2);
            }
        }
        setMeasuredDimension(mode, (int) FloatMath.ceil(f));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.h;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f == null || this.f.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.n = ay.b(motionEvent, 0);
                this.m = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.o) {
                    int count = this.f.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.h <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.h < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f.setCurrentItem(this.h + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f.setCurrentItem(this.h - 1);
                        return true;
                    }
                }
                this.o = false;
                this.n = -1;
                if (!this.f.e()) {
                    return true;
                }
                this.f.d();
                return true;
            case 2:
                float c = ay.c(motionEvent, ay.a(motionEvent, this.n));
                float f3 = c - this.m;
                if (!this.o && Math.abs(f3) > ((float) this.l)) {
                    this.o = true;
                }
                if (!this.o) {
                    return true;
                }
                this.m = c;
                if (!this.f.e() && !this.f.c()) {
                    return true;
                }
                this.f.a(f3);
                return true;
            case 5:
                i = ay.b(motionEvent);
                this.m = ay.c(motionEvent, i);
                this.n = ay.b(motionEvent, i);
                return true;
            case 6:
                action = ay.b(motionEvent);
                if (ay.b(motionEvent, action) == this.n) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.n = ay.b(motionEvent, i);
                }
                this.m = ay.c(motionEvent, ay.a(motionEvent, this.n));
                return true;
            default:
                return true;
        }
    }

    public void setCentered(boolean z) {
        this.i = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.f == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f.setCurrentItem(i);
        this.h = i;
        invalidate();
    }

    public void setGapWidth(float f) {
        this.k = f;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.j = f;
        invalidate();
    }

    public void setOnPageChangeListener(cw cwVar) {
        this.g = cwVar;
    }

    public void setSelectedColor(int i) {
        this.e.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.e.setStrokeWidth(f);
        this.d.setStrokeWidth(f);
        invalidate();
    }

    public void setUnselectedColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f != viewPager) {
            if (this.f != null) {
                this.f.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f = viewPager;
            this.f.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
