package android.support.v7.app;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;
import android.view.Window.Callback;

final class z implements y {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    private z(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void onCloseMenu(i iVar, boolean z) {
        this.a.a(iVar);
    }

    public final boolean onOpenSubMenu(i iVar) {
        Callback callback = this.a.b.getCallback();
        if (callback != null) {
            callback.onMenuOpened(8, iVar);
        }
        return true;
    }
}
