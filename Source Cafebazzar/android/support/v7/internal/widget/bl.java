package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.a.b;
import android.support.v7.a.f;
import android.support.v7.a.g;
import android.support.v7.a.j;
import android.support.v7.a.l;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class bl implements aj {
    Toolbar a;
    CharSequence b;
    Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private final bi p;
    private int q;
    private Drawable r;

    public bl(Toolbar toolbar, boolean z) {
        this(toolbar, true, j.abc_action_bar_up_description, f.abc_ic_ab_back_mtrl_am_alpha);
    }

    private bl(Toolbar toolbar, boolean z, int i, int i2) {
        int i3;
        this.o = 0;
        this.q = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        if (z) {
            bk a = bk.a(toolbar.getContext(), null, l.ActionBar, b.actionBarStyle, 0);
            CharSequence c = a.c(l.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                this.k = true;
                b(c);
            }
            CharSequence c2 = a.c(l.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                this.l = c2;
                if ((this.e & 8) != 0) {
                    this.a.setSubtitle(c2);
                }
            }
            Drawable a2 = a.a(l.ActionBar_logo);
            if (a2 != null) {
                b(a2);
            }
            a2 = a.a(l.ActionBar_icon);
            if (this.j == null && a2 != null) {
                a(a2);
            }
            a2 = a.a(l.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                this.j = a2;
                t();
            }
            c(a.a(l.ActionBar_displayOptions, 0));
            int e = a.e(l.ActionBar_customNavigationLayout, 0);
            if (e != 0) {
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(e, this.a, false);
                if (!(this.g == null || (this.e & 16) == 0)) {
                    this.a.removeView(this.g);
                }
                this.g = inflate;
                if (!(inflate == null || (this.e & 16) == 0)) {
                    this.a.addView(this.g);
                }
                c(this.e | 16);
            }
            e = a.d(l.ActionBar_height, 0);
            if (e > 0) {
                LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = e;
                this.a.setLayoutParams(layoutParams);
            }
            e = a.b(l.ActionBar_contentInsetStart, -1);
            int b = a.b(l.ActionBar_contentInsetEnd, -1);
            if (e >= 0 || b >= 0) {
                this.a.setContentInsetsRelative(Math.max(e, 0), Math.max(b, 0));
            }
            e = a.e(l.ActionBar_titleTextStyle, 0);
            if (e != 0) {
                this.a.setTitleTextAppearance(this.a.getContext(), e);
            }
            e = a.e(l.ActionBar_subtitleTextStyle, 0);
            if (e != 0) {
                this.a.setSubtitleTextAppearance(this.a.getContext(), e);
            }
            e = a.e(l.ActionBar_popupTheme, 0);
            if (e != 0) {
                this.a.setPopupTheme(e);
            }
            a.a.recycle();
            this.p = a.a();
        } else {
            i3 = 11;
            if (this.a.getNavigationIcon() != null) {
                i3 = 15;
            }
            this.e = i3;
            this.p = bi.a(toolbar.getContext());
        }
        if (i != this.q) {
            this.q = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                i3 = this.q;
                this.m = i3 == 0 ? null : this.a.getContext().getString(i3);
                s();
            }
        }
        this.m = this.a.getNavigationContentDescription();
        Drawable a3 = this.p.a(i2, false);
        if (this.r != a3) {
            this.r = a3;
            t();
        }
        this.a.setNavigationOnClickListener(new bm(this));
    }

    private void b(Drawable drawable) {
        this.i = drawable;
        r();
    }

    private void b(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void r() {
        Drawable drawable = null;
        if ((this.e & 2) != 0) {
            drawable = (this.e & 1) != 0 ? this.i != null ? this.i : this.h : this.h;
        }
        this.a.setLogo(drawable);
    }

    private void s() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.a.setNavigationContentDescription(this.q);
        } else {
            this.a.setNavigationContentDescription(this.m);
        }
    }

    private void t() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.j != null ? this.j : this.r);
        }
    }

    public final ViewGroup a() {
        return this.a;
    }

    public final void a(int i) {
        a(i != 0 ? this.p.a(i, false) : null);
    }

    public final void a(Drawable drawable) {
        this.h = drawable;
        r();
    }

    public final void a(y yVar, android.support.v7.internal.view.menu.j jVar) {
        this.a.setMenuCallbacks(yVar, jVar);
    }

    public final void a(ar arVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = arVar;
        if (arVar != null && this.o == 2) {
            this.a.addView(this.f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            arVar.setAllowCollapse(true);
        }
    }

    public final void a(Menu menu, y yVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.a.getContext());
            this.n.setId(g.action_menu_presenter);
        }
        this.n.setCallback(yVar);
        this.a.setMenu((i) menu, this.n);
    }

    public final void a(Callback callback) {
        this.c = callback;
    }

    public final void a(CharSequence charSequence) {
        if (!this.k) {
            b(charSequence);
        }
    }

    public final void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public final Context b() {
        return this.a.getContext();
    }

    public final void b(int i) {
        b(i != 0 ? this.p.a(i, false) : null);
    }

    public final void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    t();
                    s();
                } else {
                    this.a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                r();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.g != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.g);
                } else {
                    this.a.removeView(this.g);
                }
            }
        }
    }

    public final boolean c() {
        return this.a.hasExpandedActionView();
    }

    public final void d() {
        this.a.collapseActionView();
    }

    public final void d(int i) {
        if (i == 8) {
            bp.r(this.a).a(0.0f).a(new bn(this));
        } else if (i == 0) {
            bp.r(this.a).a(1.0f).a(new bo(this));
        }
    }

    public final CharSequence e() {
        return this.a.getTitle();
    }

    public final void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final boolean h() {
        return this.a.canShowOverflowMenu();
    }

    public final boolean i() {
        return this.a.isOverflowMenuShowing();
    }

    public final boolean j() {
        return this.a.isOverflowMenuShowPending();
    }

    public final boolean k() {
        return this.a.showOverflowMenu();
    }

    public final boolean l() {
        return this.a.hideOverflowMenu();
    }

    public final void m() {
        this.d = true;
    }

    public final void n() {
        this.a.dismissPopupMenus();
    }

    public final int o() {
        return this.e;
    }

    public final int p() {
        return this.o;
    }

    public final Menu q() {
        return this.a.getMenu();
    }
}
