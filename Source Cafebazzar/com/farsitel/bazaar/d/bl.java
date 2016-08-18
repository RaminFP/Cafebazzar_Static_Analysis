package com.farsitel.bazaar.d;

import android.view.animation.AnimationUtils;

final class bl implements Runnable {
    final /* synthetic */ bh a;

    bl(bh bhVar) {
        this.a = bhVar;
    }

    public final void run() {
        if (this.a.getActivity() != null) {
            this.a.q.setAnimation(AnimationUtils.loadAnimation(this.a.getActivity(), 2130968598));
            this.a.q.setVisibility(8);
        }
    }
}
