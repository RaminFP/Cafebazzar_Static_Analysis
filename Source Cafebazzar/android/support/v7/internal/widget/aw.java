package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

final class aw extends ForwardingListener {
    final /* synthetic */ ba a;
    final /* synthetic */ SpinnerCompat b;

    aw(SpinnerCompat spinnerCompat, View view, ba baVar) {
        this.b = spinnerCompat;
        this.a = baVar;
        super(view);
    }

    public final ListPopupWindow getPopup() {
        return this.a;
    }

    public final boolean onForwardingStarted() {
        if (!this.b.H.isShowing()) {
            this.b.H.show();
        }
        return true;
    }
}
