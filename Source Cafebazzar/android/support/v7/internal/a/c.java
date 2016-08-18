package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;

final class c implements y {
    final /* synthetic */ b a;
    private boolean b;

    private c(b bVar) {
        this.a = bVar;
    }

    public final void onCloseMenu(i iVar, boolean z) {
        if (!this.b) {
            this.b = true;
            this.a.a.n();
            if (this.a.b != null) {
                this.a.b.onPanelClosed(8, iVar);
            }
            this.b = false;
        }
    }

    public final boolean onOpenSubMenu(i iVar) {
        if (this.a.b == null) {
            return false;
        }
        this.a.b.onMenuOpened(8, iVar);
        return true;
    }
}
