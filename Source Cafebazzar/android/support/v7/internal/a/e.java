package android.support.v7.internal.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.bp;
import android.support.v4.view.di;
import android.support.v4.view.dy;
import android.support.v4.view.ea;
import android.support.v7.a.g;
import android.support.v7.app.a;
import android.support.v7.e.b;
import android.support.v7.internal.view.i;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.aj;
import android.support.v7.internal.widget.ar;
import android.support.v7.internal.widget.l;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

public class e extends a implements l {
    static final /* synthetic */ boolean h = (!e.class.desiredAssertionStatus());
    private static final boolean i;
    private boolean A;
    private int B = 0;
    private boolean C = true;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G = true;
    private i H;
    private boolean I;
    i a;
    android.support.v7.e.a b;
    b c;
    boolean d;
    final dy e = new f(this);
    final dy f = new g(this);
    final ea g = new h(this);
    private Context j;
    private Context k;
    private Activity l;
    private Dialog m;
    private ActionBarOverlayLayout n;
    private ActionBarContainer o;
    private aj p;
    private ActionBarContextView q;
    private ActionBarContainer r;
    private View s;
    private ar t;
    private ArrayList u = new ArrayList();
    private int v = -1;
    private boolean w;
    private boolean x;
    private ArrayList y = new ArrayList();
    private int z;

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        i = z;
    }

    public e(Activity activity, boolean z) {
        this.l = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.s = decorView.findViewById(16908290);
        }
    }

    public e(Dialog dialog) {
        this.m = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        aj ajVar;
        this.n = (ActionBarOverlayLayout) view.findViewById(g.decor_content_parent);
        if (this.n != null) {
            this.n.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(g.action_bar);
        if (findViewById instanceof aj) {
            ajVar = (aj) findViewById;
        } else if (findViewById instanceof Toolbar) {
            ajVar = ((Toolbar) findViewById).getWrapper();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.p = ajVar;
        this.q = (ActionBarContextView) view.findViewById(g.action_context_bar);
        this.o = (ActionBarContainer) view.findViewById(g.action_bar_container);
        this.r = (ActionBarContainer) view.findViewById(g.split_action_bar);
        if (this.p == null || this.q == null || this.o == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.j = this.p.b();
        this.z = 0;
        if ((this.p.o() & 4) != 0) {
            this.w = true;
        }
        android.support.v7.internal.view.a a = android.support.v7.internal.view.a.a(this.j);
        if (a.a.getApplicationInfo().targetSdkVersion < 14) {
            this.A = a.a();
        } else {
            this.A = a.a();
        }
        if (this.A) {
            this.o.setTabContainer(null);
            this.p.a(this.t);
        } else {
            this.p.a(null);
            this.o.setTabContainer(this.t);
        }
        boolean z = this.p.p() == 2;
        if (this.t != null) {
            if (z) {
                this.t.setVisibility(0);
                if (this.n != null) {
                    bp.u(this.n);
                }
            } else {
                this.t.setVisibility(8);
            }
        }
        aj ajVar2 = this.p;
        boolean z2 = !this.A && z;
        ajVar2.a(z2);
        ActionBarOverlayLayout actionBarOverlayLayout = this.n;
        z = !this.A && z;
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z);
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(null, android.support.v7.a.l.ActionBar, android.support.v7.a.b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(android.support.v7.a.l.ActionBar_hideOnContentScroll, false)) {
            if (this.n.a) {
                this.d = true;
                this.n.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.a.l.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            bp.e(this.o, f);
            if (this.r != null) {
                bp.e(this.r, f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private static boolean b(boolean z, boolean z2, boolean z3) {
        return z3 || !(z || z2);
    }

    private void f(boolean z) {
        float f;
        i iVar;
        di c;
        if (b(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                if (this.H != null) {
                    this.H.b();
                }
                this.o.setVisibility(0);
                if (this.B == 0 && i && (this.I || z)) {
                    bp.b(this.o, 0.0f);
                    f = (float) (-this.o.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.o.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    bp.b(this.o, f);
                    iVar = new i();
                    c = bp.r(this.o).c(0.0f);
                    c.a(this.g);
                    iVar.a(c);
                    if (this.C && this.s != null) {
                        bp.b(this.s, f);
                        iVar.a(bp.r(this.s).c(0.0f));
                    }
                    if (this.r != null && this.z == 1) {
                        bp.b(this.r, (float) this.r.getHeight());
                        this.r.setVisibility(0);
                        iVar.a(bp.r(this.r).c(0.0f));
                    }
                    iVar.a(AnimationUtils.loadInterpolator(this.j, 17432582));
                    iVar.a(250);
                    iVar.a(this.f);
                    this.H = iVar;
                    iVar.a();
                } else {
                    bp.c(this.o, 1.0f);
                    bp.b(this.o, 0.0f);
                    if (this.C && this.s != null) {
                        bp.b(this.s, 0.0f);
                    }
                    if (this.r != null && this.z == 1) {
                        bp.c(this.r, 1.0f);
                        bp.b(this.r, 0.0f);
                        this.r.setVisibility(0);
                    }
                    this.f.onAnimationEnd(null);
                }
                if (this.n != null) {
                    bp.u(this.n);
                }
            }
        } else if (this.G) {
            this.G = false;
            if (this.H != null) {
                this.H.b();
            }
            if (this.B == 0 && i && (this.I || z)) {
                bp.c(this.o, 1.0f);
                this.o.setTransitioning(true);
                iVar = new i();
                f = (float) (-this.o.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.o.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                c = bp.r(this.o).c(f);
                c.a(this.g);
                iVar.a(c);
                if (this.C && this.s != null) {
                    iVar.a(bp.r(this.s).c(f));
                }
                if (this.r != null && this.r.getVisibility() == 0) {
                    bp.c(this.r, 1.0f);
                    iVar.a(bp.r(this.r).c((float) this.r.getHeight()));
                }
                iVar.a(AnimationUtils.loadInterpolator(this.j, 17432581));
                iVar.a(250);
                iVar.a(this.e);
                this.H = iVar;
                iVar.a();
                return;
            }
            this.e.onAnimationEnd(null);
        }
    }

    public final Context a() {
        if (this.k == null) {
            TypedValue typedValue = new TypedValue();
            this.j.getTheme().resolveAttribute(android.support.v7.a.b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.k = new ContextThemeWrapper(this.j, i);
            } else {
                this.k = this.j;
            }
        }
        return this.k;
    }

    public final android.support.v7.e.a a(b bVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.n.setHideOnContentScrollEnabled(false);
        this.q.c();
        android.support.v7.e.a iVar = new i(this, this.q.getContext(), bVar);
        if (!iVar.e()) {
            return null;
        }
        iVar.d();
        this.q.a(iVar);
        e(true);
        if (!(this.r == null || this.z != 1 || this.r.getVisibility() == 0)) {
            this.r.setVisibility(0);
            if (this.n != null) {
                bp.u(this.n);
            }
        }
        this.q.sendAccessibilityEvent(32);
        this.a = iVar;
        return iVar;
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void a(CharSequence charSequence) {
        this.p.a(charSequence);
    }

    public final void a(boolean z) {
        if (!this.w) {
            int i = z ? 4 : 0;
            int o = this.p.o();
            this.w = true;
            this.p.c((i & 4) | (o & -5));
        }
    }

    public final void b(boolean z) {
        this.I = false;
        if (this.H != null) {
            this.H.b();
        }
    }

    public final void c(boolean z) {
        if (z != this.x) {
            this.x = z;
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                this.y.get(i);
            }
        }
    }

    public final boolean c() {
        if (this.p == null || !this.p.c()) {
            return false;
        }
        this.p.d();
        return true;
    }

    public final void d() {
        if (this.E) {
            this.E = false;
            f(true);
        }
    }

    public final void d(boolean z) {
        this.C = z;
    }

    public final void e() {
        if (!this.E) {
            this.E = true;
            f(true);
        }
    }

    public final void e(boolean z) {
        int i = 0;
        if (z) {
            if (!this.F) {
                this.F = true;
                if (this.n != null) {
                    this.n.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.F) {
            this.F = false;
            if (this.n != null) {
                this.n.setShowingForActionMode(false);
            }
            f(false);
        }
        this.p.d(z ? 8 : 0);
        ActionBarContextView actionBarContextView = this.q;
        if (!z) {
            i = 8;
        }
        actionBarContextView.a(i);
    }

    public final void f() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }
}
