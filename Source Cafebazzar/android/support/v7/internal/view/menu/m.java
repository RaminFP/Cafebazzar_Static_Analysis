package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.d.a.b;
import android.support.v4.view.ax;
import android.support.v4.view.n;
import android.support.v7.internal.widget.bi;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class m implements b {
    static String f;
    static String g;
    static String h;
    static String i;
    final int a;
    i b;
    int c = 0;
    public n d;
    ContextMenuInfo e;
    private final int j;
    private final int k;
    private final int l;
    private CharSequence m;
    private CharSequence n;
    private Intent o;
    private char p;
    private char q;
    private Drawable r;
    private int s = 0;
    private ad t;
    private Runnable u;
    private OnMenuItemClickListener v;
    private int w = 16;
    private View x;
    private ax y;
    private boolean z = false;

    m(i iVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.b = iVar;
        this.j = i2;
        this.k = i;
        this.l = i3;
        this.a = i4;
        this.m = charSequence;
        this.c = i5;
    }

    private b a(View view) {
        this.x = view;
        this.d = null;
        if (view != null && view.getId() == -1 && this.j > 0) {
            view.setId(this.j);
        }
        this.b.g();
        return this;
    }

    public final b a(ax axVar) {
        this.y = axVar;
        return this;
    }

    public final b a(n nVar) {
        if (this.d != null) {
            this.d.setVisibilityListener(null);
        }
        this.x = null;
        this.d = nVar;
        this.b.b(true);
        if (this.d != null) {
            this.d.setVisibilityListener(new n(this));
        }
        return this;
    }

    public final n a() {
        return this.d;
    }

    final CharSequence a(aa aaVar) {
        return (aaVar == null || !aaVar.a()) ? getTitle() : getTitleCondensed();
    }

    final void a(ad adVar) {
        this.t = adVar;
        adVar.setHeaderTitle(getTitle());
    }

    public final void a(boolean z) {
        this.w = (z ? 4 : 0) | (this.w & -5);
    }

    final void b(boolean z) {
        int i = this.w;
        this.w = (z ? 2 : 0) | (this.w & -3);
        if (i != this.w) {
            this.b.b(false);
        }
    }

    public final boolean b() {
        if ((this.v != null && this.v.onMenuItemClick(this)) || this.b.a(this.b.k(), (MenuItem) this)) {
            return true;
        }
        if (this.u != null) {
            this.u.run();
            return true;
        }
        if (this.o != null) {
            try {
                this.b.a.startActivity(this.o);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.d != null && this.d.onPerformDefaultAction();
    }

    final char c() {
        return this.b.b() ? this.q : this.p;
    }

    final boolean c(boolean z) {
        int i = this.w;
        this.w = (z ? 0 : 8) | (this.w & -9);
        return i != this.w;
    }

    public final boolean collapseActionView() {
        if ((this.c & 8) != 0) {
            if (this.x == null) {
                return true;
            }
            if (this.y == null || this.y.b(this)) {
                return this.b.b(this);
            }
        }
        return false;
    }

    public final void d(boolean z) {
        if (z) {
            this.w |= 32;
        } else {
            this.w &= -33;
        }
    }

    final boolean d() {
        return this.b.c() && c() != '\u0000';
    }

    public final void e(boolean z) {
        this.z = z;
        this.b.b(false);
    }

    public final boolean e() {
        return (this.w & 4) != 0;
    }

    public final boolean expandActionView() {
        return (i() && (this.y == null || this.y.a(this))) ? this.b.a(this) : false;
    }

    public final boolean f() {
        return (this.w & 32) == 32;
    }

    public final boolean g() {
        return (this.c & 1) == 1;
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView() {
        if (this.x != null) {
            return this.x;
        }
        if (this.d == null) {
            return null;
        }
        this.x = this.d.onCreateActionView(this);
        return this.x;
    }

    public final char getAlphabeticShortcut() {
        return this.q;
    }

    public final int getGroupId() {
        return this.k;
    }

    public final Drawable getIcon() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s == 0) {
            return null;
        }
        Drawable a = bi.a(this.b.a, this.s);
        this.s = 0;
        this.r = a;
        return a;
    }

    public final Intent getIntent() {
        return this.o;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.j;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.e;
    }

    public final char getNumericShortcut() {
        return this.p;
    }

    public final int getOrder() {
        return this.l;
    }

    public final SubMenu getSubMenu() {
        return this.t;
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.m;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.n != null ? this.n : this.m;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public final boolean h() {
        return (this.c & 2) == 2;
    }

    public final boolean hasSubMenu() {
        return this.t != null;
    }

    public final boolean i() {
        if ((this.c & 8) == 0) {
            return false;
        }
        if (this.x == null && this.d != null) {
            this.x = this.d.onCreateActionView(this);
        }
        return this.x != null;
    }

    public final boolean isActionViewExpanded() {
        return this.z;
    }

    public final boolean isCheckable() {
        return (this.w & 1) == 1;
    }

    public final boolean isChecked() {
        return (this.w & 2) == 2;
    }

    public final boolean isEnabled() {
        return (this.w & 16) != 0;
    }

    public final boolean isVisible() {
        if (this.d == null || !this.d.overridesItemVisibility()) {
            if ((this.w & 8) != 0) {
                return false;
            }
        } else if (!((this.w & 8) == 0 && this.d.isVisible())) {
            return false;
        }
        return true;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.b.a;
        a(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.q != c) {
            this.q = Character.toLowerCase(c);
            this.b.b(false);
        }
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.w;
        this.w = (z ? 1 : 0) | (this.w & -2);
        if (i != this.w) {
            this.b.b(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.w & 4) != 0) {
            i iVar = this.b;
            int groupId = getGroupId();
            int size = iVar.c.size();
            for (int i = 0; i < size; i++) {
                m mVar = (m) iVar.c.get(i);
                if (mVar.getGroupId() == groupId && mVar.e() && mVar.isCheckable()) {
                    mVar.b(mVar == this);
                }
            }
        } else {
            b(z);
        }
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.w |= 16;
        } else {
            this.w &= -17;
        }
        this.b.b(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.r = null;
        this.s = i;
        this.b.b(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.s = 0;
        this.r = drawable;
        this.b.b(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.o = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.p != c) {
            this.p = c;
            this.b.b(false);
        }
        return this;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.v = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.p = c;
        this.q = Character.toLowerCase(c2);
        this.b.b(false);
        return this;
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.c = i;
                this.b.g();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.b.a.getString(i));
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.m = charSequence;
        this.b.b(false);
        if (this.t != null) {
            this.t.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.n = charSequence;
        this.b.b(false);
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.b.f();
        }
        return this;
    }

    public final String toString() {
        return this.m.toString();
    }
}
