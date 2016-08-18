package android.support.v7.app;

import android.support.v4.view.bp;
import android.support.v7.e.a;
import android.support.v7.e.b;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

final class aa implements b {
    final /* synthetic */ AppCompatDelegateImplV7 a;
    private b b;

    public aa(AppCompatDelegateImplV7 appCompatDelegateImplV7, b bVar) {
        this.a = appCompatDelegateImplV7;
        this.b = bVar;
    }

    public final void a(a aVar) {
        this.b.a(aVar);
        if (this.a.q != null) {
            this.a.b.getDecorView().removeCallbacks(this.a.r);
            this.a.q.dismiss();
        } else if (this.a.p != null) {
            this.a.p.setVisibility(8);
            if (this.a.p.getParent() != null) {
                bp.u((View) this.a.p.getParent());
            }
        }
        if (this.a.p != null) {
            this.a.p.removeAllViews();
        }
        this.a.o = null;
    }

    public final boolean a(a aVar, Menu menu) {
        return this.b.a(aVar, menu);
    }

    public final boolean a(a aVar, MenuItem menuItem) {
        return this.b.a(aVar, menuItem);
    }

    public final boolean b(a aVar, Menu menu) {
        return this.b.b(aVar, menu);
    }
}
