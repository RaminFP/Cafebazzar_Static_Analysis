package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ay;
import android.support.v4.view.bp;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final b a = new b();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float[] e = new float[]{0.0f, 0.0f};
    private float[] f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int g;
    private int h;
    private float[] i = new float[]{0.0f, 0.0f};
    private float[] j = new float[]{0.0f, 0.0f};
    private float[] k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    public a(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        float f2 = (float) i;
        this.k[0] = f / 1000.0f;
        this.k[1] = f2 / 1000.0f;
        f2 = (float) i2;
        float f3 = (float) i2;
        this.j[0] = f2 / 1000.0f;
        this.j[1] = f3 / 1000.0f;
        this.g = 1;
        this.f[0] = Float.MAX_VALUE;
        this.f[1] = Float.MAX_VALUE;
        this.e[0] = 0.2f;
        this.e[1] = 0.2f;
        this.i[0] = 0.001f;
        this.i[1] = 0.001f;
        this.h = r;
        this.a.a = 500;
        this.a.b = 500;
    }

    private float a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case 0:
            case 1:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.o && this.g == 1) ? 1.0f : 0.0f : 0.0f;
            case 2:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float b = b(this.e[i] * f2, 0.0f, this.f[i]);
        b = a(f2 - f, b) - a(f, b);
        if (b < 0.0f) {
            b = -this.b.getInterpolation(-b);
        } else if (b > 0.0f) {
            b = this.b.getInterpolation(b);
        } else {
            b = 0.0f;
            if (b == 0.0f) {
                return 0.0f;
            }
            float f4 = this.i[i];
            float f5 = this.j[i];
            float f6 = this.k[i];
            f4 *= f3;
            return b <= 0.0f ? b(b * f4, f5, f6) : -b((-b) * f4, f5, f6);
        }
        b = b(b, -1.0f, 1.0f);
        if (b == 0.0f) {
            return 0.0f;
        }
        float f42 = this.i[i];
        float f52 = this.j[i];
        float f62 = this.k[i];
        f42 *= f3;
        if (b <= 0.0f) {
        }
    }

    private boolean a() {
        b bVar = this.a;
        int abs = (int) (bVar.d / Math.abs(bVar.d));
        int abs2 = (int) (bVar.c / Math.abs(bVar.c));
        if (abs != 0 && b(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private void b() {
        if (this.m) {
            this.o = false;
            return;
        }
        b bVar = this.a;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - bVar.e);
        int i2 = bVar.b;
        if (i <= i2) {
            i2 = i < 0 ? 0 : i;
        }
        bVar.k = i2;
        bVar.j = bVar.a(currentAnimationTimeMillis);
        bVar.i = currentAnimationTimeMillis;
    }

    static /* synthetic */ void f(a aVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        aVar.c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final a a(boolean z) {
        if (this.p && !z) {
            b();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i);

    public abstract boolean b(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.p) {
            switch (ay.a(motionEvent)) {
                case 0:
                    this.n = true;
                    this.l = false;
                    break;
                case 1:
                case 3:
                    b();
                    break;
                case 2:
                    break;
            }
            float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.c.getWidth());
            float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.c.getHeight());
            b bVar = this.a;
            bVar.c = a;
            bVar.d = a2;
            if (!this.o && a()) {
                if (this.d == null) {
                    this.d = new c();
                }
                this.o = true;
                this.m = true;
                if (this.l || this.h <= 0) {
                    this.d.run();
                } else {
                    bp.a(this.c, this.d, (long) this.h);
                }
                this.l = true;
            }
            if (this.q && this.o) {
                return true;
            }
        }
        return false;
    }
}
