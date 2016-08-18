package android.support.v7.internal.view.menu;

import android.support.v4.view.ax;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class r extends f implements ax {
    final /* synthetic */ o a;

    r(o oVar, OnActionExpandListener onActionExpandListener) {
        this.a = oVar;
        super(onActionExpandListener);
    }

    public final boolean a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.d).onMenuItemActionExpand(this.a.a(menuItem));
    }

    public final boolean b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.d).onMenuItemActionCollapse(this.a.a(menuItem));
    }
}
