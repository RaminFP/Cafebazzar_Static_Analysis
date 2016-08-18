package android.support.v7.app;

import android.support.v7.internal.view.k;
import android.support.v7.internal.view.menu.i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class r extends k {
    final /* synthetic */ q a;

    r(q qVar, Callback callback) {
        this.a = qVar;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) ? true : super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent.getKeyCode(), keyEvent) ? true : super.dispatchKeyShortcutEvent(keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof i)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.a.d(i) ? true : super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (!this.a.c(i)) {
            super.onPanelClosed(i, menu);
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        i iVar = menu instanceof i ? (i) menu : null;
        if (i == 0 && iVar == null) {
            return false;
        }
        if (iVar != null) {
            iVar.k = true;
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (iVar == null) {
            return onPreparePanel;
        }
        iVar.k = false;
        return onPreparePanel;
    }
}
