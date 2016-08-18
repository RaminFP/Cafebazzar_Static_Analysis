package android.support.v7.internal.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;

final class b extends ForwardingListener {
    final /* synthetic */ ActionMenuItemView a;

    public b(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public final ListPopupWindow getPopup() {
        return this.a.f != null ? this.a.f.getPopup() : null;
    }

    protected final boolean onForwardingStarted() {
        if (this.a.d == null || !this.a.d.invokeItem(this.a.a)) {
            return false;
        }
        ListPopupWindow popup = getPopup();
        return popup != null && popup.isShowing();
    }
}
