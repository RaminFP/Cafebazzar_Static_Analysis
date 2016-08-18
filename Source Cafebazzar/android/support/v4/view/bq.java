package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import java.util.WeakHashMap;

class bq implements cc {
    WeakHashMap a = null;

    bq() {
    }

    public boolean A(View view) {
        return view.getWindowToken() != null;
    }

    public int a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int a(View view) {
        return 2;
    }

    long a() {
        return 10;
    }

    public eb a(View view, eb ebVar) {
        return ebVar;
    }

    public void a(View view, float f) {
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void a(View view, int i, Paint paint) {
    }

    public void a(View view, Paint paint) {
    }

    public void a(View view, a aVar) {
    }

    public void a(View view, bi biVar) {
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    public void a(View view, boolean z) {
    }

    public boolean a(View view, int i) {
        if (view instanceof bk) {
            boolean z;
            bk bkVar = (bk) view;
            int computeHorizontalScrollOffset = bkVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = bkVar.computeHorizontalScrollRange() - bkVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange != 0) {
                if (i < 0) {
                    z = computeHorizontalScrollOffset > 0;
                } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public eb b(View view, eb ebVar) {
        return ebVar;
    }

    public void b(View view, float f) {
    }

    public void b(View view, boolean z) {
    }

    public boolean b(View view) {
        return false;
    }

    public boolean b(View view, int i) {
        if (view instanceof bk) {
            boolean z;
            bk bkVar = (bk) view;
            int computeVerticalScrollOffset = bkVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = bkVar.computeVerticalScrollRange() - bkVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange != 0) {
                if (i < 0) {
                    z = computeVerticalScrollOffset > 0;
                } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void c(View view, float f) {
    }

    public void c(View view, int i) {
    }

    public boolean c(View view) {
        return false;
    }

    public void d(View view) {
        view.invalidate();
    }

    public void d(View view, float f) {
    }

    public void d(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    public int e(View view) {
        return 0;
    }

    public void e(View view, float f) {
    }

    public void e(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    public float f(View view) {
        return 1.0f;
    }

    public int g(View view) {
        return 0;
    }

    public int h(View view) {
        return 0;
    }

    public boolean i(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int j(View view) {
        return view.getMeasuredWidth();
    }

    public int k(View view) {
        return 0;
    }

    public int l(View view) {
        return view.getPaddingLeft();
    }

    public int m(View view) {
        return view.getPaddingRight();
    }

    public boolean n(View view) {
        return true;
    }

    public float o(View view) {
        return 0.0f;
    }

    public float p(View view) {
        return 0.0f;
    }

    public int q(View view) {
        return cd.a(view);
    }

    public int r(View view) {
        return cd.b(view);
    }

    public di s(View view) {
        return new di(view);
    }

    public int t(View view) {
        return 0;
    }

    public void u(View view) {
    }

    public float v(View view) {
        return 0.0f;
    }

    public boolean w(View view) {
        return false;
    }

    public void x(View view) {
    }

    public void y(View view) {
        if (view instanceof be) {
            ((be) view).stopNestedScroll();
        }
    }

    public boolean z(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }
}
