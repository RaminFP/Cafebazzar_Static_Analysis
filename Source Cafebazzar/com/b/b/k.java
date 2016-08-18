package com.b.b;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;

final class k implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ h b;

    k(h hVar, int i) {
        this.b = hVar;
        this.a = i;
    }

    public final void run() {
        if (this.a == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
            y yVar = a.a().a;
            if (yVar != null) {
                yVar.h = true;
            }
        }
    }
}
