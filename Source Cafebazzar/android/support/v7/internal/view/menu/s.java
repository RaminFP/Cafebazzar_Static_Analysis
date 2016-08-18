package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class s extends f implements OnMenuItemClickListener {
    final /* synthetic */ o a;

    s(o oVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.a = oVar;
        super(onMenuItemClickListener);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.d).onMenuItemClick(this.a.a(menuItem));
    }
}
