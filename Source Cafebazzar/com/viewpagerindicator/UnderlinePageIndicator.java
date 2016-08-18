package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ay;
import android.support.v4.view.cw;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public class UnderlinePageIndicator extends View implements c {
    static final /* synthetic */ boolean a = (!UnderlinePageIndicator.class.desiredAssertionStatus());
    private final boolean c;
    private final Paint d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private ViewPager i;
    private cw j;
    private int k;
    private int l;
    private float m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    private final Runnable r;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new j();
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

    public final void a(int i) {
        if (this.k == 0) {
            this.l = i;
            this.m = 0.0f;
            invalidate();
            this.r.run();
        }
        if (this.j != null) {
            this.j.a(i);
        }
    }

    public final void a(int i, float f, int i2) {
        this.l = i;
        this.m = f;
        if (this.e) {
            if (i2 > 0) {
                removeCallbacks(this.r);
                this.d.setAlpha(255);
            } else if (this.k != 1) {
                postDelayed(this.r, (long) this.f);
            }
        }
        invalidate();
        if (this.j != null) {
            this.j.a(i, f, i2);
        }
    }

    public final void b(int i) {
        this.k = i;
        if (this.j != null) {
            this.j.b(i);
        }
    }

    public int getFadeDelay() {
        return this.f;
    }

    public int getFadeLength() {
        return this.g;
    }

    public boolean getFades() {
        return this.e;
    }

    public int getSelectedColor() {
        return this.d.getColor();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = this.c ? 5 : this.i.getAdapter().getCount();
        if (count != 0) {
            if (this.l >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float width = ((float) ((getWidth() - paddingLeft) - getPaddingRight())) / (((float) count) * 1.0f);
            float f = ((float) paddingLeft) + ((((float) this.l) + this.m) * width);
            canvas.drawRect(f, (float) getPaddingTop(), f + width, (float) (getHeight() - getPaddingBottom()), this.d);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.l;
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
                this.p = ay.b(motionEvent, 0);
                this.o = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.q) {
                    int count = this.i.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.l <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.l < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.i.setCurrentItem(this.l + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.i.setCurrentItem(this.l - 1);
                        return true;
                    }
                }
                this.q = false;
                this.p = -1;
                if (!this.i.e()) {
                    return true;
                }
                this.i.d();
                return true;
            case 2:
                float c = ay.c(motionEvent, ay.a(motionEvent, this.p));
                float f3 = c - this.o;
                if (!this.q && Math.abs(f3) > ((float) this.n)) {
                    this.q = true;
                }
                if (!this.q) {
                    return true;
                }
                this.o = c;
                if (!this.i.e() && !this.i.c()) {
                    return true;
                }
                this.i.a(f3);
                return true;
            case 5:
                i = ay.b(motionEvent);
                this.o = ay.c(motionEvent, i);
                this.p = ay.b(motionEvent, i);
                return true;
            case 6:
                action = ay.b(motionEvent);
                if (ay.b(motionEvent, action) == this.p) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.p = ay.b(motionEvent, i);
                }
                this.o = ay.c(motionEvent, ay.a(motionEvent, this.p));
                return true;
            default:
                return true;
        }
    }

    public void setCurrentItem(int i) {
        if (this.i == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.i.setCurrentItem(i);
        this.l = i;
        invalidate();
    }

    public void setFadeDelay(int i) {
        this.f = i;
    }

    public void setFadeLength(int i) {
        this.g = i;
        this.h = 255 / (this.g / 30);
    }

    public void setFades(boolean z) {
        if (z != this.e) {
            this.e = z;
            if (z) {
                post(this.r);
                return;
            }
            removeCallbacks(this.r);
            this.d.setAlpha(255);
            invalidate();
        }
    }

    public void setOnPageChangeListener(cw cwVar) {
        this.j = cwVar;
    }

    public void setSelectedColor(int i) {
        this.d.setColor(i);
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
            post(new i(this));
        }
    }
}
