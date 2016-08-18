package com.farsitel.bazaar.d;

import android.view.animation.AnimationUtils;

final class bj implements Runnable {
    final /* synthetic */ bi a;

    bj(bi biVar) {
        this.a = biVar;
    }

    public final void run() {
        if (this.a.a.getView() != null) {
            this.a.a.p.setAnimation(AnimationUtils.loadAnimation(this.a.a.getActivity(), 2130968594));
            this.a.a.p.setVisibility(0);
        }
    }
}
