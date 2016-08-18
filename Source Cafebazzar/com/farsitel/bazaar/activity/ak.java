package com.farsitel.bazaar.activity;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ak implements OnGlobalLayoutListener {
    final /* synthetic */ u a;

    ak(u uVar) {
        this.a = uVar;
    }

    public final void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.a.getView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.a.getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        if (this.a.u != null && this.a.u.d != null && this.a.u.d.c != null) {
            this.a.a(this.a.u.d.c, this.a.u.h);
        }
    }
}
