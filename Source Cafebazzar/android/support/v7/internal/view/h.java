package android.support.v7.internal.view;

import android.support.v4.d.a.b;
import android.support.v4.view.as;
import android.support.v4.view.n;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.o;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class h {
    Menu a;
    int b;
    int c;
    int d;
    int e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    int j;
    CharSequence k;
    CharSequence l;
    int m;
    char n;
    char o;
    int p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    int u;
    String v;
    String w;
    String x;
    n y;
    final /* synthetic */ f z;

    public h(f fVar, Menu menu) {
        this.z = fVar;
        this.a = menu;
        a();
    }

    static char a(String str) {
        return str == null ? '\u0000' : str.charAt(0);
    }

    Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            return this.z.e.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void a() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = true;
    }

    void a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.q).setVisible(this.r).setEnabled(this.s).setCheckable(this.p > 0).setTitleCondensed(this.l).setIcon(this.m).setAlphabeticShortcut(this.n).setNumericShortcut(this.o);
        if (this.t >= 0) {
            as.a(menuItem, this.t);
        }
        if (this.x != null) {
            if (this.z.e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new g(f.b(this.z), this.x));
        }
        if (this.p >= 2) {
            if (menuItem instanceof m) {
                ((m) menuItem).a(true);
            } else if (menuItem instanceof o) {
                o oVar = (o) menuItem;
                try {
                    if (oVar.e == null) {
                        oVar.e = ((b) oVar.d).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                    }
                    oVar.e.invoke(oVar.d, new Object[]{Boolean.valueOf(true)});
                } catch (Throwable e) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                }
            }
        }
        if (this.v != null) {
            as.a(menuItem, (View) a(this.v, f.a, this.z.c));
        } else {
            z = false;
        }
        if (this.u > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                as.b(menuItem, this.u);
            }
        }
        if (this.y != null) {
            as.a(menuItem, this.y);
        }
    }

    public final SubMenu b() {
        this.h = true;
        SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
        a(addSubMenu.getItem());
        return addSubMenu;
    }
}
