package android.support.v7.app;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

final class t extends s {
    boolean n = true;

    t(Context context, Window window, o oVar) {
        super(context, window, oVar);
    }

    final Callback a(Callback callback) {
        return new u(this, callback);
    }
}
