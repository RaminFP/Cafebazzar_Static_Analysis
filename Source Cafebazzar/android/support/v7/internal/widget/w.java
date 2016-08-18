package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

final class w extends ForwardingListener {
    final /* synthetic */ ActivityChooserView a;

    w(ActivityChooserView activityChooserView, View view) {
        this.a = activityChooserView;
        super(view);
    }

    public final ListPopupWindow getPopup() {
        return this.a.getListPopupWindow();
    }

    protected final boolean onForwardingStarted() {
        this.a.a();
        return true;
    }

    protected final boolean onForwardingStopped() {
        this.a.b();
        return true;
    }
}
