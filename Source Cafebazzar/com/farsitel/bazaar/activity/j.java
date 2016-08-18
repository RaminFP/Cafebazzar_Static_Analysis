package com.farsitel.bazaar.activity;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class j implements OnGlobalLayoutListener {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        this.a.L.getLocationInWindow(iArr);
        this.a.Q = iArr[1];
        this.a.L.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
