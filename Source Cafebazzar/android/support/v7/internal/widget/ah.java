package android.support.v7.internal.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class ah implements OnScrollChangedListener {
    final /* synthetic */ Field a;
    final /* synthetic */ PopupWindow b;
    final /* synthetic */ OnScrollChangedListener c;

    ah(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
        this.a = field;
        this.b = popupWindow;
        this.c = onScrollChangedListener;
    }

    public final void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.a.get(this.b);
            if (weakReference != null && weakReference.get() != null) {
                this.c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
