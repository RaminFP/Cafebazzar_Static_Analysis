package com.farsitel.bazaar.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bb implements OnTouchListener {
    final /* synthetic */ aw a;

    bb(aw awVar) {
        this.a = awVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a.b();
        }
        return false;
    }
}
