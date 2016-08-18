package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.d.a.b;
import android.support.v4.d.a.c;
import android.support.v4.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class e extends f {
    final Context a;
    Map b;
    Map c;

    e(Context context, Object obj) {
        super(obj);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.b == null) {
            this.b = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ab.a(this.a, bVar);
        this.b.put(bVar, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.c == null) {
            this.c = new a();
        }
        SubMenu subMenu2 = (SubMenu) this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        Context context = this.a;
        if (VERSION.SDK_INT >= 14) {
            subMenu2 = new ae(context, cVar);
            this.c.put(cVar, subMenu2);
            return subMenu2;
        }
        throw new UnsupportedOperationException();
    }
}
