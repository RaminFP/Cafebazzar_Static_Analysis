package android.support.v4.view;

import android.view.View;

class do extends dl {
    do() {
    }

    public final void a(di diVar, View view, dy dyVar) {
        if (dyVar != null) {
            view.animate().setListener(new dv(dyVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
