package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.d;
import android.support.v4.widget.r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final da aj = new da();
    private static final int[] b = new int[]{16842931};
    private static final Comparator d = new cn();
    private static final Interpolator e = new co();
    private boolean A;
    private int B = 1;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L = -1;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private long S;
    private r T;
    private r U;
    private boolean V = true;
    private boolean W = false;
    public List a;
    private boolean aa;
    private int ab;
    private cw ac;
    private cw ad;
    private cv ae;
    private cx af;
    private Method ag;
    private int ah;
    private ArrayList ai;
    private final Runnable ak = new cp(this);
    private int al = 0;
    private int c;
    private final ArrayList f = new ArrayList();
    private final cs g = new cs();
    private final Rect h = new Rect();
    private bj i;
    private int j;
    private int k = -1;
    private Parcelable l = null;
    private ClassLoader m = null;
    private Scroller n;
    private boolean o;
    private cy p;
    private int q;
    private Drawable r;
    private int s;
    private int t;
    private float u = -3.4028235E38f;
    private float v = Float.MAX_VALUE;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = d.a(new cz());
        int a;
        Parcelable b;
        ClassLoader c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }
    }

    public ViewPager(Context context) {
        super(context);
        g();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.P || Math.abs(i2) <= this.N) {
            i = (int) ((i >= this.j ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f.size() <= 0) {
            return i;
        }
        return Math.max(((cs) this.f.get(0)).b, Math.min(i, ((cs) this.f.get(this.f.size() - 1)).b));
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private cs a(int i, int i2) {
        cs csVar = new cs();
        csVar.b = i;
        csVar.a = this.i.instantiateItem((ViewGroup) this, i);
        csVar.d = this.i.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f.size()) {
            this.f.add(csVar);
        } else {
            this.f.add(i2, csVar);
        }
        return csVar;
    }

    private cs a(View view) {
        for (int i = 0; i < this.f.size(); i++) {
            cs csVar = (cs) this.f.get(i);
            if (this.i.isViewFromObject(view, csVar.a)) {
                return csVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r15) {
        /*
        r14 = this;
        r0 = r14.j;
        if (r0 == r15) goto L_0x028c;
    L_0x0004:
        r0 = r14.j;
        r0 = r14.b(r0);
        r14.j = r15;
        r1 = r0;
    L_0x000d:
        r0 = r14.i;
        if (r0 != 0) goto L_0x0015;
    L_0x0011:
        r14.h();
    L_0x0014:
        return;
    L_0x0015:
        r0 = r14.A;
        if (r0 == 0) goto L_0x001d;
    L_0x0019:
        r14.h();
        goto L_0x0014;
    L_0x001d:
        r0 = r14.getWindowToken();
        if (r0 == 0) goto L_0x0014;
    L_0x0023:
        r0 = r14.i;
        r0.startUpdate(r14);
        r0 = r14.B;
        r2 = 0;
        r3 = r14.j;
        r3 = r3 - r0;
        r8 = java.lang.Math.max(r2, r3);
        r2 = r14.i;
        r9 = r2.getCount();
        r2 = r9 + -1;
        r3 = r14.j;
        r0 = r0 + r3;
        r10 = java.lang.Math.min(r2, r0);
        r0 = r14.c;
        if (r9 == r0) goto L_0x00a4;
    L_0x0045:
        r0 = r14.getResources();	 Catch:{ NotFoundException -> 0x009a }
        r1 = r14.getId();	 Catch:{ NotFoundException -> 0x009a }
        r0 = r0.getResourceName(r1);	 Catch:{ NotFoundException -> 0x009a }
    L_0x0051:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r2.<init>(r3);
        r3 = r14.c;
        r2 = r2.append(r3);
        r3 = ", found: ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r3 = " Pager id: ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = " Pager class: ";
        r0 = r0.append(r2);
        r2 = r14.getClass();
        r0 = r0.append(r2);
        r2 = " Problematic adapter: ";
        r0 = r0.append(r2);
        r2 = r14.i;
        r2 = r2.getClass();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x009a:
        r0 = move-exception;
        r0 = r14.getId();
        r0 = java.lang.Integer.toHexString(r0);
        goto L_0x0051;
    L_0x00a4:
        r0 = 0;
        r2 = r0;
    L_0x00a6:
        r0 = r14.f;
        r0 = r0.size();
        if (r2 >= r0) goto L_0x0289;
    L_0x00ae:
        r0 = r14.f;
        r0 = r0.get(r2);
        r0 = (android.support.v4.view.cs) r0;
        r3 = r0.b;
        r4 = r14.j;
        if (r3 < r4) goto L_0x0119;
    L_0x00bc:
        r3 = r0.b;
        r4 = r14.j;
        if (r3 != r4) goto L_0x0289;
    L_0x00c2:
        if (r0 != 0) goto L_0x0286;
    L_0x00c4:
        if (r9 <= 0) goto L_0x0286;
    L_0x00c6:
        r0 = r14.j;
        r0 = r14.a(r0, r2);
        r7 = r0;
    L_0x00cd:
        if (r7 == 0) goto L_0x0205;
    L_0x00cf:
        r5 = r2 + -1;
        if (r5 < 0) goto L_0x011d;
    L_0x00d3:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
    L_0x00db:
        r11 = r14.getClientWidth();
        if (r11 > 0) goto L_0x011f;
    L_0x00e1:
        r3 = 0;
    L_0x00e2:
        r4 = r14.j;
        r6 = 0;
        r4 = r4 + -1;
        r13 = r4;
        r4 = r6;
        r6 = r13;
    L_0x00ea:
        if (r6 < 0) goto L_0x015f;
    L_0x00ec:
        r12 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r12 < 0) goto L_0x012f;
    L_0x00f0:
        if (r6 >= r8) goto L_0x012f;
    L_0x00f2:
        if (r0 == 0) goto L_0x015f;
    L_0x00f4:
        r12 = r0.b;
        if (r6 != r12) goto L_0x0116;
    L_0x00f8:
        r12 = r0.c;
        if (r12 != 0) goto L_0x0116;
    L_0x00fc:
        r12 = r14.f;
        r12.remove(r5);
        r12 = r14.i;
        r0 = r0.a;
        r12.destroyItem(r14, r6, r0);
        r5 = r5 + -1;
        r2 = r2 + -1;
        if (r5 < 0) goto L_0x012d;
    L_0x010e:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
    L_0x0116:
        r6 = r6 + -1;
        goto L_0x00ea;
    L_0x0119:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00a6;
    L_0x011d:
        r0 = 0;
        goto L_0x00db;
    L_0x011f:
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r7.d;
        r3 = r3 - r4;
        r4 = r14.getPaddingLeft();
        r4 = (float) r4;
        r6 = (float) r11;
        r4 = r4 / r6;
        r3 = r3 + r4;
        goto L_0x00e2;
    L_0x012d:
        r0 = 0;
        goto L_0x0116;
    L_0x012f:
        if (r0 == 0) goto L_0x0147;
    L_0x0131:
        r12 = r0.b;
        if (r6 != r12) goto L_0x0147;
    L_0x0135:
        r0 = r0.d;
        r4 = r4 + r0;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0145;
    L_0x013c:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
        goto L_0x0116;
    L_0x0145:
        r0 = 0;
        goto L_0x0116;
    L_0x0147:
        r0 = r5 + 1;
        r0 = r14.a(r6, r0);
        r0 = r0.d;
        r4 = r4 + r0;
        r2 = r2 + 1;
        if (r5 < 0) goto L_0x015d;
    L_0x0154:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
        goto L_0x0116;
    L_0x015d:
        r0 = 0;
        goto L_0x0116;
    L_0x015f:
        r5 = r7.d;
        r6 = r2 + 1;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0202;
    L_0x0169:
        r0 = r14.f;
        r0 = r0.size();
        if (r6 >= r0) goto L_0x01b8;
    L_0x0171:
        r0 = r14.f;
        r0 = r0.get(r6);
        r0 = (android.support.v4.view.cs) r0;
        r4 = r0;
    L_0x017a:
        if (r11 > 0) goto L_0x01ba;
    L_0x017c:
        r0 = 0;
        r3 = r0;
    L_0x017e:
        r0 = r14.j;
        r0 = r0 + 1;
        r13 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r0;
        r0 = r13;
    L_0x0187:
        if (r6 >= r9) goto L_0x0202;
    L_0x0189:
        r8 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r8 < 0) goto L_0x01c8;
    L_0x018d:
        if (r6 <= r10) goto L_0x01c8;
    L_0x018f:
        if (r0 == 0) goto L_0x0202;
    L_0x0191:
        r8 = r0.b;
        if (r6 != r8) goto L_0x01b5;
    L_0x0195:
        r8 = r0.c;
        if (r8 != 0) goto L_0x01b5;
    L_0x0199:
        r8 = r14.f;
        r8.remove(r5);
        r8 = r14.i;
        r0 = r0.a;
        r8.destroyItem(r14, r6, r0);
        r0 = r14.f;
        r0 = r0.size();
        if (r5 >= r0) goto L_0x01c6;
    L_0x01ad:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
    L_0x01b5:
        r6 = r6 + 1;
        goto L_0x0187;
    L_0x01b8:
        r4 = 0;
        goto L_0x017a;
    L_0x01ba:
        r0 = r14.getPaddingRight();
        r0 = (float) r0;
        r3 = (float) r11;
        r0 = r0 / r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r0 + r3;
        r3 = r0;
        goto L_0x017e;
    L_0x01c6:
        r0 = 0;
        goto L_0x01b5;
    L_0x01c8:
        if (r0 == 0) goto L_0x01e6;
    L_0x01ca:
        r8 = r0.b;
        if (r6 != r8) goto L_0x01e6;
    L_0x01ce:
        r8 = r0.d;
        r5 = r5 + 1;
        r0 = r14.f;
        r0 = r0.size();
        if (r5 >= r0) goto L_0x01e4;
    L_0x01da:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
    L_0x01e2:
        r4 = r4 + r8;
        goto L_0x01b5;
    L_0x01e4:
        r0 = 0;
        goto L_0x01e2;
    L_0x01e6:
        r0 = r14.a(r6, r5);
        r5 = r5 + 1;
        r8 = r0.d;
        r0 = r14.f;
        r0 = r0.size();
        if (r5 >= r0) goto L_0x0200;
    L_0x01f6:
        r0 = r14.f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.cs) r0;
    L_0x01fe:
        r4 = r4 + r8;
        goto L_0x01b5;
    L_0x0200:
        r0 = 0;
        goto L_0x01fe;
    L_0x0202:
        r14.a(r7, r2, r1);
    L_0x0205:
        r1 = r14.i;
        r2 = r14.j;
        if (r7 == 0) goto L_0x0246;
    L_0x020b:
        r0 = r7.a;
    L_0x020d:
        r1.setPrimaryItem(r14, r2, r0);
        r0 = r14.i;
        r0.finishUpdate(r14);
        r2 = r14.getChildCount();
        r0 = 0;
        r1 = r0;
    L_0x021b:
        if (r1 >= r2) goto L_0x0248;
    L_0x021d:
        r3 = r14.getChildAt(r1);
        r0 = r3.getLayoutParams();
        r0 = (android.support.v4.view.ct) r0;
        r0.f = r1;
        r4 = r0.a;
        if (r4 != 0) goto L_0x0242;
    L_0x022d:
        r4 = r0.c;
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 != 0) goto L_0x0242;
    L_0x0234:
        r3 = r14.a(r3);
        if (r3 == 0) goto L_0x0242;
    L_0x023a:
        r4 = r3.d;
        r0.c = r4;
        r3 = r3.b;
        r0.e = r3;
    L_0x0242:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x021b;
    L_0x0246:
        r0 = 0;
        goto L_0x020d;
    L_0x0248:
        r14.h();
        r0 = r14.hasFocus();
        if (r0 == 0) goto L_0x0014;
    L_0x0251:
        r0 = r14.findFocus();
        if (r0 == 0) goto L_0x0284;
    L_0x0257:
        r0 = r14.b(r0);
    L_0x025b:
        if (r0 == 0) goto L_0x0263;
    L_0x025d:
        r0 = r0.b;
        r1 = r14.j;
        if (r0 == r1) goto L_0x0014;
    L_0x0263:
        r0 = 0;
    L_0x0264:
        r1 = r14.getChildCount();
        if (r0 >= r1) goto L_0x0014;
    L_0x026a:
        r1 = r14.getChildAt(r0);
        r2 = r14.a(r1);
        if (r2 == 0) goto L_0x0281;
    L_0x0274:
        r2 = r2.b;
        r3 = r14.j;
        if (r2 != r3) goto L_0x0281;
    L_0x027a:
        r2 = 2;
        r1 = r1.requestFocus(r2);
        if (r1 != 0) goto L_0x0014;
    L_0x0281:
        r0 = r0 + 1;
        goto L_0x0264;
    L_0x0284:
        r0 = 0;
        goto L_0x025b;
    L_0x0286:
        r7 = r0;
        goto L_0x00cd;
    L_0x0289:
        r0 = 0;
        goto L_0x00c2;
    L_0x028c:
        r0 = 0;
        r1 = r0;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        if (this.ab > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ct ctVar = (ct) childAt.getLayoutParams();
                if (ctVar.a) {
                    int max;
                    switch (ctVar.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            int i4 = paddingLeft;
                            paddingLeft = childAt.getWidth() + paddingLeft;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i, f, i2);
        }
        if (this.a != null) {
            paddingRight = this.a.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                cw cwVar = (cw) this.a.get(paddingLeft);
                if (cwVar != null) {
                    cwVar.a(i, f, i2);
                }
            }
        }
        if (this.ad != null) {
            this.ad.a(i, f, i2);
        }
        if (this.af != null) {
            getScrollX();
            paddingRight = getChildCount();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((ct) childAt2.getLayoutParams()).a) {
                    childAt2.getLeft();
                    getClientWidth();
                }
            }
        }
        this.aa = true;
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        cs b = b(i);
        int max = b != null ? (int) (Math.max(this.u, Math.min(b.e, this.v)) * ((float) getClientWidth())) : 0;
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.n == null || this.n.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.o ? this.n.getCurrX() : this.n.getStartX();
                    this.n.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                max -= i3;
                int i4 = 0 - scrollY;
                if (max == 0 && i4 == 0) {
                    a(false);
                    b();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    currX = getClientWidth();
                    int i5 = currX / 2;
                    float f = (float) i5;
                    float f2 = (float) i5;
                    float sin = (float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(max))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d)));
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(((f2 * sin) + f) / ((float) abs))) * 4 : (int) (((((float) Math.abs(max)) / ((((float) currX) * this.i.getPageWidth(this.j)) + ((float) this.q))) + 1.0f) * 100.0f), 600);
                    this.o = false;
                    this.n.startScroll(i3, scrollY, max, i4, i5);
                    bp.d(this);
                }
            }
            if (z2) {
                d(i);
                return;
            }
            return;
        }
        if (z2) {
            d(i);
        }
        a(false);
        scrollTo(max, 0);
        c(max);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.i == null || this.i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.j != i || this.f.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.i.getCount()) {
                i = this.i.getCount() - 1;
            }
            int i3 = this.B;
            if (i > this.j + i3 || i < this.j - i3) {
                for (int i4 = 0; i4 < this.f.size(); i4++) {
                    ((cs) this.f.get(i4)).c = true;
                }
            }
            if (this.j != i) {
                z3 = true;
            }
            if (this.V) {
                this.j = i;
                if (z3) {
                    d(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(cs csVar, int i, cs csVar2) {
        int i2;
        int i3;
        int i4;
        float f;
        int count = this.i.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        if (csVar2 != null) {
            i2 = csVar2.b;
            float f3;
            int i5;
            cs csVar3;
            float f4;
            if (i2 < csVar.b) {
                i3 = i2 + 1;
                f3 = (csVar2.e + csVar2.d) + f2;
                i4 = 0;
                while (i3 <= csVar.b && i4 < this.f.size()) {
                    i5 = i4;
                    csVar3 = (cs) this.f.get(i4);
                    clientWidth = i5;
                    while (i3 > csVar3.b && clientWidth < this.f.size() - 1) {
                        i4 = clientWidth + 1;
                        i5 = i4;
                        csVar3 = (cs) this.f.get(i4);
                        clientWidth = i5;
                    }
                    f4 = f3;
                    i2 = i3;
                    while (i2 < csVar3.b) {
                        f4 = (this.i.getPageWidth(i2) + f2) + f4;
                        i2++;
                    }
                    csVar3.e = f4;
                    f = f4 + (csVar3.d + f2);
                    i4 = i2 + 1;
                    f3 = f;
                    i3 = i4;
                    i4 = clientWidth;
                }
            } else if (i2 > csVar.b) {
                clientWidth = this.f.size();
                i4 = i2 - 1;
                f3 = csVar2.e;
                i3 = i4;
                i4 = clientWidth - 1;
                while (i3 >= csVar.b && i4 >= 0) {
                    i5 = i4;
                    csVar3 = (cs) this.f.get(i4);
                    clientWidth = i5;
                    while (i3 < csVar3.b && clientWidth > 0) {
                        i4 = clientWidth - 1;
                        i5 = i4;
                        csVar3 = (cs) this.f.get(i4);
                        clientWidth = i5;
                    }
                    f4 = f3;
                    i2 = i3;
                    while (i2 > csVar3.b) {
                        f4 -= this.i.getPageWidth(i2) + f2;
                        i2--;
                    }
                    f = f4 - (csVar3.d + f2);
                    csVar3.e = f;
                    i4 = i2 - 1;
                    f3 = f;
                    i3 = i4;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.f.size();
        f = csVar.e;
        i4 = csVar.b - 1;
        this.u = csVar.b == 0 ? csVar.e : -3.4028235E38f;
        this.v = csVar.b == count + -1 ? (csVar.e + csVar.d) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            cs csVar4 = (cs) this.f.get(i2);
            while (i4 > csVar4.b) {
                f -= this.i.getPageWidth(i4) + f2;
                i4--;
            }
            f -= csVar4.d + f2;
            csVar4.e = f;
            if (csVar4.b == 0) {
                this.u = f;
            }
            i4--;
        }
        float f5 = (csVar.e + csVar.d) + f2;
        i3 = csVar.b + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            csVar4 = (cs) this.f.get(i2);
            while (i3 < csVar4.b) {
                f5 += this.i.getPageWidth(i3) + f2;
                i3++;
            }
            if (csVar4.b == count - 1) {
                this.v = (csVar4.d + f5) - 1.0f;
            }
            csVar4.e = f5;
            f5 += csVar4.d + f2;
            i3++;
        }
        this.W = false;
    }

    private void a(MotionEvent motionEvent) {
        int b = ay.b(motionEvent);
        if (ay.b(motionEvent, b) == this.L) {
            b = b == 0 ? 1 : 0;
            this.H = ay.c(motionEvent, b);
            this.L = ay.b(motionEvent, b);
            if (this.M != null) {
                this.M.clear();
            }
        }
    }

    private void a(boolean z) {
        int scrollY;
        boolean z2 = this.al == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.n.isFinished()) {
                this.n.abortAnimation();
                int scrollX = getScrollX();
                scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        c(currX);
                    }
                }
            }
        }
        this.A = false;
        boolean z3 = z2;
        scrollY = 0;
        while (scrollY < this.f.size()) {
            cs csVar = (cs) this.f.get(scrollY);
            if (csVar.c) {
                csVar.c = false;
                z2 = true;
            } else {
                z2 = z3;
            }
            scrollY++;
            z3 = z2;
        }
        if (!z3) {
            return;
        }
        if (z) {
            bp.a((View) this, this.ak);
        } else {
            this.ak.run();
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && bp.a(view, -i);
    }

    private cs b(int i) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            cs csVar = (cs) this.f.get(i2);
            if (csVar.b == i) {
                return csVar;
            }
        }
        return null;
    }

    private cs b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private void b(int i, int i2) {
        if (i2 <= 0 || this.f.isEmpty()) {
            cs b = b(this.j);
            int min = (int) ((b != null ? Math.min(b.e, this.v) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        a(this.j, false, 0, false);
    }

    private void b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.H;
        this.H = f;
        float scrollX = ((float) getScrollX()) + (f3 - f);
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.u;
        float f5 = (float) clientWidth;
        float f6 = this.v;
        cs csVar = (cs) this.f.get(0);
        cs csVar2 = (cs) this.f.get(this.f.size() - 1);
        if (csVar.b != 0) {
            f4 = csVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (csVar2.b != this.i.getCount() - 1) {
            f2 = csVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5 * f6;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.T.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.U.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.H += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        c((int) f4);
        return z3;
    }

    private boolean c(int i) {
        if (this.f.size() == 0) {
            this.aa = false;
            a(0, 0.0f, 0);
            if (this.aa) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        cs j = j();
        int clientWidth = getClientWidth();
        int i2 = this.q;
        float f = ((float) this.q) / ((float) clientWidth);
        int i3 = j.b;
        float f2 = ((((float) i) / ((float) clientWidth)) - j.e) / (j.d + f);
        clientWidth = (int) (((float) (clientWidth + i2)) * f2);
        this.aa = false;
        a(i3, f2, clientWidth);
        if (this.aa) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void d(int i) {
        if (this.ac != null) {
            this.ac.a(i);
        }
        if (this.a != null) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                cw cwVar = (cw) this.a.get(i2);
                if (cwVar != null) {
                    cwVar.a(i);
                }
            }
        }
        if (this.ad != null) {
            this.ad.a(i);
        }
    }

    private boolean e(int i) {
        View view;
        boolean l;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                l = l();
            } else {
                if (i == 66 || i == 2) {
                    l = m();
                }
                l = false;
            }
        } else if (i == 17) {
            l = (view == null || a(this.h, findNextFocus).left < a(this.h, view).left) ? findNextFocus.requestFocus() : l();
        } else {
            if (i == 66) {
                l = (view == null || a(this.h, findNextFocus).left > a(this.h, view).left) ? findNextFocus.requestFocus() : m();
            }
            l = false;
        }
        if (l) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return l;
    }

    private void g() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.G = ch.a(viewConfiguration);
        this.N = (int) (400.0f * f);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new r(context);
        this.U = new r(context);
        this.P = (int) (25.0f * f);
        this.Q = (int) (2.0f * f);
        this.E = (int) (16.0f * f);
        bp.a((View) this, new cu(this));
        if (bp.e(this) == 0) {
            bp.c((View) this, 1);
        }
        bp.a((View) this, new cq(this));
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        if (this.ah != 0) {
            if (this.ai == null) {
                this.ai = new ArrayList();
            } else {
                this.ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ai.add(getChildAt(i));
            }
            Collections.sort(this.ai, aj);
        }
    }

    private boolean i() {
        this.L = -1;
        k();
        return this.T.c() | this.U.c();
    }

    private cs j() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        int i = -1;
        Object obj = 1;
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        cs csVar = null;
        while (i2 < this.f.size()) {
            cs csVar2 = (cs) this.f.get(i2);
            if (obj != null || csVar2.b == i + 1) {
                i = i2;
            } else {
                csVar2 = this.g;
                csVar2.e = (f2 + f3) + f;
                csVar2.b = i + 1;
                csVar2.d = this.i.getPageWidth(csVar2.b);
                i = i2 - 1;
            }
            float f4 = csVar2.e;
            f2 = csVar2.d;
            if (obj == null && scrollX < f4) {
                return csVar;
            }
            if (scrollX < (f2 + f4) + f || i == this.f.size() - 1) {
                return csVar2;
            }
            int i3 = csVar2.b;
            f2 = csVar2.d;
            f3 = f4;
            obj = null;
            i2 = i + 1;
            i = i3;
            csVar = csVar2;
        }
        return csVar;
    }

    private void k() {
        this.C = false;
        this.D = false;
        if (this.M != null) {
            this.M.recycle();
            this.M = null;
        }
    }

    private boolean l() {
        if (this.j <= 0) {
            return false;
        }
        a(this.j - 1, true);
        return true;
    }

    private boolean m() {
        if (this.i == null || this.j >= this.i.getCount() - 1) {
            return false;
        }
        a(this.j + 1, true);
        return true;
    }

    private void setScrollState(int i) {
        int i2 = 0;
        if (this.al != i) {
            this.al = i;
            if (this.af != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    bp.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.ac != null) {
                this.ac.b(i);
            }
            if (this.a != null) {
                int size = this.a.size();
                while (i2 < size) {
                    cw cwVar = (cw) this.a.get(i2);
                    if (cwVar != null) {
                        cwVar.b(i);
                    }
                    i2++;
                }
            }
            if (this.ad != null) {
                this.ad.b(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    final void a() {
        int count = this.i.getCount();
        this.c = count;
        boolean z = this.f.size() < (this.B << 1) + 1 && this.f.size() < count;
        int i = 0;
        boolean z2 = false;
        int i2 = this.j;
        boolean z3 = z;
        while (i < this.f.size()) {
            int i3;
            boolean z4;
            int max;
            cs csVar = (cs) this.f.get(i);
            int itemPosition = this.i.getItemPosition(csVar.a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f.remove(i);
                    i--;
                    if (!z2) {
                        this.i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.i.destroyItem((ViewGroup) this, csVar.b, csVar.a);
                    if (this.j == csVar.b) {
                        i3 = i;
                        z = true;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.j, count - 1));
                    } else {
                        i3 = i;
                        z = true;
                        z4 = z2;
                        max = i2;
                    }
                } else if (csVar.b != itemPosition) {
                    if (csVar.b == this.j) {
                        i2 = itemPosition;
                    }
                    csVar.b = itemPosition;
                    i3 = i;
                    z = true;
                    z4 = z2;
                    max = i2;
                }
                i2 = max;
                z2 = z4;
                i = i3 + 1;
                z3 = z;
            }
            z = z3;
            i3 = i;
            z4 = z2;
            max = i2;
            i2 = max;
            z2 = z4;
            i = i3 + 1;
            z3 = z;
        }
        if (z2) {
            this.i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f, d);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                ct ctVar = (ct) getChildAt(i3).getLayoutParams();
                if (!ctVar.a) {
                    ctVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public final void a(float f) {
        if (!this.R) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.i != null) {
            this.H += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f2 = (float) clientWidth;
            float f3 = this.u;
            float f4 = (float) clientWidth;
            float f5 = this.v;
            cs csVar = (cs) this.f.get(0);
            cs csVar2 = (cs) this.f.get(this.f.size() - 1);
            float f6 = csVar.b != 0 ? csVar.e * ((float) clientWidth) : f2 * f3;
            float f7 = csVar2.b != this.i.getCount() + -1 ? csVar2.e * ((float) clientWidth) : f4 * f5;
            if (scrollX >= f6) {
                f6 = scrollX > f7 ? f7 : scrollX;
            }
            this.H += f6 - ((float) ((int) f6));
            scrollTo((int) f6, getScrollY());
            c((int) f6);
            MotionEvent obtain = MotionEvent.obtain(this.S, SystemClock.uptimeMillis(), 2, this.H, 0.0f, 0);
            this.M.addMovement(obtain);
            obtain.recycle();
        }
    }

    public final void a(int i, boolean z) {
        this.A = false;
        a(i, z, false);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    cs a = a(childAt);
                    if (a != null && a.b == this.j) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cs a = a(childAt);
                if (a != null && a.b == this.j) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        ct ctVar = (ct) generateLayoutParams;
        ctVar.a |= view instanceof cr;
        if (!this.y) {
            super.addView(view, i, generateLayoutParams);
        } else if (ctVar == null || !ctVar.a) {
            ctVar.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    final void b() {
        a(this.j);
    }

    public final boolean c() {
        if (this.C) {
            return false;
        }
        this.R = true;
        setScrollState(1);
        this.H = 0.0f;
        this.J = 0.0f;
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        } else {
            this.M.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.M.addMovement(obtain);
        obtain.recycle();
        this.S = uptimeMillis;
        return true;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.i != null) {
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            if (i < 0) {
                if (scrollX > ((int) (((float) clientWidth) * this.u))) {
                    return true;
                }
            } else if (i > 0 && scrollX < ((int) (((float) clientWidth) * this.v))) {
                return true;
            }
        }
        return false;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ct) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.o = true;
        if (this.n.isFinished() || !this.n.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.n.getCurrX();
        int currY = this.n.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!c(currX)) {
                this.n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        bp.d(this);
    }

    public final void d() {
        if (this.R) {
            if (this.i != null) {
                VelocityTracker velocityTracker = this.M;
                velocityTracker.computeCurrentVelocity(1000, (float) this.O);
                int a = (int) bl.a(velocityTracker, this.L);
                this.A = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                cs j = j();
                a(a(j.b, ((((float) scrollX) / ((float) clientWidth)) - j.e) / j.d, a, (int) (this.H - this.J)), true, true, a);
            }
            k();
            this.R = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.z.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.z.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.e(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cs a = a(childAt);
                if (a != null && a.b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        super.draw(canvas);
        int a = bp.a(this);
        if (a == 0 || (a == 1 && this.i != null && this.i.getCount() > 1)) {
            int width;
            if (!this.T.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.u * ((float) width));
                this.T.a(i, width);
                i = this.T.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.U.a()) {
                a = canvas.save();
                width = getWidth();
                int height = getHeight();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.v + 1.0f)) * ((float) width));
                this.U.a((height - paddingTop) - paddingBottom, width);
                i |= this.U.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.T.b();
            this.U.b();
        }
        if (i != 0) {
            bp.d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public final boolean e() {
        return this.R;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new ct();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ct(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bj getAdapter() {
        return this.i;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ct) ((View) this.ai.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.n == null || this.n.isFinished())) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q > 0 && this.r != null && this.f.size() > 0 && this.i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.q) / ((float) width);
            cs csVar = (cs) this.f.get(0);
            float f2 = csVar.e;
            int size = this.f.size();
            int i = csVar.b;
            int i2 = ((cs) this.f.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > csVar.b && i3 < size) {
                    i3++;
                    csVar = (cs) this.f.get(i3);
                }
                if (i4 == csVar.b) {
                    f3 = (csVar.e + csVar.d) * ((float) width);
                    f2 = (csVar.e + csVar.d) + f;
                } else {
                    float pageWidth = this.i.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.q) + f3 > ((float) scrollX)) {
                    this.r.setBounds((int) f3, this.s, (int) ((((float) this.q) + f3) + 0.5f), this.t);
                    this.r.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            i();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.J = x;
                this.H = x;
                x = motionEvent.getY();
                this.K = x;
                this.I = x;
                this.L = ay.b(motionEvent, 0);
                this.D = false;
                this.o = true;
                this.n.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.Q) {
                    this.n.abortAnimation();
                    this.A = false;
                    b();
                    this.C = true;
                    b(true);
                    setScrollState(1);
                    break;
                }
                a(false);
                this.C = false;
                break;
                break;
            case 2:
                action = this.L;
                if (action != -1) {
                    action = ay.a(motionEvent, action);
                    float c = ay.c(motionEvent, action);
                    float f = c - this.H;
                    float abs = Math.abs(f);
                    float d = ay.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.K);
                    if (f != 0.0f) {
                        x = this.H;
                        boolean z = (x < ((float) this.F) && f > 0.0f) || (x > ((float) (getWidth() - this.F)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) c, (int) d)) {
                            this.H = c;
                            this.I = d;
                            this.D = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.G) && 0.5f * abs > abs2) {
                        this.C = true;
                        b(true);
                        setScrollState(1);
                        this.H = f > 0.0f ? this.J + ((float) this.G) : this.J - ((float) this.G);
                        this.I = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.G)) {
                        this.D = true;
                    }
                    if (this.C && b(c)) {
                        bp.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        return this.C;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int i6 = i3 - i;
        int i7 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            ct ctVar;
            int max;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ctVar = (ct) childAt.getLayoutParams();
                if (ctVar.a) {
                    int i10;
                    i5 = ctVar.b;
                    int i11 = ctVar.b;
                    switch (i5 & 7) {
                        case 1:
                            i5 = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            i5 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            i5 = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight = childAt.getMeasuredWidth() + paddingRight;
                            break;
                        default:
                            i5 = paddingLeft;
                            break;
                    }
                    switch (i11 & 112) {
                        case 16:
                            max = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            i10 = paddingTop;
                            paddingTop = childAt.getMeasuredHeight() + paddingTop;
                            max = i10;
                            break;
                        case 80:
                            max = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            break;
                        default:
                            max = paddingTop;
                            break;
                    }
                    i5 += scrollX;
                    childAt.layout(i5, max, childAt.getMeasuredWidth() + i5, childAt.getMeasuredHeight() + max);
                    i10 = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = paddingLeft;
                    paddingLeft = i8 + 1;
                    max = i10;
                    i9++;
                    i8 = paddingLeft;
                    paddingLeft = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = max;
                }
            }
            max = paddingRight;
            paddingRight = paddingTop;
            paddingTop = paddingLeft;
            paddingLeft = i8;
            i9++;
            i8 = paddingLeft;
            paddingLeft = paddingTop;
            paddingTop = paddingRight;
            paddingRight = max;
        }
        i5 = (i6 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                ctVar = (ct) childAt2.getLayoutParams();
                if (!ctVar.a) {
                    cs a = a(childAt2);
                    if (a != null) {
                        i6 = ((int) (a.e * ((float) i5))) + paddingLeft;
                        if (ctVar.d) {
                            ctVar.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (ctVar.c * ((float) i5)), 1073741824), MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i6, paddingTop, childAt2.getMeasuredWidth() + i6, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.s = paddingTop;
        this.t = i7 - paddingBottom;
        this.ab = i8;
        if (this.V) {
            a(this.j, false, 0, false);
        }
        this.V = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.F = Math.min(measuredWidth / 10, this.E);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            ct ctVar;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                ctVar = (ct) childAt.getLayoutParams();
                if (ctVar != null && ctVar.a) {
                    int i6 = ctVar.b & 7;
                    int i7 = ctVar.b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (ctVar.width != -2) {
                        i3 = 1073741824;
                        i7 = ctVar.width != -1 ? ctVar.width : paddingLeft;
                    } else {
                        i7 = paddingLeft;
                    }
                    if (ctVar.height != -2) {
                        i5 = 1073741824;
                        if (ctVar.height != -1) {
                            measuredWidth = ctVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i3), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredWidth = measuredHeight - childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                                measuredWidth = measuredHeight;
                            }
                            i4++;
                            measuredHeight = measuredWidth;
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i3), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredWidth = measuredHeight - childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                        measuredWidth = measuredHeight;
                    }
                    i4++;
                    measuredHeight = measuredWidth;
                }
            }
            measuredWidth = measuredHeight;
            i4++;
            measuredHeight = measuredWidth;
        }
        this.w = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.x = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.y = true;
        b();
        this.y = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                ctVar = (ct) childAt2.getLayoutParams();
                if (ctVar == null || !ctVar.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (ctVar.c * ((float) paddingLeft)), 1073741824), this.x);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                cs a = a(childAt);
                if (a != null && a.b == this.j && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.i != null) {
                this.i.restoreState(savedState.b, savedState.c);
                a(savedState.a, false, true);
                return;
            }
            this.k = savedState.a;
            this.l = savedState.b;
            this.m = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j;
        if (this.i != null) {
            savedState.b = this.i.saveState();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            b(i, i3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.R) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.i == null || this.i.getCount() == 0) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.n.abortAnimation();
                this.A = false;
                b();
                x = motionEvent.getX();
                this.J = x;
                this.H = x;
                x = motionEvent.getY();
                this.K = x;
                this.I = x;
                this.L = ay.b(motionEvent, 0);
                break;
            case 1:
                if (this.C) {
                    VelocityTracker velocityTracker = this.M;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.O);
                    a = (int) bl.a(velocityTracker, this.L);
                    this.A = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    cs j = j();
                    a(a(j.b, ((((float) scrollX) / ((float) clientWidth)) - j.e) / j.d, a, (int) (ay.c(motionEvent, ay.a(motionEvent, this.L)) - this.J)), true, true, a);
                    z = i();
                    break;
                }
                break;
            case 2:
                if (!this.C) {
                    a = ay.a(motionEvent, this.L);
                    if (a == -1) {
                        z = i();
                        break;
                    }
                    float c = ay.c(motionEvent, a);
                    float abs = Math.abs(c - this.H);
                    float d = ay.d(motionEvent, a);
                    x = Math.abs(d - this.I);
                    if (abs > ((float) this.G) && abs > x) {
                        this.C = true;
                        b(true);
                        this.H = c - this.J > 0.0f ? this.J + ((float) this.G) : this.J - ((float) this.G);
                        this.I = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.C) {
                    z = b(ay.c(motionEvent, ay.a(motionEvent, this.L))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.C) {
                    a(this.j, true, 0, false);
                    z = i();
                    break;
                }
                break;
            case 5:
                a = ay.b(motionEvent);
                this.H = ay.c(motionEvent, a);
                this.L = ay.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.H = ay.c(motionEvent, ay.a(motionEvent, this.L));
                break;
        }
        if (z) {
            bp.d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bj bjVar) {
        if (this.i != null) {
            int i;
            this.i.setViewPagerObserver(null);
            this.i.startUpdate((ViewGroup) this);
            for (i = 0; i < this.f.size(); i++) {
                cs csVar = (cs) this.f.get(i);
                this.i.destroyItem((ViewGroup) this, csVar.b, csVar.a);
            }
            this.i.finishUpdate((ViewGroup) this);
            this.f.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((ct) getChildAt(i).getLayoutParams()).a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.j = 0;
            scrollTo(0, 0);
        }
        this.i = bjVar;
        this.c = 0;
        if (this.i != null) {
            if (this.p == null) {
                this.p = new cy();
            }
            this.i.setViewPagerObserver(this.p);
            this.A = false;
            boolean z = this.V;
            this.V = true;
            this.c = this.i.getCount();
            if (this.k >= 0) {
                this.i.restoreState(this.l, this.m);
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ag == null) {
                try {
                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.A = false;
        a(i, !this.V, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.B) {
            this.B = i;
            b();
        }
    }

    void setOnAdapterChangeListener(cv cvVar) {
        this.ae = cvVar;
    }

    @Deprecated
    public void setOnPageChangeListener(cw cwVar) {
        this.ac = cwVar;
    }

    public void setPageMargin(int i) {
        this.q = i;
        int width = getWidth();
        b(width, width);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }
}
