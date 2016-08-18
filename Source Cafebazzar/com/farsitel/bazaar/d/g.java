package com.farsitel.bazaar.d;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.farsitel.bazaar.g.j;

final class g implements AnimationListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ f b;

    g(f fVar, TextView textView) {
        this.b = fVar;
        this.a = textView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(4);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        this.b.b.v.setAnimation(alphaAnimation);
        this.b.b.v.setText(this.b.b.getString(2131165339, Long.valueOf(j.a().c() / 10)));
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
