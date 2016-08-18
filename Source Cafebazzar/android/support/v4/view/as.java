package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.d.a.b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class as {
    static final aw a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            a = new av();
        } else if (i >= 11) {
            a = new au();
        } else {
            a = new at();
        }
    }

    public static MenuItem a(MenuItem menuItem, n nVar) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a(nVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem instanceof b ? ((b) menuItem).setActionView(view) : a.a(menuItem, view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).getActionView() : a.a(menuItem);
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof b) {
            ((b) menuItem).setShowAsAction(i);
        } else {
            a.a(menuItem, i);
        }
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem instanceof b ? ((b) menuItem).setActionView(i) : a.b(menuItem, i);
    }

    public static boolean b(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).expandActionView() : a.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).isActionViewExpanded() : a.c(menuItem);
    }
}
