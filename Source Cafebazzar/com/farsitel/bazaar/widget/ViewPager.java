package com.farsitel.bazaar.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.d;
import android.support.v4.view.ay;
import android.support.v4.view.bj;
import android.support.v4.view.bl;
import android.support.v4.view.bp;
import android.support.v4.view.ch;
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
import com.farsitel.bazaar.util.q;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] a = new int[]{16842931};
    private static final az aj = new az();
    private static final Comparator e = new am();
    private static final Interpolator f = new an();
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private r S;
    private r T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int aa;
    private av ab;
    private au ac;
    private au ad;
    private at ae;
    private aw af;
    private Method ag;
    private int ah;
    private ArrayList ai;
    private final Runnable ak;
    private int al;
    private int b;
    private boolean c;
    private boolean d = true;
    private final ArrayList g = new ArrayList();
    private final aq h = new aq();
    private final Rect i = new Rect();
    private bj j;
    private int k = -1;
    private int l = -1;
    private Parcelable m = null;
    private ClassLoader n = null;
    private Scroller o;
    private ax p;
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
        public static final Creator CREATOR = d.a(new ay());
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
        q.f();
        this.B = 1;
        this.L = -1;
        this.U = true;
        this.V = false;
        this.ak = new ao(this);
        this.al = 0;
        d();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.f();
        this.B = 1;
        this.L = -1;
        this.U = true;
        this.V = false;
        this.ak = new ao(this);
        this.al = 0;
        d();
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

    private aq a(int i, int i2) {
        aq aqVar = new aq();
        aqVar.b = i;
        aqVar.a = this.j.instantiateItem((ViewGroup) this, i);
        aqVar.d = this.j.getPageWidth(i);
        if (i2 < 0 || i2 >= this.g.size()) {
            this.g.add(aqVar);
        } else {
            this.g.add(i2, aqVar);
        }
        return aqVar;
    }

    private aq a(View view) {
        for (int i = 0; i < this.g.size(); i++) {
            aq aqVar = (aq) this.g.get(i);
            if (this.j.isViewFromObject(view, aqVar.a)) {
                return aqVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r18) {
        /*
        r17 = this;
        r0 = r17;
        r2 = r0.k;
        r0 = r18;
        if (r2 == r0) goto L_0x0314;
    L_0x0008:
        r0 = r17;
        r2 = r0.k;
        r0 = r18;
        if (r2 >= r0) goto L_0x002e;
    L_0x0010:
        r2 = 66;
    L_0x0012:
        r0 = r17;
        r3 = r0.k;
        r0 = r17;
        r3 = r0.b(r3);
        r0 = r18;
        r1 = r17;
        r1.k = r0;
        r7 = r3;
        r8 = r2;
    L_0x0024:
        r0 = r17;
        r2 = r0.j;
        if (r2 != 0) goto L_0x0031;
    L_0x002a:
        r17.e();
    L_0x002d:
        return;
    L_0x002e:
        r2 = 17;
        goto L_0x0012;
    L_0x0031:
        r0 = r17;
        r2 = r0.A;
        if (r2 == 0) goto L_0x003b;
    L_0x0037:
        r17.e();
        goto L_0x002d;
    L_0x003b:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x002d;
    L_0x0041:
        r0 = r17;
        r2 = r0.j;
        r0 = r17;
        r2.startUpdate(r0);
        r0 = r17;
        r2 = r0.B;
        r3 = 0;
        r0 = r17;
        r4 = r0.k;
        r4 = r4 - r2;
        r11 = java.lang.Math.max(r3, r4);
        r0 = r17;
        r3 = r0.j;
        r12 = r3.getCount();
        r3 = r12 + -1;
        r0 = r17;
        r4 = r0.k;
        r2 = r2 + r4;
        r13 = java.lang.Math.min(r3, r2);
        r0 = r17;
        r2 = r0.b;
        if (r12 == r2) goto L_0x00d4;
    L_0x0071:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00ca }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00ca }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00ca }
    L_0x007d:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r17;
        r5 = r0.b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.j;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00ca:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007d;
    L_0x00d4:
        r2 = 0;
        r3 = r2;
    L_0x00d6:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r3 >= r2) goto L_0x0311;
    L_0x00e0:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r3);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
        r4 = r2.b;
        r0 = r17;
        r5 = r0.k;
        if (r4 < r5) goto L_0x0164;
    L_0x00f2:
        r4 = r2.b;
        r0 = r17;
        r5 = r0.k;
        if (r4 != r5) goto L_0x0311;
    L_0x00fa:
        if (r2 != 0) goto L_0x030e;
    L_0x00fc:
        if (r12 <= 0) goto L_0x030e;
    L_0x00fe:
        r0 = r17;
        r2 = r0.k;
        r0 = r17;
        r2 = r0.a(r2, r3);
        r9 = r2;
    L_0x0109:
        if (r9 == 0) goto L_0x0276;
    L_0x010b:
        r5 = r3 + -1;
        if (r5 < 0) goto L_0x0169;
    L_0x010f:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r5);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
    L_0x0119:
        r14 = r17.getClientWidth();
        if (r14 > 0) goto L_0x016b;
    L_0x011f:
        r4 = 0;
        r6 = r4;
    L_0x0121:
        r0 = r17;
        r4 = r0.k;
        r10 = 0;
        r4 = r4 + -1;
        r16 = r4;
        r4 = r10;
        r10 = r16;
    L_0x012d:
        if (r10 < 0) goto L_0x01b2;
    L_0x012f:
        r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x017c;
    L_0x0133:
        if (r10 >= r11) goto L_0x017c;
    L_0x0135:
        if (r2 == 0) goto L_0x01b2;
    L_0x0137:
        r15 = r2.b;
        if (r10 != r15) goto L_0x0161;
    L_0x013b:
        r15 = r2.c;
        if (r15 != 0) goto L_0x0161;
    L_0x013f:
        r0 = r17;
        r15 = r0.g;
        r15.remove(r5);
        r0 = r17;
        r15 = r0.j;
        r2 = r2.a;
        r0 = r17;
        r15.destroyItem(r0, r10, r2);
        r5 = r5 + -1;
        r3 = r3 + -1;
        if (r5 < 0) goto L_0x017a;
    L_0x0157:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r5);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
    L_0x0161:
        r10 = r10 + -1;
        goto L_0x012d;
    L_0x0164:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x00d6;
    L_0x0169:
        r2 = 0;
        goto L_0x0119;
    L_0x016b:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.d;
        r4 = r4 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r10 = (float) r14;
        r6 = r6 / r10;
        r4 = r4 + r6;
        r6 = r4;
        goto L_0x0121;
    L_0x017a:
        r2 = 0;
        goto L_0x0161;
    L_0x017c:
        if (r2 == 0) goto L_0x0196;
    L_0x017e:
        r15 = r2.b;
        if (r10 != r15) goto L_0x0196;
    L_0x0182:
        r2 = r2.d;
        r4 = r4 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0194;
    L_0x0189:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r5);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
        goto L_0x0161;
    L_0x0194:
        r2 = 0;
        goto L_0x0161;
    L_0x0196:
        r2 = r5 + 1;
        r0 = r17;
        r2 = r0.a(r10, r2);
        r2 = r2.d;
        r4 = r4 + r2;
        r3 = r3 + 1;
        if (r5 < 0) goto L_0x01b0;
    L_0x01a5:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r5);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
        goto L_0x0161;
    L_0x01b0:
        r2 = 0;
        goto L_0x0161;
    L_0x01b2:
        r6 = r9.d;
        r10 = r3 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0271;
    L_0x01bc:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r10 >= r2) goto L_0x021d;
    L_0x01c6:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r10);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
        r5 = r2;
    L_0x01d1:
        if (r14 > 0) goto L_0x021f;
    L_0x01d3:
        r2 = 0;
        r4 = r2;
    L_0x01d5:
        r0 = r17;
        r2 = r0.k;
        r2 = r2 + 1;
        r16 = r5;
        r5 = r6;
        r6 = r10;
        r10 = r2;
        r2 = r16;
    L_0x01e2:
        if (r10 >= r12) goto L_0x0271;
    L_0x01e4:
        r11 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r11 < 0) goto L_0x022d;
    L_0x01e8:
        if (r10 <= r13) goto L_0x022d;
    L_0x01ea:
        if (r2 == 0) goto L_0x0271;
    L_0x01ec:
        r11 = r2.b;
        if (r10 != r11) goto L_0x021a;
    L_0x01f0:
        r11 = r2.c;
        if (r11 != 0) goto L_0x021a;
    L_0x01f4:
        r0 = r17;
        r11 = r0.g;
        r11.remove(r6);
        r0 = r17;
        r11 = r0.j;
        r2 = r2.a;
        r0 = r17;
        r11.destroyItem(r0, r10, r2);
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x022b;
    L_0x0210:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
    L_0x021a:
        r10 = r10 + 1;
        goto L_0x01e2;
    L_0x021d:
        r5 = 0;
        goto L_0x01d1;
    L_0x021f:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r14;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x01d5;
    L_0x022b:
        r2 = 0;
        goto L_0x021a;
    L_0x022d:
        if (r2 == 0) goto L_0x024f;
    L_0x022f:
        r11 = r2.b;
        if (r10 != r11) goto L_0x024f;
    L_0x0233:
        r11 = r2.d;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x024d;
    L_0x0241:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
    L_0x024b:
        r5 = r5 + r11;
        goto L_0x021a;
    L_0x024d:
        r2 = 0;
        goto L_0x024b;
    L_0x024f:
        r0 = r17;
        r2 = r0.a(r10, r6);
        r6 = r6 + 1;
        r11 = r2.d;
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x026f;
    L_0x0263:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (com.farsitel.bazaar.widget.aq) r2;
    L_0x026d:
        r5 = r5 + r11;
        goto L_0x021a;
    L_0x026f:
        r2 = 0;
        goto L_0x026d;
    L_0x0271:
        r0 = r17;
        r0.a(r9, r3, r7);
    L_0x0276:
        r0 = r17;
        r3 = r0.j;
        r0 = r17;
        r4 = r0.k;
        if (r9 == 0) goto L_0x02c5;
    L_0x0280:
        r2 = r9.a;
    L_0x0282:
        r0 = r17;
        r3.setPrimaryItem(r0, r4, r2);
        r0 = r17;
        r2 = r0.j;
        r0 = r17;
        r2.finishUpdate(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x0296:
        if (r3 >= r4) goto L_0x02c7;
    L_0x0298:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (com.farsitel.bazaar.widget.ar) r2;
        r2.f = r3;
        r6 = r2.a;
        if (r6 != 0) goto L_0x02c1;
    L_0x02aa:
        r6 = r2.c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x02c1;
    L_0x02b1:
        r0 = r17;
        r5 = r0.a(r5);
        if (r5 == 0) goto L_0x02c1;
    L_0x02b9:
        r6 = r5.d;
        r2.c = r6;
        r5 = r5.b;
        r2.e = r5;
    L_0x02c1:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0296;
    L_0x02c5:
        r2 = 0;
        goto L_0x0282;
    L_0x02c7:
        r17.e();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x002d;
    L_0x02d0:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x030c;
    L_0x02d6:
        r0 = r17;
        r2 = r0.b(r2);
    L_0x02dc:
        if (r2 == 0) goto L_0x02e6;
    L_0x02de:
        r2 = r2.b;
        r0 = r17;
        r3 = r0.k;
        if (r2 == r3) goto L_0x002d;
    L_0x02e6:
        r2 = 0;
    L_0x02e7:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x002d;
    L_0x02ed:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.a(r3);
        if (r4 == 0) goto L_0x0309;
    L_0x02fb:
        r4 = r4.b;
        r0 = r17;
        r5 = r0.k;
        if (r4 != r5) goto L_0x0309;
    L_0x0303:
        r3 = r3.requestFocus(r8);
        if (r3 != 0) goto L_0x002d;
    L_0x0309:
        r2 = r2 + 1;
        goto L_0x02e7;
    L_0x030c:
        r2 = 0;
        goto L_0x02dc;
    L_0x030e:
        r9 = r2;
        goto L_0x0109;
    L_0x0311:
        r2 = 0;
        goto L_0x00fa;
    L_0x0314:
        r2 = 0;
        r3 = 2;
        r7 = r2;
        r8 = r3;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.widget.ViewPager.a(int):void");
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        if (this.aa > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ar arVar = (ar) childAt.getLayoutParams();
                if (arVar.a) {
                    int max;
                    switch (arVar.b & 7) {
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
        if (this.ad != null) {
            this.ad.a(i, f, i2);
        }
        if (this.af != null) {
            getScrollX();
            paddingRight = getChildCount();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((ar) childAt2.getLayoutParams()).a) {
                    childAt2.getLeft();
                    getClientWidth();
                }
            }
        }
        this.W = true;
    }

    private void a(int i, int i2, int i3, int i4) {
        int min;
        if (i2 <= 0 || this.g.isEmpty()) {
            aq b = b(this.k);
            min = (int) ((b != null ? Math.min(b.e, this.v) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        min = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float f = (float) (((i - min) - paddingRight) + i3);
        paddingRight = (int) (f * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingRight, getScrollY());
        if (!this.o.isFinished()) {
            this.o.startScroll(paddingRight, 0, (int) (b(this.k).e * ((float) i)), 0, this.o.getDuration() - this.o.timePassed());
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        aq b = b(i);
        int i3 = 0;
        if (b != null) {
            i3 = (int) (((float) getClientWidth()) * Math.max(this.u, Math.min(b.e, this.v)));
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i4 = i3 - scrollX;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    a(false);
                    b();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    i3 = getClientWidth();
                    int i6 = i3 / 2;
                    float f = (float) i6;
                    float f2 = (float) i6;
                    float sin = (float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i4))) / ((float) i3)) - 0.5f)) * 0.4712389167638204d)));
                    int abs = Math.abs(i2);
                    this.o.startScroll(scrollX, scrollY, i4, i5, abs > 0 ? Math.min(Math.round(Math.abs(((sin * f2) + f) / ((float) abs)) * 1000.0f) * 4, 600) : 600);
                    bp.d(this);
                }
            }
            if (z2 && this.ac != null) {
                this.ac.a(i);
            }
            if (z2 && this.ad != null) {
                this.ad.a(i);
                return;
            }
            return;
        }
        if (z2 && this.ac != null) {
            this.ac.a(i);
        }
        if (z2 && this.ad != null) {
            this.ad.a(i);
        }
        a(false);
        scrollTo(i3, 0);
        c(i3);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.j == null || this.j.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.k != i || this.g.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.j.getCount()) {
                i = this.j.getCount() - 1;
            }
            int i3 = this.B;
            if (i > this.k + i3 || i < this.k - i3) {
                for (int i4 = 0; i4 < this.g.size(); i4++) {
                    ((aq) this.g.get(i4)).c = true;
                }
            }
            if (this.k != i) {
                z3 = true;
            }
            if (this.U) {
                this.k = i;
                if (z3 && this.ac != null) {
                    this.ac.a(i);
                }
                if (z3 && this.ad != null) {
                    this.ad.a(i);
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

    private void a(aq aqVar, int i, aq aqVar2) {
        int i2;
        int i3;
        int i4;
        float f;
        int count = this.j.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        if (aqVar2 != null) {
            i2 = aqVar2.b;
            float f3;
            int i5;
            aq aqVar3;
            float f4;
            if (i2 < aqVar.b) {
                i3 = i2 + 1;
                f3 = (aqVar2.e + aqVar2.d) + f2;
                i4 = 0;
                while (i3 <= aqVar.b && i4 < this.g.size()) {
                    i5 = i4;
                    aqVar3 = (aq) this.g.get(i4);
                    clientWidth = i5;
                    while (i3 > aqVar3.b && clientWidth < this.g.size() - 1) {
                        i4 = clientWidth + 1;
                        i5 = i4;
                        aqVar3 = (aq) this.g.get(i4);
                        clientWidth = i5;
                    }
                    f4 = f3;
                    i2 = i3;
                    while (i2 < aqVar3.b) {
                        f4 = (this.j.getPageWidth(i2) + f2) + f4;
                        i2++;
                    }
                    aqVar3.e = f4;
                    f = f4 + (aqVar3.d + f2);
                    i4 = i2 + 1;
                    f3 = f;
                    i3 = i4;
                    i4 = clientWidth;
                }
            } else if (i2 > aqVar.b) {
                clientWidth = this.g.size();
                i4 = i2 - 1;
                f3 = aqVar2.e;
                i3 = i4;
                i4 = clientWidth - 1;
                while (i3 >= aqVar.b && i4 >= 0) {
                    i5 = i4;
                    aqVar3 = (aq) this.g.get(i4);
                    clientWidth = i5;
                    while (i3 < aqVar3.b && clientWidth > 0) {
                        i4 = clientWidth - 1;
                        i5 = i4;
                        aqVar3 = (aq) this.g.get(i4);
                        clientWidth = i5;
                    }
                    f4 = f3;
                    i2 = i3;
                    while (i2 > aqVar3.b) {
                        f4 -= this.j.getPageWidth(i2) + f2;
                        i2--;
                    }
                    f = f4 - (aqVar3.d + f2);
                    aqVar3.e = f;
                    i4 = i2 - 1;
                    f3 = f;
                    i3 = i4;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.g.size();
        f = aqVar.e;
        i4 = aqVar.b - 1;
        this.u = aqVar.b == 0 ? aqVar.e : -3.4028235E38f;
        this.v = aqVar.b == count + -1 ? (aqVar.e + aqVar.d) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            aq aqVar4 = (aq) this.g.get(i2);
            while (i4 > aqVar4.b) {
                f -= this.j.getPageWidth(i4) + f2;
                i4--;
            }
            f -= aqVar4.d + f2;
            aqVar4.e = f;
            if (aqVar4.b == 0) {
                this.u = f;
            }
            i4--;
        }
        float f5 = (aqVar.e + aqVar.d) + f2;
        i3 = aqVar.b + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            aqVar4 = (aq) this.g.get(i2);
            while (i3 < aqVar4.b) {
                f5 += this.j.getPageWidth(i3) + f2;
                i3++;
            }
            if (aqVar4.b == count - 1) {
                this.v = (aqVar4.d + f5) - 1.0f;
            }
            aqVar4.e = f5;
            f5 += aqVar4.d + f2;
            i3++;
        }
        this.V = false;
    }

    private void a(boolean z) {
        int scrollY;
        boolean z2 = this.al == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.o.abortAnimation();
            int scrollX = getScrollX();
            scrollY = getScrollY();
            int currX = this.o.getCurrX();
            int currY = this.o.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.A = false;
        boolean z3 = z2;
        scrollY = 0;
        while (scrollY < this.g.size()) {
            aq aqVar = (aq) this.g.get(scrollY);
            if (aqVar.c) {
                aqVar.c = false;
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

    private boolean a(float f) {
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
        aq aqVar = (aq) this.g.get(0);
        aq aqVar2 = (aq) this.g.get(this.g.size() - 1);
        if (aqVar.b != 0) {
            f4 = aqVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (aqVar2.b != this.j.getCount() - 1) {
            f2 = aqVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5 * f6;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.S.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.T.a(Math.abs(scrollX - f2) / ((float) clientWidth));
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

    private aq b(int i) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            aq aqVar = (aq) this.g.get(i2);
            if (aqVar.b == i) {
                return aqVar;
            }
        }
        return null;
    }

    private aq b(View view) {
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

    private void b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean c(int i) {
        if (this.g.size() == 0) {
            this.W = false;
            a(0, 0.0f, 0);
            if (this.W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        aq f = f();
        int clientWidth = getClientWidth();
        int i2 = this.q;
        float f2 = ((float) this.q) / ((float) clientWidth);
        int i3 = f.b;
        float f3 = ((((float) i) / ((float) clientWidth)) - f.e) / (f.d + f2);
        clientWidth = (int) (((float) (clientWidth + i2)) * f3);
        this.W = false;
        a(i3, f3, clientWidth);
        if (this.W) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.o = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.G = ch.a(viewConfiguration);
        this.N = (int) (400.0f * f);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.S = new r(context);
        this.T = new r(context);
        this.P = (int) (25.0f * f);
        this.Q = (int) (2.0f * f);
        this.E = (int) (16.0f * f);
        bp.a((View) this, new as(this));
        if (bp.e(this) == 0) {
            bp.c((View) this, 1);
        }
    }

    private boolean d(int i) {
        View view;
        boolean h;
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
                h = h();
            } else {
                if (i == 66 || i == 2) {
                    h = i();
                }
                h = false;
            }
        } else if (i == 17) {
            h = (view == null || a(this.i, findNextFocus).left < a(this.i, view).left) ? findNextFocus.requestFocus() : h();
        } else {
            if (i == 66) {
                h = (view == null || a(this.i, findNextFocus).left > a(this.i, view).left) ? findNextFocus.requestFocus() : i();
            }
            h = false;
        }
        if (h) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return h;
    }

    private void e() {
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

    private aq f() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        int i = -1;
        Object obj = 1;
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        aq aqVar = null;
        while (i2 < this.g.size()) {
            aq aqVar2 = (aq) this.g.get(i2);
            if (obj != null || aqVar2.b == i + 1) {
                i = i2;
            } else {
                aqVar2 = this.h;
                aqVar2.e = (f2 + f3) + f;
                aqVar2.b = i + 1;
                aqVar2.d = this.j.getPageWidth(aqVar2.b);
                i = i2 - 1;
            }
            float f4 = aqVar2.e;
            f2 = aqVar2.d;
            if (obj == null && scrollX < f4) {
                return aqVar;
            }
            if (scrollX < (f2 + f4) + f || i == this.g.size() - 1) {
                return aqVar2;
            }
            int i3 = aqVar2.b;
            f2 = aqVar2.d;
            f3 = f4;
            obj = null;
            i2 = i + 1;
            i = i3;
            aqVar = aqVar2;
        }
        return aqVar;
    }

    private void g() {
        this.C = false;
        this.D = false;
        if (this.M != null) {
            this.M.recycle();
            this.M = null;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean h() {
        if (this.k <= 0) {
            return false;
        }
        a(this.k - 1, true);
        return true;
    }

    private boolean i() {
        if (this.j == null || this.k >= this.j.getCount() - 1) {
            return false;
        }
        a(this.k + 1, true);
        return true;
    }

    private void setScrollState(int i) {
        if (this.al != i) {
            this.al = i;
            if (this.af != null) {
                Object obj = i != 0 ? 1 : null;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    bp.a(getChildAt(i2), obj != null ? 2 : 0, null);
                }
            }
            if (this.ac != null) {
                this.ac.b(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    childAt.setDrawingCacheEnabled(z);
                }
            }
        }
    }

    final void a() {
        int count = this.j.getCount();
        this.b = count;
        boolean z = this.g.size() < (this.B << 1) + 1 && this.g.size() < count;
        int i = 0;
        boolean z2 = false;
        int i2 = this.k;
        boolean z3 = z;
        while (i < this.g.size()) {
            int i3;
            boolean z4;
            int max;
            aq aqVar = (aq) this.g.get(i);
            int itemPosition = this.j.getItemPosition(aqVar.a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.g.remove(i);
                    i--;
                    if (!z2) {
                        this.j.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.j.destroyItem((ViewGroup) this, aqVar.b, aqVar.a);
                    if (this.k == aqVar.b) {
                        i3 = i;
                        z = true;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.k, count - 1));
                    } else {
                        i3 = i;
                        z = true;
                        z4 = z2;
                        max = i2;
                    }
                } else if (aqVar.b != itemPosition) {
                    if (aqVar.b == this.k) {
                        i2 = itemPosition;
                    }
                    aqVar.b = itemPosition;
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
            this.j.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                ar arVar = (ar) getChildAt(i3).getLayoutParams();
                if (!arVar.a) {
                    arVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public final void a(int i, boolean z) {
        this.A = false;
        a(i, true, false);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    aq a = a(childAt);
                    if (a != null && a.b == this.k) {
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
                aq a = a(childAt);
                if (a != null && a.b == this.k) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        ar arVar = (ar) generateLayoutParams;
        arVar.a |= view instanceof ap;
        if (!this.y) {
            super.addView(view, i, generateLayoutParams);
        } else if (arVar == null || !arVar.a) {
            arVar.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        if (view.getVisibility() != 8) {
            view.setDrawingCacheEnabled(this.z);
        } else {
            view.setDrawingCacheEnabled(false);
        }
    }

    final void b() {
        a(this.k);
    }

    public boolean canScrollHorizontally(int i) {
        if (this.j != null) {
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
        return (layoutParams instanceof ar) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.o.isFinished() || !this.o.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.o.getCurrX();
        int currY = this.o.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!c(currX)) {
                this.o.abortAnimation();
                scrollTo(0, currY);
            }
        }
        bp.d(this);
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
        r2 = r4.d(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.d(r2);
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
        r2 = r4.d(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.z.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.d(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                aq a = a(childAt);
                if (a != null && a.b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
        if (a == 0 || (a == 1 && this.j != null && this.j.getCount() > 1)) {
            int width;
            if (!this.S.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.u * ((float) width));
                this.S.a(i, width);
                i = this.S.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.T.a()) {
                a = canvas.save();
                width = getWidth();
                int height = getHeight();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.v + 1.0f)) * ((float) width));
                this.T.a((height - paddingTop) - paddingBottom, width);
                i |= this.T.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.S.b();
            this.T.b();
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

    protected LayoutParams generateDefaultLayoutParams() {
        return new ar();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ar(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bj getAdapter() {
        return this.j;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ar) ((View) this.ai.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.k;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q > 0 && this.r != null && this.g.size() > 0 && this.j != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.q) / ((float) width);
            aq aqVar = (aq) this.g.get(0);
            float f2 = aqVar.e;
            int size = this.g.size();
            int i = aqVar.b;
            int i2 = ((aq) this.g.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > aqVar.b && i3 < size) {
                    i3++;
                    aqVar = (aq) this.g.get(i3);
                }
                if (i4 == aqVar.b) {
                    f3 = (aqVar.e + aqVar.d) * ((float) width);
                    f2 = (aqVar.e + aqVar.d) + f;
                } else {
                    float pageWidth = this.j.getPageWidth(i4);
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
        if (!this.d) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.C = false;
            this.D = false;
            this.L = -1;
            if (this.M == null) {
                return false;
            }
            this.M.recycle();
            this.M = null;
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
                this.o.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.o.getFinalX() - this.o.getCurrX()) > this.Q) {
                    this.o.abortAnimation();
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
                    if (this.C && a(c)) {
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
            ar arVar;
            int max;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                arVar = (ar) childAt.getLayoutParams();
                if (arVar.a) {
                    int i10;
                    i5 = arVar.b;
                    int i11 = arVar.b;
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
                arVar = (ar) childAt2.getLayoutParams();
                if (!arVar.a) {
                    aq a = a(childAt2);
                    if (a != null) {
                        i6 = ((int) (a.e * ((float) i5))) + paddingLeft;
                        if (arVar.d) {
                            arVar.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (arVar.c * ((float) i5)), 1073741824), MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i6, paddingTop, childAt2.getMeasuredWidth() + i6, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.s = paddingTop;
        this.t = i7 - paddingBottom;
        this.aa = i8;
        if (this.U) {
            a(this.k, false, 0, false);
        }
        this.U = false;
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
            ar arVar;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                arVar = (ar) childAt.getLayoutParams();
                if (arVar != null && arVar.a) {
                    int i6 = arVar.b & 7;
                    int i7 = arVar.b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (arVar.width != -2) {
                        i3 = 1073741824;
                        i7 = arVar.width != -1 ? arVar.width : paddingLeft;
                    } else {
                        i7 = paddingLeft;
                    }
                    if (arVar.height != -2) {
                        i5 = 1073741824;
                        if (arVar.height != -1) {
                            measuredWidth = arVar.height;
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
                arVar = (ar) childAt2.getLayoutParams();
                if (arVar == null || !arVar.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (arVar.c * ((float) paddingLeft)), 1073741824), this.x);
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
                aq a = a(childAt);
                if (a != null && a.b == this.k && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(savedState.getSuperState());
                if (this.j != null) {
                    this.j.restoreState(savedState.b, savedState.c);
                    a(savedState.a, false, true);
                    return;
                }
                this.l = savedState.a;
                this.m = savedState.b;
                this.n = savedState.c;
                return;
            }
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e) {
            e.printStackTrace();
            super.onRestoreInstanceState(parcelable);
        }
    }

    public Parcelable onSaveInstanceState() {
        try {
            Parcelable savedState = new SavedState(super.onSaveInstanceState());
            savedState.a = this.k;
            if (this.j == null) {
                return savedState;
            }
            savedState.b = this.j.saveState();
            return savedState;
        } catch (Exception e) {
            e.printStackTrace();
            return super.onSaveInstanceState();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.q, this.q);
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
        if (this.j == null || this.j.getCount() == 0) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.o.abortAnimation();
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
                    int a = (int) bl.a(velocityTracker, this.L);
                    this.A = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    aq f2 = f();
                    i = f2.b;
                    f = ((((float) scrollX) / ((float) clientWidth)) - f2.e) / f2.d;
                    if (Math.abs((int) (ay.c(motionEvent, ay.a(motionEvent, this.L)) - this.J)) <= this.P || Math.abs(a) <= this.N) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.k ? 0.4f : 0.6f));
                    } else {
                        scrollX = a > 0 ? i : i + 1;
                    }
                    if (this.g.size() > 0) {
                        scrollX = Math.max(((aq) this.g.get(0)).b, Math.min(scrollX, ((aq) this.g.get(this.g.size() - 1)).b));
                    }
                    a(scrollX, true, true, a);
                    this.L = -1;
                    g();
                    z = this.S.c() | this.T.c();
                    break;
                }
                break;
            case 2:
                if (!this.C) {
                    i = ay.a(motionEvent, this.L);
                    float c = ay.c(motionEvent, i);
                    f = Math.abs(c - this.H);
                    float d = ay.d(motionEvent, i);
                    x = Math.abs(d - this.I);
                    if (f > ((float) this.G) && f > x) {
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
                    z = a(ay.c(motionEvent, ay.a(motionEvent, this.L))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.C) {
                    a(this.k, true, 0, false);
                    this.L = -1;
                    g();
                    z = this.S.c() | this.T.c();
                    break;
                }
                break;
            case 5:
                i = ay.b(motionEvent);
                this.H = ay.c(motionEvent, i);
                this.L = ay.b(motionEvent, i);
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
        if (this.j != null) {
            int i;
            this.j.unregisterDataSetObserver(this.p);
            this.j.startUpdate((ViewGroup) this);
            for (i = 0; i < this.g.size(); i++) {
                aq aqVar = (aq) this.g.get(i);
                this.j.destroyItem((ViewGroup) this, aqVar.b, aqVar.a);
            }
            this.j.finishUpdate((ViewGroup) this);
            this.g.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((ar) getChildAt(i).getLayoutParams()).a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.k = 0;
            scrollTo(0, 0);
        }
        this.j = bjVar;
        this.b = 0;
        if (this.j != null) {
            if (this.k == -1) {
                if (this.c) {
                    this.k = this.j.getCount() - 1;
                } else {
                    this.k = 0;
                }
            }
            if (this.p == null) {
                this.p = new ax();
            }
            this.j.registerDataSetObserver(this.p);
            this.A = false;
            boolean z = this.U;
            this.U = true;
            this.b = this.j.getCount();
            if (this.l >= 0) {
                this.j.restoreState(this.m, this.n);
                a(this.l, false, true);
                this.l = -1;
                this.m = null;
                this.n = null;
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
        a(i, !this.U, false);
    }

    public void setCurrentItemIndex(int i) {
        this.k = i;
    }

    public void setIsRtl(boolean z) {
        this.c = z;
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

    void setOnAdapterChangeListener(at atVar) {
        this.ae = atVar;
    }

    public void setOnPageChangeListener(au auVar) {
        this.ac = auVar;
    }

    public void setOnPageShownListener(av avVar) {
        this.ab = avVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.q;
        this.q = i;
        int width = getWidth();
        a(width, width, i, i2);
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
