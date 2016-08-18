package com.farsitel.bazaar.d;

import android.view.animation.AnimationUtils;

final class bk implements Runnable {
    final /* synthetic */ bi a;

    bk(bi biVar) {
        this.a = biVar;
    }

    public final void run() {
        if (this.a.a.getView() != null) {
            this.a.a.q.setAnimation(AnimationUtils.loadAnimation(this.a.a.getActivity(), 2130968632));
            this.a.a.q.setVisibility(0);
        }
    }
}
