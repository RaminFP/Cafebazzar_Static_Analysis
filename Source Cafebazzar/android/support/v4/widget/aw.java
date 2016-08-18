package android.support.v4.widget;

import android.support.v4.view.ay;
import android.support.v4.view.bl;
import android.support.v4.view.bp;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class aw {
    private static final Interpolator v = new ax();
    int a;
    int b;
    int c;
    float[] d;
    float[] e;
    float[] f;
    float[] g;
    int h;
    VelocityTracker i;
    int j;
    int k;
    View l;
    boolean m;
    private int[] n;
    private int[] o;
    private int[] p;
    private float q;
    private float r;
    private aj s;
    private final ay t;
    private final ViewGroup u;
    private final Runnable w;

    private static float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float f = (float) i4;
        float f2 = (float) i4;
        float sin = (float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)));
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(((sin * f2) + f) / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private void a(float f, float f2) {
        this.m = true;
        this.t.a(this.l, f);
        this.m = false;
        if (this.a == 1) {
            b(0);
        }
    }

    private void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.d == null || this.d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.d != null) {
                System.arraycopy(this.d, 0, obj, 0, this.d.length);
                System.arraycopy(this.e, 0, obj2, 0, this.e.length);
                System.arraycopy(this.f, 0, obj3, 0, this.f.length);
                System.arraycopy(this.g, 0, obj4, 0, this.g.length);
                System.arraycopy(this.n, 0, obj5, 0, this.n.length);
                System.arraycopy(this.o, 0, obj6, 0, this.o.length);
                System.arraycopy(this.p, 0, obj7, 0, this.p.length);
            }
            this.d = obj;
            this.e = obj2;
            this.f = obj3;
            this.g = obj4;
            this.n = obj5;
            this.o = obj6;
            this.p = obj7;
        }
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        fArr = this.e;
        this.g[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.n;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.u.getLeft() + this.j) {
            i2 = 1;
        }
        if (i4 < this.u.getTop() + this.j) {
            i2 |= 4;
        }
        if (i3 > this.u.getRight() - this.j) {
            i2 |= 2;
        }
        if (i4 > this.u.getBottom() - this.j) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.h |= 1 << i;
    }

    private void a(int i) {
        if (this.d != null) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.n[i] = 0;
            this.o[i] = 0;
            this.p[i] = 0;
            this.h &= (1 << i) ^ -1;
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        return ((this.n[i] & i2) != i2 || (this.k & i2) == 0 || (this.p[i] & i2) == i2 || (this.o[i] & i2) == i2 || ((abs <= ((float) this.b) && Math.abs(f2) <= ((float) this.b)) || (this.o[i] & i2) != 0 || abs <= ((float) this.b))) ? false : true;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        return (this.t.c(view) > 0) && Math.abs(f) > ((float) this.b);
    }

    private static int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.o;
            iArr[i] = iArr[i] | i2;
            this.t.a(i2, i);
        }
    }

    private void b(int i) {
        this.u.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.t.a(i);
            if (this.a == 0) {
                this.l = null;
            }
        }
    }

    private boolean b(View view, int i) {
        if (view == this.l && this.c == i) {
            return true;
        }
        if (view == null || !this.t.a(view)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    public static boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    private void c() {
        this.i.computeCurrentVelocity(1000, this.q);
        a(a(bl.a(this.i, this.c), this.r, this.q), a(bl.b(this.i, this.c), this.r, this.q));
    }

    private void c(MotionEvent motionEvent) {
        int c = ay.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = ay.b(motionEvent, i);
            float c2 = ay.c(motionEvent, i);
            float d = ay.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }

    public final View a(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final void a() {
        this.c = -1;
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.n, 0);
            Arrays.fill(this.o, 0);
            Arrays.fill(this.p, 0);
            this.h = 0;
        }
        if (this.i != null) {
            this.i.recycle();
            this.i = null;
        }
    }

    public final void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.l = view;
        this.c = i;
        this.t.b(view);
        b(1);
    }

    boolean a(int i, int i2, int i3, int i4) {
        int left = this.l.getLeft();
        int top = this.l.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.s.h();
            b(0);
            return false;
        }
        View view = this.l;
        int b = b(i3, (int) this.r, (int) this.q);
        int b2 = b(i4, (int) this.r, (int) this.q);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.s.a(left, top, i5, i6, (int) (((b2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) a(i6, b2, 0))) + ((b != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) a(i5, b, this.t.c(view))))));
        b(2);
        return true;
    }

    public final boolean a(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        int b = ay.b(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.i == null) {
            this.i = VelocityTracker.obtain();
        }
        this.i.addMovement(motionEvent);
        float x;
        float y;
        int b2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = ay.b(motionEvent, 0);
                a(x, y, b2);
                View a2 = a((int) x, (int) y);
                if (a2 == this.l && this.a == 2) {
                    b(a2, b2);
                }
                if ((this.n[b2] & this.k) != 0) {
                    this.t.b();
                    break;
                }
                break;
            case 1:
            case 3:
                a();
                break;
            case 2:
                if (!(this.d == null || this.e == null)) {
                    b2 = ay.c(motionEvent);
                    b = 0;
                    while (b < b2) {
                        int b3 = ay.b(motionEvent, b);
                        x = ay.c(motionEvent, b);
                        float d = ay.d(motionEvent, b);
                        float f = x - this.d[b3];
                        float f2 = d - this.e[b3];
                        View a3 = a((int) x, (int) d);
                        boolean z = a3 != null && a(a3, f, f2);
                        if (z) {
                            int left = a3.getLeft();
                            int b4 = this.t.b(a3, ((int) f) + left);
                            a3.getTop();
                            this.t.d(a3);
                            int c = this.t.c(a3);
                            if (c != 0) {
                                if (c > 0 && b4 == left) {
                                }
                            }
                            c(motionEvent);
                            break;
                        }
                        b(f, f2, b3);
                        if (!(this.a == 1 || (z && b(a3, b3)))) {
                            b++;
                        }
                        c(motionEvent);
                    }
                    c(motionEvent);
                }
                break;
            case 5:
                a = ay.b(motionEvent, b);
                float c2 = ay.c(motionEvent, b);
                y = ay.d(motionEvent, b);
                a(c2, y, a);
                if (this.a != 0) {
                    if (this.a == 2) {
                        View a4 = a((int) c2, (int) y);
                        if (a4 == this.l) {
                            b(a4, a);
                            break;
                        }
                    }
                } else if ((this.n[a] & this.k) != 0) {
                    this.t.b();
                    break;
                }
                break;
            case 6:
                a(ay.b(motionEvent, b));
                break;
        }
        return this.a == 1;
    }

    public final boolean a(View view, int i, int i2) {
        this.l = view;
        this.c = -1;
        boolean a = a(i, i2, 0, 0);
        if (!(a || this.a != 0 || this.l == null)) {
            this.l = null;
        }
        return a;
    }

    public final boolean a(boolean z) {
        if (this.a == 2) {
            boolean g = this.s.g();
            int b = this.s.b();
            int c = this.s.c();
            int left = b - this.l.getLeft();
            int top = c - this.l.getTop();
            if (left != 0) {
                bp.e(this.l, left);
            }
            if (top != 0) {
                bp.d(this.l, top);
            }
            if (!(left == 0 && top == 0)) {
                this.t.a(this.l, b);
            }
            if (g && b == this.s.d() && c == this.s.e()) {
                this.s.h();
                g = false;
            }
            if (!g) {
                this.u.post(this.w);
            }
        }
        return this.a == 2;
    }

    public final void b() {
        a();
        if (this.a == 2) {
            this.s.b();
            this.s.c();
            this.s.h();
            int b = this.s.b();
            this.s.c();
            this.t.a(this.l, b);
        }
        b(0);
    }

    public final void b(MotionEvent motionEvent) {
        int i = 0;
        int a = ay.a(motionEvent);
        int b = ay.b(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.i == null) {
            this.i = VelocityTracker.obtain();
        }
        this.i.addMovement(motionEvent);
        float x;
        float y;
        View a2;
        int top;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = ay.b(motionEvent, 0);
                a2 = a((int) x, (int) y);
                a(x, y, i);
                b(a2, i);
                if ((this.n[i] & this.k) != 0) {
                    this.t.b();
                    return;
                }
                return;
            case 1:
                if (this.a == 1) {
                    c();
                }
                a();
                return;
            case 2:
                int i2;
                if (this.a == 1) {
                    i = ay.a(motionEvent, this.c);
                    x = ay.c(motionEvent, i);
                    i2 = (int) (x - this.f[this.c]);
                    a = (int) (ay.d(motionEvent, i) - this.g[this.c]);
                    i = this.l.getLeft() + i2;
                    this.l.getTop();
                    b = this.l.getLeft();
                    top = this.l.getTop();
                    if (i2 != 0) {
                        i = this.t.b(this.l, i);
                        bp.e(this.l, i - b);
                    }
                    if (a != 0) {
                        bp.d(this.l, this.t.d(this.l) - top);
                    }
                    if (!(i2 == 0 && a == 0)) {
                        this.t.a(this.l, i);
                    }
                    c(motionEvent);
                    return;
                }
                i2 = ay.c(motionEvent);
                while (i < i2) {
                    a = ay.b(motionEvent, i);
                    float c = ay.c(motionEvent, i);
                    float d = ay.d(motionEvent, i);
                    float f = c - this.d[a];
                    float f2 = d - this.e[a];
                    b(f, f2, a);
                    if (this.a != 1) {
                        a2 = a((int) c, (int) d);
                        if (!a(a2, f, f2) || !b(a2, a)) {
                            i++;
                        }
                    }
                    c(motionEvent);
                    return;
                }
                c(motionEvent);
                return;
            case 3:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                a();
                return;
            case 5:
                i = ay.b(motionEvent, b);
                x = ay.c(motionEvent, b);
                y = ay.d(motionEvent, b);
                a(x, y, i);
                if (this.a == 0) {
                    b(a((int) x, (int) y), i);
                    if ((this.n[i] & this.k) != 0) {
                        this.t.b();
                        return;
                    }
                    return;
                }
                if (b(this.l, (int) x, (int) y)) {
                    b(this.l, i);
                    return;
                }
                return;
            case 6:
                a = ay.b(motionEvent, b);
                if (this.a == 1 && a == this.c) {
                    b = ay.c(motionEvent);
                    while (i < b) {
                        top = ay.b(motionEvent, i);
                        if (top != this.c) {
                            if (a((int) ay.c(motionEvent, i), (int) ay.d(motionEvent, i)) == this.l && b(this.l, top)) {
                                i = this.c;
                                if (i == -1) {
                                    c();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        c();
                    }
                }
                a(a);
                return;
            default:
                return;
        }
    }
}
