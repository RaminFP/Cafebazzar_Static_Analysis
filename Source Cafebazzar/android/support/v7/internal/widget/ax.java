package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ax implements OnGlobalLayoutListener {
    final /* synthetic */ SpinnerCompat a;

    ax(SpinnerCompat spinnerCompat) {
        this.a = spinnerCompat;
    }

    public final void onGlobalLayout() {
        if (!this.a.H.isShowing()) {
            this.a.H.show();
        }
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }
}
