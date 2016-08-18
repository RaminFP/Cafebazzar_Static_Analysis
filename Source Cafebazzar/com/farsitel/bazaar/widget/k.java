package com.farsitel.bazaar.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.farsitel.bazaar.g;

final class k implements OnClickListener {
    final /* synthetic */ h a;

    k(h hVar) {
        this.a = hVar;
    }

    public final void onClick(View view) {
        h hVar = this.a;
        Animation loadAnimation = AnimationUtils.loadAnimation(hVar.d, 2130968616);
        loadAnimation.setFillAfter(true);
        if (hVar.a.isPlaying()) {
            hVar.c.setImageResource(g.ic_av_pause);
            hVar.a.pause();
            hVar.g.removeMessages(0);
        } else {
            hVar.c.setImageResource(g.ic_av_play_arrow);
            hVar.g.sendEmptyMessage(0);
            hVar.a.start();
        }
        hVar.c.setVisibility(0);
        hVar.c.startAnimation(loadAnimation);
    }
}
