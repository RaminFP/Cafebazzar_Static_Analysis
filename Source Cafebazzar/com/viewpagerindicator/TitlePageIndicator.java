package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ay;
import android.support.v4.view.cw;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import java.util.ArrayList;

public class TitlePageIndicator extends View implements c {
    static final /* synthetic */ boolean a = (!TitlePageIndicator.class.desiredAssertionStatus());
    private float A;
    private int B;
    private boolean C;
    private g D;
    private final boolean c;
    private ViewPager d;
    private cw e;
    private int f;
    private float g;
    private int h;
    private final Paint i;
    private boolean j;
    private int k;
    private int l;
    private Path m;
    private final Rect n;
    private final Paint o;
    private e p;
    private f q;
    private final Paint r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private int z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new h();
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

    private void a(Rect rect, float f, int i) {
        rect.right = (int) (((float) i) - this.x);
        rect.left = (int) (((float) rect.right) - f);
    }

    private void b(Rect rect, float f, int i) {
        rect.left = (int) (((float) i) + this.x);
        rect.right = (int) (this.x + f);
    }

    private CharSequence c(int i) {
        if (this.c) {
            return String.format("Page %d", new Object[]{Integer.valueOf(i + 1)});
        }
        CharSequence pageTitle = this.d.getAdapter().getPageTitle(i);
        return pageTitle == null ? b : pageTitle;
    }

    public final void a(int i) {
        if (this.h == 0) {
            this.f = i;
            invalidate();
        }
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public final void a(int i, float f, int i2) {
        this.f = i;
        this.g = f;
        invalidate();
        if (this.e != null) {
            this.e.a(i, f, i2);
        }
    }

    public final void b(int i) {
        this.h = i;
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public float getClipPadding() {
        return this.x;
    }

    public int getFooterColor() {
        return this.o.getColor();
    }

    public float getFooterIndicatorHeight() {
        return this.s;
    }

    public float getFooterIndicatorPadding() {
        return this.u;
    }

    public e getFooterIndicatorStyle() {
        return this.p;
    }

    public float getFooterLineHeight() {
        return this.y;
    }

    public f getLinePosition() {
        return this.q;
    }

    public int getSelectedColor() {
        return this.l;
    }

    public int getTextColor() {
        return this.k;
    }

    public float getTextSize() {
        return this.i.getTextSize();
    }

    public float getTitlePadding() {
        return this.v;
    }

    public float getTopPadding() {
        return this.w;
    }

    public Typeface getTypeface() {
        return this.i.getTypeface();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = this.c ? 5 : this.d.getAdapter().getCount();
        if (count != 0) {
            int i;
            if (this.f == -1 && this.d != null) {
                this.f = this.d.getCurrentItem();
            }
            Paint paint = this.i;
            ArrayList arrayList = new ArrayList();
            int count2 = this.c ? 5 : this.d.getAdapter().getCount();
            int width = getWidth();
            int i2 = width / 2;
            for (int i3 = 0; i3 < count2; i3++) {
                CharSequence c = c(i3);
                Rect rect = new Rect();
                rect.right = (int) paint.measureText(c, 0, c.length());
                rect.bottom = (int) (paint.descent() - paint.ascent());
                i = rect.right - rect.left;
                int i4 = rect.bottom;
                int i5 = rect.top;
                rect.left = (int) ((((float) i2) - (((float) i) / 2.0f)) + ((((float) (i3 - this.f)) - this.g) * ((float) width)));
                rect.right = i + rect.left;
                rect.top = 0;
                rect.bottom = i4 - i5;
                arrayList.add(rect);
            }
            int size = arrayList.size();
            if (this.f >= size) {
                setCurrentItem(size - 1);
                return;
            }
            float f;
            int i6;
            int i7;
            Rect rect2;
            float f2;
            float width2 = ((float) getWidth()) / 2.0f;
            int left = getLeft();
            float f3 = ((float) left) + this.x;
            int width3 = getWidth();
            int i8 = left + width3;
            float f4 = ((float) i8) - this.x;
            if (((double) this.g) <= 0.5d) {
                count2 = this.f;
                f = this.g;
                i6 = count2;
            } else {
                f = 1.0f - this.g;
                i6 = this.f + 1;
            }
            Object obj = f <= 0.25f ? 1 : null;
            Object obj2 = f <= 0.05f ? 1 : null;
            float f5 = (0.25f - f) / 0.25f;
            Rect rect3 = (Rect) arrayList.get(this.f);
            f = (float) (rect3.right - rect3.left);
            if (((float) rect3.left) < f3) {
                b(rect3, f, left);
            }
            if (((float) rect3.right) > f4) {
                a(rect3, f, i8);
            }
            if (this.f > 0) {
                for (i7 = this.f - 1; i7 >= 0; i7--) {
                    rect3 = (Rect) arrayList.get(i7);
                    if (((float) rect3.left) < f3) {
                        i = rect3.right - rect3.left;
                        b(rect3, (float) i, left);
                        rect2 = (Rect) arrayList.get(i7 + 1);
                        if (((float) rect3.right) + this.v > ((float) rect2.left)) {
                            rect3.left = (int) (((float) (rect2.left - i)) - this.v);
                            rect3.right = rect3.left + i;
                        }
                    }
                }
            }
            if (this.f < count - 1) {
                for (i7 = this.f + 1; i7 < count; i7++) {
                    rect3 = (Rect) arrayList.get(i7);
                    if (((float) rect3.right) > f4) {
                        width = rect3.right - rect3.left;
                        a(rect3, (float) width, i8);
                        rect2 = (Rect) arrayList.get(i7 - 1);
                        if (((float) rect3.left) - this.v < ((float) rect2.right)) {
                            rect3.left = (int) (((float) rect2.right) + this.v);
                            rect3.right = rect3.left + width;
                        }
                    }
                }
            }
            int i9 = this.k >>> 24;
            int i10 = 0;
            while (i10 < count) {
                Rect rect4 = (Rect) arrayList.get(i10);
                if ((rect4.left > left && rect4.left < i8) || (rect4.right > left && rect4.right < i8)) {
                    Object obj3 = i10 == i6 ? 1 : null;
                    CharSequence c2 = c(i10);
                    paint = this.i;
                    boolean z = (obj3 == null || obj2 == null || !this.j) ? false : true;
                    paint.setFakeBoldText(z);
                    this.i.setColor(this.k);
                    if (!(obj3 == null || obj == null)) {
                        this.i.setAlpha(i9 - ((int) (((float) i9) * f5)));
                    }
                    if (i10 < size - 1) {
                        rect3 = (Rect) arrayList.get(i10 + 1);
                        if (((float) rect4.right) + this.v > ((float) rect3.left)) {
                            i7 = rect4.right - rect4.left;
                            rect4.left = (int) (((float) (rect3.left - i7)) - this.v);
                            rect4.right = rect4.left + i7;
                        }
                    }
                    canvas.drawText(c2, 0, c2.length(), (float) rect4.left, this.w + ((float) rect4.bottom), this.i);
                    if (!(obj3 == null || obj == null)) {
                        this.i.setColor(this.l);
                        this.i.setAlpha((int) (((float) (this.l >>> 24)) * f5));
                        canvas.drawText(c2, 0, c2.length(), (float) rect4.left, this.w + ((float) rect4.bottom), this.i);
                    }
                }
                i10++;
            }
            if (this.q == f.Top) {
                count2 = 0;
                f = 0.0f;
                f2 = 0.0f;
            } else {
                count2 = getHeight();
                f = this.y;
                f2 = this.s;
            }
            this.m.reset();
            this.m.moveTo(0.0f, ((float) count2) - (f / 2.0f));
            this.m.lineTo((float) width3, ((float) count2) - (f / 2.0f));
            this.m.close();
            canvas.drawPath(this.m, this.o);
            f = ((float) count2) - f;
            switch (d.a[this.p.ordinal()]) {
                case 1:
                    this.m.reset();
                    this.m.moveTo(width2, f - f2);
                    this.m.lineTo(width2 + f2, f);
                    this.m.lineTo(width2 - f2, f);
                    this.m.close();
                    canvas.drawPath(this.m, this.r);
                    return;
                case 2:
                    if (obj != null && i6 < size) {
                        rect3 = (Rect) arrayList.get(i6);
                        f3 = ((float) rect3.right) + this.t;
                        float f6 = ((float) rect3.left) - this.t;
                        f2 = f - f2;
                        this.m.reset();
                        this.m.moveTo(f6, f);
                        this.m.lineTo(f3, f);
                        this.m.lineTo(f3, f2);
                        this.m.lineTo(f6, f2);
                        this.m.close();
                        this.r.setAlpha((int) (255.0f * f5));
                        canvas.drawPath(this.m, this.r);
                        this.r.setAlpha(255);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        float size;
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            size = (float) MeasureSpec.getSize(i2);
        } else {
            this.n.setEmpty();
            this.n.bottom = (int) (this.i.descent() - this.i.ascent());
            size = ((((float) (this.n.bottom - this.n.top)) + this.y) + this.u) + this.w;
            if (this.p != e.None) {
                size += this.s;
            }
        }
        setMeasuredDimension(size2, (int) size);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.d == null || this.d.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.B = ay.b(motionEvent, 0);
                this.A = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.C) {
                    int count = this.d.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    float x = motionEvent.getX();
                    if (x < f - f2) {
                        if (this.f > 0) {
                            if (action == 3) {
                                return true;
                            }
                            this.d.setCurrentItem(this.f - 1);
                            return true;
                        }
                    } else if (x > f2 + f && this.f < count - 1) {
                        if (action == 3) {
                            return true;
                        }
                        this.d.setCurrentItem(this.f + 1);
                        return true;
                    }
                }
                this.C = false;
                this.B = -1;
                if (!this.d.e()) {
                    return true;
                }
                this.d.d();
                return true;
            case 2:
                float c = ay.c(motionEvent, ay.a(motionEvent, this.B));
                float f3 = c - this.A;
                if (!this.C && Math.abs(f3) > ((float) this.z)) {
                    this.C = true;
                }
                if (!this.C) {
                    return true;
                }
                this.A = c;
                if (!this.d.e() && !this.d.c()) {
                    return true;
                }
                this.d.a(f3);
                return true;
            case 5:
                i = ay.b(motionEvent);
                this.A = ay.c(motionEvent, i);
                this.B = ay.b(motionEvent, i);
                return true;
            case 6:
                action = ay.b(motionEvent);
                if (ay.b(motionEvent, action) == this.B) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.B = ay.b(motionEvent, i);
                }
                this.A = ay.c(motionEvent, ay.a(motionEvent, this.B));
                return true;
            default:
                return true;
        }
    }

    public void setClipPadding(float f) {
        this.x = f;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.d == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.d.setCurrentItem(i);
        this.f = i;
        invalidate();
    }

    public void setFooterColor(int i) {
        this.o.setColor(i);
        this.r.setColor(i);
        invalidate();
    }

    public void setFooterIndicatorHeight(float f) {
        this.s = f;
        invalidate();
    }

    public void setFooterIndicatorPadding(float f) {
        this.u = f;
        invalidate();
    }

    public void setFooterIndicatorStyle(e eVar) {
        this.p = eVar;
        invalidate();
    }

    public void setFooterLineHeight(float f) {
        this.y = f;
        this.o.setStrokeWidth(this.y);
        invalidate();
    }

    public void setLinePosition(f fVar) {
        this.q = fVar;
        invalidate();
    }

    public void setOnCenterItemClickListener(g gVar) {
        this.D = gVar;
    }

    public void setOnPageChangeListener(cw cwVar) {
        this.e = cwVar;
    }

    public void setSelectedBold(boolean z) {
        this.j = z;
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.l = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.i.setColor(i);
        this.k = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.i.setTextSize(f);
        invalidate();
    }

    public void setTitlePadding(float f) {
        this.v = f;
        invalidate();
    }

    public void setTopPadding(float f) {
        this.w = f;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.i.setTypeface(typeface);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.d != viewPager) {
            if (this.d != null) {
                this.d.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.d = viewPager;
            this.d.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
