package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.d.a.a;
import android.support.v4.f.r;
import android.support.v7.e.b;
import android.support.v7.internal.view.menu.ab;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class e implements b {
    final Callback a;
    final Context b;
    final ArrayList c = new ArrayList();
    final r d = new r();

    public e(Context context, Callback callback) {
        this.b = context;
        this.a = callback;
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu) this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.a(this.b, (a) menu);
        this.d.put(menu, menu2);
        return menu2;
    }

    public final void a(android.support.v7.e.a aVar) {
        this.a.onDestroyActionMode(b(aVar));
    }

    public final boolean a(android.support.v7.e.a aVar, Menu menu) {
        return this.a.onCreateActionMode(b(aVar), a(menu));
    }

    public final boolean a(android.support.v7.e.a aVar, MenuItem menuItem) {
        return this.a.onActionItemClicked(b(aVar), ab.a(this.b, (android.support.v4.d.a.b) menuItem));
    }

    public final ActionMode b(android.support.v7.e.a aVar) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.c.get(i);
            if (dVar != null && dVar.b == aVar) {
                return dVar;
            }
        }
        ActionMode dVar2 = new d(this.b, aVar);
        this.c.add(dVar2);
        return dVar2;
    }

    public final boolean b(android.support.v7.e.a aVar, Menu menu) {
        return this.a.onPrepareActionMode(b(aVar), a(menu));
    }
}
