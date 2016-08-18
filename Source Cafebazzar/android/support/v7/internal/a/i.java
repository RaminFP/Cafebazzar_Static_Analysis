package android.support.v7.internal.a;

import android.content.Context;
import android.support.v7.e.a;
import android.support.v7.e.b;
import android.support.v7.internal.view.f;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class i extends a implements j {
    final /* synthetic */ e a;
    private final Context d;
    private final android.support.v7.internal.view.menu.i e;
    private b f;
    private WeakReference g;

    public i(e eVar, Context context, b bVar) {
        this.a = eVar;
        this.d = context;
        this.f = bVar;
        android.support.v7.internal.view.menu.i iVar = new android.support.v7.internal.view.menu.i(context);
        this.e = iVar;
        this.e.a((j) this);
    }

    public final MenuInflater a() {
        return new f(this.d);
    }

    public final void a(int i) {
        b(this.a.j.getResources().getString(i));
    }

    public final void a(View view) {
        this.a.q.setCustomView(view);
        this.g = new WeakReference(view);
    }

    public final void a(CharSequence charSequence) {
        this.a.q.setSubtitle(charSequence);
    }

    public final void a(boolean z) {
        super.a(z);
        this.a.q.setTitleOptional(z);
    }

    public final Menu b() {
        return this.e;
    }

    public final void b(int i) {
        a(this.a.j.getResources().getString(i));
    }

    public final void b(CharSequence charSequence) {
        this.a.q.setTitle(charSequence);
    }

    public final void c() {
        if (this.a.a == this) {
            if (e.b(this.a.D, this.a.E, false)) {
                this.f.a(this);
            } else {
                this.a.b = this;
                this.a.c = this.f;
            }
            this.f = null;
            this.a.e(false);
            ActionBarContextView i = this.a.q;
            if (i.m != 2) {
                if (i.j == null) {
                    i.c();
                } else {
                    i.b();
                    i.m = 2;
                    i.l = i.d();
                    i.l.a();
                }
            }
            this.a.p.a().sendAccessibilityEvent(32);
            this.a.n.setHideOnContentScrollEnabled(this.a.d);
            this.a.a = null;
        }
    }

    public final void d() {
        if (this.a.a == this) {
            this.e.d();
            try {
                this.f.b(this, this.e);
            } finally {
                this.e.e();
            }
        }
    }

    public final boolean e() {
        this.e.d();
        try {
            boolean a = this.f.a((a) this, this.e);
            return a;
        } finally {
            this.e.e();
        }
    }

    public final CharSequence f() {
        return this.a.q.getTitle();
    }

    public final CharSequence g() {
        return this.a.q.getSubtitle();
    }

    public final boolean h() {
        return this.a.q.k;
    }

    public final View i() {
        return this.g != null ? (View) this.g.get() : null;
    }

    public final boolean onMenuItemSelected(android.support.v7.internal.view.menu.i iVar, MenuItem menuItem) {
        return this.f != null ? this.f.a((a) this, menuItem) : false;
    }

    public final void onMenuModeChange(android.support.v7.internal.view.menu.i iVar) {
        if (this.f != null) {
            d();
            this.a.q.a();
        }
    }
}
