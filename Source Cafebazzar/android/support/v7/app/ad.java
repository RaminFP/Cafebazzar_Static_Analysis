package android.support.v7.app;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;
import android.view.Menu;
import android.view.Window.Callback;

final class ad implements y {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    private ad(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void onCloseMenu(i iVar, boolean z) {
        Menu menu;
        Menu k = iVar.k();
        boolean z2 = k != iVar;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.a;
        if (z2) {
            menu = k;
        }
        PanelFeatureState a = appCompatDelegateImplV7.a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.a.a(a.a, a, k);
            this.a.a(a, true);
            return;
        }
        this.a.a(a, z);
    }

    public final boolean onOpenSubMenu(i iVar) {
        if (iVar == null && this.a.g) {
            Callback callback = this.a.b.getCallback();
            if (!(callback == null || this.a.m)) {
                callback.onMenuOpened(8, iVar);
            }
        }
        return true;
    }
}
