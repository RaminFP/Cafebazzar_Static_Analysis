package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class au implements aw {
    au() {
    }

    public final MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public final View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public final void a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public final MenuItem b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public boolean c(MenuItem menuItem) {
        return false;
    }
}
