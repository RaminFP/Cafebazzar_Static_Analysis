package com.farsitel.bazaar.d;

import android.view.animation.AnimationUtils;

final class bm implements Runnable {
    final /* synthetic */ bh a;

    bm(bh bhVar) {
        this.a = bhVar;
    }

    public final void run() {
        if (this.a.getActivity() != null) {
            this.a.p.setAnimation(AnimationUtils.loadAnimation(this.a.getActivity(), 2130968598));
            this.a.p.setVisibility(8);
        }
    }
}
