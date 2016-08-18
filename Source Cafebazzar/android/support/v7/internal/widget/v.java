package android.support.v7.internal.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class v implements OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView a;

    v(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onGlobalLayout() {
        if (!this.a.getListPopupWindow().isShowing()) {
            return;
        }
        if (this.a.isShown()) {
            this.a.getListPopupWindow().show();
            if (this.a.a != null) {
                this.a.a.subUiVisibilityChanged(true);
                return;
            }
            return;
        }
        this.a.getListPopupWindow().dismiss();
    }
}
