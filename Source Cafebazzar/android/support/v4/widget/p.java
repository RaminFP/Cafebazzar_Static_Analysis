package android.support.v4.widget;

import android.support.v4.view.bl;
import android.view.View;

final class p extends ay {
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private aw c;
    private final Runnable d;

    public final void a() {
        this.a.removeCallbacks(this.d);
    }

    public final void a(int i) {
        DrawerLayout drawerLayout = this.a;
        View view = this.c.l;
        int i2 = drawerLayout.a.a;
        int i3 = drawerLayout.b.a;
        i3 = (i2 == 1 || i3 == 1) ? 1 : (i2 == 2 || i3 == 2) ? 2 : 0;
        if (view != null && i == 0) {
            n nVar = (n) view.getLayoutParams();
            if (nVar.b == 0.0f) {
                nVar = (n) view.getLayoutParams();
                if ((nVar.d & 1) == 1) {
                    nVar.d = 0;
                    if (drawerLayout.d != null) {
                        for (i2 = drawerLayout.d.size() - 1; i2 >= 0; i2--) {
                            ((m) drawerLayout.d.get(i2)).onDrawerClosed(view);
                        }
                    }
                    drawerLayout.a(view, false);
                    if (drawerLayout.hasWindowFocus()) {
                        View rootView = drawerLayout.getRootView();
                        if (rootView != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                }
            } else if (nVar.b == 1.0f) {
                nVar = (n) view.getLayoutParams();
                if ((nVar.d & 1) == 0) {
                    nVar.d = 1;
                    if (drawerLayout.d != null) {
                        for (i2 = drawerLayout.d.size() - 1; i2 >= 0; i2--) {
                            ((m) drawerLayout.d.get(i2)).onDrawerOpened(view);
                        }
                    }
                    drawerLayout.a(view, true);
                    if (drawerLayout.hasWindowFocus()) {
                        drawerLayout.sendAccessibilityEvent(32);
                    }
                    view.requestFocus();
                }
            }
        }
        if (i3 != drawerLayout.c) {
            drawerLayout.c = i3;
            if (drawerLayout.d != null) {
                for (i2 = drawerLayout.d.size() - 1; i2 >= 0; i2--) {
                    ((m) drawerLayout.d.get(i2)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    public final void a(int i, int i2) {
        View a = (i & 1) == 1 ? this.a.a(3) : this.a.a(5);
        if (a != null && this.a.a(a) == 0) {
            this.c.a(a, i2);
        }
    }

    public final void a(View view, float f) {
        int i;
        float b = DrawerLayout.b(view);
        int width = view.getWidth();
        if (this.a.a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && b > 0.5f)) ? 0 : -width;
        } else {
            i = this.a.getWidth();
            if (f < 0.0f || (f == 0.0f && b > 0.5f)) {
                i -= width;
            }
        }
        aw awVar = this.c;
        width = view.getTop();
        if (awVar.m) {
            awVar.a(i, width, (int) bl.a(awVar.i, awVar.c), (int) bl.b(awVar.i, awVar.c));
            this.a.invalidate();
            return;
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final void a(View view, int i) {
        int width = view.getWidth();
        float width2 = this.a.a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.a.getWidth() - i)) / ((float) width);
        this.a.a(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.a.invalidate();
    }

    public final boolean a(View view) {
        return DrawerLayout.c(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }

    public final int b(View view, int i) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public final void b() {
        this.a.postDelayed(this.d, 160);
    }

    public final void b(View view) {
        ((n) view.getLayoutParams()).c = false;
        View a = this.a.a(this.b == 3 ? 5 : 3);
        if (a != null) {
            this.a.e(a);
        }
    }

    public final int c(View view) {
        return DrawerLayout.c(view) ? view.getWidth() : 0;
    }

    public final int d(View view) {
        return view.getTop();
    }
}
