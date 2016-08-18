package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.view.MenuItem;

final class d implements j {
    final /* synthetic */ b a;

    private d(b bVar) {
        this.a = bVar;
    }

    public final boolean onMenuItemSelected(i iVar, MenuItem menuItem) {
        return false;
    }

    public final void onMenuModeChange(i iVar) {
        if (this.a.b == null) {
            return;
        }
        if (this.a.a.i()) {
            this.a.b.onPanelClosed(8, iVar);
        } else if (this.a.b.onPreparePanel(0, null, iVar)) {
            this.a.b.onMenuOpened(8, iVar);
        }
    }
}
