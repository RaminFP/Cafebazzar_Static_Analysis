package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.view.Menu;
import android.view.MenuItem;

public final class ab {
    public static Menu a(Context context, a aVar) {
        if (VERSION.SDK_INT >= 14) {
            return new ac(context, aVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem a(Context context, b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new t(context, bVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new o(context, bVar);
        }
        throw new UnsupportedOperationException();
    }
}
